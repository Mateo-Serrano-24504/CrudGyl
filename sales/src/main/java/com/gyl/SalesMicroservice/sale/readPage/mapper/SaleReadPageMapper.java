package com.gyl.SalesMicroservice.sale.readPage.mapper;

import com.gyl.SalesMicroservice.sale.entity.Sale;
import com.gyl.SalesMicroservice.sale.readPage.dto.SaleReadPageResponseDto;
import org.springframework.stereotype.Component;

import java.time.ZoneOffset;

@Component
public class SaleReadPageMapper {
    public SaleReadPageResponseDto toPageDto(Sale sale) {
        return new SaleReadPageResponseDto(
                sale.getId(),
                sale.getTotal(),
                sale.getValidSince().atOffset(ZoneOffset.UTC),
                sale.getState(),
                sale.getCreatedAt().atOffset(ZoneOffset.UTC),
                sale.getClientId()
        );
    }
}
