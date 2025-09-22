/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica3nicolticona_121;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author HP-RYZEN 5
 */
//Nicol Yanina Ticona Aduviri
//R.U: 1855987
public class JuegoAdivinaImpar extends JuegoAdivinaNumero {

    private int[] numerosImpares = {1, 3, 5, 7, 9};

    public JuegoAdivinaImpar(int numeroDeVidas) {
        super(numeroDeVidas);
    }

    @Override
    public boolean validaNumero(int numero) {
        if (!super.validaNumero(numero)) {
            return false;
        }
        if (numero % 2 != 0) {
            return true;
        } else {
            System.out.println("Error: El numero debe ser impar");
            return false;
        }
    }

    @Override
    public void juega() {
        reiniciaPartida();
        Random rm = new Random();
        numeroAAdivinar = numerosImpares[rm.nextInt(numerosImpares.length)];
        while (true) {
            System.out.print("Ingresa un numero IMPAR: ");
            Scanner sc = new Scanner(System.in);
            String entrada = sc.nextLine();

            if (!validaNumero(entrada)) {
                System.out.println("Error: Debe ser un numero IMPAR entre 0 y 10");
                continue;
            }
            int numero = Integer.parseInt(entrada);

            if (numero == numeroAAdivinar) {
                System.out.println("¡Acertaste!");
                actualizaRecord();
                break;
            } else {
                if (!quitaVida()) {
                    System.out.println("Te has quedado sin vidas. El numero era: " + numeroAAdivinar);
                    break;
                } else {
                    if (numero < numeroAAdivinar) {
                        System.out.println("El numero a adivinar es mayor");
                    } else {
                        System.out.println("El numero a adivinar es menor");
                    }
                }
            }
        }
    }
}
