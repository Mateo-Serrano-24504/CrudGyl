package com.gyl.CrudGyl.client.read.service;

import com.gyl.CrudGyl.client.read.dto.ClientReadResponseDto;

public interface ClientReadService {
    ClientReadResponseDto read(Long id);
}
