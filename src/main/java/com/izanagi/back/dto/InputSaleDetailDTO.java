package com.izanagi.back.dto;

import lombok.Data;

import java.util.List;

@Data
public class InputSaleDetailDTO {
    private Long userId;
    private Double total;
    private List<SaleDetailDto> detailList;
}
