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
public class JuegoAdivinaPar extends JuegoAdivinaNumero {

    private int[] numerosPares = {0, 2, 4, 6, 8};

    public JuegoAdivinaPar(int numeroDeVidas) {
        super(numeroDeVidas);
    }

    @Override
    public boolean validaNumero(int numero) {
        if (!super.validaNumero(numero)) {
            return false;
        }
        if (numero % 2 == 0) {
            return true;
        } else {
            System.out.println("Error: El numero debe ser par");
            return false;
        }
    }

    @Override
    public void juega() {
        reiniciaPartida();
        Random rm = new Random();
        numeroAAdivinar = numerosPares[rm.nextInt(numerosPares.length)];
        System.out.println("************* Adivina un numero entre 0 y 10 *************");
        while (true) {
            System.out.print("Ingresa un numero PAR: ");
            Scanner sc = new Scanner(System.in);
            String entrada = sc.nextLine();

            if (!validaNumero(entrada)) {
                System.out.println("Error: Debe ser un numero PAR entre 0 y 10");
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
