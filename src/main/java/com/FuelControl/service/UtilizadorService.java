package com.FuelControl.service;

import com.FuelControl.model.*;
import com.FuelControl.repository.DescontoRepository;
import com.FuelControl.repository.UtilizadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UtilizadorService {
    private final UtilizadorRepository utilizadorRepository;
    private final DescontoRepository descontoRepository;

    public Utilizador criarNovoUtilizador(String nome, String email) {
        Utilizador novoUtilizador = new Utilizador();
        novoUtilizador.setNome(nome);
        novoUtilizador.setEmail(email);

        return utilizadorRepository.save(novoUtilizador);
    }

    public Desconto adicionarDesconto(Integer utilizadorId, String nomeCartao, String tipo, double valor, String nomeGasolineira) {
        Utilizador utilizador = utilizadorRepository.findById(utilizadorId)
                .orElseThrow(() -> new NaoHaUtilizadorComXId("Erro: Não há nenhum utilizador registado com esse id"));

        Desconto desconto = new Desconto();
        desconto.setUtilizador(utilizador);
        desconto.setNomeCartao(nomeCartao);
        desconto.setTipoDesconto(tipo);
        desconto.setNomeGasolineira(nomeGasolineira);
        desconto.setValorDesconto(valor);

        return descontoRepository.save(desconto);
    }

    public List<Desconto> verOsMeusDescontos(Integer utilizadorId) {
        Utilizador utilizador = utilizadorRepository.findById(utilizadorId)
                .orElseThrow(() -> new NaoHaUtilizadorComXId("Erro: Não há nenhum utilizador registado com esse id"));

        return utilizador.getDescontos();
    }

    public String apagarMeuDesconto(Integer utilizadorId, Integer descontoId) {
        Desconto desconto = descontoRepository.findById(descontoId)
                .orElseThrow(() -> new NaoTemDescontoException("Erro: Não há nenhum desconto com esse id"));

        if (!desconto.getUtilizador().getId().equals(utilizadorId)) {
            throw new IdUtilizadorDIferenteIdDescontoException("Erro de segurança: O desconto que quer apagar não pertence ao id do utilizador.");
        }

        descontoRepository.delete(desconto);
        return "Desconto apagado com sucesso da tua carteira";
    }

    public List<Desconto> verTodosPorNomeCartao(Integer utilizadorId, String nomeCartao) {
        List<Desconto> descontos = descontoRepository.findAllByUtilizadorIdAndNomeCartaoIgnoreCase(utilizadorId, nomeCartao);

        if (descontos.isEmpty()) {
            throw new NaoTemDescontoException("Erro: Utilizador " + utilizadorId + " não tem descontos na carteira do cartão " + nomeCartao);
        } else {
            return descontos;
        }
    }

    public List<Desconto> verTodosPorTipoDesconto(Integer utilizadorId, String tipoDesconto) {
        List<Desconto> descontos = descontoRepository.findAllByUtilizadorIdAndTipoDescontoIgnoreCase(utilizadorId, tipoDesconto);

        if (descontos.isEmpty()) {
            throw new NaoTemDescontoException("Erro: Utilizador " + utilizadorId + " não tem descontos do tipo " + tipoDesconto);
        } else {
            return descontos;
        }
    }

    public List<Desconto> verTodosPorValorDesconto(Integer utilizadorId, double valorDesconto) {
        List<Desconto> descontos = descontoRepository.findAllByUtilizadorIdAndValorDesconto(utilizadorId, valorDesconto);

        if (descontos.isEmpty()) {
            throw new NaoTemDescontoException("Erro: Utilizador " + utilizadorId + " não tem descontos de valor " + valorDesconto);
        } else {
            return descontos;
        }
    }

    public List<Desconto> verTodosDescontosPorNomeGasolineira(Integer utilizadorId, String nomeGasolineira) {
        List<Desconto> descontos = descontoRepository.findAllByUtilizadorIdAndNomeGasolineiraIgnoreCase(utilizadorId, nomeGasolineira);

        if (descontos.isEmpty()) {
            throw new NaoTemDescontoException("Erro: Utilizador " + utilizadorId + " não tem descontos da bomba " + nomeGasolineira);
        } else {
            return descontos;
        }
    }

    public List<Desconto> verPorUtilizadorTipoGasolineira(Integer utilizadorId, String tipo, String gasolineira) {
        List<Desconto> descontos = descontoRepository.verDescontoPorUtilizadorTipoNomeGasolineira(utilizadorId, tipo, gasolineira);

        if (descontos.isEmpty()) {
            throw new NaoTemDescontoException("Erro: Utilizador " + utilizadorId + " não tem descontos do tipo " + tipo + " para a bomba " + gasolineira);
        } else {
            return descontos;
        }
    }

    public List<Desconto> verPorUtilizadorDescontoMaiorQueX(Integer utilizadorId, double valor) {
        List<Desconto> descontos = descontoRepository.verDescontosPorUtilizadorDescontoMaiorQueX(utilizadorId, valor);

        if (descontos.isEmpty()) {
            throw new NaoTemDescontoException("Erro: Utilizador " + utilizadorId + " não tem descontos de valor maior que " + valor);
        } else {
            return descontos;
        }
    }

    public List<Desconto> verPorUtilizadorDescontoMaiorQueXNaGasolineira(Integer utilizadorId, double valor, String nomeGasolineira) {
        List<Desconto> descontos = descontoRepository.verDescontosPorUtilizadorDescontoMaiorQueXNaGasolineira(utilizadorId, valor, nomeGasolineira);

        if (descontos.isEmpty()) {
            throw new NaoTemDescontoException("Erro: Utilizador " + utilizadorId + " não tem descontos maiores que " + valor + " na bomba " + nomeGasolineira);
        } else {
            return descontos;
        }
    }
}
