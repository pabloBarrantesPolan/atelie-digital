package br.com.generation.projeto.ateliedigital.profissional;

import br.com.generation.projeto.ateliedigital.plano.Plano;
import com.github.javafaker.Faker;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class ProfissionalMock {
    public static Profissional getProfissionalMock() {

        Faker faker = new Faker(new Locale("pt-BR"));


        Profissional profissional = new Profissional();
        Set<Plano> plano = new HashSet<Plano>();
        profissional.setNome(faker.name().firstName());
        profissional.setEmail(faker.internet().emailAddress());
        profissional.setTelefone(faker.number().numberBetween(11000000, 11999999));
        profissional.setRegiao("Zona leste");
        profissional.setCep(faker.number().digits(8));
        profissional.setCpf(faker.number().digits(11));
        profissional.setPlano(plano);
        profissional.setSenha(faker.internet().password());

        return profissional;
    }
}
