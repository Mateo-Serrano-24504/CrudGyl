package com.gyl.ClientsMicroservice.client.update.service.impl;

import com.gyl.ClientsMicroservice.client.entity.Client;
import com.gyl.ClientsMicroservice.client.entity.HistoricClient;
import com.gyl.ClientsMicroservice.client.update.mapper.ClientUpdateHistoricClientMapper;
import com.gyl.ClientsMicroservice.client.update.updater.ClientUpdateClientUpdater;
import com.gyl.ClientsMicroservice.client.update.dto.ClientUpdateRequestDto;
import com.gyl.ClientsMicroservice.client.update.dto.ClientUpdateResponseDto;
import com.gyl.ClientsMicroservice.client.update.exception.ClientUpdateClientDoesNotExist;
import com.gyl.ClientsMicroservice.client.update.mapper.ClientUpdateMapper;
import com.gyl.ClientsMicroservice.client.update.repository.ClientUpdateRepository;
import com.gyl.ClientsMicroservice.client.update.repository.HistoricClientCreateRepository;
import com.gyl.ClientsMicroservice.client.update.service.ClientUpdateService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Transactional
@RequiredArgsConstructor
public class ClientUpdateServiceImpl implements ClientUpdateService {
    private final ClientUpdateRepository repository;
    private final HistoricClientCreateRepository historicClientCreateRepository;
    private final ClientUpdateMapper mapper;
    private final ClientUpdateHistoricClientMapper historicClientMapper;
    private final ClientUpdateClientUpdater builder;

    private void saveHistoricClient(Client oldClient, Instant invalidationTime) {
        HistoricClient historicClient = this.historicClientMapper.toHistoric(oldClient, invalidationTime);
        this.historicClientCreateRepository.save(historicClient);
    }

    @Override
    public ClientUpdateResponseDto update(Long id, ClientUpdateRequestDto dto) {
        Instant now = Instant.now();
        Client client = this.repository
                .findById(id)
                .orElseThrow(() -> new ClientUpdateClientDoesNotExist(id));
        this.saveHistoricClient(client, now);
        this.builder.update(client, dto);
        client.setValidSince(now);
        return this.mapper.toDto(client);
    }
}
