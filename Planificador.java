import java.util.Scanner;
import java.io.*;
import java.util.Random; 
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Random;


public class Planificador{
	public static void main(String[] args) {
		BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
           Scanner in = new Scanner(System.in); //para ingresar los valores
           
           int rafaga,tiempo,memoria,llegada, cantidad,opc, quantum, prioridad,id;
           int i = 0;
           String nombre;
           List<Object> cola = new LinkedList<Object>();
        System.out.println("\n¿Cuantos procesos deseas generar (1-10 maximo)?\n");
        cantidad = in.nextInt(); //lectura desde el teclado
        while (cantidad>10) { //validacion de los datos 
             System.out.println("Valor no valido, ingrese un valor menor a 11");
             cantidad = in.nextInt();
         }
        System.out.println("\n¿Como desea generar los procesos?\n");
        System.out.println("\n1)Aleatoriamente\n2)Manualmente\n");
        opc = in.nextInt();
     
        switch(opc)  {  //menu para la seleccion del tipo de ingreso de datos   
             case 1: //aleatoriamente
                for (i=1;i<=cantidad;i++) { //para dar valor de la propiedad a cada proceso
                     id = i;
                     rafaga = randomInteger(1,100);
                     llegada = randomInteger(1,10);
                     nombre = getSaltString();
                     memoria = randomInteger(1,1000);
                     prioridad = randomInteger(1,10);
                     quantum = randomInteger(1,50);
                     Proceso proceso = new Proceso(nombre,rafaga,memoria,llegada,id,prioridad,quantum);
                     cola.add(proceso);
                 }
          
         break;
             case 2:
             	
                 
                 
                 for (i=1;i<=procesos;i++) { //para dar valor de la propiedad a cada proceso
                     System.out.println("\n¿Id del proceso"+ i +"(1-10 maximo)?\n"); 
                     id = in.nextInt();
	                 while (id>10) { //validacion
	                     System.out.println("Valor no valido, ingrese un valor menor a 11");
	                     id = in.nextInt();
	                 }
	                 System.out.println("\n¿Nombre del proceso"+ i + "(dos caracteres maximo)?\n");
	                 nombre = lee.readLine();
	                 nombre1[i]=nombre;
	                 System.out.println("\n¿Tamaño de proceso" + i +"en memoria (1-1000)?\n");
	                 memoria = in.nextInt();
	                 while (memoria>1001) {
	                     System.out.println("Valor no valido, ingrese un valor menor a 1001");
	                     memoria = in.nextInt();
	                 }
	                 System.out.println("\n¿Tiempo de rafaga del proceso" + i + " (1-100 maximo)?\n"); 
	                 rafaga = in.nextInt();
	                 while (rafaga>101) {
	                     System.out.println("Valor no valido, ingrese un valor menor a 101");
	                     rafaga = in.nextInt();
	                 }
	                 System.out.println("\n¿Prioridad del proceso"+ i +"(1-10 maximo)?\n");
	                 prioridad = in.nextInt();
	                 while (prioridad>10) {
	                     System.out.println("Valor no valido, ingrese un valor menor a 11");
	                     prioridad = in.nextInt();
	         			}
	         		System.out.println("\n¿Tiempo de llegada del proceso"+ i +"(0-10 maximo)?\n");
	                 llegada = in.nextInt();
	                 while (llegada>10) {
	                     System.out.println("Valor no valido, ingrese un valor menor a 11");
	                     llegada = in.nextInt();
	                 }
	                 System.out.println("\n¿Quantum (1-50)?\n");
	                 quantum = in.nextInt(); //el Quantum es el mismo para cada proceso
	                 while (quantum>50) {
	                     System.out.println("Valor no valido, ingrese un valor menor a 50");
	                     quantum = in.nextInt();
	                 }
                 
                 }
                 
                 break;
             
             default:
                 break;
         }
	}
	public static String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

    public static int randomInteger(int min, int max) {

	    Random rand = new Random();

	    // nextInt excludes the top value so we have to add 1 to include the top value
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
}