package com.gyl.CrudGyl.client.create.service;

import com.gyl.CrudGyl.client.create.dto.ClientCreateResponseDto;
import com.gyl.CrudGyl.client.create.dto.ClientCreateRequestDto;

public interface ClientCreateService {
    ClientCreateResponseDto create(ClientCreateRequestDto dto);
}
