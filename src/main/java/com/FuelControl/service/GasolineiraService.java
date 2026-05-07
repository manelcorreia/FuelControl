package com.FuelControl.service;

import com.FuelControl.model.NaoHaGasolineiraNomeException;
import com.FuelControl.repository.GasolineiraRepository;
import lombok.RequiredArgsConstructor;
import com.FuelControl.model.Gasolineira;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GasolineiraService {
    private final GasolineiraRepository gasolineiraRepository;

    public List<Gasolineira> verTodasPorNome(String nomeGasolineira) {
        List<Gasolineira> gasolineiras = gasolineiraRepository.findAllByNomeIgnoreCase(nomeGasolineira);

        if (gasolineiras.isEmpty()) {
            throw new NaoHaGasolineiraNomeException("Erro: Não há gasolineiras com o nome " + nomeGasolineira);
        } else {
            return gasolineiras;
        }
    }

    public String verTodosOsPrecos(String nomeGasolineira) {
        Gasolineira bomba = gasolineiraRepository.findFirstByNomeIgnoreCase(nomeGasolineira)
                .orElseThrow(() -> new NaoHaGasolineiraNomeException("Erro: Não há gasolineiras com o nome " + nomeGasolineira));

        return "--- " + nomeGasolineira + " ---\n" +
                "- Gasolina 95: " + bomba.getPrecoGasolina95() + "\n" +
                "- Gasolina 98: " + bomba.getPrecoGasolina98() + "\n" +
                "- Gasoleo Simples: " + bomba.getGasoleoSimples() +"\n" +
                "- Gasoleo Aditivado: " + bomba.getGasoleoAditivado();
    }
}
