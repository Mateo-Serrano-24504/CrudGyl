package com.gyl.CrudGyl.client.read.controller;

import com.gyl.CrudGyl.client.read.dto.ClientReadResponseDto;
import com.gyl.CrudGyl.client.read.service.ClientReadService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientReadController {
    private final ClientReadService service;
    public ClientReadController(ClientReadService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientReadResponseDto read(@PathVariable Long id) {
        return this.service.read(id);
    }
}
