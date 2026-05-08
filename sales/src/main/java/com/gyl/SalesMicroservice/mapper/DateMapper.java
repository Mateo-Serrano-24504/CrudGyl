package com.gyl.SalesMicroservice.mapper;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public interface DateMapper {
    @SuppressWarnings("unused")
    default OffsetDateTime map(Instant value) {
        return value == null ? null : value.atOffset(ZoneOffset.UTC);
    }
}
