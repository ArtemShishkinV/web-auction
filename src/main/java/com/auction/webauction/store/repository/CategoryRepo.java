package com.auction.webauction.store.repository;

import com.auction.webauction.store.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends CrudRepository<CategoryEntity, Long> {
}
