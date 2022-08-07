import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.*;

public class EjerciciosBasicos {

    public EjerciciosBasicos(){}

    public void recibeCadena(){
        System.out.println("Ingrese cadena a invertir");
        Scanner leeCadena = new Scanner(System.in);
        String cadena = leeCadena.nextLine();
        invierteCadena(cadena);
        continuar();
        imprimeValores();
        continuar();
        imprimeArreglo();
        continuar();
        imprimeVector();
        continuar();
        tamanioVector();
        continuar();
        recorreLists();
        continuar();
        arrayInt();
        continuar();
        convocaExcepcion();
        continuar();

    }

    private void continuar(){
        System.out.println();
        System.out.println("*****************************");
        System.out.println("Presione Enter para continuar");
        System.out.println("*****************************");
        System.out.println();
        try{
            System.in.read();
        }catch (Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private void invierteCadena(String lcadena){

        if (lcadena.length() == 0){
            System.out.println("No ha ingresado una cadena de caracteres");
        }else{
            System.out.println("Su cadena de caracteres invertida: ");
            for (int cCounter = lcadena.length() - 1; cCounter >= 0; cCounter--){
                System.out.print(lcadena.charAt(cCounter));
            }
        }
    }

    private void imprimeValores(){
        String[] strArray = {"A","b","L","J","k","r","Z"};
        System.out.println("Ejericio 1, imprimir valores");
        for(int sCounter = 0; sCounter < strArray.length; sCounter++){
            System.out.println(strArray[sCounter]);
        }

    }

    private void imprimeArreglo(){
        System.out.println("Ejercicio 2: Array Bidimensional");
        int[][] arregloNumeros = {{15,45},{34,78},{75,191},{203,12},{1038,171},{16,12789}};
        for (int rCounter = 0; rCounter < arregloNumeros.length; rCounter++){
            for (int cCounter = 0; cCounter < arregloNumeros[rCounter].length; cCounter++){
                System.out.print("Posicion: [" + rCounter + ":" + cCounter + "], Valor: " + arregloNumeros[rCounter][cCounter] + "\t");
            }
            System.out.println();
        }
    }

    private void imprimeVector(){

        System.out.println("Ejercicio 3: Imprimir Vector eliminando valores");
        Vector<String> lvector = new Vector<>();
        lvector.add("Alpha");
        lvector.add("Beta");
        lvector.add("Gama");
        lvector.add("Delta");
        lvector.add("Epsilon");
        System.out.println("Vector  original: \t" + lvector);
        lvector.remove(1);
        lvector.remove(2);
        System.out.println("Nuevo Vector: \t" + lvector);
    }

    private void tamanioVector(){
        System.out.println("Ejercicio 4: Inconvenientes Vector tamaño inicial 1000 elementos");
        System.out.println("El inconveniente principal de declarar un Vector con un tamaña inicial de 1000 elementos es el uso en memoria de este Vector");
        System.out.println("Este comportamiento del tipo de datos Vector, dependiendo del equipo en el que se corra el programa ");
        System.out.println("Es que puede se puede llegar a desbordar el uso de recursos del propio equipo");
    }

    private void recorreLists(){
        System.out.println("Ejercicio 5: Recorrer ArrayList y LinkedList");
        List<String> strArray = new ArrayList<>();
        List<String> strLinked = new LinkedList<>();

        strArray.add("Primera");
        strArray.add("Segunda");
        strArray.add("Tercera");
        strArray.add("Cuarta");

        strLinked.addAll(strArray);

        for (int lCounter = 0; lCounter < strArray.size(); lCounter++){
            System.out.println("Elemento: " + lCounter +", en Array: " + strArray.get(lCounter) + ", en Linked: " + strLinked.get(lCounter));
        }
    }

    private void arrayInt(){
        System.out.println("Ejercicio 6: Recorrer ArrayList Int");
        List<Integer> intArray = new ArrayList<>();

        for (int aCounter = 1; aCounter <= 10; aCounter++){
            intArray.add(aCounter);
        }

        for (int aCounter = 0; aCounter < intArray.size(); aCounter++){
            if ((intArray.get(aCounter) % 2) == 0){
                intArray.removeIf(value -> (value % 2) == 0 );
                continue;
            }else{
                System.out.println(intArray.get(aCounter));
            }
        }
        System.out.println("Para eliminar elementos de un ArrayList dada una condicion se realiza por Predicado" +
                "Es decir por programacion funcional o lambda" +
                "Metodo: ArrayList.removeIf(Predicate p");
    }

    private int lanzaExcepcion(int intDividendo, int intDivisor) throws ArithmeticException{
        if(intDivisor == 0){
            throw new ArithmeticException("Diviion entera por 0 no se puede hacer");
        }else{
            return (intDividendo / intDivisor);
        }
    }

    private void convocaExcepcion(){
        System.out.println("Ejercicio 7: Lanza Excepcion");
        int intLDividendo = 10;
        int intLDivisor = 0;

        try{
            lanzaExcepcion(intLDividendo, intLDivisor);
        }catch (ArithmeticException aex){
            aex.printStackTrace();
        }finally {
            System.out.println("Demo Codigo");
        }
    }

}
