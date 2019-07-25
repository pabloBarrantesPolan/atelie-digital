package br.com.generation.projeto.ateliedigital.ateliedigital.cliente;

import com.github.javafaker.Faker;

import java.util.Locale;

public  class ClienteMock {

       public static Cliente getClienteMock(){

           Faker faker = new Faker(new Locale("pt-BR"));


           Cliente cliente = new Cliente();
           cliente.setNome(faker.name().firstName());
           cliente.setEmail( faker.internet().emailAddress());
           cliente.setSenha(faker.internet().password());

           return cliente;
       }
    }


