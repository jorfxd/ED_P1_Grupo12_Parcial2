package ClasesNormales;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Jugador {
    private static int aumentarId = 0;
    private int id;
    private String nombre;
    private String apodo;
    private int partidasJugadas;
    private int partidasGanadas;
    
    public Jugador(String nombre, String apodo){
        this.id = aumentarId++; //Devuelve el valor actual y luego lo incrementa
        this.nombre = nombre;
        this.apodo = apodo;
        partidasJugadas = 0;
        partidasGanadas = 0;
    }

    public static int getAumentarId() {
        return aumentarId;
    }

    public static void setAumentarId(int aumentarId) {
        Jugador.aumentarId = aumentarId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    public void setPartidasJugadas(int partidasJugadas) {
        this.partidasJugadas = partidasJugadas;
    }

    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }
    
    public void aumentarPartidasJugadas(){
        partidasJugadas++;
    }
    public void aumentarPartidasGanadas(){
        partidasGanadas++;
    }
    
    public static ArrayList<Jugador> objetoJugadores(String nombrearchivo) throws IOException{
        
        ArrayList<String> lineas = Readable.leerArchivo(nombrearchivo);
        ArrayList<Jugador> jugadores = new ArrayList<>();

        for (String line : lineas){
            String[] elemento = line.trim().split(",");
            String n = elemento[0];
            String a = elemento[1];
            jugadores.add(new Jugador(n, a));
        }
        
        return jugadores;
    }
    
    public static boolean crearJugador(String nombre, String apodo, ArrayList<Jugador> lista, String nombreArchivo) {
        for (Jugador u : lista) {
            if (u.getApodo().equals(apodo)) {
                return false;
            }
        }
        Jugador persona = new Jugador(nombre, apodo);
        lista.add(persona);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            writer.write(nombre + "," + apodo);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
