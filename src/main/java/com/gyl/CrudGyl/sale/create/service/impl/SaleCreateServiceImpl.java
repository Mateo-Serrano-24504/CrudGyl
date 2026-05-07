package com.gyl.CrudGyl.sale.create.service.impl;

import com.gyl.CrudGyl.client.entity.Client;
import com.gyl.CrudGyl.client.read.repository.ClientReadRepository;
import com.gyl.CrudGyl.product.entity.Product;
import com.gyl.CrudGyl.product.read.repository.ProductReadRepository;
import com.gyl.CrudGyl.sale.create.buider.SaleCreateSaleBuilder;
import com.gyl.CrudGyl.sale.create.buider.SaleCreateSaleDetailBuilder;
import com.gyl.CrudGyl.sale.create.dto.SaleCreateRequestDto;
import com.gyl.CrudGyl.sale.create.dto.SaleCreateResponseDto;
import com.gyl.CrudGyl.sale.create.dto.SaleDetailCreateRequestDto;
import com.gyl.CrudGyl.sale.create.exception.SaleCreateClientDoesNotExist;
import com.gyl.CrudGyl.sale.create.exception.SaleCreateClientIsInactive;
import com.gyl.CrudGyl.sale.create.exception.SaleCreateProductDoesNotExist;
import com.gyl.CrudGyl.sale.create.exception.SaleCreateProductIsInactive;
import com.gyl.CrudGyl.sale.create.mapper.SaleCreateMapper;
import com.gyl.CrudGyl.sale.create.repository.SaleCreateRepository;
import com.gyl.CrudGyl.sale.create.service.SaleCreateService;
import com.gyl.CrudGyl.sale.entity.Sale;
import com.gyl.CrudGyl.saleDetail.entity.SaleDetail;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@Transactional
public class SaleCreateServiceImpl implements SaleCreateService {
    private final SaleCreateRepository repository;
    private final ClientReadRepository clientReadRepository;
    private final ProductReadRepository productReadRepository;
    private final SaleCreateMapper mapper;
    private final SaleCreateSaleBuilder builder;
    private final SaleCreateSaleDetailBuilder saleDetailBuilder;
    public SaleCreateServiceImpl(
            SaleCreateRepository repository,
            ClientReadRepository clientReadRepository,
            ProductReadRepository productReadRepository,
            SaleCreateMapper mapper,
            SaleCreateSaleBuilder builder,
            SaleCreateSaleDetailBuilder saleDetailBuilder
    ) {
        this.repository = repository;
        this.clientReadRepository = clientReadRepository;
        this.productReadRepository = productReadRepository;
        this.mapper = mapper;
        this.builder = builder;
        this.saleDetailBuilder = saleDetailBuilder;
    }

    private Client getClient(Long id) {
        return this.clientReadRepository
                .findById(id)
                .orElseThrow(() -> new SaleCreateClientDoesNotExist(id))
                .assertActive(() -> new SaleCreateClientIsInactive(id));
    }
    private Product getProduct(Long id) {
        return this.productReadRepository
                .findById(id)
                .orElseThrow(() -> new SaleCreateProductDoesNotExist(id))
                .assertActive(() -> new SaleCreateProductIsInactive(id));
    }

    private SaleDetail buildSaleDetail(SaleDetailCreateRequestDto dto, Instant now) {
        Product product = this.getProduct(dto.productId());
        return this.saleDetailBuilder.build(dto, product, now);
    }

    @Override
    public SaleCreateResponseDto create(SaleCreateRequestDto dto) {
        Instant now = Instant.now();
        Client client = this.getClient(dto.clientId());
        List<SaleDetail> details = dto.details()
                        .stream()
                        .map(detail -> this.buildSaleDetail(detail, now))
                        .toList();
        Sale sale = this.builder.build(details, client, now);
        return this.mapper.toDto(this.repository.save(sale));
    }
}
