package edu.unimagdalena.subastas.app;

import edu.unimagdalena.subastas.logica.Puja;
import edu.unimagdalena.subastas.logica.Subasta;
import edu.unimagdalena.subastas.logica.Usuario;

public class Aplicacion {

	public static void main(String[] args) {
//- Crea tres usuarios con nombre "Juan", "Pedro" y "Enrique" con un crédito inicial de 100, 150 y 300 euros, respectivamente.
		Usuario juan = new Usuario("Juan", 100);
		Usuario pedro = new Usuario("Pedro", 150);
		Usuario enrique = new Usuario("Enrique", 300);
//Crea una subasta del producto "Teléfono Móvil" cuyo propietario sea el usuario Juan.
		Subasta subasta = new Subasta("Teléfono Móvil", juan);
//El usuario Pedro puja por esa subasta 100 euros.		
		subasta.pujar(pedro,100);
//Muestra en la consola la puja mayor de la subasta (nombre del usuario y cantidad).		
		imprimirPujaMayor(subasta);
//- El usuario Enrique puja por esa subasta 50 euros.
		subasta.pujar(enrique,50);
//- Muestra en la consola la puja mayor. Comprueba que esta segunda puja no ha sido acepta, ya que es menor que la primera.		
		imprimirPujaMayor(subasta);
//- Ejecuta la subasta.
		subasta.ejecutar();
	}

	private static void imprimirPujaMayor(Subasta subasta) {
		Puja pujaMayor  = subasta.getPujaMayor();
		Usuario usuarioPujaMayor = pujaMayor.getUsuario();
		System.out.println("Usuario: "+usuarioPujaMayor.getNombre());
		System.out.println("Cantidad: "+pujaMayor.getCantidad());
	}

}
