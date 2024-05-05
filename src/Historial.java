import java.util.Date;

public class Historial {
    private String monedaDeBase;
    private String monedaFinal;
    private String cantidad;
    private Double resultado;
    private Double rate;
    private Date fecha=new Date();

    public Historial (String monedaDeBase, String monedaFinal, String cantidad, Double resultado, Double rate){
        this.monedaDeBase= monedaDeBase;
        this.monedaFinal = monedaFinal;
        this.cantidad = cantidad;
        this.resultado = resultado;
        this.rate = rate;
    }

    @Override
    public String toString() {
        return this.cantidad + " " + this.monedaDeBase + " son " + this.resultado + " " + this.monedaFinal + " con valor de cambio de " + this.rate;
    }
}
