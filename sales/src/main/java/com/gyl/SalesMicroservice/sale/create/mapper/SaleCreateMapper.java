package com.gyl.SalesMicroservice.sale.create.mapper;

import com.gyl.SalesMicroservice.sale.create.dto.SaleCreateResponseDto;
import com.gyl.SalesMicroservice.sale.entity.Sale;
import org.springframework.stereotype.Component;

import java.time.ZoneOffset;

@Component
public class SaleCreateMapper {
    public SaleCreateResponseDto toDto(Sale sale) {
        return new SaleCreateResponseDto(
                sale.getId(), sale.getCreatedAt().atOffset(ZoneOffset.UTC), sale.getTotal()
        );
    }
}
