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
@Table(name = "clients")
public class Clients {
    @Id
    @Column()
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column()
    private String username;
    @Column()
    private String email;
    @Column()
    private String password;
}
