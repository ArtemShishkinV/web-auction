package com.auction.webauction.store.service;

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
    public List<Category> findAllCategories() {
        return StreamSupport.stream(categoryRepo.findAll().spliterator(), false)
                .map(mapper::categoryEntityToCategory).toList();
    }
}
