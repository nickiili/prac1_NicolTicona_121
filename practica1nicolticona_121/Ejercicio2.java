/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1nicolticona_121;

/**
 *
 * @author HP-RYZEN 5
 */
public class Ejercicio2 {
    private double a,b,c;
	
	public Ejercicio2(double A, double B, double C){
		this.a=A;
		this.b=B;
		this.c=C;
	}
	
	public double Discriminante() {
		double aux1;
		aux1 = Math.pow(this.b, 2);
		double disc = aux1 - 4 * (this.a * this.c);
		return disc;
	}
	
	public double getRaiz1() {
		double r;
		double aux1;
		aux1= -this.b + Math.sqrt(Discriminante());
		r=aux1/2*this.a;
		return r;
	}
	
	public double getRaiz2() {
		double r;
		double aux1;
		aux1= -this.b - Math.sqrt(Discriminante());
		r=aux1/2*this.a;
		return r;
	}
}
