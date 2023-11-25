package com.izanagi.back.dto;

import lombok.Data;

import java.util.List;

@Data
public class OutputSaleDetailsDTO {
    private String id;
    private String date;
    private List<SaleDetailsDTO> saleDetails;
    private String total;
}
