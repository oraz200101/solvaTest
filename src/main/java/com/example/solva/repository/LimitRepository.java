package com.example.solva.repository;

import com.example.solva.model.LimitMoney;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LimitRepository extends JpaRepository<LimitMoney,Long> {
}
