/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica2nicolticona_121;

/**
 *
 * @author HP-RYZEN 5
 */
//Nicol Yanina Ticona Aduviri
//R.U:1855987
public class Figura2 {
    private double[] a;
    private double[] b;

    // Constructor
    public Figura2(double[] a, double[] b) {
        this.a = a;
        this.b = b;
    }

    public double norma(double[] v) {
        double suma = 0;
        for (double val : v) suma += val * val;
        return Math.sqrt(suma);
    }

    public double productoPunto(double[] u, double[] v) {
        double suma = 0;
        for (int i = 0; i < u.length; i++) suma += u[i] * v[i];
        return suma;
    }

    // ----------- Proyección de a sobre b -----------
    public double[] proyeccion() {
        double escalar = productoPunto(a, b) / Math.pow(norma(b), 2);
        double[] resultado = new double[b.length];
        for (int i = 0; i < b.length; i++) {
            resultado[i] = escalar * b[i];
        }
        return resultado;
    }

    // ----------- Componente de a en b -----------
    public double componente() {
        return productoPunto(a, b) / norma(b);
    }

}
