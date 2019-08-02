package br.com.generation.projeto.ateliedigital.email;

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
public class EmailControllerIntegrationTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl(String path){
        return "http://localhost:" + port + "/api/v1/email" + path;
    }

    @Test
    public void save(){

        ResponseEntity<Email> postResponse = testRestTemplate.postForEntity(getRootUrl("/"), EmailMock.getEmailMock(), Email.class);

            assertNotNull(postResponse);
            assertEquals(201, postResponse.getStatusCodeValue());


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
//        ResponseEntity<String> response = testRestTemplate.exchange(getRootUrl("/cliente/"+ id), HttpMethod.GET, entity, String.class);
//        assertNotNull(response.getBody());
//        assertEquals(entity,);
//    }




    @Test
    public void testDelete() {
        int id = 1;
        Email email = testRestTemplate.getForObject(getRootUrl("/"+ id), Email.class);
        assertNotNull(email);
        testRestTemplate.delete(getRootUrl("/"+ id));
        try {
            testRestTemplate.getForObject(getRootUrl("/"+ id) , Email.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
        }
    }
}
