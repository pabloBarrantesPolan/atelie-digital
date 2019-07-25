package br.com.generation.projeto.ateliedigital.ateliedigital.cep;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cep/")
public class CepController {
    private static  final Logger logger = LoggerFactory.getLogger(CepController.class);

//    @Autowired
//    private CepService cepService;
////TODO- resolver esse controller
//    @GetMapping("{numeroCep}")
//    public Integer pegaEndereco(@PathVariable Integer numeroCep){
//        return cepService.pegaEndereco(numeroCep);
//    }

}
