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

    List<Gasolineira> findAllByLocalidadeAndRegiaoIgnoreCase(String localidade, String regiao);

    @Query("SELECT g FROM Gasolineira g WHERE g.postoCarregamento = true")
    List<Gasolineira> procurarBombasComPostoDeCarregamento();

    @Query("SELECT g FROM Gasolineira g WHERE g.regiao = :regiao AND g.postoCarregamento = true")
    List<Gasolineira> procurarBombasComPostoCarregamentoNaRegiao(String regiao);

    @Query("SELECT g FROM Gasolineira g WHERE g.localidade = :localidade and g.postoCarregamento = true")
    List<Gasolineira> procurarBombasComPostoCarregamentoNaLocalidade(String localidade);

    @Query("SELECT g FROM Gasolineira g WHERE g.regiao = :regiao AND g.localidade = :localidade AND g.postoCarregamento = true")
    List<Gasolineira> procurarBombasNaRegiaoNumaLocalidadeComPostoCarregamento(String regiao, String localidade);

    @Query("SELECT g FROM Gasolineira g WHERE g.nome = :nome AND g.regiao = :regiao AND g.localidade = :localidade AND g.postoCarregamento = true")
    List<Gasolineira> procurarBombasPorNomeNaLocalidadeDRegiaoCPostoCarregamento(String nome, String regiao, String localidade);

    @Query("SELECT g FROM Gasolineira g WHERE g.nome = :nome AND g.regiao = :regiao")
    List<Gasolineira> procurarBombasPorNomeNaRegiao(String nome, String regiao);

    @Query("SELECT g FROM Gasolineira g WHERE g.nome = :nome AND g.localidade = :localidade")
    List<Gasolineira> procurarBombasPorNomeNaLocalidade(String nome, String localidade);

    @Query("SELECT g FROM Gasolineira g WHERE g.nome = :nome and g.regiao = :regiao and g.localidade = :localidade")
    List<Gasolineira> procurarBombasPorNomeNaRegiaoNaLocalidade(String nome, String regiao, String localidade);

    @Query("SELECT g FROM Gasolineira g WHERE g.precoGasolina95 < :preco")
    List<Gasolineira> procurarBombasGasolina95AbaixoDeXPreco(double preco);

    @Query("SELECT g FROM Gasolineira g WHERE g.nome = :nome AND g.precoGasolina95 < :preco")
    List<Gasolineira> procurarBombasPorNomeGasolinaAbaixoXPreco(String nome, double preco);

    @Query("SELECT g FROM Gasolineira g WHERE g.regiao = :regiao AND g.precoGasolina95 < :preco")
    List<Gasolineira> procurarBombasNaRegiaoGasolina95AbaixoDeXPreco(String regiao, double preco);

    @Query("SELECT g FROM Gasolineira g WHERE g.nome = :nome AND g.regiao = :regiao AND g.precoGasolina95 < :preco")
    List<Gasolineira> procurarBombasPorNomeNaRegiaoGasolina95AbaixoXPreco(String nome, String regiao, double preco);

    @Query("SELECT g FROM Gasolineira g WHERE g.localidade = :localidade AND g.precoGasolina95 < :preco")
    List<Gasolineira> procurarBombasNaLocalidadeGasolina95AbaixoXPreco(String localidade, double preco);

    @Query("SELECT g FROM Gasolineira g WHERE g.nome = :nome AND g.localidade = :localidade AND g.precoGasolina95 < :preco")
    List<Gasolineira> procurarBombasPorNomeNaLocalidadeGasolina95AbaixoXPreco(String nome, String localidade, double preco);

    @Query("SELECT g FROM Gasolineira g WHERE g.regiao = :regiao AND g.localidade = :localidade AND g.precoGasolina95 < :preco")
    List<Gasolineira> procurarBombasNaRegiaoNumaLocalidadeGasolina95AbaixoXPreco(String regiao, String localidade, double preco);

    @Query("SELECT g FROM Gasolineira g WHERE g.nome = :nome AND g.regiao = :regiao AND g.localidade = :localidade AND g.precoGasolina95 < :preco")
    List<Gasolineira> procurarPorNomeNumaLocalidadeDumaRegiaoGasolina95AbaixoXPreco(String nome, String regiao, String localidade, double preco);

    @Query("SELECT g FROM Gasolineira g WHERE g.precoGasolina98 < :preco")
    List<Gasolineira> procurarBombasGasolina98AbaixoDeXPreco(double preco);

    @Query("SELECT g FROM Gasolineira g WHERE g.nome = :nome AND g.precoGasolina98 < :preco")
    List<Gasolineira> procurarBombasPorNomeGasolina98AbaixoXPreco(String nome, double preco);

    @Query("SELECT g FROM Gasolineira g WHERE g.regiao = :regiao AND g.precoGasolina98 < :preco")
    List<Gasolineira> procurarBombasNaRegiaoGasolina98AbaixoDeXPreco(String regiao, double preco);

    @Query("SELECT g FROM Gasolineira g WHERE g.nome = :nome AND g.regiao = :regiao AND g.precoGasolina98 < :preco")
    List<Gasolineira> procurarBombasPorNomeNaRegiaoGasolina98AbaixoXPreco(String nome, String regiao, double preco);

    @Query("SELECT g FROM Gasolineira g WHERE g.localidade = :localidade AND g.precoGasolina98 < :preco")
    List<Gasolineira> procurarBombasNaLocalidadeGasolina98AbaixoXPreco(String localidade, double preco);

    @Query("SELECT g FROM Gasolineira g WHERE g.nome = :nome AND g.localidade = :localidade AND g.precoGasolina98 < :preco")
    List<Gasolineira> procurarBombasPorNomeNaLocalidadeGasolina98AbaixoXPreco(String nome, String localidade, double preco);

    @Query("SELECT g FROM Gasolineira g WHERE g.regiao = :regiao AND g.localidade = :localidade AND g.precoGasolina98 < :preco")
    List<Gasolineira> procurarBombasNaRegiaoNumaLocalidadeGasolina98AbaixoXPreco(String regiao, String localidade, double preco);

    @Query("SELECT g FROM Gasolineira g WHERE g.nome = :nome AND g.regiao = :regiao AND g.localidade = :localidade AND g.precoGasolina98 < :preco")
    List<Gasolineira> procurarPorNomeNumaLocalidadeDumaRegiaoGasolina98AbaixoXPreco(String nome, String regiao, String localidade, double preco);

    @Query("SELECT g FROM Gasolineira g WHERE g.gasoleoSimples < :preco")
    List<Gasolineira> procurarBombasGasoleoSimplesAbaixoDeXPreco(double preco);

    @Query("SELECT g FROM Gasolineira g WHERE g.nome = :nome AND g.gasoleoSimples < :preco")
    List<Gasolineira> procurarBombasPorNomeGasoleoSimplesAbaixoXPreco(String nome, double preco);

    @Query("SELECT g FROM Gasolineira g WHERE g.regiao = :regiao AND g.gasoleoSimples < :preco")
    List<Gasolineira> procurarBombasNaRegiaoGasoleoSimplesAbaixoDeXPreco(String regiao, double preco);

    @Query("SELECT g FROM Gasolineira g WHERE g.nome = :nome AND g.regiao = :regiao AND g.gasoleoSimples < :preco")
    List<Gasolineira> procurarBombasPorNomeNaRegiaoGasoleoSimplesAbaixoXPreco(String nome, String regiao, double preco);

    @Query("SELECT g FROM Gasolineira g WHERE g.localidade = :localidade AND g.gasoleoSimples < :preco")
    List<Gasolineira> procurarBombasNaLocalidadeGasoleoSimplesAbaixoXPreco(String localidade, double preco);

    @Query("SELECT g FROM Gasolineira g WHERE g.nome = :nome AND g.localidade = :localidade AND g.gasoleoSimples < :preco")
    List<Gasolineira> procurarBombasPorNomeNaLocalidadeGasoleoSimplesAbaixoXPreco(String nome, String localidade, double preco);

    @Query("SELECT g FROM Gasolineira g WHERE g.regiao = :regiao AND g.localidade = :localidade AND g.gasoleoSimples < :preco")
    List<Gasolineira> procurarBombasNaRegiaoNumaLocalidadeGasoleoSimplesAbaixoXPreco(String regiao, String localidade, double preco);

    @Query("SELECT g FROM Gasolineira g WHERE g.nome = :nome AND g.regiao = :regiao AND g.localidade = :localidade AND g.gasoleoSimples < :preco")
    List<Gasolineira> procurarPorNomeNumaLocalidadeDumaRegiaoGasoleoSimplesAbaixoXPreco(String nome, String regiao, String localidade, double preco);

    @Query("SELECT g FROM Gasolineira g WHERE g.gasoleoAditivado < :preco")
    List<Gasolineira> procurarBombasGasoleoAditivadoAbaixoDeXPreco(double preco);

    @Query("SELECT g FROM Gasolineira g WHERE g.nome = :nome AND g.gasoleoAditivado < :preco")
    List<Gasolineira> procurarBombasPorNomeGasoleoAditivadoAbaixoXPreco(String nome, double preco);

    @Query("SELECT g FROM Gasolineira g WHERE g.regiao = :regiao AND g.gasoleoAditivado < :preco")
    List<Gasolineira> procurarBombasNaRegiaoGasoleoAditivadoAbaixoDeXPreco(String regiao, double preco);

    @Query("SELECT g FROM Gasolineira g WHERE g.nome = :nome AND g.regiao = :regiao AND g.gasoleoAditivado < :preco")
    List<Gasolineira> procurarBombasPorNomeNaRegiaoGasoleoAditivadoAbaixoXPreco(String nome, String regiao, double preco);

    @Query("SELECT g FROM Gasolineira g WHERE g.localidade = :localidade AND g.gasoleoAditivado < :preco")
    List<Gasolineira> procurarBombasNaLocalidadeGasoleoAditivadoAbaixoXPreco(String localidade, double preco);

    @Query("SELECT g FROM Gasolineira g WHERE g.nome = :nome AND g.localidade = :localidade AND g.gasoleoAditivado < :preco")
    List<Gasolineira> procurarBombasPorNomeNaLocalidadeGasoleoAditivadoAbaixoXPreco(String nome, String localidade, double preco);

    @Query("SELECT g FROM Gasolineira g WHERE g.regiao = :regiao AND g.localidade = :localidade AND g.gasoleoAditivado < :preco")
    List<Gasolineira> procurarBombasNaRegiaoNumaLocalidadeGasoleoAditivadoAbaixoXPreco(String regiao, String localidade, double preco);

    @Query("SELECT g FROM Gasolineira g WHERE g.nome = :nome AND g.regiao = :regiao AND g.localidade = :localidade AND g.gasoleoAditivado < :preco")
    List<Gasolineira> procurarPorNomeNumaLocalidadeDumaRegiaoGasoleoAditivadoAbaixoXPreco(String nome, String regiao, String localidade, double preco);
}
