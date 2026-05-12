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
        desconto.setTipo(tipo);
        desconto.setNomeGasolineira(nomeGasolineira);
        desconto.setDesconto(valor);

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
}
