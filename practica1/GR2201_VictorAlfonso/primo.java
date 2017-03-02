/**
* Esta aplicacion imprime los numeros pasados por entrada y nos indica si son primos o no   *
* @author Estudiante EPS alfonso.carvajal@estudiante.uam.es victor.garciacarrerea@estudiante.uam.es
*
*/
public class primo {
/**
* Punto de entrada a la aplicación.
*
* Este método imprime  numero por pantalla con la indicacion  de si es primo de cada numero que se le pasa como entrada
*
* @param args Los argumentos de la línea de comando. Se espera un número o mas como primer parámetro */
public static void main(String[] args) {
if (args.length < 1) {
System.out.println("Se espera un numero como parametro."); return;
}
int k, num = args.length;

for(k = 0; k < num; k++){

	String arg = args[k]; // una variable String que obtiene en el parametro
	int x = Integer.parseInt(arg); // una variable int, que convierte arg a int 
	

	int i = 0, flag = 0;
	double lim = Math.sqrt(x);
	for(i = 2; i <= lim; i++){
		if(x % i == 0 ){
			flag = 1;
			break;
		}
	}
	if(x < 2){
		System.out.println(x + " No Es primo");
	}
	else if(flag == 0) System.out.println(x + " Es primo");
	else System.out.println(x + " No Es primo");
}

return;
}
}

