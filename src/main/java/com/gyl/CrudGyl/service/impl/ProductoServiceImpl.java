package com.gyl.CrudGyl.service.impl;

import com.gyl.CrudGyl.dto.ProductoRequestDto;
import com.gyl.CrudGyl.dto.ProductResponseDto;
import com.gyl.CrudGyl.entity.Producto;
import com.gyl.CrudGyl.exception.RecursoNoEncontradoException;
import com.gyl.CrudGyl.mapper.ProductoMapper;
import com.gyl.CrudGyl.repository.ProductoRepository;
import com.gyl.CrudGyl.service.ProductoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }

    @Override
    public ProductResponseDto crear(ProductoRequestDto dto) {
        Producto producto = ProductoMapper.toEntity(dto);
        Producto guardado = productoRepository.save(producto);
        return ProductoMapper.toResponseDto(guardado);
    }

    private List<ProductResponseDto> listarPorNombre(String nombre) {
        return productoRepository.findByNombre(nombre)
                .stream()
                .map(ProductoMapper::toResponseDto)
                .toList();
    }

    private List<ProductResponseDto> listarTodos() {
        return productoRepository.findAll()
                .stream()
                .map(ProductoMapper::toResponseDto)
                .toList();
    }

    @Override
    public List<ProductResponseDto> listarConParametros(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            return this.listarTodos();
        }
        return this.listarPorNombre(nombre);
    }

    @Override
    public ProductResponseDto buscarPorID(Long id) {
        return productoRepository.findById(id)
                .map(ProductoMapper::toResponseDto)
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "No se encontró el id: " + id
                ));
    }

    @Override
    public ProductResponseDto actualizar(Long id, ProductoRequestDto dto){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "No se encontró el id" + id
                ));

        ProductoMapper.updateEntity(producto,dto);
        Producto guardado = productoRepository.save(producto);
        return ProductoMapper.toResponseDto(guardado);

    }

    @Override
    public void eliminar(Long id){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "No se encontró el id" + id
                ));

        productoRepository.delete(producto);
    }
}
