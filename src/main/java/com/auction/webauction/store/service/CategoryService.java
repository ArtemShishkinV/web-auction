package com.auction.webauction.store.service;

import com.auction.webauction.store.exception.CategoryNotFoundException;
import com.auction.webauction.store.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(Long id) throws CategoryNotFoundException;
    void add(Category category);
}
