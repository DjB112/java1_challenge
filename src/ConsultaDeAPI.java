import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaDeAPI {
    public Consulta consultarMoneda(String monedaBase, String monedaFinal, String cantidad){
        String urlDirec = "https://v6.exchangerate-api.com/v6/6397da860b829dba74cbb368/pair/"+monedaBase+"/"+monedaFinal+"/"+cantidad;
        //String urlDirec = "https://v6.exchangerate-api.com/v6/6397da860b829dba74cbb368/latest/"+monedaBase;

        try {
            URI direccion = URI.create(urlDirec);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).setPrettyPrinting().create();
            return gson.fromJson(response.body(), Consulta.class);

        }catch (IllegalArgumentException e) {
            System.out.println("Error en la URI, Verifique la Moneda");
        }catch(Exception e) {
            throw new RuntimeException("Error, No se encontro moneda");
        }
        return null;
    }
}
