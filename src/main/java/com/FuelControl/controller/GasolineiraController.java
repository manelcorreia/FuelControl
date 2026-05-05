package com.FuelControl.controller;

import com.FuelControl.dto.AlteracaoPrecoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.FuelControl.service.GasolineiraService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gasolineira")
public class GasolineiraController {
    private final GasolineiraService gasolineiraService;

    @PostMapping("/alteracao-preco")
    public String alterarPrecoCombustivel(@RequestBody AlteracaoPrecoDTO dados) {
        return gasolineiraService.mudarPrecoCombustivel(dados.getNomeGasolineira(), dados.getNomeCombustivel(), dados.getNovoPreco());
    }

    @GetMapping("/todos-precos/{nomeGasolineira}")
    public String verTodosPrecos(@PathVariable String nomeGasolineira) {
        return gasolineiraService.listarTodosPrecos(nomeGasolineira);
    }
}
