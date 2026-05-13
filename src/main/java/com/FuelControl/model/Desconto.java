package com.FuelControl.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Desconto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nomeCartao; // cartão pingo doce, cartão sócio benfica, etc
    private String tipoDesconto; // acumulativo no cartão, desconto direto, etc
    private double valorDesconto;
    private String nomeGasolineira;

    @ManyToOne
    @JoinColumn(name = "utilizador_id") // nome da coluna que vai aparecer na tabela de desconto no MySQL
    @JsonIgnore
    private Utilizador utilizador;
}
