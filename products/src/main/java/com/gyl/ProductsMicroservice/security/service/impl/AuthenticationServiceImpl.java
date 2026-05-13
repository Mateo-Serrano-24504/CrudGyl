package com.gyl.ProductsMicroservice.security.service.impl;

import com.gyl.ProductsMicroservice.security.dto.usuario.request.LoginRequestDTO;
import com.gyl.ProductsMicroservice.security.dto.usuario.request.RegistroRequestDTO;
import com.gyl.ProductsMicroservice.security.dto.usuario.response.RegistroResponseDTO;
import com.gyl.ProductsMicroservice.security.dto.usuario.response.TokenResponseDTO;
import com.gyl.ProductsMicroservice.security.entity.Usuario;
import com.gyl.ProductsMicroservice.security.mapper.UsuarioMapper;
import com.gyl.ProductsMicroservice.security.repository.UsuarioRepository;
import com.gyl.ProductsMicroservice.security.TokenService;
import com.gyl.ProductsMicroservice.security.service.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UsuarioRepository usuarioRepository;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public RegistroResponseDTO registrar(RegistroRequestDTO dto) {
        String password = passwordEncoder.encode(dto.password());

        Usuario usuario = UsuarioMapper.toEntity(dto, password);

        usuarioRepository.save(usuario);

        return new RegistroResponseDTO(usuario.getUsername(), usuario.getPassword());
    }

    @Override
    public TokenResponseDTO login(LoginRequestDTO dto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.username(),dto.password())
        );

        UserDetails usuario = usuarioRepository.findByUsername(dto.username())
                .orElseThrow();

        String token = tokenService.getToken(usuario);
        return new TokenResponseDTO(token);
    }
}