package com.auction.webauction.store.model;

import lombok.Value;
import java.math.BigDecimal;

@Value
public class Product {
    Long id;
    String title;
    BigDecimal price;
    Category category;
}
