package com.FuelControl.repository;

import com.FuelControl.model.Gasolineira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GasolineiraRepository extends JpaRepository<Gasolineira, Integer> {
    List<Gasolineira> findAllByNomeIgnoreCase(String nome);
    Optional<Gasolineira> findFirstByNomeIgnoreCase(String nome);
    List<Gasolineira> findAllByRegiaoIgnoreCase(String nome);
    List<Gasolineira> findAllByLocalidadeIgnoreCase(String nome);
    @Query("SELECT g FROM Gasolineira g WHERE g.postoCarregamento = true")
    List<Gasolineira> procurarBombasComPostoDeCarregamento();
    @Query("SELECT g FROM Gasolineira g WHERE g.regiao = :regiao AND g.postoCarregamento = true")
    List<Gasolineira> procurarBombasComPostoCarregamentoNaRegiao(String regiao);
    @Query("SELECT g FROM Gasolineira g WHERE g.localidade = :localidade and g.postoCarregamento = true")
    List<Gasolineira> procurarBombasComPostoCarregamentoNaLocalidade(String localidade);
    @Query("SELECT g FROM Gasolineira g WHERE g.nome = :nome AND g.regiao = :regiao")
    List<Gasolineira> procurarBombasPorNomeNaRegiao(String nome, String regiao);
    @Query("SELECT g FROM Gasolineira g WHERE g.nome = :nome AND g.localidade = :localidade")
    List<Gasolineira> procurarBombasPorNomeNaLocalidade(String nome, String localidade);
    @Query("SELECT g FROM Gasolineria g WHERE g.nome = :nome and g.regiao = :regiao and g.localidade = localidade")
    List<Gasolineira> procurarBombasPorNomeNaRegiaoNaLocalidade(String nome, String regiao, String localidade);
    @Query("SELECT g FROM Gasolineira g WHERE g.precoGasolina95 < :preco")
    List<Gasolineira> procurarBombasGasolina95AbaixoDeXPreco(double preco);
    @Query("SELECT g FROM Gasolineira g WHERE g.regiao = :regiao AND g.precoGasolina95 < :preco")
    List<Gasolineira> procurarBombasNaRegiaoGasolina95AbaixoDeXPreco(String regiao, double preco);
    @Query("SELECT g FROM Gasolineira g WHERE g.localidade = :localidade AND g.precoGasolina95 < :preco")
    List<Gasolineira> procurarBombasNaLocalidadeGasolina95AbaixoXPreco(String localidade, double preco);
}
