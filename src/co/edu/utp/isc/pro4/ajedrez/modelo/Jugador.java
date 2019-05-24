/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.pro4.ajedrez.modelo;

import co.edu.utp.isc.pro4.ajedrez.controlador.Ajedrez;
import co.edu.utp.isc.pro4.ajedrez.exceptions.MovimientoNoValidoException;

/**
 *
 * @author utp
 */
public class Jugador {

    private Ajedrez ajedrez;
    private final String nombre;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public void jugar(Casilla casillaI, Casilla casillaF) throws MovimientoNoValidoException {
        if(casillaI.isOcupada()){
            Ficha f;
            f = casillaI.getFicha();
            if((casillaI.getFicha().getColor() == Color.BLANCO) && (ajedrez.getTurno() == 0) 
                || (casillaI.getFicha().getColor() == Color.NEGRO) && (ajedrez.getTurno() == 1))
                f.mover(ajedrez.getTablero(), casillaI, casillaF);
            else{
                ajedrez.cambioTurno();//Para volver al turno en que estaba
                System.out.println("No es su turno");
            }
        }
        else{
            ajedrez.cambioTurno();
            System.out.println("No ha seleccionado una ficha");
        }
    }

    public void setAjedrez(Ajedrez ajedrez) {
        this.ajedrez = ajedrez;
    }

    public String getNombre() {
        return this.nombre;
    }

    
    private void rendirse() {
        // No me gusta pero los estudiantes lo pidieron
        ajedrez.rendirse();
    }
    
}
