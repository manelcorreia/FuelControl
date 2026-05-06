package com.FuelControl.service;

import com.FuelControl.model.NaoHaCombustivelNomeException;
import com.FuelControl.model.NaoHaGasolineiraNomeException;
import lombok.RequiredArgsConstructor;
import com.FuelControl.model.BaseDadosMemoria;
import com.FuelControl.model.Gasolineira;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GasolineiraService {
    private final BaseDadosMemoria baseDadosMemoria;

    public String mudarPrecoCombustivel(String nomeGasolineira, String nomeCombustivel, double novoPreco) {
        List<Gasolineira> gasolineiras = baseDadosMemoria.getGasolineiras();

        for (Gasolineira bomba : gasolineiras) {
            if (bomba.getNome().equalsIgnoreCase(nomeGasolineira)) {
                if (nomeCombustivel.equalsIgnoreCase("Gasolina simples")) {
                    bomba.setPrecoGasolina95(novoPreco);
                    return "Novo preço Gasolina Simples: " + novoPreco;
                } else if (nomeCombustivel.equalsIgnoreCase("Gasolina 98")) {
                    bomba.setPrecoGasolina98(novoPreco);
                    return "Novo preço Gasolina 98: " + novoPreco;
                } else if (nomeCombustivel.equalsIgnoreCase("Gasoleo Simples")) {
                    bomba.setGasoleoSimples(novoPreco);
                    return "Novo preço Gasoleo Simples: " + novoPreco;
                } else if (nomeCombustivel.equalsIgnoreCase("Gasoleo Aditivado")) {
                    bomba.setGasoleoAditivado(novoPreco);
                    return "Novo preço Gasoleo Aditivado: " + novoPreco;
                } else {
                    throw new NaoHaCombustivelNomeException("Não há nenhum combustível com esse nome. Tente Gasolina simples, gasolina 98, gasoleo simples ou gasoleo aditivado");
                }
            }
        }
        throw new NaoHaGasolineiraNomeException("Não há nenhuma gasolineira com o nome " + nomeGasolineira);
    }

    public String listarTodosPrecos(String nomeGasolineira) {
        List<Gasolineira> gasolineiras = baseDadosMemoria.getGasolineiras();

        for (Gasolineira bomba : gasolineiras) {
            if (bomba.getNome().equalsIgnoreCase(nomeGasolineira)) {
                return "Gasolina 95: " + bomba.getPrecoGasolina95() + "\nGasolina 98: " + bomba.getPrecoGasolina98() + "\nGasoleo Simples: " + bomba.getGasoleoSimples() + "\nGasoleo Aditivado: " + bomba.getGasoleoAditivado();
            }
        }
        throw new NaoHaGasolineiraNomeException("Não há nenhuma gasolineira com o nome " + nomeGasolineira);
    }
}
