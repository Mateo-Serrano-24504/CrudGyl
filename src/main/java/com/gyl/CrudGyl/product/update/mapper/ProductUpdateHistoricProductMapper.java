package com.gyl.CrudGyl.product.update.mapper;

import com.gyl.CrudGyl.mapper.DateMapper;
import com.gyl.CrudGyl.product.entity.HistoricProduct;
import com.gyl.CrudGyl.product.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.Instant;

@Mapper(componentModel = "spring")
public interface ProductUpdateHistoricProductMapper extends DateMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "productTypeId", source = "product.productType.id")
    @Mapping(target = "validTo", source = "validTo")
    HistoricProduct toHistoric(Product product, Instant validTo);
}
