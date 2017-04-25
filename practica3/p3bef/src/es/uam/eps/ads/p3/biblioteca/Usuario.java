package es.uam.eps.ads.p3.biblioteca;

import java.util.ArrayList;
//import java.util.Collections;


public class Usuario {
	private String nombre;
	private int numPrestados;
	private int limPrestados;
	private ArrayList<Ejemplar> prestados;
	
	public Usuario(String nombre) {
		this.nombre = nombre; 
		this.numPrestados = 0;
		this.prestados = new ArrayList<Ejemplar>();
	}

	public String getNombre() {
		return nombre;
	}

	public int getNumPrestados() {
		return numPrestados;
	}
	
	public void addNumPrestados(){
		this.numPrestados++;
	}

	public void setNumPrestados(int numPrestados) {
		this.numPrestados = numPrestados;
	}

	public int getLimPrestados() {
		return limPrestados;
	}

	public void setLimPrestados(int limPrestados) {
		this.limPrestados = limPrestados;
	}
	
	
	
	public void anyadirPrestamo(Prestamo p){
	}
	
	public void eliminarPrestamo(Prestamo p){
		}
	
	public void sancionarPorRetraso(int dias){
		}
	
	public void eliminarSancion(){
	}

	public ArrayList<Ejemplar> getPrestamos(){
		return this.prestados; //(ArrayList<Ejemplar>) Collections.unmodifiableList(prestados);
		
	}
	public void addPrestamoToList(Ejemplar e){
		this.prestados.add(e);
	}
	
	public void eliminarPrestamoDeList(Ejemplar elim){
		int indice = 0;
		for(Ejemplar e: this.prestados){
			if(e.equals(elim)){
				break;
			}
			indice++;
		}
		this.prestados.remove(indice);
	}
	
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", numPrestados=" + numPrestados + ", limPrestados=" + limPrestados
				+ "]";
	}
}
