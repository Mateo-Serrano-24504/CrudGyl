package com.gyl.SalesMicroservice.exception;

import lombok.Getter;

@Getter
public class ProviderError extends RuntimeException {
    private final ErrorFormat errorFormat;
    public ProviderError(String message, ErrorFormat errorFormat) {
        super(message);
        this.errorFormat = errorFormat;
    }
}
