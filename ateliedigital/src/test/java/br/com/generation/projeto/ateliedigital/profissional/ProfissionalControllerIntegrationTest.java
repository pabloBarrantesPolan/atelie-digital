package br.com.generation.projeto.ateliedigital.profissional;

import br.com.generation.projeto.ateliedigital.AteliedigitalApplication;
import br.com.generation.projeto.ateliedigital.plano.Plano;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Collections;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AteliedigitalApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProfissionalControllerIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl(String path){
        return "http://localhost:" + port + "/api/v1/profissionais" + path;
    }

    private String token;

    @Before
    public void init() {
        this.token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNTY0NjY2MzM0LCJleHAiOjE1NjU1MzAzMzR9.msN9ebk2SnYWLvLQQavrOKNf_lJDvROkMYreCqoMQGNznIm4UasEPVvkexHj5bfwkeSK4swiHqp4gP0gdquSQA";
    }
    @Test
    public void save(){

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Bearer " + this.token);

        HttpEntity<Profissional> entity = new HttpEntity<>(ProfissionalMock.getProfissionalMock(), headers);

        ResponseEntity<Profissional> postResponse = testRestTemplate.exchange(
                getRootUrl("/"),
                HttpMethod.POST,
                entity,
                Profissional.class
        );
            assertNotNull(postResponse);
            assertEquals(201, postResponse.getStatusCodeValue());


    }


    @Test
    public void findAll(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + this.token);
        HttpEntity<String> entity = new HttpEntity(null, headers);

        ResponseEntity<String> response = testRestTemplate.exchange(
                getRootUrl("/"),
                HttpMethod.GET,
                entity,
                String.class
        );
        assertNotNull(response.getBody());
        assertEquals(200, response.getStatusCodeValue());

    }
    @Test
    public void findById(){

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + this.token);
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<Profissional> response = testRestTemplate.exchange(
                getRootUrl("/") + "1",
                HttpMethod.GET,
                entity,
                Profissional.class);

        assertNotNull(response.getBody());
        assertEquals(200, response.getStatusCodeValue());
    }


    @Test
    public void update(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Bearer " + this.token);

        HttpEntity<Profissional> entity = new HttpEntity<>(ProfissionalMock.getProfissionalMock(), headers);

        ResponseEntity<Profissional> responseEntity = testRestTemplate.exchange(
                getRootUrl("/") + "1",
                HttpMethod.PUT,
                entity,
                Profissional.class
        );
    }
/* // Teste original
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
        String novaImagem = ProfissionalMock.getProfissionalMock().getUrlImagem();
        profissional.setUrlImagem(novaImagem);
        testRestTemplate.put(getRootUrl("/"+ id), profissional);
        assertEquals(novoNome, profissional.getNome());

    }*/

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
