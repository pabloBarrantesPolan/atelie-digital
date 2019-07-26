package br.com.generation.projeto.ateliedigital.ateliedigital.cliente;



import br.com.generation.projeto.ateliedigital.ateliedigital.AteliedigitalApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Locale;

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

    @Test
    public void save(){

        for (int i = 0; i < 100; i++) {
            ResponseEntity<Cliente> postResponse = testRestTemplate.postForEntity(getRootUrl("/"),
                    ClienteMock.getClienteMock(), Cliente.class);

            assertNotNull(postResponse);
            assertEquals(201, postResponse.getStatusCodeValue());
        }

    }


    @Test
    public void findAll(){
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity(null, headers);
        ResponseEntity<String> response = testRestTemplate.exchange(getRootUrl("/clientes"), HttpMethod.GET, entity, String.class);
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

        int id = 1;
        Cliente cliente = testRestTemplate.getForObject(getRootUrl("/clientes/" +id) , Cliente.class);

        String novoNome = ClienteMock.getClienteMock().getNome();
        cliente.setNome(novoNome);
        String novoEmail = ClienteMock.getClienteMock().getEmail();
        cliente.setEmail(novoEmail);
        String novaSenha = ClienteMock.getClienteMock().getSenha();
        cliente.setSenha(novaSenha);

      testRestTemplate.put(getRootUrl("/clientes/"+ id), cliente);
        assertEquals(novoNome, cliente.getNome());

    }

    @Test
    public void testDeleteCliente() {
        int id = 2;
        Cliente cliente = testRestTemplate.getForObject(getRootUrl("/cliente/"+ id), Cliente.class);
        assertNotNull(cliente);
        testRestTemplate.delete(getRootUrl("/cliente/"+ id));
        try {
           testRestTemplate.getForObject(getRootUrl("/cliente/"+ id) , Cliente.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
        }
    }

}
