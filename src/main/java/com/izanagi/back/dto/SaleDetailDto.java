package com.izanagi.back.dto;

import lombok.Data;

@Data
public class SaleDetailDto {
    private Long productId;
    private Double price;
    private Integer quantity;
}
