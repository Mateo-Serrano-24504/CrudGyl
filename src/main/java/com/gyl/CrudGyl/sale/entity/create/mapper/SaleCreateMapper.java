package com.gyl.CrudGyl.sale.entity.create.mapper;

import com.gyl.CrudGyl.sale.entity.Sale;
import com.gyl.CrudGyl.sale.entity.create.dto.SaleCreateRequestDto;
import com.gyl.CrudGyl.sale.entity.create.dto.SaleCreateResponseDto;
import org.springframework.stereotype.Component;

import java.time.ZoneOffset;

@Component
public class SaleCreateMapper {
    public Sale fromDto(SaleCreateRequestDto dto) {
        return new Sale(dto.total());
    }
    public SaleCreateResponseDto toDto(Sale sale) {
        return new SaleCreateResponseDto(
                sale.getId(), sale.getCreatedAt().atOffset(ZoneOffset.UTC), sale.getTotal()
        );
    }
}
