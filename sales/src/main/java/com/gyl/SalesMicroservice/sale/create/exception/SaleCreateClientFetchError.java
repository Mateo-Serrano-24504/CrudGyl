package com.gyl.SalesMicroservice.sale.create.exception;

import com.gyl.SalesMicroservice.exception.ErrorFormat;
import com.gyl.SalesMicroservice.exception.ProviderError;

public class SaleCreateClientFetchError extends ProviderError {
    public SaleCreateClientFetchError(ErrorFormat errorFormat) {
        super("Error during fetch of client", errorFormat);
    }
}
