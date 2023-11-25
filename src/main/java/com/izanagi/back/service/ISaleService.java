package com.izanagi.back.service;

import com.izanagi.back.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface ISaleService extends JpaRepository<Sale, Long> {
    @Query(value = "select p.name, p.price, sd.quantity, sd.price \n" +
            "from sale\n" +
            "inner join sale_detail sd\n" +
            "on sale.id = sd.sale_id\n" +
            "inner join products p\n" +
            "on sd.product_id = p.id\n" +
            "where user_id = :IN_USER_ID\n" +
            "and sale.id = :IN_SALE_ID", nativeQuery = true)
    List<Object[]> getSaleDetails(
            @Param("IN_USER_ID") Long userId,
            @Param("IN_SALE_ID") Long saleId
    );
}
