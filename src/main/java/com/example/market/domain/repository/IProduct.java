package com.example.market.domain.repository;

import java.util.List;

import com.example.market.domain.dto.ProductDTO;

public interface IProduct {
    public List<ProductDTO> getAllProducts();
    public ProductDTO getById(Long id);
    public ProductDTO save(ProductDTO product);
    public void delete(Long id);
    public ProductDTO update(Long id, ProductDTO product);
}
