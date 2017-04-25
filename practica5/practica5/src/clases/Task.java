package clases;

import java.util.Set;
import java.util.TreeSet;

import interfaces.AdjustableTime;

public class Task implements Comparable<Task>{
	private final String nombre;
	private AdjustableTime estimado;
	private AdjustableTime dedicado;
	private Task parent;
	private Set<Task> subTareas;
	
	/**
	 * Constructor
	 * @param nom, nombre de la tarea
	 * @param est, tiempo estimado de la tarea
	 * @param calc, tiempo calculado de la tarea
	 */
	public Task(String nom, int est, int ded){
		this(nom);
		this.estimado = new ObservablePropertyInteger(est);
		this.dedicado = new ObservablePropertyInteger(ded);
		this.subTareas = new TreeSet<Task>();
	}
	
	/**
	 * Constructor
	 * @param nom, nombre de la tarea
	 */
	public Task(String nom){
		this.nombre = nom;
	}
	
	/**
	 * Devuelve el nombre de la tarea
	 * @return nombre, el nombre de la tarea
	 */
	public String getName(){
		return this.nombre;
	}
	
	public boolean addTask(Task t){
		if(this.containsTask(t) == false){
			if(t.getParent() != null){
				throw new IllegalArgumentException();
			}
			else if(t.containsTask(this) == true){
				return false;
			}
			else{
				this.subTareas.add(t);
				t.setParent(this);
				ObservablePropertyInteger padre = (ObservablePropertyInteger) this.getEstimated();
				ObservablePropertyInteger hijo = (ObservablePropertyInteger) t.getEstimated();
				padre.addObservableProperty(hijo);
				
				padre = (ObservablePropertyInteger) this.getDedicated();
				hijo = (ObservablePropertyInteger) t.getDedicated();
				padre.addObservableProperty(hijo);
				return true;
			}
		}
		else{
			return false;
		}
	}
	boolean removeTask(Task t){
		if(this.getTasks().contains(t)){
			this.subTareas.remove(t);
			t.setParent(null);					//UNSURE
			ObservablePropertyInteger padre = (ObservablePropertyInteger) this.getEstimated();
			ObservablePropertyInteger hijo = (ObservablePropertyInteger) t.getEstimated();
			padre.removeObservableProperty(hijo);
			
			padre = (ObservablePropertyInteger) this.getDedicated();
			hijo = (ObservablePropertyInteger) t.getDedicated();
			padre.removeObservableProperty(hijo);
			return true;
		}
		else if(this.containsTask(t) == true){
			return t.getParent().removeTask(t);
		}
		else{
			return false;
		}
	}
	public Set<Task> getTasks(){
		final Set<Task> temp = this.subTareas;		//En teoria
		return temp;
	}
	public boolean containsTask(Task t){				//Possibly Unsure
		if(this.subTareas.contains(t)){
			return true;
		}
		for(Task temp: this.subTareas){
			if(temp.containsTask(t) == true){
				return true;
			}
		}
		return false;
	}
	public Task getParent(){
		return this.parent;
	}
	public void setParent(Task parent){
		Task temp;
		if(parent == null){
			this.parent = parent;
		}
		else{
			if(this.containsTask(parent)){
				throw new IllegalArgumentException(); 
			}
			if((temp = this.getParent()) != null){
				temp.removeTask(this);
			}
			parent.addTask(this);
			this.parent = parent;
		}
	}
	
	/**
	 * Devuelve el tiempo estimado de la tarea
	 * @return estimado, valor AdjustableTime de tiempo estimado para la tarea
	 */
	public AdjustableTime getEstimated(){
		return this.estimado;
	}
	/**
	 * Devuelv
	 * @return
	 */
	public AdjustableTime getDedicated(){
		return this.dedicado;
	}
	
	public String getSubTareas(){
		String temp = null;
		for(Task t: this.subTareas){
			if(temp == null){
				temp = t.getName();
			}
			else{
				temp += " " + t.getName();
			}
		}
		return temp;
	}
	
	public String getParentName(){
		if(this.parent == null){
			return "NONE";
		}
		else{
			return this.parent.getName();
		}
	}
	
	@Override
	public String toString() {
		return "nombre=" + nombre + ", estimado=" + estimado + ", dedicado=" + dedicado + ", parent=" + this.getParentName() + ", Subs: " + this.getSubTareas();

	}

	@Override
	public int compareTo(Task o) {
		return this.nombre.compareToIgnoreCase(o.getName());
	}
	
	
}
