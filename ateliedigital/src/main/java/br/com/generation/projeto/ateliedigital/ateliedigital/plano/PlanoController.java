package com.atelie.demo.plano;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.awt.image.RasterFormatException;
import java.util.List;
import java.util.Optional;


@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class PlanoController {

    @Autowired
    private PlanoRepository repository;


    @GetMapping("/planos")
    public List<Plano> findByAll(){
        return repository.findAll();
    }

    @GetMapping("/planos/{id}")
    public Optional<Plano> findById(@PathVariable Long id){
        return repository.findById(id);
    }

    @PostMapping("/planos/tipo")
    public List<Plano> findByNome(@RequestParam String tipo) {
        return repository.findByTipo(tipo);
    }

    @PostMapping("/planos/numero")
    public List<Plano> findByNumero(@RequestParam Integer numero) {
        return repository.findByNumero(numero);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/planos")
    public Plano save (@RequestBody Plano plano){
        return repository.save(plano);
    }

    @PutMapping("/planos/{id}")
    public Plano saveOrUpdate(@PathVariable Long id, @RequestBody Plano plano) {
// "UPDATE cliente SET ... WHERE/planos/{id}") ..."
        return repository.findById(id).map(planoAtualizado -> {
            planoAtualizado.setTipo(plano.getTipo());
            planoAtualizado.setNumero(plano.getNumero());

            return repository.save(planoAtualizado);
        }).orElseThrow(() ->
                new RasterFormatException("Não existe plano cadastrado com o id :" + id));
    }

    @DeleteMapping(("/planos/{id}"))
    public void delete( @PathVariable Long id){
        repository.deleteById(id);
    }


}
