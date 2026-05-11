package com.FuelControl.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Gasolineira {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private double precoGasolina95;
    private double precoGasolina98;
    private double gasoleoSimples;
    private double gasoleoAditivado;
    private boolean postoCarregamento = false;
    private String regiao;
    private String localidade;
}
