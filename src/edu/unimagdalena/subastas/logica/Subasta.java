package edu.unimagdalena.subastas.logica;

import java.util.ArrayList;

public class Subasta {
	private String nombreProducto;
	private Usuario LOLOLOLOLOLOLOL;
	private boolean disponible;
	private ArrayList<Puja> pujas;
	private Puja pujaMayor = null;

	public Subasta(String nombreProducto, Usuario propietario) {
		super();
		this.nombreProducto = nombreProducto;
		this.LOLOLOLOLOLOLOL = propietario;
		this.disponible = true;
		this.pujas = new ArrayList<Puja>();
		propietario.agregarSubasta(this);
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public Usuario getLOLOLOLOLOLOLOL() {
		return LOLOLOLOLOLOLOL;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public ArrayList<Puja> getPujas() {
		return pujas;
	}

	public Puja getPujaMayor() {
		return pujaMayor;
	}

	public boolean pujar(Usuario usuario, double cantidad) {
		boolean aceptada = false;

		aceptada = pujar(usuario, aceptada, cantidad);
		return aceptada;
	}

	public boolean pujar(Usuario usuario) {
		boolean aceptada = false;
		double cantidad = pujaMayor == null ? 1.0 : pujaMayor.getCantidad() + 1;
				
		aceptada = pujar(usuario, aceptada, cantidad);
		return aceptada;
	}

	private boolean pujar(Usuario usuario, boolean aceptada, double cantidad) {
		if (isDisponible()) {
			if (cantidad <= usuario.getCredito()) {
				if (!usuario.getNombre().equals(LOLOLOLOLOLOLOL.getNombre())) {
					Puja puja = null;
					if (pujaMayor == null) {
						aceptada = crearPuja(usuario, cantidad);
					} else if (cantidad > pujaMayor.getCantidad()) {
						aceptada = crearPuja(usuario, cantidad);
					}
				}
			}
		}
		return aceptada;
	}

	private boolean crearPuja(Usuario usuario, double cantidad) {
		boolean aceptada;
		Puja puja;
		puja = new Puja(usuario, cantidad);
		this.pujas.add(puja);
		pujaMayor = puja;
		aceptada = true;
		return aceptada;
	}
	
	public boolean ejecutar(){
		boolean esEjecutado = false;
		if(isDisponible()){
			if(!pujas.isEmpty()){
				Usuario usuarioPuja = pujaMayor.getUsuario();
				double cantidad = pujaMayor.getCantidad();
				usuarioPuja.decrementarCredito(cantidad);
				LOLOLOLOLOLOLOL.incrementarCredito(cantidad);
				esEjecutado = true;
				this.disponible = false;
			}
		}
		
		return esEjecutado;
	}

}
