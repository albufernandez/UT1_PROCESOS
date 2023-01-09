package Unidad1;

public class Proceso {
	
		//Declaracion de variables
		private String comando;
		private long PID;
		
		//Getters y setters 
		public String getComando() {
			return comando;}

		public void setComando(String comando) {
			this.comando = comando;}

		public long getPID() {
			return PID;}

		public void setPID(long pID) {
			PID = pID;}
		
		//ToString
		public String toString() {
			return "Proceso [comando=" + comando + ", PID=" + PID + "]";}

		//Constructor de la clase Proce
		public Proceso(String comando, long PID) {
			this.comando=comando;  this.PID=PID;	
		}	

}
