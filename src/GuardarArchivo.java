import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GuardarArchivo {

    public void guardarJson(ArrayList<Historial> list) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escritura = new FileWriter("historial.json");
        escritura.write(gson.toJson(list));
        escritura.close();
    }
}
