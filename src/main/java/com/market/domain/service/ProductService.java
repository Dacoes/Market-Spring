package com.market.domain.service;

import com.market.domain.Product;
import com.market.domain.repository.ProductRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepositry productRepositry;

    public List<Product> getAll(){
        return productRepositry.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return productRepositry.getProdutc(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        return productRepositry.getByCategory(categoryId);
    }

    public Optional<List<Product>> getScarseProducts(int quantity){
        return productRepositry.getScarseProducts(quantity);
    }

    public Product save(Product product){
        return productRepositry.save(product);
    }
    public boolean delete(int productId){
        return getProduct(productId).map(product -> {
            productRepositry.delete(productId);
            return true;
        }).orElse(false);

    }

}
