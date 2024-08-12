/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesNormales;

public class Jugador {
    private static int aumentarId=0;
    private int id;
    private String nombre;
    private int partidasJugadas;
    private int partidasGanadas;
    
    public Jugador(String nombre){
        this.id = aumentarId++; //Devuelve el valor actual y luego lo incrementa
        this.nombre=nombre;
        partidasJugadas=0;
        partidasGanadas=0;
    }
    
    public void aumentarPartidasJugadas(){
        partidasJugadas++;
    }
    public void aumentarPartidasGanadas(){
        partidasGanadas++;
    }
    
    public int getId(){
        return id;
    }
}
