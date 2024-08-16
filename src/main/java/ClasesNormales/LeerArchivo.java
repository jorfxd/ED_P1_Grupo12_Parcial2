package ClasesNormales;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class LeerArchivo implements Leer {
    public static String texto="src/main/resources/saved_files/";
    private String N_archivo;
    public LeerArchivo(String N_archivo){
        this.N_archivo=N_archivo;
    }
    
    @Override
    public ArrayList<String> leer(){
        ArrayList<String> lineas=new ArrayList<>();
        File archivo=null;
        FileReader fr=null;
        BufferedReader br=null;
        
        try{
            archivo= new File(N_archivo);
            fr=new FileReader(archivo,StandardCharsets.UTF_8);
            br=new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return lineas;
    }
   
}