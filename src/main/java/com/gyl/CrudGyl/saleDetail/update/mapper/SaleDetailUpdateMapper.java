package com.gyl.CrudGyl.saleDetail.update.mapper;

import com.gyl.CrudGyl.saleDetail.entity.SaleDetail;
import com.gyl.CrudGyl.saleDetail.update.dto.SaleDetailUpdateRequestDto;
import com.gyl.CrudGyl.saleDetail.update.dto.SaleDetailUpdateResponseDto;
import org.springframework.stereotype.Component;

import java.time.ZoneOffset;

@Component
public class SaleDetailUpdateMapper {
    public SaleDetail fromDto(SaleDetailUpdateRequestDto dto) {
        return new SaleDetail(
                dto.amount(),
                dto.state()
        );
    }
    public SaleDetailUpdateResponseDto toDto(SaleDetail saleDetail) {
        return new SaleDetailUpdateResponseDto(
                saleDetail.getId(),
                saleDetail.getAmount(),
                saleDetail.getUnitPrice(),
                saleDetail.getSubtotal(),
                saleDetail.getProduct().getId(),
                saleDetail.getSale().getId(),
                saleDetail.getCreatedAt().atOffset(ZoneOffset.UTC),
                saleDetail.getState(),
                saleDetail.getValidSince().atOffset(ZoneOffset.UTC)
        );
    }
}
