import java.io.*;
import java.net.URISyntaxException;

public class EjercicioInputStream {

    public EjercicioInputStream(){
    }

     public void copiaArchivo(String sFile, String tFile){

        String archivo = "numeros.txt";
        try{
            InputStream fReader = new FileInputStream(sFile);
            byte[] fData = fReader.readAllBytes();
            PrintStream fWriter = new PrintStream(tFile);
            fWriter.write(fData);
            System.out.println("Creando archivo de destino: " + tFile);
            System.out.println("Datos enviados a archivo, ubicado en raiz de proyecto");
            fReader.close();
            fWriter.close();
        }catch (FileNotFoundException fnfex){
            System.out.println("Capullo, archivo no encontrado");
        }catch (IOException ioex){
            System.out.println("Error en lectura de datos" + ioex.getMessage());
        }
     }
}