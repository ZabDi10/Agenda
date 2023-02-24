package com.cursoceat.main;

public class Contactos {
	
	private String nombre;
	private String telefono;
	
	
	//Contructores
	//Al heredar contactos necesito el constructor vacio
	public Contactos() {
		
	}
	
	public Contactos(String nombre) {
	
		this.nombre = nombre;
	}

	public Contactos(String nombre, String telefono) {
		
		this.nombre = nombre;
		this.telefono = telefono;
	}
	
	
	//Metodos Setter y Getter
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
	
}
