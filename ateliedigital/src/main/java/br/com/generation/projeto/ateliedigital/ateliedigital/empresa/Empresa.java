package br.com.generation.projeto.ateliedigital.ateliedigital.empresa;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @NotNull
    @Column(name = "razao_social")
    private String razaoSocial;

    @NotNull
    @Column(name = "nome_fantasia")
    private String nomeFantasia;

    @NotNull
    @Column(unique = true)
    private String cnpj;

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
