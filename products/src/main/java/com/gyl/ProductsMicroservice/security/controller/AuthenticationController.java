package com.gyl.ProductsMicroservice.security.controller;

import com.gyl.ProductsMicroservice.security.dto.usuario.request.LoginRequestDTO;
import com.gyl.ProductsMicroservice.security.dto.usuario.request.RegistroRequestDTO;
import com.gyl.ProductsMicroservice.security.dto.usuario.response.RegistroResponseDTO;
import com.gyl.ProductsMicroservice.security.dto.usuario.response.TokenResponseDTO;
import com.gyl.ProductsMicroservice.security.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public RegistroResponseDTO registrar(@Valid @RequestBody RegistroRequestDTO dto) {
        return authenticationService.registrar(dto);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public TokenResponseDTO autenticar(@Valid @RequestBody LoginRequestDTO dto) {
        return authenticationService.login(dto);
    }
}