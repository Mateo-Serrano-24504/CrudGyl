package com.gyl.CrudGyl.service;

import com.gyl.CrudGyl.dto.ProductoRequestDto;
import com.gyl.CrudGyl.dto.ProductResponseDto;

import java.util.List;

public interface ProductoService {

    ProductResponseDto crear(ProductoRequestDto producto);

    List<ProductResponseDto> listarConParametros(String nombre);

    ProductResponseDto buscarPorID(Long id);

    ProductResponseDto actualizar(Long id, ProductoRequestDto dto);

    void eliminar(Long id);
}
