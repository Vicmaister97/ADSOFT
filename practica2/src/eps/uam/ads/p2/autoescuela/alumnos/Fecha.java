package eps.uam.ads.p2.autoescuela.alumnos;
/**
* En este fichero se encuentra la implementacion de la clase Fecha empleada en el apartado 1 de la P2   *
* @author Estudiante EPS alfonso.carvajal@estudiante.uam.es victor.garciacarrerea@estudiante.uam.es
*
*/

public class Fecha {

	private int dia;
	private int mes;
	private int annio;
/**
*Crea una fecha con dia, mes y año.
*
* @param ndia Dia de la fecha.
* @param nmes Mes de la fecha.
* @param nannio Año de la fecha.
*/
	public Fecha(int ndia, int nmes, int nannio){
		dia = ndia;
		mes = nmes;
		annio = nannio;
	}
/**
* Comprueba la validez de una fecha dada
*
* @return Booleano True si es valida o False si no es valida
*/
	public boolean isFechaValida(){
		if (dia < 1 || dia > 31)	return false;
		if (mes < 1 || mes > 12)	return false;
		if (annio < 0)	return false;

		return true;
	}
/**
* Obtiene la fecha
*
* @return Un String con dia, mes y año de la fecha de la forma dia/mes/año
*/
	public String getFecha(){
		
		return dia + "/" + mes + "/" + annio;
	}

}