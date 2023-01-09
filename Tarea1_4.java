package Unidad1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

//TODO Auto-generated method stub
		// crear un programa en java con las siguientes ocpinoes:
		//1. crear proceso [pidiendo datos a usuario]
		//2. listar procesos [mostrando todos los datos]
		//3. cerrar un proceso [mostrando solo nombres]
		//0. salir
		// del proceso dar el nombre el comando y el pid
		//arraylist


	 class Proce{
		 String nomProceso, comando;
		 long pid;
		 
		
		public String getNomProceso() {
			return nomProceso;
		}

		public void setNomProceso(String nomProceso) {
			this.nomProceso = nomProceso;
		}

		public String getComando() {
			return comando;
		}

		public void setComando(String comando) {
			this.comando = comando;
		}

		public long getPid() {
			return pid;
		}

		public void setPid(long pid) {
			this.pid = pid;
		}

		public Proce(String nomProceso, String comando, long pid) {
			
			this.nomProceso=nomProceso;
			this.comando=comando;
			this.pid=pid;
			
		}
	}
	
	public class Tarea1_4 { //declaraciones
	
		private Runtime rt;
		private Scanner teclado;
		private int pid;
		private String nomProceso;
		ArrayList<Proce> alProcesos;

	public Tarea1_4() { //iniciar las declaraciones
		alProcesos = new ArrayList<Proce>();
		rt= Runtime.getRuntime();
		teclado = new Scanner (System.in);
		int pid;
		String nomProceso;

	}
	
	public void iniciarPrograma() {
		
		int opcion = 0;
		System.out.println("Bienvenid@ al programa 1_4");
		do {
			menuOpciones();
			opcion = cogerOpcion();
			tramitaOpcion(opcion);
		} while(opcion != 0);
	}

	public void menuOpciones() {
		System.out.println("Opcion 1: crear un proceso introduciendo los datos");
		System.out.println("Opcion 2: listar procesos y sus datos");
		System.out.println("Opcion 3: cerrar un proceso dando su pid");
		System.out.println("Opcion 0: salir");
		System.out.println("Escoja una.");
	}
	
	public int cogerOpcion() {
		int opcion = Integer.parseInt(teclado.nextLine()) ;
		return opcion;
	}
	
	public void tramitaOpcion(int opcion) {
		switch (opcion) {
		case 1: creaProceso();
			break;
		case 2: listaProcesos();
			break;
		case 3: cierraProceso();
			break;
		case 0: System.out.println("Has cerrado el programa");
			break;
		default: System.out.println("Datos erroneos");
			break;	
		}
	}
	
	public void creaProceso() {
	
		System.out.println("Dime el nombre del proceso");
			String nomProceso = teclado.nextLine();
		System.out.println("Dime el nombre del programa como por ejemplo mspaint.exe ");
			String ejecutable = teclado.nextLine();
		
		try {
			
			Process miProcess = rt.exec(ejecutable);
			long pid = miProcess.pid();
			
			Proce miProceso = new Proce(nomProceso,ejecutable, pid);
			alProcesos.add(miProceso);
			
			System.out.println("El pid de " + nomProceso + " es: " + miProcess.pid() + "\n");
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void listaProcesos() {
		
		if (alProcesos.size()>0) {
			
		for (int i=0; i<alProcesos.size(); i++) {
			
			Proce proceso = alProcesos.get(i);
			
			System.out.println("Proceso numero: " + (i+1));
			System.out.println("El nombre de tu poceso es: " + proceso.getNomProceso() +" y el numero de proceso es: "+ proceso.getPid());
			}	
		}
		else System.out.println("No hay procesos");
	}
	
	public void cierraProceso() {
		System.out.println("Dime el numero del proceso que quieras cerrar");
		int proceso =  Integer.parseInt(teclado.nextLine());
		
		String ejecutable ="TASKKILL /F /PID " + proceso;
		
		try {
			Process miProceso = rt.exec(ejecutable);
			
			//bucle que recorre todos los objetos de tipo Proceso buscando el que tenga el pid
			for (int i=0; i<alProcesos.size(); i++) {
				Proce proce = alProcesos.get(i);
					if (proce.getPid()==proceso) { //si encuentra ese pid borra el objeto de la lista
						alProcesos.remove(i);
					}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Tarea1_4 tarea = new Tarea1_4();
		tarea.iniciarPrograma();	
		
	}

}
	
	
