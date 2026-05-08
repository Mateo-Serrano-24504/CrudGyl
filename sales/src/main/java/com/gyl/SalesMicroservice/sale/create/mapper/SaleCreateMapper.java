package com.gyl.SalesMicroservice.sale.create.mapper;

import com.gyl.SalesMicroservice.mapper.DateMapper;
import com.gyl.SalesMicroservice.sale.create.dto.SaleCreateResponseDto;
import com.gyl.SalesMicroservice.sale.entity.Sale;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring",
        uses = DateMapper.class
)
public interface SaleCreateMapper {
    SaleCreateResponseDto toDto(Sale sale);
}
