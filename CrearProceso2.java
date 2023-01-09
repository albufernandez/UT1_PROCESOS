package Unidad1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CrearProceso2 {
Scanner teclado = new Scanner (System.in);
ProcessBuilder pb = new ProcessBuilder();

long pid;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CrearProceso2 cp = new CrearProceso2();
		
		cp.opciones();
		

	}
	
	public int pedirOpcion() {
		int opcion = Integer.parseInt(teclado.nextLine());
		return opcion;
	}
	
	public void opciones() {
		
		
		
		Process proceso=null;
		boolean salir = true;
		
		while(salir){
			
			System.out.println("\nLas opciones son: \n1)Crear un fichero \n2)Abrir fichero(en espera) \n3)Abrir fichero \n4)Cerrar fichero \n5)Leer fichero \n0)Salir \nEscoja una \n");
			Scanner teclado = new Scanner (System.in);
			int opcion = Integer.parseInt(teclado.nextLine()); 
			
		switch(opcion) {
		
	
		case 0: salir = false ; 
		break;
		case 1:crearFichero(); 
		break;
		case 2: abrirFicheroEspera(); 
		break;
		case 3: abrirFichero(); 
		break;
		case 4: proceso.destroy(); 
		break;
		case 5: leerFichero(); 
		break;
			}
		}
		
	}
	
	//metodo que crea un fichero con el contenido que le pasamos por consola
	public  void crearFichero() {
		try {
			Scanner teclado = new Scanner (System.in);
			System.out.println("escribe el nombre del fichero sin txt");
			String nombreFichero = teclado.nextLine();
			
			System.out.println("Escribe el contenido del fichero");
			String contenido = teclado.nextLine();
			
			BufferedWriter bw = new BufferedWriter (new FileWriter (new File(nombreFichero + ".txt")));
			bw.write(contenido);
			bw.close();
	
		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}
	
	public void leerFichero() {
		
		System.out.println("Qué fichero quieres leer?");
		Scanner teclado = new Scanner (System.in);
		String nombreFichero = teclado.nextLine();
	
		
		try {
			
			BufferedReader br = new BufferedReader (new FileReader (new File(nombreFichero + ".txt")));
			String texto = "";
			String linea= br.readLine();
			
			while (linea != null) {
				texto = texto + linea;
				linea = br.readLine();
				
				System.out.println(texto); }
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void abrirFicheroEspera() {
		
		System.out.println("¿Que fichero quieres abrir?");
		Scanner teclado = new Scanner (System.in);
		String fichero = teclado.nextLine();
	    
	    
		pb.command("notepad.exe", fichero+".txt");
		try {
			Process pstart = pb.start();
			pid = pstart.pid();
			System.out.println("el numero de proceso es: " + pstart.pid());
			pstart.waitFor();
				
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void cerrarFichero() {
		Runtime rt = Runtime.getRuntime();
		Process miProceso;
		
	}

	public void abrirFichero() {
		
		System.out.println("Que fichero quieres abrir?");
		Scanner teclado = new Scanner (System.in);
		
		String fichero = teclado.nextLine();
		pb.command("notepad.exe", fichero+".txt");
		try {
			Process pStart = pb.start();
			System.out.println("el numero de proceso es: " + pStart.pid());
			;
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
