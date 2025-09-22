/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica3nicolticona_121;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author HP-RYZEN 5
 */
//Nicol Yanina Ticona Aduviri
//R.U: 1855987
public class JuegoAdivinaNumero extends Juego {

    protected int numeroAAdivinar;

    public JuegoAdivinaNumero(int numeroDeVidas) {
        super(numeroDeVidas);
    }

    public boolean validaNumero(int numero) {
        return numero >= 0 && numero <= 10;
    }

    public boolean validaNumero(String numeroStr) {
        try {
            int numero = Integer.parseInt(numeroStr);
            return validaNumero(numero);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void juega() {
        reiniciaPartida();
        Random rm = new Random();
        numeroAAdivinar = rm.nextInt(11); 
        
        System.out.println("************* Adivina un numero entre 0 y 10 *************");        
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Ingresa un numero: ");
            String entrada = sc.nextLine();
            
            if (!validaNumero(entrada)) {
                System.out.println("Error: Debe ser un numero entre 0 y 10");
                continue;
            }
            
            int numero = Integer.parseInt(entrada);
            
            if (numero == numeroAAdivinar) {
                System.out.println(" Acertaste!!");
                actualizaRecord();
                break;
            } else {
                if (!quitaVida()) {
                    System.out.println("Te quedaste sin vidas. El numero era: " + numeroAAdivinar);
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
