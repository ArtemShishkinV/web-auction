package com.auction.webauction.store.controller;

import com.auction.webauction.store.exception.CategoryNotFoundException;
import com.auction.webauction.store.mapper.CategoryToDtoMapper;
import com.auction.webauction.store.model.Category;
import com.auction.webauction.store.model.dto.CategoryRequestDto;
import com.auction.webauction.store.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryToDtoMapper mapper;

    @GetMapping
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(categoryService.findById(id).toString());
        } catch (CategoryNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping
    public void add(@RequestBody CategoryRequestDto categoryRequestDto) {
        categoryService.add(mapper.categoryRequestDtoToCategory(categoryRequestDto));
    }

}
