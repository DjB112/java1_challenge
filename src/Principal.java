import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ConsultaDeAPI moneda = new ConsultaDeAPI();
        String monedaBase = "";
        String monedaFinal = "";
        String cantidad;
        int seguir = 0;
        Consulta consulta;
        Scanner lectura = new Scanner(System.in);
        Respuesta respuesta = new Respuesta();
        Menu menu = new Menu();
        ArrayList<Historial> list = new ArrayList<>();

        do {

            menu.imprimirMenu();  //imprimimos el menu
            var lecturaDeMenu = lectura.nextLine(); //cargamos la respuesta

            switch (lecturaDeMenu) {
                case "1":
                    monedaBase = "USD";
                    monedaFinal = "ARS";
                    break;
                case "2":
                    monedaBase = "ARS";
                    monedaFinal = "USD";
                    break;
                case "3":
                    monedaBase = "USD";
                    monedaFinal = "BRL";
                    break;
                case "4":
                    monedaBase = "BRL";
                    monedaFinal = "USD";
                    break;
                case "5":
                    monedaBase = "USD";
                    monedaFinal = "COP";
                    break;
                case "6":
                    monedaBase = "COP";
                    monedaFinal = "USD";
                    break;
                case "7":
                    seguir = 7;
                    break;
                default:
                    seguir = 7;
                    System.out.println("Error en Seleccion de Menu");
                    break;
            }
            if (seguir != 7) {
              try {
                  System.out.println("Ingrese el Monto a convertir: ");
                  cantidad = lectura.nextLine();
                  consulta = moneda.consultarMoneda(monedaBase, monedaFinal, cantidad);
                  System.out.println("Resultado:");
                  if (consulta.result().equals("success")) {
                      respuesta.imprimirRespuesta(monedaBase, monedaFinal, cantidad, consulta.conversion_rate(), consulta.conversion_result(), consulta.time_last_update_utc());
                      Historial historial = new Historial(monedaBase, monedaFinal, cantidad, consulta.conversion_result(), consulta.conversion_rate());
                      list.add(historial);
                  } else {
                      System.out.println("Error en su consulta.");
                  }
              }catch (Exception e){
                  System.out.println("Error de Consulta");
                  seguir =7;
              }
            }
        } while (seguir != 7);

        System.out.println("Su Historial:");
        for (Historial item : list) {
            System.out.println(item);
            }
        GuardarArchivo archivar =new GuardarArchivo();
        try {
                archivar.guardarJson(list);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }

}

