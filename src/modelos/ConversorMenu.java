package modelos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConversorMenu {

    private final List<String> historialDeConversiones = new ArrayList<>();


    Scanner teclado = new Scanner (System.in);

    public void mostrarMenu() {
        System.out.println("""
                
                ***********************************************************************
                
                ¡Bienvenido al conversor de moneda!
                
                1) Dólar -> Peso argentino
                2) Peso argentino -> Dólar
                3) Dólar -> Real brasileño
                4) Real brasileño -> Dólar
                5) Dólar -> Peso colombiano
                6) Peso colombiano -> Dólar
                7) Salir
                
                ***********************************************************************
                
                Elija una de las opciones:
                """);
    }


    public void calculadoraConversion(String moneda1, String moneda2){
        ConsultaAPI consulta = new ConsultaAPI();
        ValorConversion conversion = consulta.comparaMonedas(moneda1, moneda2);
        var tasa = conversion.conversion_rate();

        BigDecimal bigDecimal1 = BigDecimal.valueOf(tasa);
        System.out.println("La tasa de conversión actualmente es de " + bigDecimal1.toPlainString() + " " + moneda2 + " por cada " + moneda1);

        System.out.println("Ingrese el valor que desea convertir de " + moneda1 + " a " + moneda2 + ":");
        double numeroUsuario = teclado.nextDouble();

        var resultadoConversion = numeroUsuario*tasa;
        String resultadoDosDecimales = String.format("%.2f", resultadoConversion);

        System.out.println("***********************************************************************" +
                           "\nEl valor de " + numeroUsuario + "[" + moneda1
                           + "] corresponde al valor final de => " + resultadoDosDecimales + "[" + moneda2 + "] " +
                           "\n***********************************************************************");

        historialDeConversiones.add(numeroUsuario + " " + moneda1 + " => " + resultadoDosDecimales + " " + moneda2);
    }

    public void continuacionUsuario(){

        System.out.println("""
                
                ¿Desea continuar?
                1) Si
                2) No, quiero salir de la aplicación.
                """);

    }


    public List<String> getHistorialDeConversiones() {
        return historialDeConversiones;
    }

}




