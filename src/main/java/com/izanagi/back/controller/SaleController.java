package com.izanagi.back.controller;

import com.izanagi.back.dto.InputSaleDetailDTO;
import com.izanagi.back.dto.InputSaleDetailsDTO;
import com.izanagi.back.dto.OutputSaleDetailsDTO;
import com.izanagi.back.dto.SaleDetailDto;
import com.izanagi.back.dto.SaleDetailsDTO;
import com.izanagi.back.model.Clients;
import com.izanagi.back.model.Sale;
import com.izanagi.back.model.SaleDetail;
import com.izanagi.back.service.ISaleDetailService;
import com.izanagi.back.service.ISaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sale")
public class SaleController {
    private final ISaleService saleService;
    private final ISaleDetailService saleDetailService;

    @PostMapping("/register")
    public ResponseEntity<String> registerSale(
            @RequestBody InputSaleDetailDTO input
    ) {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            Sale newSale = new Sale();
            newSale.setUserId(input.getUserId());
            newSale.setTotal(input.getTotal());
            newSale.setDate(dtf.format(now));
            Sale insertedSale = saleService.save(newSale);

            List<SaleDetailDto> saleDetails = input.getDetailList();
            for (SaleDetailDto saleDetail : saleDetails) {
                SaleDetail newSaleDetail = new SaleDetail();
                newSaleDetail.setSaleId(insertedSale.getId());
                newSaleDetail.setProductId(saleDetail.getProductId());
                newSaleDetail.setQuantity(saleDetail.getQuantity());
                newSaleDetail.setPrice(saleDetail.getPrice());
                saleDetailService.save(newSaleDetail);
            }

            return ResponseEntity.ok("Venta registrada exitosamente");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al registrar venta. Error: " + e.getMessage());
        }
    }

    @PostMapping("/get")
    public ResponseEntity<OutputSaleDetailsDTO> getSale(
            @RequestBody InputSaleDetailsDTO input
    ) {
        try {
            Sale sale = saleService.getReferenceById(input.getSaleId());

            OutputSaleDetailsDTO output = new OutputSaleDetailsDTO();
            output.setId(sale.getId().toString());
            output.setDate(sale.getDate());
            output.setTotal(sale.getTotal().toString());

            List<Object[]> saleList = saleService.getSaleDetails(
                    input.getUserId(),
                    input.getSaleId()
            );

            List<SaleDetailsDTO> saleDetails = new ArrayList<>();
            for (Object[] saleDetail : saleList) {
                SaleDetailsDTO newSaleDetail = new SaleDetailsDTO();
                newSaleDetail.setName(saleDetail[0].toString());
                newSaleDetail.setPrice(saleDetail[1].toString());
                newSaleDetail.setQuantity(saleDetail[2].toString());
                newSaleDetail.setTotal(saleDetail[3].toString());
                saleDetails.add(newSaleDetail);
            }
            output.setSaleDetails(saleDetails);

            return ResponseEntity.ok(output);
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
