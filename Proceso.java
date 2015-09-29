public class Proceso {
	public String nombre;
	public int rafaga;
	public int tiempo;
	public int memoria;
	public int llegada;
	public int id;
	public int prioridad;
	public int quantum;
	public Proceso(String nombre2,int rafaga2,int memoria2,int llegada2, int id2, int prioridad2, int quantum2){
		nombre = nombre2;
		rafaga = rafaga2;
		memoria = memoria2;
		llegada = llegada2;
		id = id2;
		prioridad = prioridad2;
		quantum = quantum2;
	}
	 public void imprimir(){
	 	System.out.println(id);
	 }
	 public Proceso(){
	 	
	 }
}