/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadebibliotecauniversitaria;

/**
 *
 * @author HP-RYZEN 5
 */


//Nicol Yanina Ticona Aduviri
//R.U: 1855987
public class Estudiante {

    private String codigo;
    private String nombre;

    public Estudiante(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public void mostrarInfo() {
        System.out.println("Estudiante: " + nombre + " [" + codigo + "]");
    }

    @Override
    public String toString() {
        return nombre + " (" + codigo + ")";
    }
}
