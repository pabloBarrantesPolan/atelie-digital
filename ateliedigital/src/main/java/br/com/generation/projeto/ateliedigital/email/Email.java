package br.com.generation.projeto.ateliedigital.email;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @NotNull
    @Column(name = "email_remetente")
    private String emailRemetente;

    @NotNull
    private String assunto;


    @NotNull
    private String conteudo;
}
