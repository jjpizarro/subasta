/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unimagdalena.subastas.logica;

/**
 *
 * @author Estudiante
 */
public class SubastaLimitada extends Subasta {
    private final int numeroMaxPujas;
    private int pujasRealizadas;

    public SubastaLimitada(String nombreProducto, Usuario propietario, int numeroMaxPujas) {
        super(nombreProducto, propietario);
        this.numeroMaxPujas = numeroMaxPujas;
        this.pujasRealizadas = 0;
    }
    
    public int consultarPujasPendientes(){
        return this.numeroMaxPujas - pujasRealizadas;
    }
    
    public boolean pujar(Usuario usuario, double cantidad) {
        boolean pujaAceptada = false;
        
        pujaAceptada = super.pujar(usuario, cantidad);
        if(pujaAceptada){
            ++pujasRealizadas;
            if(pujasRealizadas >= this.numeroMaxPujas){
                ejecutar();
            }
            
        }
        return pujaAceptada;
        
    } 
}
