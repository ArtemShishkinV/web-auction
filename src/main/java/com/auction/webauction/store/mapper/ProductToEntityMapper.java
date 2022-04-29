package com.auction.webauction.store.mapper;

import com.auction.webauction.store.entity.ProductEntity;
import com.auction.webauction.store.model.Product;
import org.mapstruct.Mapper;

@Mapper
public interface ProductToEntityMapper {
    Product productEntityToProduct(ProductEntity productEntity);
    ProductEntity productToProductEntity(Product product);
}
