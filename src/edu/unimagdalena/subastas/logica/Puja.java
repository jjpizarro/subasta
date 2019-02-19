package edu.unimagdalena.subastas.logica;

public class Puja {
	private Usuario usuario;
	private double cantidad;
	public Puja(Usuario usuario, double cantidad) {
		this.usuario = usuario;
		this.cantidad = cantidad;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public double getCantidad() {
		return cantidad;
	}
	
	
}
