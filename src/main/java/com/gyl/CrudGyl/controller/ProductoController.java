package com.gyl.CrudGyl.controller;

import com.gyl.CrudGyl.dto.ProductResponseDto;
import com.gyl.CrudGyl.dto.ProductoRequestDto;
import com.gyl.CrudGyl.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponseDto crear(@Valid @RequestBody ProductoRequestDto dto) {
        return productoService.crear(dto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponseDto> listar(@RequestParam(required = false) String nombre) {
        return productoService.listarConParametros(nombre);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(productoService.buscarPorID(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> actualizar(@PathVariable Long id, @Valid @RequestBody ProductoRequestDto dto) {
        return ResponseEntity.ok(productoService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        productoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
