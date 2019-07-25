package br.com.generation.projeto.ateliedigital.ateliedigital.profissional;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @NotBlank
    private String nome;

    @NotBlank
    @Column(unique = true)
    private String cpf;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private Integer telefone;

    @NotBlank
    private String  regiao;

    @NotBlank
    private String cep;
}
