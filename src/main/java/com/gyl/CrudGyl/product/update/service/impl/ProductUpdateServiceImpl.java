package com.gyl.CrudGyl.product.update.service.impl;

import com.gyl.CrudGyl.product.entity.HistoricProduct;
import com.gyl.CrudGyl.product.entity.Product;
import com.gyl.CrudGyl.product.update.dto.ProductUpdateRequestDto;
import com.gyl.CrudGyl.product.update.dto.ProductUpdateResponseDto;
import com.gyl.CrudGyl.product.update.exception.ProductUpdateProductDoesNotExist;
import com.gyl.CrudGyl.product.update.exception.ProductUpdateProductTypeDoesNotExist;
import com.gyl.CrudGyl.product.update.mapper.ProductUpdateMapper;
import com.gyl.CrudGyl.product.update.repository.HistoricProductCreateRepository;
import com.gyl.CrudGyl.product.update.repository.ProductUpdateRepository;
import com.gyl.CrudGyl.product.update.service.ProductUpdateService;
import com.gyl.CrudGyl.productType.entity.ProductType;
import com.gyl.CrudGyl.productType.read.repository.ProductTypeReadRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
@Transactional
public class ProductUpdateServiceImpl implements ProductUpdateService {
    private final ProductUpdateRepository repository;
    private final HistoricProductCreateRepository historicProductCreateRepository;
    private final ProductTypeReadRepository productTypeReadRepository;
    private final ProductUpdateMapper mapper;
    public ProductUpdateServiceImpl(
            ProductUpdateRepository repository,
            HistoricProductCreateRepository historicProductCreateRepository,
            ProductTypeReadRepository productTypeReadRepository,
            ProductUpdateMapper mapper
    ) {
        this.repository = repository;
        this.historicProductCreateRepository = historicProductCreateRepository;
        this.productTypeReadRepository = productTypeReadRepository;
        this.mapper = mapper;
    }

    private HistoricProduct createHistoricProduct(Product product, Instant invalidationTime) {
        HistoricProduct historicProduct = new HistoricProduct(product);
        historicProduct.setValidTo(invalidationTime);
        return historicProduct;
    }

    @Override
    public ProductUpdateResponseDto update(Long id, ProductUpdateRequestDto dto) {
        Instant now = Instant.now();
        Optional<Product> optionalProduct = this.repository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new ProductUpdateProductDoesNotExist(id);
        }
        Optional<ProductType> optionalProductType = this.productTypeReadRepository.findById(dto.productTypeId());
        if (optionalProductType.isEmpty()) {
            throw new ProductUpdateProductTypeDoesNotExist(dto.productTypeId());
        }
        Product product = optionalProduct.get();
        ProductType productType = optionalProductType.get();
        this.historicProductCreateRepository.save(this.createHistoricProduct(product, now));
        Product newProduct = this.mapper.fromDto(dto);
        newProduct.setId(product.getId());
        newProduct.setValidSince(now);
        newProduct.setCreatedAt(product.getCreatedAt());
        newProduct.setProductType(productType);
        return this.mapper.toDto(this.repository.save(newProduct));
    }
}
