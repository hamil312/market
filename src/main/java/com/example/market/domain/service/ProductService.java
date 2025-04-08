package com.example.market.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.market.domain.dto.ProductDTO;
import com.example.market.infraestructure.repositories.ProductoImpl;

@Service
public class ProductService {

    @Autowired
    private ProductoImpl productImpl;

    public List<ProductDTO> getAll() {
        return productImpl.getAllProducts();
    }
    public ProductDTO getById(Long id){ 
        return productImpl.getById(id); 
    }

    public ProductDTO save(ProductDTO product) { 
        return productImpl.save(product); 
    }

    public void delete(Long id) { 
        productImpl.delete(id); 
    }

    public ProductDTO update(Long id, ProductDTO product) { 
        return productImpl.update(id, product);
    }
}
