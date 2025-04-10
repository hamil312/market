package com.example.market.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.market.domain.dto.ProductDTO;
import com.example.market.domain.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDTO> obtenerProductos() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ProductDTO obtenerProducto(@PathVariable Long id){
        return productService.getById(id);
    }

    @PostMapping
    public ProductDTO guardar(@RequestBody ProductDTO entity) {
        return productService.save(entity);
    }

    @PutMapping("/{id}")
    public ProductDTO actualizar(@PathVariable Long id, @RequestBody ProductDTO entity) {
        return productService.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        productService.delete(id);
    }

}
