package com.gyl.SalesMicroservice.sale.update.mapper;

import com.gyl.SalesMicroservice.mapper.DateMapper;
import com.gyl.SalesMicroservice.sale.entity.Sale;
import com.gyl.SalesMicroservice.sale.update.dto.SaleUpdateResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        uses = DateMapper.class
)
public interface SaleUpdateMapper {
    @Mapping(target = "id", source = "sale.id")
    @Mapping(target = "total", source = "sale.total")
    @Mapping(target = "validSince", source = "sale.validSince")
    @Mapping(target = "createdAt", source = "sale.createdAt")
    @Mapping(target = "state", source = "sale.state")
    SaleUpdateResponseDto toDto(Sale sale);
}
