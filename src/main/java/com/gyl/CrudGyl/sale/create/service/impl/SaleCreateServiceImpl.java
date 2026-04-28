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
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SaleCreateServiceImpl implements SaleCreateService {
    private final SaleCreateRepository repository;
    private final ClientFindRepository clientFindRepository;
    private final SaleCreateMapper mapper;
    public SaleCreateServiceImpl(SaleCreateRepository repository, ClientFindRepository clientFindRepository, SaleCreateMapper mapper) {
        this.repository = repository;
        this.clientFindRepository = clientFindRepository;
        this.mapper = mapper;
    }

    @Override
    public SaleCreateResponseDto create(SaleCreateRequestDto dto) {
        Optional<Client> client = this.clientFindRepository.findById(dto.clientId());
        if (client.isEmpty()) {
            throw new ClientDoesNotExist(dto.clientId());
        }
        Sale sale = this.mapper.fromDto(dto);
        sale.setClient(client.get());
        return this.mapper.toDto(this.repository.save(sale));
    }
}
