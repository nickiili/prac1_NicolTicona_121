/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examen;

/**
 *
 * @author HP-RYZEN 5
 */
public class Linea {

    private String color;
    Persona[] filaPersonas;
    Cabina[] cabinas;
    int cantidadCabinas;
    int cantidadFila;

    public Linea(String color) {
        this.color = color;
        filaPersonas = new Persona[50];
        cabinas = new Cabina[20];
        cantidadCabinas = 0;
        cantidadFila = 0;
    }

    public String getColor() {
        return color;
    }

    public Cabina[] getCabinas() {
        return cabinas;
    }

    public int getCantidadCabinas() {
        return cantidadCabinas;
    }

    public Persona[] getFilaPersonas() {
        return filaPersonas;
    }

    public int getCantidadFila() {
        return cantidadFila;
    }

    public void agregarPersona(Persona p) {
        filaPersonas[cantidadFila++] = p;
    }

    public void agregarCabina(int nroCab) {
        cabinas[cantidadCabinas++] = new Cabina(nroCab);
    }

    public Persona sacarPrimeraPersona() {
        if (cantidadFila == 0) {
            return null;
        }

        Persona primera = filaPersonas[0];

        for (int i = 1; i < cantidadFila; i++) {
            filaPersonas[i - 1] = filaPersonas[i];
        }

        filaPersonas[--cantidadFila] = null;
        return primera;
    }
}
