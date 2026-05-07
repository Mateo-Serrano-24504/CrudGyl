package com.gyl.ClientsMicroservice.client.create.service;

import com.gyl.ClientsMicroservice.client.create.dto.ClientCreateResponseDto;
import com.gyl.ClientsMicroservice.client.create.dto.ClientCreateRequestDto;

public interface ClientCreateService {
    ClientCreateResponseDto create(ClientCreateRequestDto dto);
}
