package com.FuelControl.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Desconto {
    private String nome; // cartão pingo doce, cartão sócio benfica, etc
    private String tipo; // acumulativo no cartão, desconto direto, etc
    private double desconto;
    private String nomeGasolineira;
}
