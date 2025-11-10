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
import java.util.ArrayList;

public class Libro {

    private String titulo;
    private String isbn;
    private ArrayList<Pagina> paginas;

    public Libro(String titulo, String isbn) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.paginas = new ArrayList<>();
    }

    public void agregarPagina(int numero, String contenido) {
        paginas.add(new Pagina(numero, contenido));
    }

    public void leer() {
        System.out.println("\nLeyendo \"" + titulo + "\":");
        for (Pagina p : paginas) {
            p.mostrarPagina();
        }
    }

    @Override
    public String toString() {
        return titulo + " (ISBN: " + isbn + ")";
    }

    // Clase interna Pagina
    public class Pagina {

        private int numero;
        private String contenido;

        public Pagina(int numero, String contenido) {
            this.numero = numero;
            this.contenido = contenido;
        }

        public void mostrarPagina() {
            System.out.println("Página " + numero + ": " + contenido);
        }
    }
}
