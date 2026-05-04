package com.gyl.CrudGyl.sale.update.service.impl;

import com.gyl.CrudGyl.client.entity.Client;
import com.gyl.CrudGyl.client.read.repository.ClientReadRepository;
import com.gyl.CrudGyl.sale.entity.Sale;
import com.gyl.CrudGyl.sale.update.dto.SaleUpdateRequestDto;
import com.gyl.CrudGyl.sale.update.dto.SaleUpdateResponseDto;
import com.gyl.CrudGyl.sale.update.exception.SaleUpdateClientDoesNotExist;
import com.gyl.CrudGyl.sale.update.exception.SaleUpdateSaleDoesNotExist;
import com.gyl.CrudGyl.sale.update.mapper.SaleUpdateMapper;
import com.gyl.CrudGyl.sale.update.repository.SaleUpdateRepository;
import com.gyl.CrudGyl.sale.update.service.SaleUpdateService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
@Transactional
public class SaleUpdateServiceImpl implements SaleUpdateService {
    private final SaleUpdateRepository repository;
    private final ClientReadRepository clientReadRepository;
    private final SaleUpdateMapper mapper;
    public SaleUpdateServiceImpl(
            SaleUpdateRepository repository,
            ClientReadRepository clientReadRepository,
            SaleUpdateMapper mapper
    ) {
        this.repository = repository;
        this.clientReadRepository = clientReadRepository;
        this.mapper = mapper;
    }

    @Override
    public SaleUpdateResponseDto update(Long id, SaleUpdateRequestDto dto) {
        Instant now = Instant.now();
        Optional<Sale> optionalSale = this.repository.findById(id);
        if (optionalSale.isEmpty()) {
            throw new SaleUpdateSaleDoesNotExist(id);
        }
        Optional<Client> optionalClient = this.clientReadRepository.findById(dto.clientId());
        if (optionalClient.isEmpty()) {
            throw new SaleUpdateClientDoesNotExist(dto.clientId());
        }
        Sale sale = optionalSale.get();
        Client client = optionalClient.get();
        sale.setValidSince(now);
        sale.setState(dto.state());
        sale.setClient(client);
        return this.mapper.toDto(this.repository.save(sale));
    }
}
