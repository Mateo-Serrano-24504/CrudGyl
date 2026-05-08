package com.gyl.SalesMicroservice.provider;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gyl.SalesMicroservice.exception.ErrorFormat;
import com.gyl.SalesMicroservice.result.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestClientResponseException;

import java.util.function.Function;

@RequiredArgsConstructor
public abstract class Provider<T, A, R extends RuntimeException> {
    protected final ObjectMapper objectMapper;
    private Result<ErrorFormat, T> parseServiceErrorFormat(
            RestClientResponseException ex,
            Function<Exception, R> exceptionFactory
    ) {
        try {
            ErrorFormat error = objectMapper.readValue(
                    ex.getResponseBodyAsString(),
                    ErrorFormat.class
            );
            return Result.error(error, ex.getStatusCode().value());
        } catch (JsonProcessingException parseEx) {
            throw exceptionFactory.apply(parseEx);
        }
    }
    protected abstract Result<ErrorFormat, T> tryProvide(A arguments);
    protected Result<ErrorFormat, T> provide(A arguments, Function<Exception, R> exceptionFactory) {
        try {
            return tryProvide(arguments);
        } catch (RestClientResponseException ex) {
            return parseServiceErrorFormat(ex, exceptionFactory);
        } catch (Exception e) {
            throw exceptionFactory.apply(e);
        }
    }
}
