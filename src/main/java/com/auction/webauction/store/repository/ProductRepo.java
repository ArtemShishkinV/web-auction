package com.auction.webauction.store.repository;

import com.auction.webauction.store.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends CrudRepository<ProductEntity, Long> {
}
