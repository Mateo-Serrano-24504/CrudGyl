package com.gyl.ProductsMicroservice.security.mapper;

import com.gyl.ProductsMicroservice.security.dto.usuario.request.LoginRequestDTO;
import com.gyl.ProductsMicroservice.security.dto.usuario.request.RegistroRequestDTO;
import com.gyl.ProductsMicroservice.security.entity.Role;
import com.gyl.ProductsMicroservice.security.entity.Usuario;

public class UsuarioMapper {
    public UsuarioMapper() {}

    public static Usuario toEntity(RegistroRequestDTO dto, String password) {
        Usuario usuario = new Usuario();

        usuario.setUsername(dto.username());
        usuario.setPassword(password);
        usuario.setRol(Role.USER);

        return usuario;
    }

    public static void actualizarEntidad(Usuario usuario, LoginRequestDTO dto) {
        usuario.setUsername(dto.username());
        usuario.setPassword(dto.password());
    }
}