package br.com.generation.projeto.ateliedigital.empresa;

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
@SpringBootTest(classes = AteliedigitalApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmpresaControllerIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl(String path){
        return "http://localhost:" + port + "/api/v1/empresas" + path;
    }

    private String token;

    @Before
    public void init() {
        this.token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNTY0NjY2MzM0LCJleHAiOjE1NjU1MzAzMzR9.msN9ebk2SnYWLvLQQavrOKNf_lJDvROkMYreCqoMQGNznIm4UasEPVvkexHj5bfwkeSK4swiHqp4gP0gdquSQA";}


    @Test
    public void save(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Bearer " + this.token);

        HttpEntity<Empresa> entity = new HttpEntity<>(EmpresaMock.getEmpresaMock(), headers);

        ResponseEntity<Empresa> responseEntity = testRestTemplate.exchange(
                getRootUrl("/"),
                HttpMethod.POST,
                entity,
                Empresa.class
        );

        assertNotNull(responseEntity);
        assertEquals(201, responseEntity.getStatusCodeValue());

/*
        for (int i = 0; i < 10; i++) {
            ResponseEntity<Empresa> postResponse = testRestTemplate.postForEntity(getRootUrl("/"),
                    EmpresaMock.getEmpresaMock(), Empresa.class);

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

        ResponseEntity<Empresa> response = testRestTemplate.exchange(
                getRootUrl("/") + "1",
                HttpMethod.GET,
                entity,
                Empresa.class);

        assertNotNull(response.getBody());
        assertEquals(200, response.getStatusCodeValue());
/*
        int id = 3;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity(null, headers);
        ResponseEntity<String> response = testRestTemplate.exchange(getRootUrl("/"+ id), HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
        assertEquals(entity,);
        */

    }


    @Test
    public void update(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Bearer " + this.token);

        HttpEntity<Empresa> entity = new HttpEntity<>(EmpresaMock.getEmpresaMock(), headers);

        ResponseEntity<Empresa> responseEntity = testRestTemplate.exchange(
                getRootUrl("/") + "1",
                HttpMethod.PUT,
                entity,
                Empresa.class
        );

        assertNotNull(responseEntity);
        assertEquals(200, responseEntity.getStatusCodeValue());
    /*
        int id = 1;
        Empresa empresa = testRestTemplate.getForObject(getRootUrl("/" +id) , Empresa.class);

        String novoNome = EmpresaMock.getEmpresaMock().getNomeFantasia();
        empresa.setNomeFantasia(novoNome);
        String novaRazao = EmpresaMock.getEmpresaMock().getRazaoSocial();
        empresa.setRazaoSocial(novaRazao);
        String novoEmail = EmpresaMock.getEmpresaMock().getEmail();
        empresa.setEmail(novoEmail);
        Integer novoTelefone = EmpresaMock.getEmpresaMock().getTelefone();
        empresa.setTelefone(novoTelefone);
        String  novoCnpj = EmpresaMock.getEmpresaMock().getCnpj();
        empresa.setCnpj(novoCnpj);
        String novaRegiao = EmpresaMock.getEmpresaMock().getRegiao();
        empresa.setRegiao(novaRegiao);
        HashSet<Plano> novoPlano = (HashSet<Plano>) EmpresaMock.getEmpresaMock().getPlano();
        empresa.setPlano(novoPlano);
        String novaSenha = EmpresaMock.getEmpresaMock().getSenha();
        empresa.setSenha(novaSenha);

        testRestTemplate.put(getRootUrl("/"+ id), empresa);
        assertEquals(novaRazao, empresa.getRazaoSocial());
    */
    }

    @Test
    public void testDelete() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Bearer " + this.token);

        int id = 1;
        Empresa empresa = testRestTemplate.getForObject(getRootUrl("/"+ id), Empresa.class);
        assertNotNull(empresa);
        testRestTemplate.delete(getRootUrl("/"+ id));
        try {
            testRestTemplate.getForObject(getRootUrl("/"+ id) , Empresa.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
        }
    }
}
