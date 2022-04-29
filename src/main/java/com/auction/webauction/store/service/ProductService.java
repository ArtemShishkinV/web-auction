package com.auction.webauction.store.service;

import com.auction.webauction.store.exception.ProductNotFoundException;
import com.auction.webauction.store.model.Product;
import com.auction.webauction.store.model.dto.ProductRequestDto;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Long id) throws ProductNotFoundException;
    void add(ProductRequestDto productRequestDto);
}
