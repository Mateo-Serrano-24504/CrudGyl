package com.gyl.CrudGyl.client.create.builder;

import com.gyl.CrudGyl.client.create.dto.ClientCreateRequestDto;
import com.gyl.CrudGyl.client.entity.Client;

import java.time.Instant;

public interface ClientCreateClientBuilder {
    Client build(ClientCreateRequestDto dto, Instant time);
}
