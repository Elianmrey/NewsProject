package com.bytefalcons.noticias;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Connector {

    @SneakyThrows
    public StringBuilder ConnectAndReceive(String route) {


        URL myUrl = new URL(route);
        HttpURLConnection connection = (HttpURLConnection) myUrl.openConnection();
        connection.setRequestMethod("GET");
        int response = connection.getResponseCode();

        StringBuilder responseIn = new StringBuilder();

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
