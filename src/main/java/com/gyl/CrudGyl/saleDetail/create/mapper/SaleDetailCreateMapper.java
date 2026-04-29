package com.gyl.CrudGyl.saleDetail.create.mapper;

import com.gyl.CrudGyl.saleDetail.create.dto.SaleDetailCreateRequestDto;
import com.gyl.CrudGyl.saleDetail.create.dto.SaleDetailCreateResponseDto;
import com.gyl.CrudGyl.saleDetail.entity.SaleDetail;

public class SaleDetailCreateMapper {
    public SaleDetail fromDto(SaleDetailCreateRequestDto dto) {
        return new SaleDetail(
                dto.amount(),
                dto.unitPrice(),
                dto.subtotal()
        );
    }
    public SaleDetailCreateResponseDto toDto(SaleDetail saleDetail) {
        return new SaleDetailCreateResponseDto(
                saleDetail.getId(),
                saleDetail.getAmount(),
                saleDetail.getUnitPrice(),
                saleDetail.getSubtotal(),
                saleDetail.getClient().getId(),
                saleDetail.getSale().getId()
        );
    }
}
