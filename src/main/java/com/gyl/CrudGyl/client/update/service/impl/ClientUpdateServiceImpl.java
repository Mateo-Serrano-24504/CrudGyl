package com.gyl.CrudGyl.client.update.service.impl;

import com.gyl.CrudGyl.client.entity.Client;
import com.gyl.CrudGyl.client.entity.HistoricClient;
import com.gyl.CrudGyl.client.update.dto.ClientUpdateRequestDto;
import com.gyl.CrudGyl.client.update.dto.ClientUpdateResponseDto;
import com.gyl.CrudGyl.client.update.mapper.ClientUpdateMapper;
import com.gyl.CrudGyl.client.update.repository.ClientUpdateRepository;
import com.gyl.CrudGyl.client.update.repository.HistoricClientCreateRepository;
import com.gyl.CrudGyl.client.update.service.ClientUpdateService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
@Transactional
public class ClientUpdateServiceImpl implements ClientUpdateService {
    private final ClientUpdateRepository repository;
    private final HistoricClientCreateRepository historicClientCreateRepository;
    private final ClientUpdateMapper mapper;
    public ClientUpdateServiceImpl(
            ClientUpdateRepository repository,
            HistoricClientCreateRepository historicClientCreateRepository,
            ClientUpdateMapper mapper
    ) {
        this.repository = repository;
        this.historicClientCreateRepository = historicClientCreateRepository;
        this.mapper = mapper;
    }

    private HistoricClient createHistoricClient(Client oldClient, Instant invalidationTime) {
        HistoricClient historicClient = new HistoricClient(oldClient);
        historicClient.setValidTo(invalidationTime);
        return historicClient;
    }

    @Override
    public ClientUpdateResponseDto update(Long id, ClientUpdateRequestDto dto) {
        Instant now = Instant.now();
        Optional<Client> optionalClient = this.repository.findById(id);
        if (optionalClient.isEmpty()) {
            throw new RuntimeException("");
        }
        Client client = optionalClient.get();
        Client newClient = this.mapper.fromDto(dto);
        newClient.setId(client.getId());
        newClient.setValidSince(now);
        newClient.setState(client.getState());
        newClient.setCreatedAt(client.getCreatedAt());
        this.repository.save(newClient);
        this.historicClientCreateRepository.save(this.createHistoricClient(client, now));
        return this.mapper.toDto(newClient);
    }
}
