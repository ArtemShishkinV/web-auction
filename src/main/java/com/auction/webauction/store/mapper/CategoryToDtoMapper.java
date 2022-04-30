package com.auction.webauction.store.mapper;

import com.auction.webauction.store.model.Category;
import com.auction.webauction.store.model.dto.CategoryRequestDto;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryToDtoMapper {
    Category categoryRequestDtoToCategory(CategoryRequestDto categoryRequestDto);
}
