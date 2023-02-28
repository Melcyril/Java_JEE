package com.example.model;

public class Operation {
	
	private float nombre1;
	private float nombre2;
	private String operation;
	private float resultat;
	
	public Operation(float nombre1, float nombre2, String operation, float resultat) {
		super();
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.operation = operation;
		this.resultat = resultat;
	}
			
	@Override
	public String toString() {
		String operateur = " ? ";
		
		if(this.operation.equals("add"))
			operateur = " + ";
		else if(this.operation.equals("sub"))
			operateur = " - ";
		else if(this.operation.equals("mul"))
			operateur = " * ";
		else if(this.operation.equals("div"))
			operateur = " / ";
		
		return this.nombre1 + operateur + this.nombre2 + " = " + this.resultat;
	}

	public float getNombre1() {
		return nombre1;
	}
	public void setNombre1(float nombre1) {
		this.nombre1 = nombre1;
	}
	public float getNombre2() {
		return nombre2;
	}
	public void setNombre2(float nombre2) {
		this.nombre2 = nombre2;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public float getResultat() {
		return resultat;
	}
	public void setResultat(float resultat) {
		this.resultat = resultat;
	}
	
	
}
