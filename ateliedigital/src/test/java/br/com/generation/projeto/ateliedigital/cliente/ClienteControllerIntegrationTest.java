package br.com.generation.projeto.ateliedigital.cliente;



import br.com.generation.projeto.ateliedigital.AteliedigitalApplication;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AteliedigitalApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClienteControllerIntegrationTest  {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl(String path){
        return "http://localhost:" + port + "/api/v1/clientes" + path;
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

        HttpEntity<Cliente> entity = new HttpEntity<>(ClienteMock.getClienteMock(), headers);

        ResponseEntity<Cliente> responseEntity = testRestTemplate.exchange(
                getRootUrl("/"),
                HttpMethod.POST,
                entity,
                Cliente.class
        );
        /* teste sem segurança
        for (int i = 0; i < 10; i++) {
            ResponseEntity<Cliente> postResponse = testRestTemplate.postForEntity(getRootUrl("/"),
                    ClienteMock.getClienteMock(), Cliente.class);

            assertNotNull(postResponse);
            assertEquals(201, postResponse.getStatusCodeValue());
        }
*/
    }


    @Test
    public void findAll(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + this.token);
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = testRestTemplate.exchange(
                getRootUrl("/"),
                HttpMethod.GET,
                entity,
                String.class);

        assertNotNull(response.getBody());
        assertEquals(200, response.getStatusCodeValue());

        /*
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity(null, headers);
        ResponseEntity<String> response = testRestTemplate.exchange(getRootUrl("/"), HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
        assertEquals(200, response.getStatusCodeValue());
*/
    }
    @Test
    public void findById(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + this.token);
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<Cliente> response = testRestTemplate.exchange(
                getRootUrl("/") + "1",
                HttpMethod.GET,
                entity,
                Cliente.class);

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
//        ResponseEntity<String> response = testRestTemplate.exchange(getRootUrl("/cliente/"+ id), HttpMethod.GET, entity, String.class);
//        assertNotNull(response.getBody());
//        assertEquals(entity,);
//    }


    @Test
    public void update(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Bearer " + this.token);

        HttpEntity<Cliente> entity = new HttpEntity<>(ClienteMock.getClienteMock(), headers);

        ResponseEntity<Cliente> responseEntity = testRestTemplate.exchange(
                getRootUrl("/") + "1",
                HttpMethod.PUT,
                entity,
                Cliente.class

        );

        assertNotNull(responseEntity);
        assertEquals(200, responseEntity.getStatusCodeValue());
/*
        int id = 10;
        Cliente cliente = testRestTemplate.getForObject(getRootUrl("/" +id) , Cliente.class);

        String novoNome = ClienteMock.getClienteMock().getNome();
        cliente.setNome(novoNome);
        String novoEmail = ClienteMock.getClienteMock().getEmail();
        cliente.setEmail(novoEmail);
        String novaSenha = ClienteMock.getClienteMock().getSenha();
        cliente.setSenha(novaSenha);

      testRestTemplate.put(getRootUrl("/"+ id), cliente);
        assertEquals(novoNome, cliente.getNome());
*/
    }

    @Test
    public void testDeleteCliente() {
        int id = 100;
        Cliente cliente = testRestTemplate.getForObject(getRootUrl("/"+ id), Cliente.class);
        assertNotNull(cliente);
        testRestTemplate.delete(getRootUrl("/"+ id));
        try {
           testRestTemplate.getForObject(getRootUrl("/"+ id) , Cliente.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
        }
    }

}
