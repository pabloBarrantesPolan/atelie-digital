package br.com.generation.projeto.ateliedigital.ateliedigital.empresa;

import com.github.javafaker.Faker;

import java.util.Locale;

public class EmpresaMock {
    public static Empresa getEmpresaMock(){

        Faker faker = new Faker(new Locale("pt-BR"));


        Empresa empresa = new Empresa();
        empresa.setRazaoSocial(faker.name().firstName()+ "SA");
        empresa.setNomeFantasia(faker.name().firstName());
        empresa.setEmail( faker.internet().emailAddress());
        empresa.setTelefone( faker.number().numberBetween(11000000,11999999));
        empresa.setRegiao("Zona leste");
        empresa.setCep(faker.number().digits(8));
        empresa.setCnpj(faker.number().digits(11));
        empresa.setPlano(faker.number().randomDigit());
        empresa.setSenha(faker.internet().password());

        return empresa;
    }
}
