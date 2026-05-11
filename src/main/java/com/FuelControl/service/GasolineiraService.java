package com.FuelControl.service;

import com.FuelControl.model.*;
import com.FuelControl.repository.GasolineiraRepository;
import lombok.RequiredArgsConstructor;
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

    public List<Gasolineira> verTodasPorRegiao(String nomeRegiao) {
        List<Gasolineira> bombas = gasolineiraRepository.findAllByRegiaoIgnoreCase(nomeRegiao);

        if (bombas.isEmpty()) {
            throw new NaoHaGasolineiraRegiaoException("Não há gasolineiras nessa região");
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> verTodasPorLocalidade(String nomeLocalidade) {
        List<Gasolineira> bombas = gasolineiraRepository.findAllByLocalidadeIgnoreCase(nomeLocalidade);

        if (bombas.isEmpty()) {
            throw new NaoHaGasolineiraLocalidadeException("Não há gasolineiras nessa localidade");
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> verTodasComPostoCarregamento() {
        List<Gasolineira> bombas = gasolineiraRepository.procurarBombasComPostoDeCarregamento();

        if (bombas.isEmpty()) {
            throw new NaoHaBombasComCarregadorException("Não há gasolineiras com posto de carregamento");
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> verRegiaoPostoCarregamento(String nomeRegiao) {
        List<Gasolineira> bombas = gasolineiraRepository.procurarBombasComPostoCarregamentoNaRegiao(nomeRegiao);

        if (bombas.isEmpty()) {
            throw new NaoHaBombasComCarregadorException("Não há bombas com carregador na região " + nomeRegiao);
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> verLocalidadePostoCarregamento(String nomeLocalidade) {
        List<Gasolineira> bombas = gasolineiraRepository.procurarBombasComPostoCarregamentoNaLocalidade(nomeLocalidade);

        if (bombas.isEmpty()) {
            throw new NaoHaBombasComCarregadorException("Não há gasolineiras com posto de carregamento na localidade " + nomeLocalidade);
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> verBombasNumaLocalidadeDumaRegiaoCPostoCarregamento(String regiao, String localidade) {
        List<Gasolineira> bombas = gasolineiraRepository.procurarBombasNaRegiaoNumaLocalidadeComPostoCarregamento(regiao, localidade);

        if (bombas.isEmpty()) {
            throw new NaoHaBombasComCarregadorException("Erro: Não há bombas na localidade " + localidade + " da região " + regiao + " com posto de carregamento");
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> verBombasPorNomeNumaLocalidadeDRegiaoCPostoCarregamento(String nome, String regiao, String localidade) {
        List<Gasolineira> bombas = gasolineiraRepository.procurarBombasPorNomeNaLocalidadeDRegiaoCPostoCarregamento(nome, regiao, localidade);

        if (bombas.isEmpty()) {
            throw new NaoHaBombasComCarregadorException("Erro: Não há bombas " + nome + " na localidade " + localidade + " da região " + regiao + " com posto de carregamento");
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> verGasolineiraPorNomePorRegiao(String nome, String regiao) {
        List<Gasolineira> bombas = gasolineiraRepository.procurarBombasPorNomeNaRegiao(nome, regiao);

        if (bombas.isEmpty()) {
            throw new NaoHaGasolineiraRegiaoException("Não há gasolineiras com o nome " + nome + " na região " + regiao);
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> verGasolineiraPorNomePorLocalidade(String nome, String localidade) {
        List<Gasolineira> bombas = gasolineiraRepository.procurarBombasPorNomeNaLocalidade(nome, localidade);

        if (bombas.isEmpty()) {
            throw new NaoHaGasolineiraLocalidadeException("Erro: Não há gasolineiras com o nome " + nome + " na localidade " + localidade);
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> verGasolineiraPorNomePorRegiaoPorLocalidade(String nome, String regiao, String localidade) {
        List<Gasolineira> bombas = gasolineiraRepository.procurarBombasPorNomeNaRegiaoNaLocalidade(nome, regiao, localidade);

        if (bombas.isEmpty()) {
            throw new NaoHaGasolineiraLocalidadeException("Erro: Não há gasolineiras com o nome " + nome + " na localidade " + localidade + " na região " + regiao);
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> procurarTodasBombasGasolina95AbaixoDeXPreco(double preco) {
        List<Gasolineira> bombas = gasolineiraRepository.procurarBombasGasolina95AbaixoDeXPreco(preco);

        if (bombas.isEmpty()) {
            throw new NaoHaCombustivelAbaixoPrecoException("Erro: Não há nenhuma bomba com gasolina 95 abaixo desse preço (" + preco + ")");
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> procurarPorNomeGasolina95AbaixoXPreco(String nome, double preco) {
        List<Gasolineira> bombas = gasolineiraRepository.procurarBombasPorNomeGasolinaAbaixoXPreco(nome, preco);

        if (bombas.isEmpty()) {
            throw new NaoHaCombustivelAbaixoPrecoException("Erro: Não há nenhuma bomba " + nome + " com gasolina 95 abaixo de " + preco);
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> procurarTodasBombasNaRegiaoGasolina95AbaixoDeXPreco(double preco, String regiao) {
        List<Gasolineira> bombas = gasolineiraRepository.procurarBombasNaRegiaoGasolina95AbaixoDeXPreco(regiao, preco);

        if (bombas.isEmpty()) {
            throw new NaoHaCombustivelAbaixoPrecoException("Erro: Não há bombas na região " + regiao + " com gasolina 95 abaixo desse preço (" + preco + ")");
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> procurarPorNomeNaRegiaoGasolina95AbaixoXPreco(String nome, String regiao, double preco) {
        List<Gasolineira> bombas = gasolineiraRepository.procurarBombasPorNomeNaRegiaoGasolina95AbaixoXPreco(nome, regiao, preco);

        if (bombas.isEmpty()) {
            throw new NaoHaCombustivelAbaixoPrecoException("Erro: Não há bombas " + nome + " na região " + regiao + " com gasolina 95 abaixo de " + preco);
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> procurarTodasBombasNaLocalidadeGasolina95AbaixoDeXPreco(double preco, String localidade) {
        List<Gasolineira> bombas = gasolineiraRepository.procurarBombasNaLocalidadeGasolina95AbaixoXPreco(localidade, preco);

        if (bombas.isEmpty()) {
            throw new NaoHaCombustivelAbaixoPrecoException("Erro: Não há bombas na região " + localidade + " com gasolina 95 abaixo desse preço (" + preco + ")");
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> procurarPorNomeNaLocalidadeGasolina95AbaixoXPreco(String nome, String localidade, double preco) {
        List<Gasolineira> bombas = gasolineiraRepository.procurarBombasPorNomeNaLocalidadeGasolina95AbaixoXPreco(nome, localidade, preco);

        if (bombas.isEmpty()) {
            throw new NaoHaCombustivelAbaixoPrecoException("Erro: Não há bombas " + nome + " na localidade " + localidade + " com gasolina 95 abaixo de " + preco);
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> procurarBombasNaRegiaoNumaLocalidadeGasolina95AbaixoDeXPreco(String regiao, String localidade, double preco) {
        List<Gasolineira> bombas = gasolineiraRepository.procurarBombasNaRegiaoNumaLocalidadeGasolina95AbaixoXPreco(regiao, localidade, preco);

        if (bombas.isEmpty()) {
            throw new NaoHaCombustivelAbaixoPrecoException("Erro: Não há bombas na localidade " + localidade + " da região " + regiao + " com gasolina 95 abaixo de " + preco);
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> procurarPorNomeNumaLocalidadeDumaRegiaoGasolina95AbaixoXPreco(String nome, String regiao, String localidade, double preco) {
        List<Gasolineira> bombas = gasolineiraRepository.procurarPorNomeNumaLocalidadeDumaRegiaoGasolina95AbaixoXPreco(nome, regiao, localidade, preco);

        if (bombas.isEmpty()) {
            throw new NaoHaCombustivelAbaixoPrecoException("Erro: Não há bombas " + nome + " na localidade " + localidade + " da região " + regiao + " com gasolina 95 abaixo de " + preco);
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> procurarTodasBombasGasolina98AbaixoDeXPreco(double preco) {
        List<Gasolineira> bombas = gasolineiraRepository.procurarBombasGasolina98AbaixoDeXPreco(preco);

        if (bombas.isEmpty()) {
            throw new NaoHaCombustivelAbaixoPrecoException("Erro: Não há nenhuma bomba com gasolina 98 abaixo desse preço (" + preco + ")");
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> procurarPorNomeGasolina98AbaixoXPreco(String nome, double preco) {
        List<Gasolineira> bombas = gasolineiraRepository.procurarBombasPorNomeGasolina98AbaixoXPreco(nome, preco);

        if (bombas.isEmpty()) {
            throw new NaoHaCombustivelAbaixoPrecoException("Erro: Não há nenhuma bomba " + nome + " com gasolina 98 abaixo de " + preco);
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> procurarTodasBombasNaRegiaoGasolina98AbaixoDeXPreco(double preco, String regiao) {
        List<Gasolineira> bombas = gasolineiraRepository.procurarBombasNaRegiaoGasolina98AbaixoDeXPreco(regiao, preco);

        if (bombas.isEmpty()) {
            throw new NaoHaCombustivelAbaixoPrecoException("Erro: Não há bombas na região " + regiao + " com gasolina 98 abaixo desse preço (" + preco + ")");
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> procurarPorNomeNaRegiaoGasolina98AbaixoXPreco(String nome, String regiao, double preco) {
        List<Gasolineira> bombas = gasolineiraRepository.procurarBombasPorNomeNaRegiaoGasolina98AbaixoXPreco(nome, regiao, preco);

        if (bombas.isEmpty()) {
            throw new NaoHaCombustivelAbaixoPrecoException("Erro: Não há bombas " + nome + " na região " + regiao + " com gasolina 98 abaixo de " + preco);
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> procurarTodasBombasNaLocalidadeGasolina98AbaixoDeXPreco(double preco, String localidade) {
        List<Gasolineira> bombas = gasolineiraRepository.procurarBombasNaLocalidadeGasolina98AbaixoXPreco(localidade, preco);

        if (bombas.isEmpty()) {
            throw new NaoHaCombustivelAbaixoPrecoException("Erro: Não há bombas na região " + localidade + " com gasolina 98 abaixo desse preço (" + preco + ")");
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> procurarPorNomeNaLocalidadeGasolina98AbaixoXPreco(String nome, String localidade, double preco) {
        List<Gasolineira> bombas = gasolineiraRepository.procurarBombasPorNomeNaLocalidadeGasolina98AbaixoXPreco(nome, localidade, preco);

        if (bombas.isEmpty()) {
            throw new NaoHaCombustivelAbaixoPrecoException("Erro: Não há bombas " + nome + " na localidade " + localidade + " abaixo de " + preco);
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> procurarBombasNaRegiaoNumaLocalidadeGasolina98AbaixoDeXPreco(String regiao, String localidade, double preco) {
        List<Gasolineira> bombas = gasolineiraRepository.procurarBombasNaRegiaoNumaLocalidadeGasolina98AbaixoXPreco(regiao, localidade, preco);

        if (bombas.isEmpty()) {
            throw new NaoHaCombustivelAbaixoPrecoException("Erro: Não há bombas na localidade " + localidade + " da região " + regiao + " com gasolina 98 abaixo de " + preco);
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> procurarPorNomeNumaLocalidadeDumaRegiaoGasolina98AbaixoXPreco(String nome, String regiao, String localidade, double preco) {
        List<Gasolineira> bombas = gasolineiraRepository.procurarPorNomeNumaLocalidadeDumaRegiaoGasolina98AbaixoXPreco(nome, regiao, localidade, preco);

        if (bombas.isEmpty()) {
            throw new NaoHaCombustivelAbaixoPrecoException("Erro: Não há bombas " + nome + " na localidade " + localidade + " da região " + regiao + " com gasolina 98 abaixo de " + preco);
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> procurarTodasBombasGasoleoSimplesAbaixoDeXPreco(double preco) {
        List<Gasolineira> bombas = gasolineiraRepository.procurarBombasGasoleoSimplesAbaixoDeXPreco(preco);

        if (bombas.isEmpty()) {
            throw new NaoHaCombustivelAbaixoPrecoException("Erro: Não há nenhuma bomba com gasoleo simples abaixo desse preço (" + preco + ")");
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> procurarPorNomeGasoleoSimplesAbaixoXPreco(String nome, double preco) {
        List<Gasolineira> bombas = gasolineiraRepository.procurarBombasPorNomeGasoleoSimplesAbaixoXPreco(nome, preco);

        if (bombas.isEmpty()) {
            throw new NaoHaCombustivelAbaixoPrecoException("Erro: Não há nenhuma bomba " + nome + " com gasoleo simples abaixo de " + preco);
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> procurarTodasBombasNaRegiaoGasoleoSimplesAbaixoDeXPreco(double preco, String regiao) {
        List<Gasolineira> bombas = gasolineiraRepository.procurarBombasNaRegiaoGasoleoSimplesAbaixoDeXPreco(regiao, preco);

        if (bombas.isEmpty()) {
            throw new NaoHaCombustivelAbaixoPrecoException("Erro: Não há bombas na região " + regiao + " com gasoleo simples abaixo desse preço (" + preco + ")");
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> procurarPorNomeNaRegiaoGasoleoSimplesAbaixoXPreco(String nome, String regiao, double preco) {
        List<Gasolineira> bombas = gasolineiraRepository.procurarBombasPorNomeNaRegiaoGasoleoSimplesAbaixoXPreco(nome, regiao, preco);

        if (bombas.isEmpty()) {
            throw new NaoHaCombustivelAbaixoPrecoException("Erro: Não há bombas " + nome + " na região " + regiao + " com gasoleo simples abaixo de " + preco);
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> procurarTodasBombasNaLocalidadeGasoleoSimplesAbaixoDeXPreco(double preco, String localidade) {
        List<Gasolineira> bombas = gasolineiraRepository.procurarBombasNaLocalidadeGasoleoSimplesAbaixoXPreco(localidade, preco);

        if (bombas.isEmpty()) {
            throw new NaoHaCombustivelAbaixoPrecoException("Erro: Não há bombas na região " + localidade + " com gasoleo simples abaixo desse preço (" + preco + ")");
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> procurarPorNomeNaLocalidadeGasoleoSimplesAbaixoXPreco(String nome, String localidade, double preco) {
        List<Gasolineira> bombas = gasolineiraRepository.procurarBombasPorNomeNaLocalidadeGasoleoSimplesAbaixoXPreco(nome, localidade, preco);

        if (bombas.isEmpty()) {
            throw new NaoHaCombustivelAbaixoPrecoException("Erro: Não há bombas " + nome + " na localidade " + localidade + " gasoleo simples abaixo de " + preco);
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> procurarBombasNaRegiaoNumaLocalidadeGasoleoSimplesAbaixoDeXPreco(String regiao, String localidade, double preco) {
        List<Gasolineira> bombas = gasolineiraRepository.procurarBombasNaRegiaoNumaLocalidadeGasoleoSimplesAbaixoXPreco(regiao, localidade, preco);

        if (bombas.isEmpty()) {
            throw new NaoHaCombustivelAbaixoPrecoException("Erro: Não há bombas na localidade " + localidade + " da região " + regiao + " com gasoleo simples abaixo de " + preco);
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> procurarPorNomeNumaLocalidadeDumaRegiaoGasoleoSimplesAbaixoXPreco(String nome, String regiao, String localidade, double preco) {
        List<Gasolineira> bombas = gasolineiraRepository.procurarPorNomeNumaLocalidadeDumaRegiaoGasoleoSimplesAbaixoXPreco(nome, regiao, localidade, preco);

        if (bombas.isEmpty()) {
            throw new NaoHaCombustivelAbaixoPrecoException("Erro: Não há bombas " + nome + " na localidade " + localidade + " da região " + regiao + " com gasoleo simples abaixo de " + preco);
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> procurarTodasBombasGasoleoAditivadoAbaixoDeXPreco(double preco) {
        List<Gasolineira> bombas = gasolineiraRepository.procurarBombasGasoleoAditivadoAbaixoDeXPreco(preco);

        if (bombas.isEmpty()) {
            throw new NaoHaCombustivelAbaixoPrecoException("Erro: Não há nenhuma bomba com gasoleo aditivado abaixo desse preço (" + preco + ")");
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> procurarPorNomeGasoleoAditivadoAbaixoXPreco(String nome, double preco) {
        List<Gasolineira> bombas = gasolineiraRepository.procurarBombasPorNomeGasoleoAditivadoAbaixoXPreco(nome, preco);

        if (bombas.isEmpty()) {
            throw new NaoHaCombustivelAbaixoPrecoException("Erro: Não há nenhuma bomba " + nome + " com gasoleo aditivado abaixo de " + preco);
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> procurarTodasBombasNaRegiaoGasoleoAditivadoAbaixoDeXPreco(double preco, String regiao) {
        List<Gasolineira> bombas = gasolineiraRepository.procurarBombasNaRegiaoGasoleoAditivadoAbaixoDeXPreco(regiao, preco);

        if (bombas.isEmpty()) {
            throw new NaoHaCombustivelAbaixoPrecoException("Erro: Não há bombas na região " + regiao + " com gasoleo aditivado abaixo desse preço (" + preco + ")");
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> procurarPorNomeNaRegiaoGasoleoAditivadoAbaixoXPreco(String nome, String regiao, double preco) {
        List<Gasolineira> bombas = gasolineiraRepository.procurarBombasPorNomeNaRegiaoGasoleoAditivadoAbaixoXPreco(nome, regiao, preco);

        if (bombas.isEmpty()) {
            throw new NaoHaCombustivelAbaixoPrecoException("Erro: Não há bombas " + nome + " na região " + regiao + " com gasoleo aditivado abaixo de " + preco);
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> procurarTodasBombasNaLocalidadeGasoleoAditivadoAbaixoDeXPreco(double preco, String localidade) {
        List<Gasolineira> bombas = gasolineiraRepository.procurarBombasNaLocalidadeGasoleoAditivadoAbaixoXPreco(localidade, preco);

        if (bombas.isEmpty()) {
            throw new NaoHaCombustivelAbaixoPrecoException("Erro: Não há bombas na região " + localidade + " com gasoleo aditivado abaixo desse preço (" + preco + ")");
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> procurarPorNomeNaLocalidadeGasoleoAditivadoAbaixoXPreco(String nome, String localidade, double preco) {
        List<Gasolineira> bombas = gasolineiraRepository.procurarBombasPorNomeNaLocalidadeGasoleoAditivadoAbaixoXPreco(nome, localidade, preco);

        if (bombas.isEmpty()) {
            throw new NaoHaCombustivelAbaixoPrecoException("Erro: Não há bombas " + nome + " na localidade " + localidade + " gasoleo aditivado abaixo de " + preco);
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> procurarBombasNaRegiaoNumaLocalidadeGasoleoAditivadoAbaixoDeXPreco(String regiao, String localidade, double preco) {
        List<Gasolineira> bombas = gasolineiraRepository.procurarBombasNaRegiaoNumaLocalidadeGasoleoAditivadoAbaixoXPreco(regiao, localidade, preco);

        if (bombas.isEmpty()) {
            throw new NaoHaCombustivelAbaixoPrecoException("Erro: Não há bombas na localidade " + localidade + " da região " + regiao + " com gasoleo aditivado abaixo de " + preco);
        } else {
            return bombas;
        }
    }

    public List<Gasolineira> procurarPorNomeNumaLocalidadeDumaRegiaoGasoleoAditivadoAbaixoXPreco(String nome, String regiao, String localidade, double preco) {
        List<Gasolineira> bombas = gasolineiraRepository.procurarPorNomeNumaLocalidadeDumaRegiaoGasoleoAditivadoAbaixoXPreco(nome, regiao, localidade, preco);

        if (bombas.isEmpty()) {
            throw new NaoHaCombustivelAbaixoPrecoException("Erro: Não há bombas " + nome + " na localidade " + localidade + " da região " + regiao + " com gasoleo aditivado abaixo de " + preco);
        } else {
            return bombas;
        }
    }
}
