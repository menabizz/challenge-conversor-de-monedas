import modelos.ConversorMenu;

import java.util.List;
import java.util.Scanner;

public class AppParaElUsuario {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int numeroUsuario = 0;
        ConversorMenu conversorMenu = new ConversorMenu();

        List<String> historialDeConversiones = conversorMenu.getHistorialDeConversiones();

        while (numeroUsuario != 7){
            conversorMenu.mostrarMenu();

            numeroUsuario = teclado.nextInt();

            switch (numeroUsuario){
                case 1:
                    conversorMenu.calculadoraConversion("USD", "ARS");
                    break;
                case 2:
                    conversorMenu.calculadoraConversion("ARS", "USD");
                    break;
                case 3:
                    conversorMenu.calculadoraConversion("USD", "BRL");
                    break;
                case 4:
                    conversorMenu.calculadoraConversion("BRL", "USD");
                    break;
                case 5:
                    conversorMenu.calculadoraConversion("USD", "COP");
                    break;
                case 6:
                    conversorMenu.calculadoraConversion("COP", "USD");
                    break;
                case 7:
                    System.out.println("Saliendo de la aplicación . . .");
                    break;
                default:
                    System.out.println("Opción no válida. Seleccione un número válido.");

            }

            if (numeroUsuario != 7){
                conversorMenu.continuacionUsuario();
                int continuacion = teclado.nextInt();

                while (continuacion != 1) {
                    if (continuacion == 2){
                        System.out.println("Saliendo de la aplicación . . .");
                        numeroUsuario = 7;
                        break;
                    } else {
                        System.out.println("Número inválido. Por favor ingrese un número válido.");
                        conversorMenu.continuacionUsuario();
                        continuacion = teclado.nextInt();
                    }
                }
            }

        }

        System.out.println("\n***********************************************************************");
        System.out.println("\nRealizaste las siguientes conversiones:\n");

        if (historialDeConversiones.isEmpty()){
            System.out.println("No realizaste ninguna conversión esta vez!");
        } else {
            historialDeConversiones.forEach(System.out::println);
        }


        System.out.println("\n***********************************************************************");

        System.out.println("\n¡Muchas gracias por utilizar nuestros servicios!");
} }
