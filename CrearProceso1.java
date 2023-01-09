package Unidad1;

import java.io.IOException;
import java.util.Scanner;

public class CrearProceso1 {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//poner 4 opciones (2 programas de las dos formas)
		//mostrar pid e info notepad.exe y mspaint.exe
		
		
		System.out.println("Introduce la opcion a hacer: \nopcion 1: abrir el bloc de notas con PB " +
				"\nopcion 2: abrir el paint con PB \nopcion 3: abrir el bloc de notas con RT" + 
				"\nopcion 4: abrir el paint con RT \nopcion 5: salir");
		
		Scanner teclado = new Scanner (System.in);
		int num = teclado.nextInt();
		
		while (num>0 && num<5 ) {
			
			if (num == 1) {
				
				String proceso = "notepad.exe";
				ProcessBuilder pb = new ProcessBuilder(proceso);
				Process miProceso;
				try {
					
					miProceso = pb.start();
					System.out.println("el numero de proceso es : " + miProceso.pid());
					System.out.println("la info del proceso es : " + miProceso.info());
				} catch(IOException e) {
					e.printStackTrace();
				}
				
				
				
			}
			if (num ==2) {
				String proceso = "mspaint.exe";
				ProcessBuilder pb = new ProcessBuilder(proceso);
				Process miProceso;
				try {
				miProceso = pb.start();
				System.out.println("el numero de proceso es : " + miProceso.pid());
				System.out.println("la info del proceso es : " + miProceso.info());
				} catch(IOException e) {
					e.printStackTrace();
				}
				
			}
			if (num ==3) {
				String proceso = "notepad.exe";
				Runtime rt = Runtime.getRuntime();
				Process miProceso;
				try {
					miProceso = rt.exec(proceso);
					System.out.println("el numero de proceso es : " + miProceso.pid());
					System.out.println("la info del proceso es : " + miProceso.info());
				} catch (IOException e){
					e.printStackTrace();
				}
				
			}
			if (num ==4) {
				String proceso = "mspaint.exe";
				Runtime rt = Runtime.getRuntime();
				Process miProceso;
				try {
					miProceso = rt.exec(proceso);
					System.out.println("el numero de proceso es : " + miProceso.pid());
					System.out.println("la info del proceso es : " + miProceso.info());
				} catch (IOException e){
					e.printStackTrace();
				}
				
			}
			
			System.out.println("Introduce la opcion a hacer: \nopcion 1: abrir el bloc de notas con PB " +
					"\nopcion 2: abrir el paint con PB \nopcion 3: abrir el bloc de notas con RT" + 
					"\nopcion 4: abrir el paint con RT \nopcion 5: salir");
			Scanner teclado2 = new Scanner (System.in);
			num = teclado2.nextInt();
			
		}
		

	}

}
