package com.gyl.CrudGyl.client.update.controller;

import com.gyl.CrudGyl.client.update.dto.ClientUpdateRequestDto;
import com.gyl.CrudGyl.client.update.dto.ClientUpdateResponseDto;
import com.gyl.CrudGyl.client.update.service.ClientUpdateService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientUpdateController {
    private final ClientUpdateService service;
    public ClientUpdateController(ClientUpdateService service) {
        this.service = service;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientUpdateResponseDto update(@PathVariable Long id, @Valid @RequestBody ClientUpdateRequestDto dto) {
        return this.service.update(id, dto);
    }
}
