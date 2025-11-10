/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadebibliotecauniversitaria;

import java.util.ArrayList;

/**
 *
 * @author HP-RYZEN 5
 */

//Nicol Yanina Ticona Aduviri
//R.U: 1855987
import java.util.ArrayList;

public class Biblioteca {
    private String nombre;
    private ArrayList<Libro> libros;
    private ArrayList<Autor> autores;
    private ArrayList<Prestamo> prestamos;
    private Horario horario;

    public Biblioteca(String nombre, String dias, String horaApertura, String horaCierre) {
        this.nombre = nombre;
        this.horario = new Horario(dias, horaApertura, horaCierre);
        this.libros = new ArrayList<>();
        this.autores = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    public void agregarAutor(Autor autor) {
        autores.add(autor);
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }


    public void prestarLibro(Estudiante estudiante, Libro libro) {
        Prestamo p = new Prestamo(estudiante, libro);
        prestamos.add(p);
    }

    public void mostrarEstado() {
        System.out.println("=== ESTADO DE LA BIBLIOTECA: " + nombre + " ===");
        horario.mostrarHorario();

        System.out.println("\nAutores registrados:");
        for (Autor a : autores) {
            System.out.println(" - " + a);
        }

        System.out.println("\nLibros disponibles:");
        for (Libro l : libros) {
            System.out.println(" - " + l);
        }

        System.out.println("\nPréstamos activos:");
        for (Prestamo p : prestamos) {
            p.mostrarInfo();
        }
    }

    public void cerrarBiblioteca() {
        prestamos.clear();
        System.out.println("\nLa biblioteca ha cerrado. Todos los préstamos fueron eliminados.");
    }


    public class Horario {
        private String dias;
        private String horaApertura;
        private String horaCierre;

        public Horario(String dias, String horaApertura, String horaCierre) {
            this.dias = dias;
            this.horaApertura = horaApertura;
            this.horaCierre = horaCierre;
        }

        public void mostrarHorario() {
            System.out.println("Horario: " + dias + " (" + horaApertura + " - " + horaCierre + ")");
        }
    }
}

