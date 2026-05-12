package com.FuelControl.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Utilizador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String nome;
    private String email;

    @OneToMany(mappedBy = "utilizador", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Desconto> descontos = new ArrayList<>();
}
