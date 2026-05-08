package com.gyl.SalesMicroservice.result;

import java.util.function.Function;

public record Result<E, T>(E error, T value, Integer status) {
    public static <E, T> Result<E, T> ok(T value, Integer status) {
        return new Result<>(null, value, status);
    }

    public static <E, T> Result<E, T> error(E error, Integer status) {
        return new Result<>(error, null, status);
    }

    public boolean isOk() {
        return this.error == null;
    }

    public boolean isError() {
        return !this.isOk();
    }

    public T orElseThrow(Function<E, ? extends RuntimeException> exceptionFactory) {
        if (this.isOk()) {
            return this.value;
        }
        throw exceptionFactory.apply(this.error);
    }
}
