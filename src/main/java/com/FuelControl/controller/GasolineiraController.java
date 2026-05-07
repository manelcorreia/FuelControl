package com.FuelControl.controller;

import com.FuelControl.dto.AlteracaoPrecoDTO;
import com.FuelControl.model.Gasolineira;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.FuelControl.service.GasolineiraService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gasolineira")
public class GasolineiraController {
    private final GasolineiraService gasolineiraService;

    @GetMapping("/todas-bombas/{nomeGasolineira}")
    public List<Gasolineira> verTodasBombasPorNome(@PathVariable String nomeGasolineira) {
        return gasolineiraService.verTodasPorNome(nomeGasolineira);
    }

    @GetMapping("/precos/{nomeGasolineira}")
    public String verPrecosGasolineira(@PathVariable String nomeGasolineira) {
        return gasolineiraService.verTodosOsPrecos(nomeGasolineira);
    }
}
