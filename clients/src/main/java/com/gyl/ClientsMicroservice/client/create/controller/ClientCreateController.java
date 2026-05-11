package com.gyl.ClientsMicroservice.client.create.controller;

import com.gyl.ClientsMicroservice.client.create.dto.ClientCreateResponseDto;
import com.gyl.ClientsMicroservice.client.create.dto.ClientCreateRequestDto;
import com.gyl.ClientsMicroservice.client.create.service.ClientCreateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class ClientCreateController {
    private final ClientCreateService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientCreateResponseDto create(@Valid @RequestBody ClientCreateRequestDto dto) {
        return this.service.create(dto);
    }
}
