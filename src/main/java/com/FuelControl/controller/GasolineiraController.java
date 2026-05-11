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

    @GetMapping("/{nome}/combustivel/gasolina95/abaixo-{preco}")
    public List<Gasolineira> porNomeGasolina95AbaixoXPreco(@PathVariable String nome, @PathVariable double preco) {
        return gasolineiraService.procurarPorNomeGasolina95AbaixoXPreco(nome, preco);
    }

    @GetMapping("/regiao-{regiao}/combustivel/gasolina95/abaixo-{preco}")
    public List<Gasolineira> porRegiaoGasolina95AbaixoXPreco(@PathVariable String regiao, @PathVariable double preco) {
        return gasolineiraService.procurarTodasBombasNaRegiaoGasolina95AbaixoDeXPreco(preco, regiao);
    }

    @GetMapping("/{nome}/regiao-{regiao}/combustivel/gasolina95/abaixo-{preco}")
    public List<Gasolineira> porNomeNaRegiaoGasolina95AbaixoXPreco(@PathVariable String nome, @PathVariable String regiao, @PathVariable double preco) {
        return gasolineiraService.procurarPorNomeNaRegiaoGasolina95AbaixoXPreco(nome, regiao, preco);
    }

    @GetMapping("/localidade-{localidade}/combustivel/gasolina95/abaixo-{preco}")
    public List<Gasolineira> porLocalidadeGasolina95AbaixoXPreco(@PathVariable String localidade, @PathVariable double preco) {
        return gasolineiraService.procurarTodasBombasNaLocalidadeGasolina95AbaixoDeXPreco(preco, localidade);
    }

    @GetMapping("/{nome}/localidade-{localidade}/combustivel/gasolina95/abaixo-{preco}")
    public List<Gasolineira> porNomeNaLocalidadeGasolina95AbaixoXPreco(@PathVariable String nome, @PathVariable String localidade, @PathVariable double preco) {
        return gasolineiraService.procurarPorNomeNaLocalidadeGasolina95AbaixoXPreco(nome, localidade, preco);
    }

    @GetMapping("/regiao-{regiao}/localidade-{localidade}/gasolina95/abaixo-{preco}")
    public List<Gasolineira> verPorLocalidadeNaRegiaoGasolina95AbaixoXPreco(@PathVariable String regiao, @PathVariable String localidade, @PathVariable double preco) {
        return gasolineiraService.procurarBombasNaRegiaoNumaLocalidadeGasolina95AbaixoDeXPreco(regiao, localidade, preco);
    }

    @GetMapping("/{nome}/regiao-{regiao}/localidade-{localidade}/combustivel/gasolina95/abaixo-{preco}")
    public List<Gasolineira> porNomeNaLocalidadeDumaRegiaoGasolina95AbaixoXPreco(@PathVariable String nome, @PathVariable String regiao, @PathVariable String localidade, @PathVariable double preco) {
        return gasolineiraService.procurarPorNomeNumaLocalidadeDumaRegiaoGasolina95AbaixoXPreco(nome, regiao, localidade, preco);
    }

    @GetMapping("/combustivel/gasolina98/abaixo-{preco}")
    public List<Gasolineira> todasBombasComGasolina98AbaixoXPreco(@PathVariable double preco) {
        return gasolineiraService.procurarTodasBombasGasolina98AbaixoDeXPreco(preco);
    }

    @GetMapping("/{nome}/combustivel/gasolina98/abaixo-{preco}")
    public List<Gasolineira> porNomeGasolina98AbaixoXPreco(@PathVariable String nome, @PathVariable double preco) {
        return gasolineiraService.procurarPorNomeGasolina98AbaixoXPreco(nome, preco);
    }

    @GetMapping("/regiao-{regiao}/combustivel/gasolina98/abaixo-{preco}")
    public List<Gasolineira> porRegiaoGasolina98AbaixoXPreco(@PathVariable String regiao, @PathVariable double preco) {
        return gasolineiraService.procurarTodasBombasNaRegiaoGasolina98AbaixoDeXPreco(preco, regiao);
    }

    @GetMapping("/{nome}/regiao-{regiao}/combustivel/gasolina98/abaixo-{preco}")
    public List<Gasolineira> porNomeNaRegiaoGasolina98AbaixoXPreco(@PathVariable String nome, @PathVariable String regiao, @PathVariable double preco) {
        return gasolineiraService.procurarPorNomeNaRegiaoGasolina98AbaixoXPreco(nome, regiao, preco);
    }

    @GetMapping("/localidade-{localidade}/combustivel/gasolina98/abaixo-{preco}")
    public List<Gasolineira> porLocalidadeGasolina98AbaixoXPreco(@PathVariable String localidade, @PathVariable double preco) {
        return gasolineiraService.procurarTodasBombasNaLocalidadeGasolina98AbaixoDeXPreco(preco, localidade);
    }

    @GetMapping("/{nome}/localidade-{localidade}/combustivel/gasolina98/abaixo-{preco}")
    public List<Gasolineira> porNomeNaLocalidadeGasolina98AbaixoXPreco(@PathVariable String nome, @PathVariable String localidade, @PathVariable double preco) {
        return gasolineiraService.procurarPorNomeNaLocalidadeGasolina98AbaixoXPreco(nome, localidade, preco);
    }

    @GetMapping("/regiao-{regiao}/localidade-{localidade}/gasolina98/abaixo-{preco}")
    public List<Gasolineira> verPorLocalidadeNaRegiaoGasolina98AbaixoXPreco(@PathVariable String regiao, @PathVariable String localidade, @PathVariable double preco) {
        return gasolineiraService.procurarBombasNaRegiaoNumaLocalidadeGasolina98AbaixoDeXPreco(regiao, localidade, preco);
    }

    @GetMapping("/{nome}/regiao-{regiao}/localidade-{localidade}/combustivel/gasolina98/abaixo-{preco}")
    public List<Gasolineira> porNomeNaLocalidadeDumaRegiaoGasolina98AbaixoXPreco(@PathVariable String nome, @PathVariable String regiao, @PathVariable String localidade, @PathVariable double preco) {
        return gasolineiraService.procurarPorNomeNumaLocalidadeDumaRegiaoGasolina98AbaixoXPreco(nome, regiao, localidade, preco);
    }

    @GetMapping("/combustivel/gasoleo-simples/abaixo-{preco}")
    public List<Gasolineira> todasBombasComGasoleoSimplesAbaixoXPreco(@PathVariable double preco) {
        return gasolineiraService.procurarTodasBombasGasoleoSimplesAbaixoDeXPreco(preco);
    }

    @GetMapping("/{nome}/combustivel/gasoleo-simples/abaixo-{preco}")
    public List<Gasolineira> porNomeGasoleoSimplesAbaixoXPreco(@PathVariable String nome, @PathVariable double preco) {
        return gasolineiraService.procurarPorNomeGasoleoSimplesAbaixoXPreco(nome, preco);
    }

    @GetMapping("/regiao-{regiao}/combustivel/gasoleo-simples/abaixo-{preco}")
    public List<Gasolineira> porRegiaoGasoleoSimplesAbaixoXPreco(@PathVariable String regiao, @PathVariable double preco) {
        return gasolineiraService.procurarTodasBombasNaRegiaoGasoleoSimplesAbaixoDeXPreco(preco, regiao);
    }

    @GetMapping("/{nome}/regiao-{regiao}/combustivel/gasoleo-simples/abaixo-{preco}")
    public List<Gasolineira> porNomeNaRegiaoGasoleoSimplesAbaixoXPreco(@PathVariable String nome, @PathVariable String regiao, @PathVariable double preco) {
        return gasolineiraService.procurarPorNomeNaRegiaoGasoleoSimplesAbaixoXPreco(nome, regiao, preco);
    }

    @GetMapping("/localidade-{localidade}/combustivel/gasoleo-simples/abaixo-{preco}")
    public List<Gasolineira> porLocalidadeGasoleoSimplesAbaixoXPreco(@PathVariable String localidade, @PathVariable double preco) {
        return gasolineiraService.procurarTodasBombasNaLocalidadeGasoleoSimplesAbaixoDeXPreco(preco, localidade);
    }

    @GetMapping("/{nome}/localidade-{localidade}/combustivel/gasoleo-simples/abaixo-{preco}")
    public List<Gasolineira> porNomeNaLocalidadeGasoleoSimplesAbaixoXPreco(@PathVariable String nome, @PathVariable String localidade, @PathVariable double preco) {
        return gasolineiraService.procurarPorNomeNaLocalidadeGasoleoSimplesAbaixoXPreco(nome, localidade, preco);
    }

    @GetMapping("/regiao-{regiao}/localidade-{localidade}/gasoleo-simples/abaixo-{preco}")
    public List<Gasolineira> verPorLocalidadeNaRegiaoGasoleoSimplesAbaixoXPreco(@PathVariable String regiao, @PathVariable String localidade, @PathVariable double preco) {
        return gasolineiraService.procurarBombasNaRegiaoNumaLocalidadeGasoleoSimplesAbaixoDeXPreco(regiao, localidade, preco);
    }

    @GetMapping("/{nome}/regiao-{regiao}/localidade-{localidade}/combustivel/gasoleo-simples/abaixo-{preco}")
    public List<Gasolineira> porNomeNaLocalidadeDumaRegiaoGasoleoSimplesAbaixoXPreco(@PathVariable String nome, @PathVariable String regiao, @PathVariable String localidade, @PathVariable double preco) {
        return gasolineiraService.procurarPorNomeNumaLocalidadeDumaRegiaoGasoleoSimplesAbaixoXPreco(nome, regiao, localidade, preco);
    }


    @GetMapping("/combustivel/gasoleo-aditivado/abaixo-{preco}")
    public List<Gasolineira> todasBombasComGasoleoSimplesGasoleoAditivadoAbaixoXPreco(@PathVariable double preco) {
        return gasolineiraService.procurarTodasBombasGasoleoAditivadoAbaixoDeXPreco(preco);
    }

    @GetMapping("/{nome}/combustivel/gasoleo-aditivado/abaixo-{preco}")
    public List<Gasolineira> porNomeGasoleoAditivadoAbaixoXPreco(@PathVariable String nome, @PathVariable double preco) {
        return gasolineiraService.procurarPorNomeGasoleoAditivadoAbaixoXPreco(nome, preco);
    }

    @GetMapping("/regiao-{regiao}/combustivel/gasoleo-aditivado/abaixo-{preco}")
    public List<Gasolineira> porRegiaoGasoleoAditivadoAbaixoXPreco(@PathVariable String regiao, @PathVariable double preco) {
        return gasolineiraService.procurarTodasBombasNaRegiaoGasoleoAditivadoAbaixoDeXPreco(preco, regiao);
    }

    @GetMapping("/{nome}/regiao-{regiao}/combustivel/gasoleo-aditivado/abaixo-{preco}")
    public List<Gasolineira> porNomeNaRegiaoGasoleoAditivadoAbaixoXPreco(@PathVariable String nome, @PathVariable String regiao, @PathVariable double preco) {
        return gasolineiraService.procurarPorNomeNaRegiaoGasoleoAditivadoAbaixoXPreco(nome, regiao, preco);
    }

    @GetMapping("/localidade-{localidade}/combustivel/gasoleo-aditivado/abaixo-{preco}")
    public List<Gasolineira> porLocalidadeGasoleoAditivadoAbaixoXPreco(@PathVariable String localidade, @PathVariable double preco) {
        return gasolineiraService.procurarTodasBombasNaLocalidadeGasoleoAditivadoAbaixoDeXPreco(preco, localidade);
    }

    @GetMapping("/{nome}/localidade-{localidade}/combustivel/gasoleo-aditivado/abaixo-{preco}")
    public List<Gasolineira> porNomeNaLocalidadeGasoleoAditivadoAbaixoXPreco(@PathVariable String nome, @PathVariable String localidade, @PathVariable double preco) {
        return gasolineiraService.procurarPorNomeNaLocalidadeGasoleoAditivadoAbaixoXPreco(nome, localidade, preco);
    }

    @GetMapping("/regiao-{regiao}/localidade-{localidade}/gasoleo-aditivado/abaixo-{preco}")
    public List<Gasolineira> verPorLocalidadeNaRegiaoGasoleoAditivadoAbaixoXPreco(@PathVariable String regiao, @PathVariable String localidade, @PathVariable double preco) {
        return gasolineiraService.procurarBombasNaRegiaoNumaLocalidadeGasoleoAditivadoAbaixoDeXPreco(regiao, localidade, preco);
    }

    @GetMapping("/{nome}/regiao-{regiao}/localidade-{localidade}/combustivel/gasoleo-aditivado/abaixo-{preco}")
    public List<Gasolineira> porNomeNaLocalidadeDumaRegiaoGasoleoAditivadoAbaixoXPreco(@PathVariable String nome, @PathVariable String regiao, @PathVariable String localidade, @PathVariable double preco) {
        return gasolineiraService.procurarPorNomeNumaLocalidadeDumaRegiaoGasoleoAditivadoAbaixoXPreco(nome, regiao, localidade, preco);
    }
}
