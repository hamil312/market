package com.example.market.controller;

import java.util.List;
//import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.market.domain.dto.ProductDTO;
import com.example.market.domain.service.ProductService;


@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDTO> obtenerProductos() {
        return productService.getAll();
    }

    /*@GetMapping
    public ProductDTO obtenerProducto(@RequestParam Long id){
        return productService.getById(id);
    }*/
    

}
