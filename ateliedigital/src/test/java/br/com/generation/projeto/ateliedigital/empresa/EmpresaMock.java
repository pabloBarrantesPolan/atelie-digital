package br.com.generation.projeto.ateliedigital.empresa;

import br.com.generation.projeto.ateliedigital.plano.Plano;
import com.github.javafaker.Faker;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class EmpresaMock {
    public static Empresa getEmpresaMock(){

        Faker faker = new Faker(new Locale("pt-BR"));


        Empresa empresa = new Empresa();
        Set<Plano> plano = new HashSet<>();

        empresa.setRazaoSocial(faker.name().firstName());
        empresa.setNomeFantasia(faker.name().firstName()+"S.A");
        empresa.setEmail( faker.internet().emailAddress());
        empresa.setTelefone( faker.number().numberBetween(11000000,11999999));
        empresa.setRegiao("Zona leste");
        empresa.setCep(faker.number().digits(8));
        empresa.setCnpj(faker.number().digits(11));
        empresa.setPlano(plano);
        empresa.setSenha(faker.internet().password());

        return empresa;
    }
}
