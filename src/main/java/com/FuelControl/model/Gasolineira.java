package com.FuelControl.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Gasolineira {
    private String nome;
    private double precoGasolina95;
    private double precoGasolina98;
    private double gasoleoSimples;
    private double gasoleoAditivado;
    private boolean postoCarregamento = false;
    private String regiao;
    private String localidade;
}
