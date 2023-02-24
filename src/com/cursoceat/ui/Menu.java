package com.cursoceat.ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.cursoceat.main.Contactos;

public class Menu extends Contactos {

	static ArrayList<Contactos> miAgenda = new ArrayList<Contactos>();

	static public void miMenu() {

		int opcion;

		do {
			System.out.println("\t******************");
			System.out.println("\tAgenda Telefónica");
			System.out.println("\t******************");
			System.out.println("\t\t1 Alta");
			System.out.println("\t\t2 Buscar");
			System.out.println("\t\t3 Mostrar");
			System.out.println("\t\t4 Salir");
			System.out.println("\t******************");
			System.out.print("\n\tSu opcion es ->");

			opcion = new Scanner(System.in).nextInt();
			switch (opcion) {
			case 1 -> {
				alta();
			}
			case 2 -> {
				buscar();
			}
			case 3 -> {
				mostrar();
			}

			}

		} while (opcion != 4);

	}

	// ***************************************************************
	static void alta() {
		String telefono;
		String nombre;
		do {
			System.out.println("\tIndique el nombre del Contacto->");
			nombre = new Scanner(System.in).nextLine();

		} while (nombre.isEmpty());

		nombre = pasarMayu(nombre);

		do {
			System.out.println("\tIndique el telefono del Contacto->");
			telefono = new Scanner(System.in).nextLine();

		} while (validarTelefono(telefono));

		// Aqui tenemos que crear un objeto y guardar los datos capturados
		Contactos unCtto = new Contactos(nombre, telefono);

		miAgenda.add(unCtto);

	}

	// ***************************************************************
	static void buscar() {
		String nombre;
		boolean encontrado = false;

		do {
			System.out.println("\tIndique el nombre a buscar->");
			nombre = new Scanner(System.in).nextLine();

		} while (nombre.isEmpty());
		
		for (Contactos c : miAgenda) {
			String nombreAgendaString = c.getNombre();
			if (nombreAgendaString.startsWith(nombre)) {
				System.out.println("\t" + c.getNombre() + "\t(" + c.getTelefono() + ")");
				encontrado=true;
				
			}
			if (!encontrado) {
				System.out.println("El contacto no existe");
			}
		}
	}

	// ***************************************************************
	static void mostrar() {
		for (Contactos c : miAgenda) {
			System.out.println("\t" + c.getNombre() + "\t(" + c.getTelefono() + ")");
		}
	}

	// ***************************************************************
	static String pasarMayu(String cadena) {
		String[] arrayCadenaString = cadena.split(" ");
		String temp = "";
		for (int i = 0; i < arrayCadenaString.length; i++) {
			arrayCadenaString[i] = arrayCadenaString[i].substring(0, 1).toUpperCase()
					+ arrayCadenaString[i].substring(1).toLowerCase();
			temp = temp + arrayCadenaString[i] + " ";
		} // convertimos el string en un array de string y modificamos cada columna para
			// dejarla en mayus. Luego volvemos a hacer el string.
		return temp;
	}

	// ***************************************************************
	static boolean validarTelefono(String telefono) {
		boolean correcto = false;
		if ((!telefono.startsWith("9") && !telefono.startsWith("6") && !telefono.startsWith("7"))
				|| telefono.length() != 9) {
			correcto = true;
		} // Cualquier numero que no sea 9 6 o 7 y no tenga 9 digitos entra al if y da
			// true. Luego el while se repite
		return correcto;
	}
}
