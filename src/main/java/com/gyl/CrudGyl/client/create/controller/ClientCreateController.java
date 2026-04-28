package com.gyl.CrudGyl.client.create.controller;

import com.gyl.CrudGyl.client.create.dto.ClientCreateResponseDto;
import com.gyl.CrudGyl.client.create.dto.ClientCreateRequestDto;
import com.gyl.CrudGyl.client.create.service.ClientCreateService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientCreateController {
    private final ClientCreateService service;
    public ClientCreateController(ClientCreateService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientCreateResponseDto create(@Valid @RequestBody ClientCreateRequestDto dto) {
        return this.service.create(dto);
    }
}
