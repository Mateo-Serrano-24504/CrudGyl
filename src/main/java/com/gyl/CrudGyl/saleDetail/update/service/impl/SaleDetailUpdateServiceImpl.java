package com.gyl.CrudGyl.saleDetail.update.service.impl;

import com.gyl.CrudGyl.persistence.EntityState;
import com.gyl.CrudGyl.product.entity.Product;
import com.gyl.CrudGyl.sale.entity.Sale;
import com.gyl.CrudGyl.saleDetail.entity.SaleDetail;
import com.gyl.CrudGyl.saleDetail.update.dto.SaleDetailUpdateRequestDto;
import com.gyl.CrudGyl.saleDetail.update.dto.SaleDetailUpdateResponseDto;
import com.gyl.CrudGyl.saleDetail.update.exception.SaleDetailUpdateProductIdDoesNotMatch;
import com.gyl.CrudGyl.saleDetail.update.exception.SaleDetailUpdateSaleDetailDoesNotExist;
import com.gyl.CrudGyl.saleDetail.update.mapper.SaleDetailUpdateMapper;
import com.gyl.CrudGyl.saleDetail.update.repository.SaleDetailUpdateRepository;
import com.gyl.CrudGyl.saleDetail.update.service.SaleDetailUpdateService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class SaleDetailUpdateServiceImpl implements SaleDetailUpdateService {
    private final SaleDetailUpdateRepository repository;
    private final SaleDetailUpdateMapper mapper;
    public SaleDetailUpdateServiceImpl(
            SaleDetailUpdateRepository repository,
            SaleDetailUpdateMapper mapper
    ) {
        this.repository = repository;
        this.mapper = mapper;
    }

    private Product getProduct(SaleDetail original, SaleDetailUpdateRequestDto dto) {
        Long originalProductId = original.getProduct().getId();
        if (Objects.equals(originalProductId, dto.productId())) {
            return original.getProduct();
        }
        throw new SaleDetailUpdateProductIdDoesNotMatch(originalProductId, dto.productId());
    }

    private SaleDetail makeSaleDetail(SaleDetail original, SaleDetailUpdateRequestDto dto, Instant validationTime) {
        SaleDetail newSaleDetail = this.mapper.fromDto(dto);
        Product product = this.getProduct(original, dto);
        newSaleDetail.setId(original.getId());
        newSaleDetail.setCreatedAt(original.getCreatedAt());
        newSaleDetail.setValidSince(validationTime);
        newSaleDetail.setProduct(product);
        newSaleDetail.setUnitPrice(product.getPrice());
        newSaleDetail.setSubtotal(product.getPrice() * newSaleDetail.getAmount());
        newSaleDetail.setSale(original.getSale());
        return newSaleDetail;
    }

    @Override
    public SaleDetailUpdateResponseDto update(Long id, SaleDetailUpdateRequestDto dto) {
        Instant now = Instant.now();
        Optional<SaleDetail> optionalSaleDetail = this.repository.findById(id);
        if (optionalSaleDetail.isEmpty()) {
            throw new SaleDetailUpdateSaleDetailDoesNotExist(id);
        }
        SaleDetail saleDetail = optionalSaleDetail.get();
        SaleDetail newSaleDetail = this.makeSaleDetail(saleDetail, dto, now);

        Sale sale = saleDetail.getSale();
        double newSubtotal = newSaleDetail.getState() == EntityState.ACTIVE ? newSaleDetail.getSubtotal() : 0d;
        sale.setTotal(sale.getTotal() - saleDetail.getSubtotal() + newSubtotal);
        sale.setValidSince(now);
        return this.mapper.toDto(this.repository.save(newSaleDetail));
    }
}
