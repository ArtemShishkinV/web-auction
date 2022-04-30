package com.auction.webauction.store.mapper;

import com.auction.webauction.store.model.Product;
import com.auction.webauction.store.model.dto.ProductRequestDto;
import org.mapstruct.Mapper;

@Mapper
public interface ProductToDtoMapper {
    Product productRequestDtoToProduct(ProductRequestDto productRequestDto);
}
