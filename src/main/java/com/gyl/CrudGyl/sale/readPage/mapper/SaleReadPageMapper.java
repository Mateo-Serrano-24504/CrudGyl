package com.gyl.CrudGyl.sale.readPage.mapper;

import com.gyl.CrudGyl.sale.entity.Sale;
import com.gyl.CrudGyl.sale.readPage.dto.SaleReadPageResponseDto;
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
                sale.getClient().getId()
        );
    }
}
