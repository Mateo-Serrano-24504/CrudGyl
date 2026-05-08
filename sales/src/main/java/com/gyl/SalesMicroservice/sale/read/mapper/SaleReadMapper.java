package com.gyl.SalesMicroservice.sale.read.mapper;

import com.gyl.SalesMicroservice.mapper.DateMapper;
import com.gyl.SalesMicroservice.sale.entity.Sale;
import com.gyl.SalesMicroservice.sale.read.dto.SaleDetailReadResponseDto;
import com.gyl.SalesMicroservice.sale.read.dto.SaleReadResponseDto;
import com.gyl.SalesMicroservice.saleDetail.entity.SaleDetail;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface SaleReadMapper extends DateMapper {
    @Mapping(target = "id", source = "sale.id")
    @Mapping(target = "total", source = "sale.total")
    @Mapping(target = "validSince", source = "sale.validSince")
    @Mapping(target = "createdAt", source = "sale.createdAt")
    @Mapping(target = "state", source = "sale.state")
    @Mapping(target = "salesDetails", expression = "java(mapSalesDetails(sale.salesDetails))")
    SaleReadResponseDto toDto(Sale sale);

    @SuppressWarnings("unused")
    default List<SaleDetailReadResponseDto> mapSalesDetails(Sale sale, SaleDetailReadMapper mapper) {
        return sale.getSalesDetails().stream()
                .map(mapper::toDto)
                .toList();
    }
    @AfterMapping
    @SuppressWarnings("unused")
    default void attachSaleToSalesDetails(Sale sale, List<SaleDetail> details) {
        details.forEach(
                detail -> detail.setSale(sale)
        );
    }
}
