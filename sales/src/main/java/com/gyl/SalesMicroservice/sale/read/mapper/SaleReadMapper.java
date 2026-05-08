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

@Mapper(
        componentModel = "spring",
        uses = {
                SaleDetailReadMapper.class,
                DateMapper.class
        }
)
public interface SaleReadMapper {
    @Mapping(target = "id", source = "sale.id")
    @Mapping(target = "total", source = "sale.total")
    @Mapping(target = "validSince", source = "sale.validSince")
    @Mapping(target = "createdAt", source = "sale.createdAt")
    @Mapping(target = "state", source = "sale.state")
    @Mapping(target = "details", source = "salesDetails")
    SaleReadResponseDto toDto(Sale sale);

    @AfterMapping
    @SuppressWarnings("unused")
    default void attachSaleToSalesDetails(Sale sale, List<SaleDetail> details) {
        details.forEach(
                detail -> detail.setSale(sale)
        );
    }
}
