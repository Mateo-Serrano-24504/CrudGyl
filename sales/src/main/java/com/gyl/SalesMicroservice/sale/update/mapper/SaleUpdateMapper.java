package com.gyl.SalesMicroservice.sale.update.mapper;

import com.gyl.SalesMicroservice.sale.entity.Sale;
import com.gyl.SalesMicroservice.sale.update.dto.SaleUpdateResponseDto;
import org.springframework.stereotype.Component;

import java.time.ZoneOffset;

@Component
public class SaleUpdateMapper {
    public SaleUpdateResponseDto toDto(Sale sale) {
        return new SaleUpdateResponseDto(
                sale.getId(),
                sale.getTotal(),
                sale.getClientId(),
                sale.getValidSince().atOffset(ZoneOffset.UTC),
                sale.getState(),
                sale.getCreatedAt().atOffset(ZoneOffset.UTC)
        );
    }
}
