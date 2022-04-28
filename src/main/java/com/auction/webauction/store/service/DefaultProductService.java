package com.auction.webauction.store.service;

import com.auction.webauction.store.model.Product;
import com.auction.webauction.store.repository.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class DefaultProductService implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> getAllProducts() {
        return null;
    }
}
