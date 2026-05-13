package com.gyl.ClientsMicroservice.security.service;

import com.gyl.ClientsMicroservice.security.dto.usuario.request.LoginRequestDTO;
import com.gyl.ClientsMicroservice.security.dto.usuario.request.RegistroRequestDTO;
import com.gyl.ClientsMicroservice.security.dto.usuario.response.RegistroResponseDTO;
import com.gyl.ClientsMicroservice.security.dto.usuario.response.TokenResponseDTO;

public interface AuthenticationService {
    RegistroResponseDTO registrar(RegistroRequestDTO dto);
    TokenResponseDTO login(LoginRequestDTO dto);
}