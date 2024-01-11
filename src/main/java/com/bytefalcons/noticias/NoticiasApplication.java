package com.bytefalcons.noticias;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NoticiasApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoticiasApplication.class, args);


      JSONObject jsonIn = new JSONObject(new Connector().ConnectAndReceive("https://servicodados.ibge.gov.br/api/v3/noticias/?de=01-11-2024").toString());
      JSONArray news = jsonIn.getJSONArray("items");

        System.out.println(news);
    }

}
