package com.gyl.SalesMicroservice.sale.create.exception;

import com.gyl.SalesMicroservice.exception.ErrorFormat;
import com.gyl.SalesMicroservice.exception.ProviderError;

public class SaleCreateProductFetchError extends ProviderError {
    public SaleCreateProductFetchError(ErrorFormat errorFormat) {
        super("Error during fetch of product", errorFormat);
    }
}
