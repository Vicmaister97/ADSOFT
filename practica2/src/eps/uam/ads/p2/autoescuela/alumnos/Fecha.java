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
	
	public Fecha(int ndia, int nmes, int nannio){
		dia = ndia;
		mes = nmes;
		annio = nannio;
	}

	public boolean isFechaValida(){
		if (dia < 1 || dia > 31)	return false;
		if (mes < 1 || mes > 12)	return false;
		if (annio < 0)	return false;

		return true;
	}

	public String getFecha(){
		
		return dia + "/" + mes + "/" + annio;
	}

}