package eps.uam.ads.p2.autoescuela.alumnos;
/**
* En este fichero se encuentra la implementacion de la clase Alumno empleada en el apartado 1 de la P2   *
* @author Estudiante EPS alfonso.carvajal@estudiante.uam.es victor.garciacarrerea@estudiante.uam.es
*
*/



public class Alumno {

	private int dni;
	private String nombre;
	private String apellidos;
	private String direccion;
	private int telefono;
	private Fecha fechaMatricula;
	private Fecha fechaSupTeorico;
	private Fecha fechaSupPractico;
	
	
/**
*Crea un Alumno con todos sus datos.
*
* @param dni El DNI del alumno sin letra.
* @param nombre El nombre del alumno.
* @param apellidos Los apellidos del alumno.
* @param direccion La direccion del alumno.
* @param telefono El telefono del alumno.
* @param ndia Dia de matricula.
* @param nmes Mes de matricula.
* @param nannio Año de matricula.
*/
	public Alumno(int dni, String nombre, String apellidos, String direccion,
			int telefono, int ndia, int nmes, int nannio) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.fechaMatricula = new Fecha(ndia, nmes, nannio);
	}

/**
* Obtiene la fecha de matricula del alumno.
*
* @return Un objeto de tipo Fecha que representa la fecha de matricula del alumno.
*/
	
	public Fecha getFechaMatricula(){
		return fechaMatricula;
	}
/**
* Modifica la fecha de superacion del teorico con los datos pasados como parametros de entrada.
*
* @param ndia Dia de la superacion del teorico.
* @param nmes Mes de la superacion del teorico.
* @param nannio Año de la superacon del teorico.
*
*/	
	public void setFechaSupTeorico(int ndia, int nmes, int nannio){
		fechaSupTeorico = new Fecha(ndia, nmes, nannio);
	}
/**
* Modifica la fecha de superacion del practico con los datos pasados como parametros de entrada.
*
* @param ndia Dia de la superacion del practico.
* @param nmes Mes de la superacion del practico.
* @param nannio Año de la superacon del practico.
*
*/	
	public void setFechaSupPractico(int ndia, int nmes, int nannio){
		fechaSupPractico = new Fecha(ndia, nmes, nannio);
	}
	
/**
* Obtiene el nombre del alumno.
*
* @return Un String con el nombre y los apellidos del alumno.
*/	
	public String getNombreYApellidos(){
		return nombre + " " + apellidos;
	}
/**
* Obtiene la fecha de superacion del examen teorico del alumno.
*
* @return Un objeto de tipo Fecha que representa la fecha de superacion del examen teorico del alumno.
*/
	public Fecha getFechaSupTeorico(){
		return fechaSupTeorico;
	}
/**
* Obtiene la fecha de superacion del examen practico del alumno.
*
* @return Un objeto de tipo Fecha que representa la fecha de superacion del examen practico del alumno.
*/	
	public Fecha getFechaSupPractico(){
		return fechaSupPractico;
	}
	
	
	
	public String toString() {
		return "<dni: " + dni + ">" + "\n\tNombre y apellidos: " + nombre
				+ " " + apellidos + "\n\tDirección: " + direccion + "\n\tTeléfono: "
				+ telefono + "\n\tFecha de matriculación: " + fechaMatricula.getFecha();
	}

/**
* Comprueba la validez de una fecha dada
*
* @param f Fecha que se desea comprobar
*
* @return Booleano True si es valida o False si no es valida
*/	
	public boolean isFechaValida(Fecha f){
		return f.isFechaValida();
		
	}

}