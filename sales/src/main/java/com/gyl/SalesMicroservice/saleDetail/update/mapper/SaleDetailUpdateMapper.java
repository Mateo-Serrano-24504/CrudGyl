package com.gyl.SalesMicroservice.saleDetail.update.mapper;

import com.gyl.SalesMicroservice.mapper.DateMapper;
import com.gyl.SalesMicroservice.saleDetail.entity.SaleDetail;
import com.gyl.SalesMicroservice.saleDetail.update.dto.SaleDetailUpdateRequestDto;
import com.gyl.SalesMicroservice.saleDetail.update.dto.SaleDetailUpdateResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SaleDetailUpdateMapper extends DateMapper {
    SaleDetail fromDto(SaleDetailUpdateRequestDto dto);

    @Mapping(target = "id", source = "saleDetail.id")
    @Mapping(target = "createdAt", source = "saleDetail.createdAt")
    @Mapping(target = "validSince", source = "saleDetail.validSince")
    @Mapping(target = "state", source = "saleDetail.state")
    SaleDetailUpdateResponseDto toDto(SaleDetail saleDetail);
}
