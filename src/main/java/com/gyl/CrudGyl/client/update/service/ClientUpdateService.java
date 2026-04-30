package com.gyl.CrudGyl.client.update.service;

import com.gyl.CrudGyl.client.update.dto.ClientUpdateRequestDto;
import com.gyl.CrudGyl.client.update.dto.ClientUpdateResponseDto;

public interface ClientUpdateService {
    ClientUpdateResponseDto update(Long id, ClientUpdateRequestDto dto);
}
