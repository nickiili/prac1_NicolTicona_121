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
public class Vector {
    private double x, y, z;

    public Vector() {
        this(0, 0, 0);
    }

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // -------- Operaciones básicas --------
    // a) Suma de vectores
    public Vector suma(Vector b) {
        return new Vector(this.x + b.x, this.y + b.y, this.z + b.z);
    }

    // b) Multiplicación por escalar
    public Vector multiplicarPorEscalar(double r) {
        return new Vector(r * this.x, r * this.y, r * this.z);
    }

    // c) Longitud del vector
    public double longitud() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    // d) Vector normalizado
    public Vector normalizar() {
        double norma = this.longitud();
        if (norma == 0) throw new ArithmeticException("No se puede normalizar el vector nulo");
        return new Vector(x / norma, y / norma, z / norma);
    }

    // e) Producto escalar
    public double productoEscalar(Vector b) {
        return this.x * b.x + this.y * b.y + this.z * b.z;
    }

    // f) Producto vectorial
    public Vector productoVectorial(Vector b) {
        return new Vector(
            this.y * b.z - this.z * b.y,
            this.z * b.x - this.x * b.z,
            this.x * b.y - this.y * b.x
        );
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

}

