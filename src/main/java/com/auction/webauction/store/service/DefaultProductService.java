package com.auction.webauction.store.service;

import com.auction.webauction.store.entity.ProductEntity;
import com.auction.webauction.store.exception.ProductNotFoundException;
import com.auction.webauction.store.mapper.CategoryToEntityMapper;
import com.auction.webauction.store.mapper.ProductToDtoMapper;
import com.auction.webauction.store.mapper.ProductToEntityMapper;
import com.auction.webauction.store.model.Product;
import com.auction.webauction.store.model.dto.ProductRequestDto;
import com.auction.webauction.store.repository.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class DefaultProductService implements ProductService {
    private ProductRepo productRepo;
    private CategoryService categoryService;
    private ProductToEntityMapper productToEntityMapper;
    private CategoryToEntityMapper categoryToEntityMapper;
    private ProductToDtoMapper productToDtoMapper;

    @Override
    public List<Product> findAll() {
        return StreamSupport.stream(productRepo.findAll().spliterator(), false)
                .map(productToEntityMapper::productEntityToProduct).toList();
    }

    @Override
    public Product findById(Long id) {
        return productToEntityMapper.productEntityToProduct(productRepo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found: id = " + id)));
    }

    @Override
    public void add(ProductRequestDto productRequestDto) {
        ProductEntity productEntity = productToEntityMapper.productToProductEntity(
                productToDtoMapper.productRequestDtoToProduct(productRequestDto));
        productEntity.setCategory(categoryToEntityMapper.categoryToCategoryEntity(
                categoryService.findById(productRequestDto.getCategoryId())));
        productRepo.save(productEntity);
    }
}
