package tests;

import clases.Task;
import clases.Tasks;

public class Apartado2 {
	public static void main(String[] args){
		//Task task1 = new Task("Tarea 1");
		Tasks total = Tasks.TASKS;
		
		total.newTask("Tarea1");
		total.newTask("Tarea2");
		total.newTask("Tarea3");
		total.newTask("Tarea4");
		total.newTask("Tarea5");
		total.newTask("Tarea6");
		
		System.out.println("Deberia ser: Todas a 10");
		System.out.println("Tarea1: " + total.buscarPorNombre("Tarea1") + "\nTarea2: " + total.buscarPorNombre("TaReA2") + "\nTarea3: " + total.buscarPorNombre("TaReA3") + "\nTarea4: " + total.buscarPorNombre("TaReA4") + "\nTarea5: " + total.buscarPorNombre("tarea5") + "\nTarea6: " + total.buscarPorNombre("TaReA6"));
		
		Task t1 = total.buscarPorNombre("Tarea1");
		Task t2 = total.buscarPorNombre("Tarea2");
		Task t3 = total.buscarPorNombre("Tarea3");
		Task t4 = total.buscarPorNombre("Tarea4");
		Task t5 = total.buscarPorNombre("Tarea5");
		Task t6 = total.buscarPorNombre("Tarea6");
		
		t2.addTask(t3);
		t2.addTask(t4);
		t1.addTask(t2);
		
		System.out.println("Deberia ser: TE1 = 40, TD1 = 20\nTE2 = 30, TD2 = 15\nResto Normal");
		System.out.println("Tarea1: " + t1 + "\nTarea2: " + t2 + "\nTarea3: " + t3 + "\nTarea4: " + t4 + "\nTarea5: " + t5 + "\nTarea6: " + t6);
		
		t1.addTask(t5);
		t5.addTask(t6);
		System.out.println("Deberia ser: TE1 = 60, TD1 = 30\nTE2 = 30, TD2 = 15\nTE3 = 20, TD3 = 10");
		System.out.println("Tarea1: " + t1 + "\nTarea2: " + t2 + "\nTarea3: " + t3 + "\nTarea4: " + t4 + "\nTarea5: " + t5 + "\nTarea6: " + t6);
		
		t6.setParent(t2);
		System.out.println("Deberia ser: TE1 = 60, TD1 = 30\nTE2 = 30, TD2 = 15\nTE3 = 20, TD3 = 10");
		System.out.println("Tarea1: " + t1 + "\nTarea2: " + t2 + "\nTarea3: " + t3 + "\nTarea4: " + t4 + "\nTarea5: " + t5 + "\nTarea6: " + t6);
		
		System.out.println("t1 contains t3 should be true (indirect): " + t1.containsTask(t3));
		System.out.println("t5 contains t6 should be false: " + t5.containsTask(t6));
		System.out.println("t1 contains t2 should be true (direct): " + t1.containsTask(t2));
		
		System.out.println("\n\nEsto va a lanzar una Excepcion y se acaba el programa");
		total.newTask("Tarea1");
	}
}
