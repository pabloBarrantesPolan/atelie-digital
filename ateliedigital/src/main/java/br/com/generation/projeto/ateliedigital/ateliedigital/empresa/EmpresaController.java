package br.com.generation.projeto.ateliedigital.ateliedigital.empresa;

import br.com.generation.projeto.ateliedigital.ateliedigital.profissional.Profissional;
import br.com.generation.projeto.ateliedigital.ateliedigital.profissional.ProfissionalRepository;
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
@RequestMapping(value = "/api/v1/empresas", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@CrossOrigin("*")
public class EmpresaController {
    @Autowired
    private EmpresaRepository repository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Salva uma nova empresa")
    public Empresa Save(@Valid @RequestBody Empresa empresa){

        return repository.save(empresa);

    }
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Mostra lista de Empresas")
    public List<Empresa> findAll(){

        return repository.findAll();
    }
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Pesquisa uma empresa pelo ID")
    public Optional<Empresa> findById(@PathVariable Long id){
        return repository.findById(id);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Atualiza uma Empresa pelo ID")
    public Empresa update(@PathVariable Long id, @RequestBody Empresa empresa) throws ResourceNotFoundException {

        return repository.findById(id).map( e -> {
            e.setNomeFantasia(empresa.getNomeFantasia());
            e.setRazaoSocial(empresa.getRazaoSocial());
            e.setCep(empresa.getCep());
            e.setEmail(empresa.getEmail());
            e.setTelefone(empresa.getTelefone());
            e.setCnpj(empresa.getCnpj());
            e.setRegiao(empresa.getRegiao());
            e.setSenha(empresa.getSenha());
            e.setPlano(empresa.getPlano());
            return repository.save(e);
        }).orElseThrow(()->
                new ResourceNotFoundException("Não existe essa empresa"));

    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Apaga uma empresa pelo ID")
    public void deleteById(@PathVariable Long id){
        repository.deleteById(id);
    }

    @GetMapping(value = "/pesquisa/{regiao}")
    @ApiOperation(value = "filtra por regiao")
    public List<Empresa> findByRegiao(@PathVariable String regiao){
        return  repository.findByRegiao(regiao);
    }
}
