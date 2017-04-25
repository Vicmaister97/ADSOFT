package clases;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;


public class Tasks {

	public static final Tasks TASKS = new Tasks();	
	private SortedSet<Task> allTasks;
	
	
	/**
	 * Constructor privado para Singleton
	 * Inicializamos el array de todos los Task
	 */
	private Tasks(){
		this.allTasks = new TreeSet<Task>();
	}
	
	public Task newTask(String taskName) throws IllegalArgumentException{
		//Task temp = new Task(taskName);
		Task temp = new Task(taskName, 10, 5);
		if(this.buscarPorNombre(taskName) != null){
			throw new IllegalArgumentException();
		}
		allTasks.add(temp);
		
		return temp;
	}


	public Task buscarPorNombre(String taskName){
		Iterator<Task> it = TASKS.allTasks.iterator();
		while(it.hasNext()){
			Task temp = (Task)it.next();
			if(taskName.equalsIgnoreCase(temp.getName()) == true){
				return temp;
			}
		}
		return null;
	}

	
	
}
