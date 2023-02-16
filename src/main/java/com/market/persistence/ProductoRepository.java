package com.market.persistence;

import com.fasterxml.jackson.annotation.OptBoolean;
import com.market.domain.Product;
import com.market.domain.repository.ProductRepositry;
import com.market.persistence.CRUD.ProductoCrudRepository;
import com.market.persistence.entity.Producto;
import com.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepositry {
    @Autowired
    private ProductoCrudRepository productoCrudRepository;


    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getAll(){

        return productMapper.toProducts((List<Producto>) productoCrudRepository.findAll());
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        return Optional.of(
                productMapper.toProducts(
                        productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId)));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {

        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity,true);
        return productos.map(prods ->productMapper.toProducts(prods));

    }

    @Override
    public Optional<Product> getProdutc(int productId) {
        return  productoCrudRepository.findById(productId).map(producto ->productMapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = productMapper.toProducto(product);
        return productMapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId){
        productoCrudRepository.deleteById(productId);
    }

}
