package com.izanagi.back.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sale_detail")
public class SaleDetail {
    @Id
    @Column()
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column()
    private Long saleId;
    @Column()
    private Long productId;
    @Column()
    private Integer quantity;
    @Column()
    private Double price;
}
