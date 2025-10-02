/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.practicanicolticona_121_2;

import java.util.Random;

/**
 *
 * @author HP-RYZEN 5
 */
//Nicol Yanina Ticona Aduviri
//R.u: 1855987
public class Aplicacion {

    public static void main(String[] args) {
        Random rand = new Random();

        Figura[] figuras = new Figura[5];
        String[] colores = {"Rojo", "Azul", "Verde", "Amarillo", "Negro"};

        for (int i = 0; i < figuras.length; i++) {
            int tipo = rand.nextInt(2) + 1; // 1 = Cuadrado, 2 = Círculo
            String color = colores[rand.nextInt(colores.length)];

            if (tipo == 1) {
                double lado = 1 + rand.nextInt(10); // entre 1 y 10
                figuras[i] = new Cuadrado(lado, color);
            } else {
                double radio = 1 + rand.nextInt(10);
                figuras[i] = new Circulo(radio, color);
            }
        }

        // Mostrar resultados
        for (Figura f : figuras) {
            System.out.println(f);
            System.out.println("Área: " + f.area());
            System.out.println("Perímetro: " + f.perimetro());

            if (f instanceof Coloreado) {
                Coloreado c = (Coloreado) f;
                System.out.println("Cómo colorear: " + c.comoColorear());
            }

            System.out.println("=============================================");
        }
    }
}
