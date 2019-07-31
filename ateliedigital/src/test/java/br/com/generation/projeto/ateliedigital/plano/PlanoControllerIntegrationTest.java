package br.com.generation.projeto.ateliedigital.plano;


import br.com.generation.projeto.ateliedigital.AteliedigitalApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AteliedigitalApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PlanoControllerIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;
    private String getRootUrl(String path){
        return "http://localhost:" + port + "/api/v1/planos" + path;
    }

    @Test
    public void save(){

        for (int i = 0; i < 10; i++) {
            ResponseEntity<Plano> postResponse = testRestTemplate.postForEntity(getRootUrl("/"),
                    PlanoMock.getPlanoMock(),Plano.class);
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

        int id = 1;
        Plano plano = testRestTemplate.getForObject(getRootUrl("/" +id) , Plano.class);

        String novoTipo = PlanoMock.getPlanoMock().getTipo();
        plano.setTipo(novoTipo);
        String novaDesc = PlanoMock.getPlanoMock().getDescricao();
        plano.setDescricao(novaDesc);
        String novoValor = PlanoMock.getPlanoMock().getValor();
        plano.setValor(novoValor);


        testRestTemplate.put(getRootUrl("/"+ id), plano);
        assertEquals(novoTipo, plano.getTipo());

    }

    @Test
    public void testDelete() {
        int id = 9;
        Plano plano = testRestTemplate.getForObject(getRootUrl("/"+ id), Plano.class);
        assertNotNull(plano);
        testRestTemplate.delete(getRootUrl("/"+ id));
        try {
            testRestTemplate.getForObject(getRootUrl("/"+ id) , Plano.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
        }
    }
}
