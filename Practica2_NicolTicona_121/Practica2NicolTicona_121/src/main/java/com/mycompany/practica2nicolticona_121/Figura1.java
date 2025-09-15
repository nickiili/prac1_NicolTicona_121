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
public class Figura1 {
    private double[] a;
    private double[] b;

    // Constructor
    public Figura1(double[] a, double[] b) {
        this.a = a;
        this.b = b;
    }

    public double norma(double[] v) {
        double suma = 0;
        for (double val : v) suma += val * val;
        return Math.sqrt(suma);
    }

    public double[] suma(double[] u, double[] v) {
        double[] res = new double[u.length];
        for (int i = 0; i < u.length; i++) res[i] = u[i] + v[i];
        return res;
    }

    public double[] resta(double[] u, double[] v) {
        double[] res = new double[u.length];
        for (int i = 0; i < u.length; i++) res[i] = u[i] - v[i];
        return res;
    }

    // ----------- Criterio de perpendicularidad con diagonales -----------
    public boolean EsPerpendicularConDiagonales() {
        double normaSuma = norma(suma(a, b));
        double normaResta = norma(resta(a, b));
        return Math.abs(normaSuma - normaResta) < 1e-6; // tolerancia numérica
    }

}

