package br.com.generation.projeto.ateliedigital.profissional;

import com.github.javafaker.Faker;

import java.util.Locale;

public class ProfissionalMock {
    public static Profissional getProfissionalMock() {

        Faker faker = new Faker(new Locale("pt-BR"));


        Profissional profissional = new Profissional();
        profissional.setNome(faker.name().firstName());
        profissional.setEmail(faker.internet().emailAddress());
        profissional.setTelefone(faker.number().numberBetween(11000000, 11999999));
        profissional.setRegiao("Zona leste");
        profissional.setCep(faker.number().digits(8));
        profissional.setCpf(faker.number().digits(11));
        profissional.setPlano(faker.number().randomDigit());
        profissional.setSenha(faker.internet().password());

        return profissional;
    }
}
