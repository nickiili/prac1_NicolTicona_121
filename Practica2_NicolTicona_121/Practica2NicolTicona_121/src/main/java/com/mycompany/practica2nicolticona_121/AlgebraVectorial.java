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
public class AlgebraVectorial {
    private double[] a;
    private double[] b;

    // -------- Sobrecarga de constructores --------
    public AlgebraVectorial() {
        this.a = new double[]{0, 0, 0};
        this.b = new double[]{0, 0, 0};
    }

    public AlgebraVectorial(double[] a) {
        this.a = a;
        this.b = new double[]{0, 0, 0};
    }

    public AlgebraVectorial(double[] a, double[] b) {
        this.a = a;
        this.b = b;
    }

    // -------- Operaciones auxiliares --------
    private double norma(double[] v) {
        double suma = 0;
        for (double val : v) suma += val * val;
        return Math.sqrt(suma);
    }

    private double productoPunto(double[] u, double[] v) {
        double suma = 0;
        for (int i = 0; i < u.length; i++) suma += u[i] * v[i];
        return suma;
    }

    private double[] productoCruz(double[] u, double[] v) {
        return new double[]{
            u[1]*v[2] - u[2]*v[1],
            u[2]*v[0] - u[0]*v[2],
            u[0]*v[1] - u[1]*v[0]
        };
    }

    private double[] suma(double[] u, double[] v) {
        double[] res = new double[u.length];
        for (int i = 0; i < u.length; i++) res[i] = u[i] + v[i];
        return res;
    }

    private double[] resta(double[] u, double[] v) {
        double[] res = new double[u.length];
        for (int i = 0; i < u.length; i++) res[i] = u[i] - v[i];
        return res;
    }

    // -------- Métodos de Perpendicularidad --------
    // (c) Producto punto = 0
    public boolean esPerpendicular() {
        return Math.abs(productoPunto(a, b)) < 1e-6;
    }

    // Sobrecarga para otros criterios (a, b, d)
    public boolean esPerpendicular(String metodo) {
        switch (metodo) {
            case "a": // |a+b| = |a-b|
                return Math.abs(norma(suma(a, b)) - norma(resta(a, b))) < 1e-6;
            case "b": // |a-b| = |b-a| (siempre se cumple)
                return Math.abs(norma(resta(a, b)) - norma(resta(b, a))) < 1e-6;
            case "d": // |a+b|^2 = |a|^2 + |b|^2
                double izq = Math.pow(norma(suma(a, b)), 2);
                double der = Math.pow(norma(a), 2) + Math.pow(norma(b), 2);
                return Math.abs(izq - der) < 1e-6;
            default:
                return esPerpendicular();
        }
    }

    // -------- Métodos de Paralelismo --------
    // (f) Producto cruz = 0
    public boolean esParalela() {
        double[] cruz = productoCruz(a, b);
        return Math.abs(cruz[0]) < 1e-6 && Math.abs(cruz[1]) < 1e-6 && Math.abs(cruz[2]) < 1e-6;
    }

    // (e) a = r*b
    public boolean esParalela(String metodo) {
        if ("e".equals(metodo)) {
            double r = (b[0] != 0) ? a[0]/b[0] : 0;
            for (int i = 0; i < a.length; i++) {
                if (b[i] != 0) {
                    if (Math.abs(a[i]/b[i] - r) > 1e-6) return false;
                } else if (a[i] != 0) {
                    return false;
                }
            }
            return true;
        }
        return esParalela();
    }

    // -------- Proyección de a sobre b --------
    public double[] proyeccion() {
        double escalar = productoPunto(a, b) / Math.pow(norma(b), 2);
        double[] res = new double[b.length];
        for (int i = 0; i < b.length; i++) res[i] = escalar * b[i];
        return res;
    }

    // -------- Componente de a en b --------
    public double componente() {
        return productoPunto(a, b) / norma(b);
    }
}