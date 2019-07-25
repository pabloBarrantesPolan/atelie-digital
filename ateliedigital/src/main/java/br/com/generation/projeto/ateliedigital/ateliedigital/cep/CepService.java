package br.com.generation.projeto.ateliedigital.ateliedigital.cep;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;




@Service
public class CepService {

    private static  final Logger logger = LoggerFactory.getLogger(CepService.class);

    @GetMapping("cep/{numeroCep}")
    public String statusCodeToCat(@PathVariable Integer numeroCep){

        String retorno = null;

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://viacep.com.br/ws/" + numeroCep + "/json/")
                .get()
                .build();

        Response response;

        {
            try {
                response = client.newCall(request).execute();
                retorno = response.body().string();
            } catch (IOException e) {
                logger.info("Não achamos esse Cep: "+numeroCep);
            }
        }
        return retorno;

    }

}
