package com.example.market.infraestructure.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.market.domain.dto.ProductDTO;
import com.example.market.domain.repository.IProduct;
import com.example.market.infraestructure.crud.ProductoRepository;
import com.example.market.infraestructure.entity.Producto;
import com.example.market.infraestructure.mapper.ProductoMapper;


@Repository
public class ProductoImpl implements IProduct  {
    
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ProductoMapper productoMapper;

    public List<ProductDTO> getAllProducts() {
        List<Producto> productos = productoRepository.findAll();
        return productoMapper.toProductsDTO(productos);
    }

    public ProductDTO getById(Long id){
        Producto producto = productoRepository.findById(id).get();
        return  productoMapper.toProductDTO(producto);
    }

    public ProductDTO save(ProductDTO product) {
        Producto producto = productoMapper.toProducto(product);
        return productoMapper.toProductDTO(productoRepository.save(producto));
    }

    public void delete(Long id) {
        productoRepository.deleteById(id);
    }

    public ProductDTO update(Long id, ProductDTO product) {
        Producto productoToUpdate = productoRepository.findById(id).get();
        Producto updatedProducto = productoMapper.toProducto(product);
        productoToUpdate.setNombre(updatedProducto.getNombre());
        productoToUpdate.setPrecio(updatedProducto.getPrecio());
        productoToUpdate.setStock(updatedProducto.getStock());
        productoRepository.save(productoToUpdate);
        return productoMapper.toProductDTO(productoRepository.save(productoToUpdate));
    }
}
