package br.com.generation.projeto.ateliedigital.ateliedigital.resourceNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import sun.nio.cs.HistoricallyNamedCharset;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {

    public ResourceNotFoundException(String msg){
        super(msg);
    }
}
