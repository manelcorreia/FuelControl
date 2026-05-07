package com.FuelControl.repository;

import com.FuelControl.model.Gasolineira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GasolineiraRepository extends JpaRepository<Gasolineira, Integer> {
    List<Gasolineira> findAllByNomeIgnoreCase(String nome);
    Optional<Gasolineira> findFirstByNomeIgnoreCase(String nome);
}
