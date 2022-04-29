package com.auction.webauction.store.service;

import com.auction.webauction.store.exception.CategoryNotFoundException;
import com.auction.webauction.store.mapper.CategoryToEntityMapper;
import com.auction.webauction.store.model.Category;
import com.auction.webauction.store.repository.CategoryRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class DefaultCategoryService implements CategoryService {
    private final CategoryRepo categoryRepo;
    private final CategoryToEntityMapper mapper;

    @Override
    public List<Category> findAll() {
        return StreamSupport.stream(categoryRepo.findAll().spliterator(), false)
                .map(mapper::categoryEntityToCategory).toList();
    }

    @Override
    public Category findById(Long id) throws CategoryNotFoundException {
        return mapper.categoryEntityToCategory(categoryRepo.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found: id = " + id)));
    }

    @Override
    public void add(Category category) {
        categoryRepo.save(mapper.categoryToCategoryEntity(category));
    }
}
