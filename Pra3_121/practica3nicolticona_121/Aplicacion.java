/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.practica3nicolticona_121;

import java.util.Scanner;

/**
 *
 * @author HP-RYZEN 5
 */
//Nicol Yanina Ticona Aduviri
//R.U: 1855987
public class Aplicacion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("-------------------- Juego de las adivinanzas --------------------");
        System.out.print("¿Con cuántas vidas quieres jugar? ");
        int vidas = sc.nextInt();

        JuegoAdivinaNumero juego = new JuegoAdivinaNumero(vidas);
        juego.juega();
        System.out.println("");
        System.out.println("-------------------- Juego de las adivinanzas --------------------");
        System.out.println("--------------------------- par e impar ---------------------------");
        JuegoAdivinaPar juego2 = new JuegoAdivinaPar(2);
        JuegoAdivinaImpar juego3 = new JuegoAdivinaImpar(3);

        System.out.println("\n============ Juego Adivina Número Par ============");
        juego2.juega();

        System.out.println("\n============ Juego Adivina Número Impar ============");
        juego3.juega();
    }

}
