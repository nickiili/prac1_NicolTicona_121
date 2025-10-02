/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.practica4nicolticona_121;

import java.util.Scanner;

/**
 *
 * @author HP-RYZEN 5
 */
//Nicol Yanina Ticona Aduviri
//R.u: 1855987
public class Aplicacion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Empleado[] empleados = new Empleado[5];

        System.out.println("======== Registro de 3 empleados a tiempo completo ========");
        for (int i = 0; i < 3; i++) {
            System.out.print("Nombre del empleado: ");
            String nombre = sc.next();
            System.out.print("Salario anual: ");
            double salarioAnual = sc.nextDouble();
            empleados[i] = new EmpleadoTiempoCompleto(nombre, salarioAnual);
        }

        System.out.println("\n======== Registro de 2 empleados por horas ========");
        for (int i = 3; i < 5; i++) {
            System.out.print("Nombre del empleado: ");
            String nombre = sc.next();
            System.out.print("Horas trabajadas: ");
            double horas = sc.nextDouble();
            System.out.print("Tarifa por hora: ");
            double tarifa = sc.nextDouble();
            empleados[i] = new EmpleadoTiempoHorario(nombre, horas, tarifa);
        }

        System.out.println("\n======== Lista de empleados y sus salarios mensuales ========");
        for (Empleado e : empleados) {
            System.out.println(e.getNombre() + " = Salario mensual: " + e.CalcularSalarioMensual());
        }
    }
}
