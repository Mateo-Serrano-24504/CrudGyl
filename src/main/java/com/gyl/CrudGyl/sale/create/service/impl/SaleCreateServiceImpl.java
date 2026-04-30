package com.gyl.CrudGyl.sale.create.service.impl;

import com.gyl.CrudGyl.client.entity.Client;
import com.gyl.CrudGyl.persistence.EntityState;
import com.gyl.CrudGyl.product.entity.Product;
import com.gyl.CrudGyl.sale.create.dto.SaleCreateRequestDto;
import com.gyl.CrudGyl.sale.create.dto.SaleCreateResponseDto;
import com.gyl.CrudGyl.sale.create.exception.ClientDoesNotExist;
import com.gyl.CrudGyl.sale.create.exception.ProductDoesNotExist;
import com.gyl.CrudGyl.sale.create.mapper.SaleCreateMapper;
import com.gyl.CrudGyl.sale.create.repository.ClientFindRepository;
import com.gyl.CrudGyl.sale.create.repository.ProductFindRepository;
import com.gyl.CrudGyl.sale.create.repository.SaleCreateRepository;
import com.gyl.CrudGyl.sale.create.service.SaleCreateService;
import com.gyl.CrudGyl.sale.entity.Sale;
import com.gyl.CrudGyl.sale.entity.SaleDetail;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
@Transactional
public class SaleCreateServiceImpl implements SaleCreateService {
    private final SaleCreateRepository repository;
    private final ClientFindRepository clientFindRepository;
    private final ProductFindRepository productFindRepository;
    private final SaleCreateMapper mapper;
    public SaleCreateServiceImpl(
            SaleCreateRepository repository,
            ClientFindRepository clientFindRepository,
            ProductFindRepository productFindRepository,
            SaleCreateMapper mapper
    ) {
        this.repository = repository;
        this.clientFindRepository = clientFindRepository;
        this.productFindRepository = productFindRepository;
        this.mapper = mapper;
    }

    private SaleDetail fillSaleDetail(Instant now, Long amount, Long productId, Sale sale) {
        SaleDetail saleDetail = new SaleDetail();
        Optional<Product> product = this.productFindRepository.findById(productId);
        if (product.isEmpty()) {
            throw new ProductDoesNotExist(productId);
        }
        saleDetail.setValidSince(now);
        saleDetail.setState(EntityState.ACTIVE);
        saleDetail.setCreatedAt(now);
        saleDetail.setSale(sale);
        saleDetail.setProduct(product.get());
        saleDetail.setAmount(amount);
        saleDetail.setUnitPrice(product.get().getPrice());
        saleDetail.setSubtotal(saleDetail.getUnitPrice() * saleDetail.getAmount());
        return saleDetail;
    }

    @Override
    public SaleCreateResponseDto create(SaleCreateRequestDto dto) {
        Instant now = Instant.now();
        Optional<Client> client = this.clientFindRepository.findById(dto.clientId());
        if (client.isEmpty()) {
            throw new ClientDoesNotExist(dto.clientId());
        }
        Sale sale = new Sale();
        sale.setValidSince(now);
        sale.setState(EntityState.ACTIVE);
        sale.setCreatedAt(now);
        sale.setClient(client.get());
        sale.setSalesDetails(
                dto.details()
                        .stream()
                        .map(item -> this.fillSaleDetail(
                                now,
                                item.amount(),
                                item.productId(),
                                sale
                            )
                        )
                        .toList()
        );
        sale.setTotal(
                sale.getSalesDetails()
                        .stream()
                        .mapToDouble(SaleDetail::getSubtotal)
                        .sum()
        );
        return this.mapper.toDto(this.repository.save(sale));
    }
}
