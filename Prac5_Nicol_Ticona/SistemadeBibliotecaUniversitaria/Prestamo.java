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
import java.time.LocalDate;

public class Prestamo {

    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private Estudiante estudiante;
    private Libro libro;

    public Prestamo(Estudiante estudiante, Libro libro) {
        this.estudiante = estudiante;
        this.libro = libro;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = fechaPrestamo.plusDays(7);
    }

    public void mostrarInfo() {
        System.out.println("Préstamo:");
        System.out.println("  Libro: " + libro);
        System.out.println("  Estudiante: " + estudiante);
        System.out.println("  Fecha préstamo: " + fechaPrestamo);
        System.out.println("  Fecha devolución: " + fechaDevolucion);
    }
}
