package br.com.generation.projeto.ateliedigital.email;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Api
@RequestMapping(value = "/api/v1/emails")
@CrossOrigin("*")
public class EmailController {

    @Autowired
    private EmailRepository repository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    @ApiOperation(value = "Salva um novo E-mail")
    public Email save(@Valid  @RequestBody Email email){

        return repository.save(email);

    }
    @GetMapping("/")
    @ApiOperation(value = "Mostra lista de E-mail")
    public List<Email> findAll(){
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Pesquisa um E-mail pelo ID")
    public Optional<Email> findById(@PathVariable Long id){
        return repository.findById(id);
    }



    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Apaga um E-mail pelo ID")
    public void deleteById(@PathVariable Long id){
        repository.deleteById(id);
    }
}
