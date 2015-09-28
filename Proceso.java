public class Proceso {
	private String nombre;
	private int rafaga;
	private int tiempo;
	private int memoria;
	private int llegada;
	private int id;
	private int prioridad;
	private int quantum;
	public Proceso(String nombre,int rafaga,int memoria,int llegada, int id, int prioridad, int quantum){
		nombre = nombre;
		rafaga = rafaga;
		memoria = memoria;
		llegada = llegada;
		id = id;
		prioridad = prioridad;
		quantum = quantum;
	}
}