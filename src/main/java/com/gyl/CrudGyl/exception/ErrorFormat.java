package com.gyl.CrudGyl.exception;

import java.util.List;

public record ErrorFormat (
        String message,
        List<String> errors
) {}
