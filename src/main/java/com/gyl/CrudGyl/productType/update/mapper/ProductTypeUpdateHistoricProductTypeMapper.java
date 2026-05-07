package com.gyl.CrudGyl.productType.update.mapper;

import com.gyl.CrudGyl.productType.entity.HistoricProductType;
import com.gyl.CrudGyl.productType.entity.ProductType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.Instant;

@Mapper(componentModel = "spring")
public interface ProductTypeUpdateHistoricProductTypeMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "productTypeId", source = "productType.id")
    @Mapping(target = "validTo", source = "validTo")
    HistoricProductType toHistoric(ProductType productType, Instant validTo);
}
