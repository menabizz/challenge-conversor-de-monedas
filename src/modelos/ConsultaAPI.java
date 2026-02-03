package modelos;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {

    public ValorConversion comparaMonedas(String moneda1, String moneda2){

        URI direccionURI = URI.create("https://v6.exchangerate-api.com/v6/0a9a6ebbd499bd6c655ee27c/pair/" + moneda1 + "/" + moneda2 );

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                .uri(direccionURI)
                .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), ValorConversion.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }




}
