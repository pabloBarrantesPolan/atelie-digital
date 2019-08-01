package br.com.generation.projeto.ateliedigital.profissional;


import br.com.generation.projeto.ateliedigital.plano.Plano;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

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
    @OneToOne
    @JoinColumn(name = "id")
    private Plano plano = new Plano();
}
