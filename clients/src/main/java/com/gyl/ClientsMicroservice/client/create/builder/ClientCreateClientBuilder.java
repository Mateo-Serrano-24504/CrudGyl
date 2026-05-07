package com.gyl.ClientsMicroservice.client.create.builder;

import com.gyl.ClientsMicroservice.client.create.dto.ClientCreateRequestDto;
import com.gyl.ClientsMicroservice.client.entity.Client;

import java.time.Instant;

public interface ClientCreateClientBuilder {
    Client build(ClientCreateRequestDto dto, Instant time);
}
