import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int intLSeleccion = menuPrincipal();

        switch (intLSeleccion){
            case 1:
                EjerciciosBasicos leBasico = new EjerciciosBasicos();
                leBasico.recibeCadena();
                break;

            case 2:
                EjercicioInputStream leInput = new EjercicioInputStream();
                leInput.copiaArchivo("numeros.txt","copiaNumeros.txt");
                break;

            case 3:
                EjercicioPropuesto lePropuesto = new EjercicioPropuesto();
                lePropuesto.setVisible(true);
                break;

            default:
                System.out.println("Seleccion nó valida");
                break;
        }

    }

    public static int menuPrincipal(){
        Scanner selScanner = new Scanner(System.in);
        int intSeleccion = 0;
        do{
            System.out.println("Seleccione opcion de ejercciios");
            System.out.println("1. Ejercicios Basicos");
            System.out.println("2. Ejercicio InputStream - PrintStream");
            System.out.println("3. Programa Avanzado");
            System.out.print("Opcion: ");
            try{
                intSeleccion = selScanner.nextInt();
            }catch (NumberFormatException nfex){
                System.out.println("Ha ingresado un valor invalido");
            }
        }while (intSeleccion <= 0);

        return intSeleccion;
    }

}
