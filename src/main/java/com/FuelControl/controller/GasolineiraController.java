package com.FuelControl.controller;

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

    @GetMapping("/regiao/{nomeRegiao}")
    public List<Gasolineira> verTodasPorRegiao(@PathVariable String nomeRegiao) {
        return gasolineiraService.verTodasPorRegiao(nomeRegiao);
    }

    @GetMapping("/localidade/{nomeLocalidade}")
    public List<Gasolineira> verTodasPorLocalidade(@PathVariable String nomeLocalidade) {
        return gasolineiraService.verTodasPorLocalidade(nomeLocalidade);
    }

    @GetMapping("/posto-carregamento")
    public List<Gasolineira> verTodasComPostoCarregamento() {
        return gasolineiraService.verTodasComPostoCarregamento();
    }

    @GetMapping("/posto-carregamento/regiao/{nomeRegiao}")
    public List<Gasolineira> verPorRegiaoPostoCarregamento(@PathVariable String nomeRegiao) {
        return gasolineiraService.verRegiaoPostoCarregamento(nomeRegiao);
    }

    @GetMapping("/posto-carregamento/localidade/{nomeLocalidade}")
    public List<Gasolineira> verPorLocalidadePostoCarregamento(@PathVariable String nomeLocalidade) {
        return gasolineiraService.verLocalidadePostoCarregamento(nomeLocalidade);
    }

    @GetMapping("/posto-carregamento/regiao-{nomeRegiao}/localidade-{nomeLocalidade}")
    public List<Gasolineira> verPorRegiaoPorLocalidadePostoCarregamento(@PathVariable String nomeRegiao, @PathVariable String nomeLocalidade) {
        return gasolineiraService.verBombasNumaLocalidadeDumaRegiaoCPostoCarregamento(nomeRegiao, nomeLocalidade);
    }

    @GetMapping("/posto-carregamento/{nomeGasolineira}/regiao-{nomeRegiao}/localidade-{nomeLocalidade}")
    public List<Gasolineira> verPorNomeNaLocalidadeDRegiaoPostoCarregamento(@PathVariable String nomeGasolineira, @PathVariable String nomeRegiao, @PathVariable String nomeLocalidade) {
        return gasolineiraService.verBombasPorNomeNumaLocalidadeDRegiaoCPostoCarregamento(nomeGasolineira, nomeRegiao, nomeLocalidade);
    }

    @GetMapping("/{nomeGasolineira}/regiao-{nomeRegiao}")
    public List<Gasolineira> verPorNomeNaRegiao(@PathVariable String nomeGasolineira, @PathVariable String nomeRegiao) {
        return gasolineiraService.verGasolineiraPorNomePorRegiao(nomeGasolineira, nomeRegiao);
    }

    @GetMapping("/{nomeGasolineira}/localidade-{nomeLocalidade}")
    public List<Gasolineira> verPorNomeNaLocalidade(@PathVariable String nomeGasolineira, @PathVariable String nomeLocalidade) {
        return gasolineiraService.verGasolineiraPorNomePorLocalidade(nomeGasolineira, nomeLocalidade);
    }

    @GetMapping("/{nomeGasolineira}/regiao-{nomeRegiao}/localidade-{nomeLocalidade}")
    public List<Gasolineira> verPorNomeNaRegiaoNaLocalidade(@PathVariable String nomeGasolineira, @PathVariable String nomeRegiao, @PathVariable String nomeLocalidade) {
        return gasolineiraService.verGasolineiraPorNomePorRegiaoPorLocalidade(nomeGasolineira, nomeRegiao, nomeLocalidade);
    }

    @GetMapping("/combustivel/gasolina95/abaixo-{preco}")
    public List<Gasolineira> todasBombasComGasolina95AbaixoXPreco(@PathVariable double preco) {
        return gasolineiraService.procurarTodasBombasGasolina95AbaixoDeXPreco(preco);
    }

    @GetMapping("/regiao-{regiao}/combustivel/gasolina95/abaixo-{preco}")
    public List<Gasolineira> porRegiaoGasolina95AbaixoXPreco(@PathVariable String regiao, @PathVariable double preco) {
        return gasolineiraService.procurarTodasBombasNaRegiaoGasolina95AbaixoDeXPreco(preco, regiao);
    }

    @GetMapping("/localidade-{localidade}/combustivel/gasolina95/abaixo-{preco}")
    public List<Gasolineira> porLocalidadeGasolina95AbaixoXPreco(@PathVariable String localidade, @PathVariable double preco) {
        return gasolineiraService.procurarTodasBombasNaLocalidadeGasolina95AbaixoDeXPreco(preco, localidade);
    }

    @GetMapping("/regiao-{regiao}/localidade-{localidade}/gasolina95/abaixo-{preco}")
    public List<Gasolineira> verPorLocalidadeNaRegiaoGasolina95AbaixoXPreco(@PathVariable String regiao, @PathVariable String localidade, @PathVariable double preco) {
        return gasolineiraService.procurarBombasNaRegiaoNumaLocalidadeGasolina95AbaixoDeXPreco(regiao, localidade, preco);
    }
}
