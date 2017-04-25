package es.uam.eps.ads.p3.biblioteca;

import java.util.ArrayList;

/**
* En este fichero se encuentra la implementacion de la clase Usuario
* @author Estudiante EPS alfonso.carvajal@estudiante.uam.es victor.garciacarrerea@estudiante.uam.es
*
*/



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
	
	/**
	* decrementa el numero de ejemplares que tiene un usuario prestado
	*
	* @param p Prestamo que se quiere eliminar
	*
	*/
	public void eliminarPrestamo(Prestamo p){
		this.setNumPrestados(this.getNumPrestados() - 1);
		p.cambiarStatus();
	} 
	
	public void sancionarPorRetraso(int dias){
		}
	
	public void eliminarSancion(){
	}

	/**
	* Devuelve todos los prestamos activos de un usuario dado
	*
	* @return ArrayList<Ejemplar> una lista de ejemplares
	*/
	public ArrayList<Ejemplar> getPrestamos(){
		return this.prestados; //(ArrayList<Ejemplar>) Collections.unmodifiableList(prestados);
		
	}
	
	/**
	* Añade un ejemplar prestado a la lista del usuario
	*
	* @param e Ejemplar que se quiere añadir
	*
	*/
	public void addPrestamoToList(Ejemplar e){
		this.prestados.add(e);
	}
	
	/**
	* Elimina un ejemplar prestado de la lista del usuario
	*
	* @param e Ejemplar que se desea eliminar
	*
	*/
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
