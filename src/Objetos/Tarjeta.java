/**
 * El chip de las tarjetas de juego tiene suficiente espacio de almacenamiento 
 * pero ninguna potencia informática. Las tarjetas almacenan información sobre 
 * su saldo de créditos actual, el saldo de tickets y el número de tarjeta. 
 * Ninguno de los saldos debe ser negativo. Las tarjetas no pueden realizar 
 * cálculos, incluida una simple suma, ni determinar que sus saldos podrían ser negativos.
 * Todas las tarjetas se crean con un número de identificación entero único. 
 * Aunque cada tarjeta no puede hacer una simple suma, es posible realizar 
 * cálculos con las propiedades que pertenecen a todas las tarjetas..
 */
package Objetos;

import Diseño.Colores;


/**
 *
 * @author yasin
 */
public class Tarjeta {
    private int creditos;
    private int tickets;
    private int numTarjeta;
    private static int contador=1;
    
    /**
     * 
     * @param creditos: El numero de creditos a introducir en la tarjeta.
     */
    
    public Tarjeta(int creditos){
        this.creditos = creditos;
        this.tickets = 0;
        this.numTarjeta = contador++;
    }
    
    public int getCreditos(){
        return this.creditos;
    }
    
    /**
     * Getter de los creditos
     * @return: Devuelve el numero de creditos. 
     */    
    public int getTickets(){
        return this.tickets;
    }
    
    /**
     * Getter de los tickets
     * @return: Devuelve el numero de tickets.
     */
    public int getNumTarjeta(){
        return this.numTarjeta;
    }
    
    /**
     * Getter del numero de la tarjeta.
     * @return: Devuelve el numero identificativo de la tarjeta.
     */
    public void setTickets(int tickets){
       
        this.tickets = tickets;
       
    }
    
    /**
     * Setter de los tickets
     * @param tickets: Establece el numero de tickets.
     */
    public void setCreditos(int creditos){
        this.creditos = creditos;
        
    }
    
    
    @Override
    /**
     * toString de la tarjeta
     * @return: Devuelve toda la informacion de la tarjeta. 
     */
    public String toString(){
        return ("Numero de tarjeta: "+getNumTarjeta()+"\nNumero de creditos: "+getCreditos()+"\nNumero de tickets: "+getTickets());
    }
}
