package com.FuelControl.repository;

import com.FuelControl.model.Desconto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DescontoRepository extends JpaRepository<Desconto, Integer> {
    List<Desconto> findAllByUtilizadorIdAndNomeCartaoIgnoreCase(Integer utilizadorId, String nomeCartao);

    List<Desconto> findAllByUtilizadorIdAndTipoDescontoIgnoreCase(Integer utilizadorId, String tipoDesconto);

    List<Desconto> findAllByUtilizadorIdAndValorDesconto(Integer utilizadorId, double valor);

    List<Desconto> findAllByUtilizadorIdAndNomeGasolineiraIgnoreCase(Integer utilizadorId, String nomeGasolineira);

    @Query("SELECT d FROM Desconto d WHERE d.utilizador.id = :utilizador_id AND d.tipoDesconto = :tipoDesconto AND d.nomeGasolineira = :nomeGasolineira")
    List<Desconto> verDescontoPorUtilizadorTipoNomeGasolineira(Integer utilizador_id, String tipoDesconto, String nomeGasolineira);

    @Query("SELECT d FROM Desconto d WHERE d.utilizador.id = :utilizador_id AND d.valorDesconto > :preco")
    List<Desconto> verDescontosPorUtilizadorDescontoMaiorQueX(Integer utilizador_id, double preco);

    @Query("SELECT d FROM Desconto d WHERE d.utilizador.id = :utilizador_id AND d.valorDesconto > :preco AND d.nomeGasolineira = :nomeGasolineira")
    List<Desconto> verDescontosPorUtilizadorDescontoMaiorQueXNaGasolineira(Integer utilizador_id, double preco, String nomeGasolineira);
}
