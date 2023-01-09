package Unidad1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Tarea1_5 {
	
	/* Crear un programa en Java con las siguientes opciones:
	 * 1. Mostrar direccion IP
	 * 2. Mostrar mascara de subred
	 * 3. Mostrar puerta de enlace
	 * 0. Salir
	 * en el exec("cmd.exe /ipconfing") if (line.contains("Direccion IPv4") syso line
	 */

	private Runtime rt; 
	private Scanner teclado; 
	
	public Tarea1_5(){ //constructor inicializa
		rt = Runtime.getRuntime();
		teclado = new Scanner (System.in);
		
		
	}
	
	public void iniciarPrograma() {
		System.out.println("Bienvenid@ al programa");
		int opcion = 0;
		do {
		mostrarMenu();
		opcion = cogerOpcion();
		tramitarOpcion(opcion);
		
		} while (opcion!=0);
	}
	
	public void mostrarMenu() {
		System.out.println("Opcion 1. Mostrar direccion IP");
		System.out.println("Opcion 2. Mostrar mascara de subred");
		System.out.println("Opcion 3. Mostrar puerta de enlace");
		System.out.println("Opcion 0. Salir");
		System.out.println("Escoja una");
	}
	
	public int cogerOpcion() {
		int opcion = Integer.parseInt( teclado.nextLine());
		return opcion;
	}
	
	public void tramitarOpcion(int opcion) {
		switch(opcion) {
		case 1: mostrarIP();
			break;
		case 2: mostrarMascaraSubred();
			break;
		case 3: mostrarPuertaEnlace();
			break;
		case 0: System.out.println("Fin del programa");
			break;
		default: System.out.println("Has introducido datos erroneos");
			break;
		
		}
	}
	
	public void mostrarIP() {
		String lineaIP;
		String ejecutable = "cmd.exe /c ipconfig";
		try {
			Process miProceso = rt.exec(ejecutable);
			
			//recogemos el resultado de el cmd
			BufferedReader leerIP = new BufferedReader( new InputStreamReader(miProceso.getInputStream()));
			lineaIP = leerIP.readLine();
			
			//mostrar el resultado
			while (lineaIP!=null) {
					if (lineaIP.contains(" IPv4")) {System.out.println(lineaIP);}
				lineaIP = leerIP.readLine();
			}
			leerIP.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void mostrarMascaraSubred() {
		
		String lineaMascara;
		String ejecutable = "cmd.exe /c ipconfig";
		
		try {
			Process miProceso = rt.exec(ejecutable);
			
			BufferedReader leerMascara = new BufferedReader ( new InputStreamReader (miProceso.getInputStream()));
			lineaMascara = leerMascara.readLine();
			
			while (lineaMascara != null) {
					if (lineaMascara.contains("subred")) { System.out.println(lineaMascara);}	
					lineaMascara = leerMascara.readLine();
			}
			leerMascara.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public void mostrarPuertaEnlace() {
		String lineaPuerta;
		String ejecutable = "cmd.exe /c ipconfig";
		
		try {
			Process miProceso = rt.exec(ejecutable);
			
			BufferedReader leerPuerta = new BufferedReader ( new InputStreamReader(miProceso.getInputStream()));
			lineaPuerta = leerPuerta.readLine();
			
			while (lineaPuerta != null) {
				if (lineaPuerta.contains("enlace")) { System.out.println(lineaPuerta);}
				lineaPuerta = leerPuerta.readLine();
			}
			leerPuerta.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

	public static void main(String[] args) {
		
		Tarea1_5 tarea = new Tarea1_5();
		tarea.iniciarPrograma();
	}

}
