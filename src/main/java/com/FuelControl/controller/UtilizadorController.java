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

    @GetMapping("/{utilizadorId}/carteira-descontos/nomeCartao-{nomeCartao}")
    public List<Desconto> verTodosPorNomeCartao(@PathVariable Integer utilizadorId, @PathVariable String nomeCartao) {
        return utilizadorService.verTodosPorNomeCartao(utilizadorId, nomeCartao);
    }

    @GetMapping("/{utilizadorId}/carteira-descontos/tipoDesconto-{tipoDesconto}")
    public List<Desconto> verTodosPorTipoDesconto(@PathVariable Integer utilizadorId, @PathVariable String tipoDesconto) {
        return utilizadorService.verTodosPorTipoDesconto(utilizadorId, tipoDesconto);
    }

    @GetMapping("/{utilizadorId}/carteira-descontos/valorDesconto={valorDesconto}")
    public List<Desconto> verTodosPorValorDesconto(@PathVariable Integer utilizadorId, @PathVariable double valorDesconto) {
        return utilizadorService.verTodosPorValorDesconto(utilizadorId, valorDesconto);
    }

    @GetMapping("/{utilizadorId}/carteira-descontos/nomeGasolineira-{nomeGasolineira}")
    public List<Desconto> verTodosPorNomeGasolineira(@PathVariable Integer utilizadorId, @PathVariable String nomeGasolineira) {
        return utilizadorService.verTodosDescontosPorNomeGasolineira(utilizadorId, nomeGasolineira);
    }

    @GetMapping("/{utilizadorId}/carteira-descontos/tipo_desconto-{tipoDesconto}/bomba-{nomeGasolineira}")
    public List<Desconto> verDescontoPorUtilizadorPorTipoPorGasolineira(@PathVariable Integer utilizadorId, @PathVariable String tipoDesconto, @PathVariable String nomeGasolineira) {
        return utilizadorService.verPorUtilizadorTipoGasolineira(utilizadorId, tipoDesconto, nomeGasolineira);
    }

    @GetMapping("/{utilizadorId}/carteira-descontos/valorDesconto>{valor}")
    public List<Desconto> verDescontosPorUtilizadorDescontoMaiorQueX(@PathVariable Integer utilizadorId, @PathVariable double valor) {
        return utilizadorService.verPorUtilizadorDescontoMaiorQueX(utilizadorId, valor);
    }

    @GetMapping("/{utilizadorId}/carteira-descontos/valorDesconto>{valor}/bomba-{gasolineira}")
    public List<Desconto> verDescontosPorUtilizadorDescontoMaiorQueXNaGasolineira(@PathVariable Integer utilizadorId, @PathVariable double valor, @PathVariable String gasolineira) {
        return utilizadorService.verPorUtilizadorDescontoMaiorQueXNaGasolineira(utilizadorId, valor, gasolineira);
    }

    @GetMapping("/{utilizadorId}/carteira-descontos/regiao-{regiao}")
    public List<Desconto> verDescontosPorUtilizadorNaRegiao(@PathVariable Integer utilizadorId, @PathVariable String regiao) {
        return utilizadorService.verPorRegiaoQueBombasEDescontosTenhoNaCarteira(utilizadorId, regiao);
    }

    @GetMapping("/{utilizadorId}/carteira-descontos/localidade-{localidade}")
    public List<Desconto> verDescontosPorUtilizadorNaLocalidade(@PathVariable Integer utilizadorId, @PathVariable String localidade) {
        return utilizadorService.verPorLocalidadeQueBombasEDescontosTenhoNaCarteira(utilizadorId, localidade);
    }

    @GetMapping("/{utilizadorId}/carteira-descontos/regiao-{regiao}/localidade-{localidade}")
    public List<Desconto> verDescontosPorUtilizadorNaLocalidadeDumaRegiao(@PathVariable Integer utilizadorId, @PathVariable String regiao, @PathVariable String localidade) {
        return utilizadorService.verPorLocalidadeNaRegiaoQueBombasEDescontosTenhoNaCarteira(utilizadorId, regiao, localidade);
    }
}
