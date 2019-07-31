package br.com.generation.projeto.ateliedigital.plano;



import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.awt.image.RasterFormatException;
import java.util.List;
import java.util.Optional;


@RequestMapping("/api/v1/planos")
@Api //documentar api Swagger
@CrossOrigin("*") //caminho do angular
@RestController
public class PlanoController {

    @Autowired
    private PlanoRepository repository;


    @GetMapping("/")
    @ApiOperation(value = "Listar planos")
    public List<Plano> findByAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Mostra um plano pelo ID")
    public Optional<Plano> findById(@PathVariable Long id){
        return repository.findById(id);
    }

//    @GetMapping("/pesquisa/{tipo}")
//    @ApiOperation(value = "Mostra lista de planos por tipo")
//    public List<Plano> findByNome(@PathVariable String tipo) {
//        return repository.findByTipo(tipo);
//    }
//
//    @GetMapping("/{numero}")
//    @ApiOperation(value = "Mostra lista de planos por numero")
//    public List<Plano> findByNumero(@PathVariable Integer numero) {
//        return repository.findByNumero(numero);
//    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    @ApiOperation(value = "Salva um novo plano")
    public Plano save (@RequestBody Plano plano){
        return repository.save(plano);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza um plano pelo ID")
    public Plano saveOrUpdate(@PathVariable Long id, @RequestBody Plano plano) {
// "UPDATE cliente SET ... WHERE/planos/{id}") ..."
        return repository.findById(id).map(planoAtualizado -> {
            planoAtualizado.setTipo(plano.getTipo());
            planoAtualizado.setNumero(plano.getNumero());
            planoAtualizado.setValor(plano.getValor());

            return repository.save(planoAtualizado);
        }).orElseThrow(() ->
                new RasterFormatException("Não existe plano cadastrado com o id :" + id));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Apaga um plano pelo ID")
    public void delete( @PathVariable Long id){
        repository.deleteById(id);
    }


}
