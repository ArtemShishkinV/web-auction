package com.auction.webauction.store.model.dto;

import lombok.Data;


@Data
public class ProductRequestDto {
    private String title;
    private Long price;
    private Long categoryId;
}
