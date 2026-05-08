package com.gyl.SalesMicroservice.sale.update.exception;

import com.gyl.SalesMicroservice.exception.ErrorFormat;
import com.gyl.SalesMicroservice.exception.ProviderError;

public class SaleUpdateClientFetchError extends ProviderError {
    public SaleUpdateClientFetchError(ErrorFormat errorFormat) {
        super("Error during fetch of client", errorFormat);
    }
}
