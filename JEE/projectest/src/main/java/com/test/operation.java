package com.test;

public class operation {
	private String nombre1;
	private String nombre2;
	private String operation;
	private String resultat;

	public operation(String nombre1, String nombre2, String operation, String resultat) {
		super();
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.operation = operation;
		this.resultat = resultat;
	}
	public String getNombre1() {
		return nombre1;
	}
	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}
	public String getNombre2() {
		return nombre2;
	}
	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getResultat() {
		return resultat;
	}
	public void setResultat(String resultat) {
		this.resultat = resultat;
	}
	public String toString(){
		String operateur= "";
		if(this.operation.equals("ajout")) 
			operateur=" + ";
		
		else if(this.operation.equals("difference")) 
			operateur=" - ";
		else if(this.operation.equals("multiplication")) 
			operateur=" * ";
		else if(this.operation.equals("division")) {
			operateur=" / ";
			
		}
		return this.nombre1+operateur+this.nombre2+" = "+this.resultat;
	}

}
