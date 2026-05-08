package com.gyl.SalesMicroservice.saleDetail.update.exception;

import com.gyl.SalesMicroservice.exception.ErrorFormat;
import com.gyl.SalesMicroservice.exception.ProviderError;

public class SaleDetailUpdateProductFetchError extends ProviderError {
    public SaleDetailUpdateProductFetchError(ErrorFormat errorFormat) {
        super("Error during fetch of product", errorFormat);
    }
}
