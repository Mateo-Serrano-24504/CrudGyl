package com.gyl.SalesMicroservice.saleDetail.readPage.mapper;

import com.gyl.SalesMicroservice.saleDetail.entity.SaleDetail;
import com.gyl.SalesMicroservice.saleDetail.readPage.dto.SaleDetailReadPageResponseDto;
import org.springframework.stereotype.Component;

import java.time.ZoneOffset;

@Component
public class SaleDetailReadPageMapper {
    public SaleDetailReadPageResponseDto toPageDto(SaleDetail saleDetail) {
        return new SaleDetailReadPageResponseDto(
                saleDetail.getId(),
                saleDetail.getAmount(),
                saleDetail.getUnitPrice(),
                saleDetail.getSubtotal(),
                saleDetail.getProductId(),
                saleDetail.getCreatedAt().atOffset(ZoneOffset.UTC),
                saleDetail.getState(),
                saleDetail.getValidSince().atOffset(ZoneOffset.UTC)
        );
    }
}
