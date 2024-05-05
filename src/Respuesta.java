import java.util.ArrayList;

public class Respuesta {
    public void imprimirRespuesta(String monedaBase, String monedaFinal, String cantidad, Double rate, Double resultado, String actualizacion){

        System.out.println(cantidad + " " + monedaBase + " son " + resultado + " " + monedaFinal + " con valor de cambio de " + rate);
        System.out.println("Ultima actualizacion: "+actualizacion);

    }
}
