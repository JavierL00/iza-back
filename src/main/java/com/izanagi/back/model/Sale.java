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
@Table(name = "sale")
public class Sale {
    @Id
    @Column()
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column()
    private Long userId;
    @Column()
    private Double total;
    @Column()
    private String date;
}
