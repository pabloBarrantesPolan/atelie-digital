package br.com.generation.projeto.ateliedigital.plano;

import com.github.javafaker.Faker;

import java.util.Locale;

public class PlanoMock {
    public static Plano getPlanoMock(){

        Faker faker = new Faker(new Locale("pt-BR"));


        Plano plano = new Plano();
        plano.setTipo(faker.name().firstName());
        plano.setNumero(faker.number().randomDigit());
        plano.setDescricao(faker.gameOfThrones().dragon());
        plano.setValor( faker.ancient().titan());


        return plano;
    }
}
