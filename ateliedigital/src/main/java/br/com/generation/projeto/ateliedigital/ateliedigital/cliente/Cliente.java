package br.com.generation.projeto.ateliedigital.ateliedigital.cliente;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @NotNull
    private String nome;

    @NotNull
    @Column(unique = true)
    private String email;


    @NotNull
    private String senha;

}
