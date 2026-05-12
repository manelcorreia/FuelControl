package com.FuelControl.controller;

import com.FuelControl.model.Desconto;
import com.FuelControl.model.Utilizador;
import com.FuelControl.service.UtilizadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilizador")
@RequiredArgsConstructor
public class UtilizadorController {
    private final UtilizadorService utilizadorService;

    @PostMapping("/registo")
    public Utilizador criarUtilizador(@RequestParam String nome, @RequestParam String email) {
        return utilizadorService.criarNovoUtilizador(nome, email);
    }

    @PostMapping("/{utilizadorId}/desconto/novo-desconto")
    public Desconto adicionarNovoDesconto(@PathVariable Integer utilizadorId, @RequestParam String nomeCartao, @RequestParam String tipoDesconto, @RequestParam double valor, @RequestParam String nomeGasolineira) {
        return utilizadorService.adicionarDesconto(utilizadorId, nomeCartao, tipoDesconto, valor, nomeGasolineira);
    }

    @GetMapping("/{utilizadorId}/carteira-descontos")
    public List<Desconto> verTodosDescontos(@PathVariable Integer utilizadorId) {
        return utilizadorService.verOsMeusDescontos(utilizadorId);
    }

    @DeleteMapping("/{utilizadorId}/desconto/{descontoId}/apagar")
    public String apagarDesconto(@PathVariable Integer utilizadorId, @PathVariable Integer descontoId) {
        return utilizadorService.apagarMeuDesconto(utilizadorId, descontoId);
    }
}
