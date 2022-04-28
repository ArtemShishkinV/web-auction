package com.auction.webauction.store.mapper;

import com.auction.webauction.store.entity.CategoryEntity;
import com.auction.webauction.store.model.Category;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryToEntityMapper {
    CategoryEntity categoryToCategoryEntity(Category category);

    Category categoryEntityToCategory(CategoryEntity categoryEntity);
}
