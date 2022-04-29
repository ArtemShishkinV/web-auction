package com.auction.webauction.store.controller;

import com.auction.webauction.store.exception.ProductNotFoundException;
import com.auction.webauction.store.mapper.ProductToDtoMapper;
import com.auction.webauction.store.model.Product;
import com.auction.webauction.store.model.dto.ProductRequestDto;
import com.auction.webauction.store.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(productService.findById(id).toString());
        } catch (ProductNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public void add(@RequestBody ProductRequestDto productRequestDto) {
        productService.add(productRequestDto);
    }
}
