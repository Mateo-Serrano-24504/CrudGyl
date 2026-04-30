package com.gyl.CrudGyl.sale.read.mapper;

import com.gyl.CrudGyl.sale.entity.Sale;
import com.gyl.CrudGyl.sale.read.dto.SaleReadResponseDto;
import org.springframework.stereotype.Component;

import java.time.ZoneOffset;

@Component
public class SaleReadMapper {
    private final SaleDetailReadMapper saleDetailReadMapper;
    public SaleReadMapper(SaleDetailReadMapper saleDetailReadMapper) {
        this.saleDetailReadMapper = saleDetailReadMapper;
    }
    public SaleReadResponseDto toDto(Sale sale) {
        return new SaleReadResponseDto(
                sale.getId(),
                sale.getTotal(),
                sale.getValidSince().atOffset(ZoneOffset.UTC),
                sale.getState(),
                sale.getCreatedAt().atOffset(ZoneOffset.UTC),
                sale.getClient().getId(),
                sale.getSalesDetails().stream()
                        .map(this.saleDetailReadMapper::toDto)
                        .toList()
        );
    }
}
