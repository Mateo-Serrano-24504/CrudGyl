package com.gyl.CrudGyl.sale.update.mapper;

import com.gyl.CrudGyl.sale.entity.Sale;
import com.gyl.CrudGyl.sale.update.dto.SaleUpdateResponseDto;
import org.springframework.stereotype.Component;

import java.time.ZoneOffset;

@Component
public class SaleUpdateMapper {
    public SaleUpdateResponseDto toDto(Sale sale) {
        return new SaleUpdateResponseDto(
                sale.getId(),
                sale.getTotal(),
                sale.getClient().getId(),
                sale.getValidSince().atOffset(ZoneOffset.UTC),
                sale.getState(),
                sale.getCreatedAt().atOffset(ZoneOffset.UTC)
        );
    }
}
