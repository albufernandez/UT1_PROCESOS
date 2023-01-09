package Unidad1;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Tarea1_3 {
	//declaraciones globales poner las cosas private
	private Scanner teclado ;
	private Runtime rt; 
	//private InetAddress address;
	//private String sHostName;

	//constructor
	public Tarea1_3(){
		
		//iniciar lo declarado
		teclado = new Scanner (System.in);
		rt = Runtime.getRuntime();
		
	}
	
	
	//metodos todos privados
	private void menu() {
		System.out.println("1) Abrir el bloc de notas");
		System.out.println("2) mostrar el resultado de ipconfig");
		System.out.println("3) escribe tu el comando");
		System.out.println("0) Salir del programa");	
	}
	
	//no lleva void y ponemos tipo de dato porque va a devolver ese tipo de dato
	private int cogerOpcion() {
		int opcion = Integer.parseInt(teclado.nextLine());
		return opcion;
	}
	
	private void hacerOpcion (int opcion) {
		switch(opcion) {
		case 0:
			System.out.println("Fin del programa");
			break;
		case 1: 
			abrirBloc();
			break;
		case 2:
			imprimirIP();
			break;
		case 3:
			escribeComando();
			break;
			
			default:
				System.out.println("Datos incorrectos");
				break;

		}
	}
	
	private void escribeComando() {
		System.out.println("Dime el comando que quieres ejecutar");
		String comando = teclado.nextLine();
		Process miProceso;
		try {
			miProceso = rt.exec(comando);
			System.out.println("El PID de tu proceso es: " + miProceso.pid());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	private void imprimirIP(){
		try {
			System.out.println("Tu ip es" + InetAddress.getLocalHost());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void abrirBloc() {
		try {
			Process miProceso = rt.exec("notepad.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Se ha cerrado el programa");
	}
	
	
	
	
	//iniciar programa es como el programa de verdad, aqui metemos los metodos en el orden
	private void iniciarPrograma() {
		
		int opcion =0; 
		System.out.println("Bienvenid@ al programa 1_3");
		do {
		menu();
		opcion=cogerOpcion();
		hacerOpcion(opcion);
		
		
		}
		while (opcion!=0);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tarea1_3 tarea = new Tarea1_3();
		tarea.iniciarPrograma();
		

	}

}
