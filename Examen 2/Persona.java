/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examen;

/**
 *
 * @author HP-RYZEN 5
 */
public class Persona {

    private String nombre;
    private int edad;
    private float pesoPersona;

    public Persona(String nombre, int edad, float peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.pesoPersona = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public float getPesoPersona() {
        return pesoPersona;
    }

    @Override
    public String toString() {
        return nombre + " (" + edad + " años, " + pesoPersona + " kg)";
    }
}
