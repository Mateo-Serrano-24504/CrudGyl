package com.gyl.ProductsMicroservice.security.service;

import com.gyl.ProductsMicroservice.security.dto.usuario.request.LoginRequestDTO;
import com.gyl.ProductsMicroservice.security.dto.usuario.request.RegistroRequestDTO;
import com.gyl.ProductsMicroservice.security.dto.usuario.response.RegistroResponseDTO;
import com.gyl.ProductsMicroservice.security.dto.usuario.response.TokenResponseDTO;

public interface AuthenticationService {
    RegistroResponseDTO registrar(RegistroRequestDTO dto);
    TokenResponseDTO login(LoginRequestDTO dto);
}