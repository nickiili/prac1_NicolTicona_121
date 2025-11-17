/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.examen;

/**
 *
 * @author HP-RYZEN 5
 */
public class Examen {

    public static void main(String[] args) {
        MiTeleferico t = new MiTeleferico();

        // Crear líneas
        
        t.agregarLinea(new Linea("Amarillo"), 0);
        t.agregarLinea(new Linea("Rojo"), 1);
        t.agregarLinea(new Linea("Verde"), 2);

        // Cabinas
        
        t.agregarCabina("Amarillo");
        t.agregarCabina("Amarillo");
        t.agregarCabina("Rojo");
        t.agregarCabina("Verde");

        // Personas
        
        t.agregarPersonaFila(new Persona("Ana", 20, 55), "Amarillo");
        t.agregarPersonaFila(new Persona("Luis", 30, 70), "Amarillo");
        t.agregarPersonaFila(new Persona("Marta", 65, 60), "Rojo");
        t.agregarPersonaFila(new Persona("Pedro", 40, 80), "Verde");

        // Subir personas a cabinas
        
        t.agregarPrimeraPersonaCabina("Amarillo", 1);
        t.agregarPrimeraPersonaCabina("Amarillo", 2);
        t.agregarPrimeraPersonaCabina("Rojo", 1);
        t.agregarPrimeraPersonaCabina("Verde", 1);

        // Verificar cabinas
        System.out.println("==========  verificar cabinas ==========");
        t.verificarCabinas();

        // Mostrar estado completo
        System.out.println("========== Mostrar estado completo ==========");
        t.mostrar();

        // Línea con más ingreso regular
        System.out.println("========== Línea con más ingreso regular ==========");
        t.lineaConMasIngresoRegular();

    }
}
