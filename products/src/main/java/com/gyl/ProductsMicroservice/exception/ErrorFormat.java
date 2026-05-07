package com.gyl.ProductsMicroservice.exception;

import java.util.List;

public record ErrorFormat (
        String message,
        List<String> errors
) {}
