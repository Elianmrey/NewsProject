package com.bytefalcons.noticias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NoticiasApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoticiasApplication.class, args);


        System.out.println(new Connector().ConnectAndReceive("https://servicodados.ibge.gov.br/api/v3/noticias/?tipo=noticia"));
    }

}
