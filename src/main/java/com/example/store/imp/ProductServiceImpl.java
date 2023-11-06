package com.example.store.imp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.store.model.Product;
import com.example.store.repository.ProductRepository;
import com.example.store.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product create(Product product) {
        return repository.save(product);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public Product update(int id, Product product) {
        Optional<Product> existingProductOptional = repository.findById(id);

        if (existingProductOptional.isPresent()) {
            Product existingProduct = existingProductOptional.get();
            existingProduct.setProductName(product.getProductName());
            existingProduct.setPrice(product.getPrice());

            return repository.save(existingProduct);
        } else {
            
            return null;
        }
    }
}

