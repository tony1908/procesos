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
           
           int rafaga,tiempo,memoria,llegada, cantidad,opc, quantum= 10, prioridad,id;//el quantum debe ser leido desde el usuario
           int i = 0;
           String nombre;
           ArrayList<Proceso> cola = new ArrayList<Proceso>();//array list para almacenar los procesos
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
                     rafaga = randomInteger(1,100);//llama la funcion para generar numeros random
                     llegada = randomInteger(1,10);
                     nombre = getSaltString();//llama a la funcion para generar cadenas random
                     memoria = randomInteger(1,1000);
                     prioridad = randomInteger(1,10);
                     // quantum = randomInteger(1,50);
                     Proceso proceso = new Proceso(nombre,rafaga,memoria,llegada,id,prioridad);//crea una instancia de proceso
                     cola.add(proceso);//mete cada procesos en desorden a un arraylist
                 }
          
         break;
             case 2:
             	
                 //reduje todos los for que tenian a uno solo
                 
                 for (i=1;i<=cantidad;i++) { //para dar valor de la propiedad a cada proceso
                     System.out.println("\n¿Id del proceso"+ i +"(1-10 maximo)?\n"); 
                     id = in.nextInt();
	                 while (id>10) { //validacion
	                     System.out.println("Valor no valido, ingrese un valor menor a 11");
	                     id = in.nextInt();
	                 }
	                 System.out.println("\n¿Nombre del proceso"+ i + "(dos caracteres maximo)?\n");
                     try{
                          nombre = lee.readLine();
                        }catch(IOException e){
                          e.printStackTrace();
                        }
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
	                 // System.out.println("\n¿Quantum (1-50)?\n");
	                 // quantum = in.nextInt(); //el Quantum es el mismo para cada proceso
	                 // while (quantum>50) {
	                 //     System.out.println("Valor no valido, ingrese un valor menor a 50");
	                 //     quantum = in.nextInt();
	                 // }
                 
                 }
                 
                 break;
             
             default:
                 break;
         }
	}
	public static String getSaltString() {//funcion para generar cadenas random
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

    public static int randomInteger(int min, int max) {//funcion para generar numeros random

	    Random rand = new Random();

	    // nextInt excludes the top value so we have to add 1 to include the top value
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}

    public static ArrayList<Proceso>  acomodarObjetos(ArrayList<Proceso> cola){//funcion para acomodar por tiempo de acomodo a los procesos(el del tipo aaraylist)
        int i;//la funcion consiste en iterar el arreglo encontradno el valor mas bajo en cada iteracion y colocarlo hasta el frente de un nuevo arraylist
        int temp = 0;
        int pos = 0;
        int tam = cola.size();
        ArrayList<Proceso> cola2 = new ArrayList<Proceso>();
        Proceso temo;
        Proceso nuevo = new Proceso();

        do{
            for (i=0; i<tam;i++ ) {
                temo = cola.get(i);

                if (temp <= temo.llegada) {
                    temp = temo.llegada;
                    pos = i;
                    nuevo = temo;
                }
            }
            cola.remove(pos);
            cola2.add(0,nuevo);
            tam = cola.size();
            temp = 0;
            pos = 0;

        }while(cola.size()>0);
        return(cola2);
    } 
}