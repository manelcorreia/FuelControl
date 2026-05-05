package com.FuelControl.dto;

import lombok.Data;

@Data
public class AlteracaoPrecoDTO {
    private String nomeGasolineira;
    private String nomeCombustivel;
    private double novoPreco;
}
