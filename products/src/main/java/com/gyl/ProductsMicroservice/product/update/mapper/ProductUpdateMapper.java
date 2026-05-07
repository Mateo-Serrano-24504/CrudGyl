package com.gyl.ProductsMicroservice.product.update.mapper;

import com.gyl.ProductsMicroservice.mapper.DateMapper;
import com.gyl.ProductsMicroservice.product.entity.Product;
import com.gyl.ProductsMicroservice.product.update.dto.ProductUpdateRequestDto;
import com.gyl.ProductsMicroservice.product.update.dto.ProductUpdateResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductUpdateMapper extends DateMapper {
    Product fromDto(ProductUpdateRequestDto dto);

    @Mapping(target = "productTypeId", source = "productType.id")
    ProductUpdateResponseDto toDto(Product product);
}
