package com.gyl.ClientsMicroservice.client.update.service;

import com.gyl.ClientsMicroservice.client.update.dto.ClientUpdateRequestDto;
import com.gyl.ClientsMicroservice.client.update.dto.ClientUpdateResponseDto;

public interface ClientUpdateService {
    ClientUpdateResponseDto update(Long id, ClientUpdateRequestDto dto);
}
