package br.com.generation.projeto.ateliedigital.email;

import com.github.javafaker.Faker;

import java.util.Locale;

public class EmailMock {
    public static Email getEmailMock(){

        Faker faker = new Faker(new Locale("pt-BR"));


        Email email = new Email();
        email.setEmailRemetente(faker.internet().emailAddress());
        email.setAssunto( faker.commerce().productName());
        email.setConteudo("olá meu nome é: "+faker.name().firstName());

        return email;
    }
}
