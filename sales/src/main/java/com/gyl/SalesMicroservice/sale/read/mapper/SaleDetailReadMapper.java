package com.gyl.SalesMicroservice.sale.read.mapper;

import com.gyl.SalesMicroservice.mapper.DateMapper;
import com.gyl.SalesMicroservice.saleDetail.entity.SaleDetail;
import com.gyl.SalesMicroservice.sale.read.dto.SaleDetailReadResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SaleDetailReadMapper extends DateMapper {
    @Mapping(target = "id", source = "saleDetail.id")
    @Mapping(target = "validSince", source = "saleDetail.validSince")
    @Mapping(target = "createdAt", source = "saleDetail.createdAt")
    @Mapping(target = "state", source = "saleDetail.state")
    @Mapping(target = "saleId", source = "saleDetail.sale.id")
    SaleDetailReadResponseDto toDto(SaleDetail saleDetail);
}
