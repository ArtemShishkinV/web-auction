package com.auction.webauction.store.model;

import lombok.Value;

@Value
public class Product {
    Long id;
    String title;
    Long price;
    String categoryTitle;
}
