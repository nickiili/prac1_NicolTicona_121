/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemadebibliotecauniversitaria;

/**
 *
 * @author HP-RYZEN 5
 */



//Nicol Yanina Ticona Aduviri
//R.U: 1855987
public class SistemadeBibliotecaUniversitaria {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca("Biblioteca Central UMSA", "Lunes a Viernes", "08:00", "18:00");

        // Agregación: Autores
        Autor autor1 = new Autor("Gabriel García Márquez", "Colombiano");
        Autor autor2 = new Autor("Julio Cortázar", "Argentino");
        biblioteca.agregarAutor(autor1);
        biblioteca.agregarAutor(autor2);

        // Agregación: Libros
        Libro libro1 = new Libro("Cien Años de Soledad", "978-84-376-0494-7");
        libro1.agregarPagina(1, "Muchos años después, frente al pelotón de fusilamiento...");
        libro1.agregarPagina(2, "El coronel Aureliano Buendía había de recordar...");

        Libro libro2 = new Libro("Rayuela", "978-84-376-0494-8");
        libro2.agregarPagina(1, "Encontraría a la Maga en el Pont des Arts...");
        libro2.agregarPagina(2, "Pero no, la Maga no estaba.");

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);

        // Asociación: Préstamos entre Estudiante y Libro
        Estudiante estudiante1 = new Estudiante("202501", "Ana Pérez");
        Estudiante estudiante2 = new Estudiante("202502", "Luis Fernández");

        biblioteca.prestarLibro(estudiante1, libro1);
        biblioteca.prestarLibro(estudiante2, libro2);

        // Mostrar estado general
        biblioteca.mostrarEstado();

        // Composición (leer libro con sus páginas)
        libro1.leer();

        // Cerrar biblioteca
        biblioteca.cerrarBiblioteca();
    }
}
