package com.example.market.domain.repository;

import java.util.List;

import com.example.market.domain.dto.ProductDTO;

public interface IProduct {

    public List<ProductDTO> getAll();
    // public ProductDTO getById(Long id);
}
