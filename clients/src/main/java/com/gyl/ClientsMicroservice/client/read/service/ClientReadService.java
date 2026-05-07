package com.gyl.ClientsMicroservice.client.read.service;

import com.gyl.ClientsMicroservice.client.read.dto.ClientReadResponseDto;

public interface ClientReadService {
    ClientReadResponseDto read(Long id);
}
