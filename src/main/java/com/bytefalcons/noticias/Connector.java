package com.bytefalcons.noticias;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Connector {

    @SneakyThrows
    public StringBuffer ConnectAndReceive(String route) {


        URL myUrl = new URL(route);
        HttpURLConnection connection = (HttpURLConnection) myUrl.openConnection();
        connection.setRequestMethod("GET");
        int response = connection.getResponseCode();

            StringBuffer responseIn = new StringBuffer();

        if (response == HttpURLConnection.HTTP_OK) {
            BufferedReader receive = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String read;


            while ((read = receive.readLine()) != null) {
                responseIn.append(read);
            }
            receive.close();

        }
        return responseIn;
    }
}
