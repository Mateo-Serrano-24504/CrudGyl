package com.gyl.CrudGyl.product.update.updater;

import com.gyl.CrudGyl.product.entity.Product;
import com.gyl.CrudGyl.product.update.dto.ProductUpdateRequestDto;
import com.gyl.CrudGyl.productType.entity.ProductType;
import org.mapstruct.*;

import java.time.Instant;

@Mapper(componentModel = "spring")
public interface ProductUpdateUpdater {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "name", source = "dto.name")
    @Mapping(target = "state", source = "dto.state")
    @Mapping(target = "productType", source = "productType")
    @Mapping(target = "validSince", source = "validSince")
    void update(
            @MappingTarget Product original,
            ProductUpdateRequestDto dto,
            ProductType productType,
            Instant validSince
    );
}
