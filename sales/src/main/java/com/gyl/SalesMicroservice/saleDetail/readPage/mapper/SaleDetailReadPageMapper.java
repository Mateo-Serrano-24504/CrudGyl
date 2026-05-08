package com.gyl.SalesMicroservice.saleDetail.readPage.mapper;

import com.gyl.SalesMicroservice.mapper.DateMapper;
import com.gyl.SalesMicroservice.saleDetail.entity.SaleDetail;
import com.gyl.SalesMicroservice.saleDetail.readPage.dto.SaleDetailReadPageResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        uses = DateMapper.class
)
public interface SaleDetailReadPageMapper {
    @Mapping(target = "id", source = "saleDetail.id")
    @Mapping(target = "createdAt", source = "saleDetail.createdAt")
    @Mapping(target = "validSince", source = "saleDetail.validSince")
    @Mapping(target = "state", source = "saleDetail.state")
    SaleDetailReadPageResponseDto toPageDto(SaleDetail saleDetail);
}
