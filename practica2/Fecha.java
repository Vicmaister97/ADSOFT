/**
* En este fichero se encuentra la implementacion de la clase Fecha empleada en el apartado 1 de la P2   *
* @author Estudiante EPS alfonso.carvajal@estudiante.uam.es victor.garciacarrerea@estudiante.uam.es
*
*/

package eps.uam.ads.p2.autoescuela.Fecha;

public class Fecha {

	int private dia;
	int private mes;
	int private annio;

	public boolean isFechaValida(){
		if (dia < 1 || dia > 31)	return FALSE;
		if (mes < 1 || mes > 12)	return FALSE;
		if (annio < 0)	return FALSE;

		return TRUE;
	}

	public String getFecha(){
		String fecha = Integer.toString(dia) + Integer.toString(mes) + Integer.toString(annio);

		return fecha;
	}


	public static void main(String[] args) {
	if (args.length < 1) {
	System.out.println("Se espera un numero como parametro."); return;
	}
	String arg = args[0]; // una variable String que obtiene el primer parametro
	int x = Integer.parseInt(arg); // una variable int, que convierte arg a int 
	if (x < 0) {
	System.out.println("Se espera un numero positivo."); return;
	}
	int i = 0, j = 0;
	int[][] numeros = new int[x + 1][x + 1];
	for(i = 0; i <= x; i++){
		for(j = 0; j <= i; j++){
			if(j == 0 || j == i) numeros[i][j] = 1;
			
			else numeros[i][j] = numeros[i - 1][j] + numeros[i - 1][j - 1];
		}
		for(j = 0; j <= i; j++) System.out.print(numeros[i][j] + " ");

		System.out.print("\n");
		
		}
	}
}
