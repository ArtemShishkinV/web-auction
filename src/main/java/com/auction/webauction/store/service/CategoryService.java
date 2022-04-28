package com.auction.webauction.store.service;

import com.auction.webauction.store.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategories();
}
