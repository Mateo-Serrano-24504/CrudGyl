package com.gyl.ClientsMicroservice.client.read.controller;

import com.gyl.ClientsMicroservice.client.read.dto.ClientReadResponseDto;
import com.gyl.ClientsMicroservice.client.read.service.ClientReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class ClientReadController {
    private final ClientReadService service;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientReadResponseDto read(@PathVariable Long id) {
        return this.service.read(id);
    }
}
