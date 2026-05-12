package com.FuelControl.repository;

import com.FuelControl.model.Desconto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescontoRepository extends JpaRepository<Desconto, Integer> {
}
