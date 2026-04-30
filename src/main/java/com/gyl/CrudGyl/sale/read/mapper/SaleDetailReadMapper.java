package com.gyl.CrudGyl.sale.read.mapper;

import com.gyl.CrudGyl.sale.entity.SaleDetail;
import com.gyl.CrudGyl.sale.read.dto.SaleDetailReadResponseDto;
import org.springframework.stereotype.Component;

import java.time.ZoneOffset;

@Component
public class SaleDetailReadMapper {
    public SaleDetailReadResponseDto toDto(SaleDetail saleDetail) {
        return new SaleDetailReadResponseDto(
                saleDetail.getId(),
                saleDetail.getAmount(),
                saleDetail.getUnitPrice(),
                saleDetail.getSubtotal(),
                saleDetail.getValidSince().atOffset(ZoneOffset.UTC),
                saleDetail.getState(),
                saleDetail.getCreatedAt().atOffset(ZoneOffset.UTC)
        );
    }
}
