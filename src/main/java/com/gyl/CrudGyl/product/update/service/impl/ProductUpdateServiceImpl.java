package com.gyl.CrudGyl.product.update.service.impl;

import com.gyl.CrudGyl.product.entity.HistoricProduct;
import com.gyl.CrudGyl.product.entity.Product;
import com.gyl.CrudGyl.product.update.updater.ProductUpdateProductUpdater;
import com.gyl.CrudGyl.product.update.dto.ProductUpdateRequestDto;
import com.gyl.CrudGyl.product.update.dto.ProductUpdateResponseDto;
import com.gyl.CrudGyl.product.update.exception.ProductUpdateProductDoesNotExist;
import com.gyl.CrudGyl.product.update.exception.ProductUpdateProductIsInactive;
import com.gyl.CrudGyl.product.update.exception.ProductUpdateProductTypeDoesNotExist;
import com.gyl.CrudGyl.product.update.mapper.ProductUpdateHistoricProductMapper;
import com.gyl.CrudGyl.product.update.mapper.ProductUpdateMapper;
import com.gyl.CrudGyl.product.update.repository.HistoricProductCreateRepository;
import com.gyl.CrudGyl.product.update.repository.ProductUpdateRepository;
import com.gyl.CrudGyl.product.update.service.ProductUpdateService;
import com.gyl.CrudGyl.productType.entity.ProductType;
import com.gyl.CrudGyl.productType.read.repository.ProductTypeReadRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductUpdateServiceImpl implements ProductUpdateService {
    private final ProductUpdateRepository repository;
    private final HistoricProductCreateRepository historicProductCreateRepository;
    private final ProductTypeReadRepository productTypeReadRepository;
    private final ProductUpdateMapper mapper;
    private final ProductUpdateHistoricProductMapper historicProductMapper;
    private final ProductUpdateProductUpdater builder;

    private Product getProduct(Long id) {
       return this.repository
               .findById(id)
               .orElseThrow(() -> new ProductUpdateProductDoesNotExist(id))
               .assertActive(() -> new ProductUpdateProductIsInactive(id));
    }
    private ProductType getProductType(Long id) {
        return this.productTypeReadRepository
                .findById(id)
                .orElseThrow(() -> new ProductUpdateProductTypeDoesNotExist(id))
                .assertActive(() -> new ProductUpdateProductIsInactive(id));
    }

    private void saveHistoric(Product product, Instant invalidationTime) {
        HistoricProduct historicProduct = historicProductMapper.toHistoric(product, invalidationTime);
        this.historicProductCreateRepository.save(historicProduct);
    }

    @Override
    public ProductUpdateResponseDto update(Long id, ProductUpdateRequestDto dto) {
        Instant now = Instant.now();
        Product product = this.getProduct(id);
        ProductType productType = this.getProductType(dto.productTypeId());
        this.saveHistoric(product, now);
        this.builder.update(product, dto, productType, now);
        return this.mapper.toDto(product);
    }
}
