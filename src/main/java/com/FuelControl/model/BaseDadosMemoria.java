package com.FuelControl.model;

import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Getter
@Repository
public class BaseDadosMemoria {
    private final List<Gasolineira> gasolineiras = new ArrayList<>();
    private final List<Desconto> descontos = new ArrayList<>();

    public BaseDadosMemoria() {
        Gasolineira bp = new Gasolineira();
        bp.setNome("BP");
        bp.setPrecoGasolina95(2.05);

        Gasolineira galp = new Gasolineira();
        galp.setNome("Galp");
        galp.setPrecoGasolina98(2.15);

        gasolineiras.add(bp);
        gasolineiras.add(galp);

        Desconto cartaoBenfica = new Desconto();
        cartaoBenfica.setNome("Cartão benfica");
        cartaoBenfica.setTipo("Desconto direto");
        cartaoBenfica.setDesconto(0.06);
        cartaoBenfica.setNomeGasolineira("BP");

        descontos.add(cartaoBenfica);
    }
}
