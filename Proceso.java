public class Proceso {
	public String nombre;
	public int rafaga;
	public int tiempo;
	public int memoria;
	public int llegada;
	public int id;
	public int prioridad;
	public int quantum;
	public Proceso(String nombre,int rafaga,int memoria,int llegada, int id, int prioridad, int quantum){
		this.nombre = nombre;
		this.rafaga = rafaga;
		this.memoria = memoria;
		this.llegada = llegada;
		this.id = id;
		this.prioridad = prioridad;
		this.quantum = quantum;
	}
	 public void imprimir(){
	 	System.out.println(id);
	 }
	 public Proceso(){

	 }
}