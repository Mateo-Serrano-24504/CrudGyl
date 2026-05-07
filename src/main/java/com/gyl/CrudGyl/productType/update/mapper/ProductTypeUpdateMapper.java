package com.gyl.CrudGyl.productType.update.mapper;

import com.gyl.CrudGyl.mapper.DateMapper;
import com.gyl.CrudGyl.productType.entity.ProductType;
import com.gyl.CrudGyl.productType.update.dto.ProductTypeUpdateRequestDto;
import com.gyl.CrudGyl.productType.update.dto.ProductTypeUpdateResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductTypeUpdateMapper extends DateMapper {
    ProductType fromDto(ProductTypeUpdateRequestDto dto);
    ProductTypeUpdateResponseDto toDto(ProductType productType);
}
