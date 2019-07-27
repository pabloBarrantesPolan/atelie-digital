package br.com.generation.projeto.ateliedigital.ateliedigital.profissional;


import br.com.generation.projeto.ateliedigital.ateliedigital.cliente.Cliente;
import br.com.generation.projeto.ateliedigital.ateliedigital.cliente.ClienteController;
import br.com.generation.projeto.ateliedigital.ateliedigital.cliente.ClienteRepository;
import br.com.generation.projeto.ateliedigital.ateliedigital.resourceNotFoundException.ResourceNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Api
@RequestMapping(value = "/api/v1/profissionais", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@CrossOrigin("*")
public class ProfissionalController {

    @Autowired
    private ProfissionalRepository repository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Salva um novo Profissional")
    public Profissional Save(@Valid @RequestBody Profissional profissional){

        return repository.save(profissional);

    }
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Mostra lista de Profissional")
    public List<Profissional> findAll(){

        return repository.findAll();
    }
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Pesquisa um Profissional pelo ID")
    public Optional<Profissional> findById(@PathVariable Long id){
        return repository.findById(id);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Atualiza um Profissional pelo ID")
    public Profissional update(@PathVariable Long id, @RequestBody Profissional profissional) throws ResourceNotFoundException {

        return repository.findById(id).map( p -> {
            p.setNome(profissional.getNome());
            p.setCep(profissional.getCep());
            p.setEmail(profissional.getEmail());
            p.setTelefone(profissional.getTelefone());
            p.setCpf(profissional.getCpf());
            p.setRegiao(profissional.getRegiao());
            p.setSenha(profissional.getSenha());
            p.setPlano(profissional.getPlano());
            return repository.save(p);
        }).orElseThrow(()->
                new ResourceNotFoundException("Não existe esse profissional"));

    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Apaga um Profissional pelo ID")
    public void deleteById(@PathVariable Long id){
        repository.deleteById(id);
    }

    @GetMapping(value = "/pesquisa/{regiao}")
    @ApiOperation(value = "filtra por regiao")
    public List<Profissional> findByRegiao(@PathVariable String regiao){
        return  repository.findByRegiao(regiao);
    }
}
