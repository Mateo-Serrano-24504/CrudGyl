package com.gyl.ProductsMicroservice.productType.update.mapper;

import com.gyl.ProductsMicroservice.mapper.DateMapper;
import com.gyl.ProductsMicroservice.productType.entity.ProductType;
import com.gyl.ProductsMicroservice.productType.update.dto.ProductTypeUpdateRequestDto;
import com.gyl.ProductsMicroservice.productType.update.dto.ProductTypeUpdateResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductTypeUpdateMapper extends DateMapper {
    ProductType fromDto(ProductTypeUpdateRequestDto dto);
    ProductTypeUpdateResponseDto toDto(ProductType productType);
}
