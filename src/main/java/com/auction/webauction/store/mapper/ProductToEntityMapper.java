package com.auction.webauction.store.mapper;

import com.auction.webauction.store.entity.ProductEntity;
import com.auction.webauction.store.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ProductToEntityMapper {
    @Mapping(target = "categoryTitle", source = "category.title")
    Product productEntityToProduct(ProductEntity productEntity);
    ProductEntity productToProductEntity(Product product);
}
