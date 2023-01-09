package Unidad1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Practica1_1 {
	
	//Declaraci�n de variables
	Runtime rt; Scanner teclado;  ArrayList<Proceso> alProce;
	
	//Constructor de la clase Practica1_1
	public Practica1_1() {
		rt = Runtime.getRuntime();
		teclado = new Scanner (System.in);
		alProce = new ArrayList<Proceso>();
		}
	
	//M�todo que imprime los mensajes de saludo y de fin de programa y ejecuta los m�todos del programa
	public void ejecutaPrograma() {
		System.out.println("�Bienvenid@ al programa!");
		escribeComando();
		borrarProcesos();
		System.out.println("Fin de la pr�ctica 1_1");
	}
	
	//M�todo al que le pasamos un comando, crea el proceso y lo a�ade a un arrayList
	public void escribeComando() {
		
		int veces =2;
		
		//Bucle que se repite las veces del valor de la variable "veces"
		for (int i=1; i<=veces;i++) {
			System.out.println("Proceso " + i);
			System.out.println("Comando:");
			
			try {
				Proceso miProceso; //Creamos un objeto de tipo Proce
				long PID;
				String ejecutable;
				
				ejecutable=teclado.nextLine(); // Guardamos el nombre del comando 
				Process proceso = rt.exec(ejecutable); //Se crea un proceso y guardamos objeto de tipo Process
				System.out.println("Proceso creado con �xito");
				
				PID= proceso.pid(); //Guardamos en la variable pid el valor del pid
				miProceso = new Proceso(ejecutable,PID);
				
				alProce.add(miProceso); //A�adimos al arrayList el Proce que acabaos de crear con sus datos
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		System.out.println("\n");
	}

	//M�todo que lista los procesos y nos pregunta cual queremos cerrar (al cerrarlo lo borra del arrayList) 
	//hasta que no queden procesos activos
	public void borrarProcesos() {
		long PIDcerrar;
		int proceCerrar;
		
		//Bucle que se ejecutara hasta que el arrayList est� vacio
		while (alProce.size()!=0) {
			
			System.out.println("PROCESOS ACTIVOS:");
			//Bucle que se ejecuta tantas veces como objetos tenga el ArrayList
			for (int i =0; i< alProce.size(); i++) {
				System.out.println("PROCESO " + i + " > " + alProce.get(i).toString()); //Imprime los datos de cada Proce
				}
			
			System.out.println("Selecciona proceso a cerrar");
			proceCerrar= Integer.parseInt(teclado.nextLine()); //Se guarda el numero de proceso
			int tama�o = alProce.size();
			
			//Comprobamos que el numero que queremos cerrar est� dentro de la lista
			if (proceCerrar>=tama�o) {System.out.println("El n�mero de proceso que has introducido no existe \n");}
			
			else {
			
				PIDcerrar = alProce.get(proceCerrar).getPID();//Buscamos el pid del proceso que queremos cerrar
			
				try {
	
				rt.exec("TASKKILL /F /PID " + PIDcerrar); //Cierra el proceso con el pid que hemos pasado
			
				//En las siguientes lineas se borra el objeto de la lista
				for (int i=0; i<alProce.size();i++) { //Bucle que recorre todos los objetos 
					long PIDProce = alProce.get(i).getPID(); //Guarda sus pid
				
					//Si el pid del objeto es el mismo que queremos borrar, borrar el objeto de la lista
					if (PIDProce == PIDcerrar) { alProce.remove(i); 
					System.out.println("Proceso cerrado correctamente");} 
					}
				
				} catch (IOException e) {
					e.printStackTrace();
			}
		}
	}
		System.out.println("\n");
}
		
	public static void main(String[] args) {
		
		
		Practica1_1 practica = new Practica1_1();
		practica.ejecutaPrograma();

	}

}
