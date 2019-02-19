package edu.unimagdalena.subastas.logica;

import java.util.ArrayList;

public class Usuario {
	private final String nombre;
	private double credito = 0.0;
	private ArrayList<Subasta> subastas = null;
	public Usuario(String nombre, double credito) {
		this.nombre = nombre;
		this.credito = credito;
		subastas = new ArrayList<Subasta>();
	}
	public void incrementarCredito(double cantidad){
		this.credito += cantidad;
	}
	public void decrementarCredito(double cantidad){
		this.credito -= cantidad;
	}
	public String getNombre() {
		return nombre;
	}
	public double getCredito() {
		return credito;
	}
	
	public void agregarSubasta (Subasta subasta){
		this.subastas.add(subasta);
	}
	
}
