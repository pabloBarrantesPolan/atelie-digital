package br.com.generation.projeto.ateliedigital.ateliedigital.profissional;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @NotNull
    private String nome;

    @NotNull
    @Column(unique = true)
    private String cpf;

    @NotNull
    @Email
    private String email;

    @NotNull
    private Integer telefone;

    @NotNull
    private String  regiao;

    @NotNull
    private String cep;

    @NotNull
    private String senha;

    @NotNull
    private  Integer plano;
}
