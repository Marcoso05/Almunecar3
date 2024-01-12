/**
 * Cada juego tiene un nombre único en toda la sala. Los juegos requieren un 
 * determinado número de créditos para poder jugar. Cada juego está equipado 
 * con un lector de tarjetas y una pequeña pantalla informativa. Al leer una 
 * tarjeta, se reduce su saldo de créditos según el coste del juego y genera 
 * un número no negativo aleatorio de tickets. Se imprime el número de tarjeta, 
 * el número de tickets ganados al jugar, junto con el nuevo total de tickets. 
 * Se imprime un mensaje si una tarjeta no tiene suficientes créditos para jugar.
 */
package Objetos;
import java.util.Random;
import Juegos.*;
/**
 *
 * @author Yasín Pérez
 */
public class Juego {
    private String nombre;
    private int creditosNecesarios;
    private Juegos.AdivinaOrden hola; 
    
     /**
     * 
     * @param nombre: Nombre del juego.
     * @param creditosNecesarios: Creditos necesarios para jugar.
     */
    public Juego(String nombre, int creditosNecesarios){
        setNombre(nombre);
        setCreditosNecesarios(creditosNecesarios);
    }
    
    /**
     * Getter del nombre del juego.
     * @return Devuelve el nombre del juego.
     */
    public String getNombre(){
        return this.nombre;
    }
    
    /**
     * Getter de los creditos necesarios
     * @return Devuelve el numero de creditos necesarios
     */
    public int getCreditosNecesarios(){
        return this.creditosNecesarios;
    }
    
    /**
     * Setter del nombre del juego.
     * @param nombre: nombre del juego
     */
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    
    /**
     * Setter de los creditos necesarios.
     * @param creditosNecesarios: Creditos necesarios para jugar.
     */
    public void setCreditosNecesarios(int creditosNecesarios){
        this.creditosNecesarios=creditosNecesarios;
    }
    
     /**
     * Muestra la informacion de la tarjeta
     * @param tarjeta: El numero de la tarjeta.
     */
    public void lectorTarjeta(Tarjeta tarjeta){
        System.out.println(tarjeta.toString());
    }
    /**
     * Clase principal la cual van a utilizar las hijas para jugar
     * 
     * Autor Marcos Bermejo Salamanca
     * @param tarjeta con la que se va a jugar
     * @return en número de tickets ganados en el juego
     */
    public int jugar(Tarjeta tarjeta){
        Random azar = new Random();
        int tickets = azar.nextInt(95)+5; // entre 0 y 99
        if(this.creditosNecesarios>tarjeta.getCreditos()){
            System.out.println("\n\t\tNo tiene creditos suficientes");
        }
        else{
            
            tarjeta.setCreditos(tarjeta.getCreditos()-this.creditosNecesarios);
            tarjeta.setTickets(tarjeta.getTickets()+tickets);
        }
        return tickets;
    }
    /**
     * Comprueba si dispone de los creditos necesarios para jugar
     * 
     * Autor Marcos Bermejo Salamanca
     * @param tar Tarjeta que se va acomprobar si dispone de los creditos necesarios
     * @return Boolean de si dispone de los creditos necesarios
     */
    public boolean comprobarCreditosNecesarios(Tarjeta tar) {
        boolean posible = false;
        if (this.getCreditosNecesarios() <= tar.getCreditos()) {
            posible = true;
        } else {
            posible = false;
        }
        return posible;
    }
    
    /**
     * Cobra los tickets a la hora de jugar
     * 
     * Autor Marcos Bermejo Salamanca
     * @param tarjeta con la que se va a jugar
     * @return Un boolean si se ha podido realizar la operacion correctamente
     */
    public boolean cobrar (Tarjeta tarjeta){
        boolean puede = true;
         if(this.creditosNecesarios>tarjeta.getCreditos()){
            System.out.println("\n\t\tNo tiene creditos suficientes");
            puede = false;
        }
        else{
            tarjeta.setCreditos(tarjeta.getCreditos()-this.creditosNecesarios);
        }
        return puede;
    }
    
    /**
     * Suma los tickets ganados
     * 
     * Autor Marcos Bermejo Salamanca
     * @param tarjeta con la que se va a jugar
     * @param tickets que se le van a sumar
     */
    public void sumarTickets (Tarjeta tarjeta, int tickets){
        tarjeta.setTickets(tickets+tarjeta.getTickets());
    }
    
    
    /**
     * toString del juego.
     * @return String con el nombre del juego con los creditos que se necesitan para jugar.
     */
    @Override
    public String toString(){
        return ("El nombre del juego es: " + getNombre()+"\nSe necesitan "+getCreditosNecesarios()+" creditos para jugar");
    }
}
