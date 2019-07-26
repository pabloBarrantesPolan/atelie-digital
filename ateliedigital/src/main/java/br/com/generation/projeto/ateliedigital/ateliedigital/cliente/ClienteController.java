package br.com.generation.projeto.ateliedigital.ateliedigital.cliente;

import br.com.generation.projeto.ateliedigital.ateliedigital.resourceNotFoundException.ResourceNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Api
@RequestMapping(value = "/api/v1/clientes", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@CrossOrigin("*")
public class ClienteController {

    private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);

    @Autowired
    private ClienteRepository repository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Salva um novo Cliente")
    public Cliente Save(@RequestBody Cliente cliente){

        return repository.save(cliente);

    }
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Mostra lista de CLientes")
    public List<Cliente> findAll(){
        logger.info("foi!");
        return repository.findAll();
    }
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Pesquisa um Cliente pelo ID")
    public Optional<Cliente> findById(@PathVariable Long id){
        return repository.findById(id);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Atualiza um CLiente pelo ID")
    public Cliente update(@PathVariable Long id, @RequestBody Cliente cliente) throws ResourceNotFoundException {

        return repository.findById(id).map( c -> {
            c.setNome(cliente.getNome());
            c.setEmail(cliente.getEmail());
            c.setSenha(cliente.getSenha());
            return repository.save(c);
        }).orElseThrow(()->
                new ResourceNotFoundException("Não existe esse usuario"));

    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Apaga um Cliente pelo ID")
    public void deleteById(@PathVariable Long id){
        repository.deleteById(id);
    }

}


