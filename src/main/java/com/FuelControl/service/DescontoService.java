package com.FuelControl.service;

import com.FuelControl.model.BaseDadosMemoria;
import com.FuelControl.model.Desconto;
import com.FuelControl.model.Gasolineira;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DescontoService {
    private final BaseDadosMemoria baseDadosMemoria;

    public String verTodosDescontos(String nomeGasolineira) {
        List<Gasolineira> bombas = baseDadosMemoria.getGasolineiras();
        List<Desconto> descontos = baseDadosMemoria.getDescontos();

        boolean bombaExiste = false;

        for (Gasolineira bomba : bombas) {
            if (bomba.getNome().equalsIgnoreCase(nomeGasolineira)) {
                bombaExiste = true;
                break;
            }
        }

        if (!bombaExiste) {
            return "Erro: Não foi encontrada nenhuma bomba com esse nome.";
        }

        StringBuilder resultado = new StringBuilder();
        resultado.append("Descontos ativos na ").append(nomeGasolineira).append(":\n");

        boolean temDesconto = false;

        for (Desconto desconto : descontos) {
            if (desconto.getNomeGasolineira().equalsIgnoreCase(nomeGasolineira)) {
                resultado.append("- ")
                        .append(desconto.getNome()).append(": ")
                        .append(desconto.getDesconto()).append(" cêntimos de desconto. (")
                        .append(desconto.getTipo()).append(")\n");
                temDesconto = true;
            }
        }

        if (!temDesconto) {
            return "Nenhum desconto encontrado na bomba " + nomeGasolineira;
        }

        return resultado.toString();
    }
}
