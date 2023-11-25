package com.izanagi.back.service;

import com.izanagi.back.model.SaleDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISaleDetailService extends JpaRepository<SaleDetail, Long> {
}
