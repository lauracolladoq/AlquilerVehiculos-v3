package org.iesalandalus.programacion.alquilervehiculos;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;

import org.iesalandalus.programacion.alquilervehiculos.modelo.FactoriaFuenteDatos;
import org.iesalandalus.programacion.alquilervehiculos.modelo.Modelo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.ModeloCascada;
import org.iesalandalus.programacion.alquilervehiculos.vista.FactoriaVista;
import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;

public class MainApp {

	public static void main(String[] args) {
		Modelo modelo = new ModeloCascada(FactoriaFuenteDatos.FICHEROS);
		// Modelo modelo = new ModeloCascada(FactoriaFuenteDatos.MEMORIA.crear());
		Vista vista = procesarArgumentosVista(args);
		Controlador controlador = new Controlador(modelo, vista);
		controlador.comenzar();
	}

	private static Vista procesarArgumentosVista(String[] args) {
		Vista vista = FactoriaVista.GRAFICA.crear();
		for (String argumento : args) {
			if (argumento.equalsIgnoreCase("-vtexto")) {
				vista = FactoriaVista.TEXTO.crear();

			} else if (argumento.equalsIgnoreCase("-vgrafica")) {
				vista = FactoriaVista.GRAFICA.crear();
			}
		}
		return vista;
	}

}
