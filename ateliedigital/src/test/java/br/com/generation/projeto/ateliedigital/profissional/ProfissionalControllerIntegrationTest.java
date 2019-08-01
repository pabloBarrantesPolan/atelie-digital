package br.com.generation.projeto.ateliedigital.profissional;

import br.com.generation.projeto.ateliedigital.AteliedigitalApplication;
import br.com.generation.projeto.ateliedigital.plano.Plano;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AteliedigitalApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProfissionalControllerIntegrationTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl(String path){
        return "http://localhost:" + port + "/api/v1/profissionais" + path;
    }

    @Test
    public void save(){

        for (int i = 0; i < 10; i++) {
            ResponseEntity<Profissional> postResponse = testRestTemplate.postForEntity(getRootUrl("/"),
                    ProfissionalMock.getProfissionalMock(), Profissional.class);

            assertNotNull(postResponse);
            assertEquals(201, postResponse.getStatusCodeValue());
        }

    }


    @Test
    public void findAll(){
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity(null, headers);
        ResponseEntity<String> response = testRestTemplate.exchange(getRootUrl("/"), HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
        assertEquals(200, response.getStatusCodeValue());

    }
//todo --- pesquisar falso positivo do metodo
//    @Test
//    public void findById(){
//
//        int id = 3;
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<String> entity = new HttpEntity(null, headers);
//        ResponseEntity<String> response = testRestTemplate.exchange(getRootUrl("/"+ id), HttpMethod.GET, entity, String.class);
//        assertNotNull(response.getBody());
//        assertEquals(entity,);
//    }


    @Test
    public void update(){

        int id = 13;
        Profissional profissional = testRestTemplate.getForObject(getRootUrl("/" +id) , Profissional.class);

        String novoNome = ProfissionalMock.getProfissionalMock().getNome();
        profissional.setNome(novoNome);


        String novoEmail = ProfissionalMock.getProfissionalMock().getEmail();
        profissional.setEmail(novoEmail);
        Integer novoTelefone = ProfissionalMock.getProfissionalMock().getTelefone();
        profissional.setTelefone(novoTelefone);
        String  novoCpf = ProfissionalMock.getProfissionalMock().getCpf();
        profissional.setCpf(novoCpf);
        String novaRegiao = ProfissionalMock.getProfissionalMock().getRegiao();
        profissional.setRegiao(novaRegiao);
        HashSet<Plano> novoPlano = (HashSet<Plano>) ProfissionalMock.getProfissionalMock().getPlano();
        profissional.setPlano(novoPlano);
        String novaSenha = ProfissionalMock.getProfissionalMock().getSenha();
        profissional.setSenha(novaSenha);

        testRestTemplate.put(getRootUrl("/"+ id), profissional);
        assertEquals(novoNome, profissional.getNome());

    }

    @Test
    public void testDelete() {
        int id = 9;
        Profissional profissional = testRestTemplate.getForObject(getRootUrl("/"+ id), Profissional.class);
        assertNotNull(profissional);
        testRestTemplate.delete(getRootUrl("/"+ id));
        try {
            testRestTemplate.getForObject(getRootUrl("/"+ id) , Profissional.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
        }
    }
}
