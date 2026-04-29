package com.gyl.CrudGyl.sale.create.service.impl;

import com.gyl.CrudGyl.client.entity.Client;
import com.gyl.CrudGyl.sale.create.dto.SaleCreateRequestDto;
import com.gyl.CrudGyl.sale.create.dto.SaleCreateResponseDto;
import com.gyl.CrudGyl.sale.create.exception.ClientDoesNotExist;
import com.gyl.CrudGyl.sale.create.mapper.SaleCreateMapper;
import com.gyl.CrudGyl.sale.create.repository.ClientFindRepository;
import com.gyl.CrudGyl.sale.create.repository.SaleCreateRepository;
import com.gyl.CrudGyl.sale.create.service.SaleCreateService;
import com.gyl.CrudGyl.sale.entity.Sale;
import com.gyl.CrudGyl.saleDetail.create.mapper.SaleDetailCreateMapper;
import com.gyl.CrudGyl.saleDetail.entity.SaleDetail;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
@Transactional
public class SaleCreateServiceImpl implements SaleCreateService {
    private final SaleCreateRepository repository;
    private final ClientFindRepository clientFindRepository;
    private final SaleCreateMapper mapper;
    private final SaleDetailCreateMapper saleDetailCreateMapper;
    public SaleCreateServiceImpl(
            SaleCreateRepository repository,
            ClientFindRepository clientFindRepository,
            SaleCreateMapper mapper,
            SaleDetailCreateMapper saleDetailCreateMapper
    ) {
        this.repository = repository;
        this.clientFindRepository = clientFindRepository;
        this.mapper = mapper;
        this.saleDetailCreateMapper = saleDetailCreateMapper;
    }

    @Override
    public SaleCreateResponseDto create(SaleCreateRequestDto dto) {
        Optional<Client> client = this.clientFindRepository.findById(dto.clientId());
        if (client.isEmpty()) {
            throw new ClientDoesNotExist(dto.clientId());
        }
        Sale sale = new Sale();
        sale.setCreatedAt(Instant.now());
        sale.setClient(client.get());
        sale.setSalesDetails(
                dto.requests()
                        .stream()
                        .map(this.saleDetailCreateMapper::fromDto)
                        .toList()
        );
        sale.getSalesDetails().forEach(item -> {
            item.setSale(sale);
            item.setClient(client.get());
        });
        sale.setTotal(
                sale.getSalesDetails()
                        .stream()
                        .mapToDouble(SaleDetail::getSubtotal)
                        .sum()
        );
        return this.mapper.toDto(this.repository.save(sale));
    }
}
