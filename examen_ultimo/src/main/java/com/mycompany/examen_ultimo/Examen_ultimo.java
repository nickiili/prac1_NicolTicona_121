/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.examen_ultimo;

import java.util.Scanner;

/**
 *
 * @author HP-RYZEN 5
 */
public class Examen_ultimo {

    public static void main(String[] args) {
        Consultorio c = new Consultorio("medicos.json", "consultas.json");
        Scanner sc = new Scanner(System.in);

        if(c.leerMedicos().isEmpty()) {
            c.altaMedico(new Medico(1,"Juan","Perez",5));
            c.altaMedico(new Medico(2,"Ana","Lopez",3));
            c.altaMedico(new Medico(3,"Luis","Gomez",7));
        }

        if(c.leerConsutas().isEmpty()) {
            c.altaConsulta(new Consulta(101,"Carlos","Diaz",1,25,"diciembre",2025));
            c.altaConsulta(new Consulta(102,"Maria","Diaz",1,10,"enero",2025));
            c.altaConsulta(new Consulta(103,"Pedro","Ramirez",1,15,"febrero",2025));

            c.altaConsulta(new Consulta(104,"Lucia","Perez",2,25,"diciembre",2025));
            c.altaConsulta(new Consulta(105,"Sofia","Lopez",2,5,"marzo",2025));
            c.altaConsulta(new Consulta(106,"Mateo","Gomez",2,31,"diciembre",2025));

            c.altaConsulta(new Consulta(107,"Valentina","Diaz",3,20,"abril",2025));
            c.altaConsulta(new Consulta(108,"Daniel","Lopez",3,25,"diciembre",2025));
            c.altaConsulta(new Consulta(109,"Camila","Gomez",3,15,"mayo",2025));
        }

        int opcion = -1;

        while(opcion != 0){
            System.out.println("\n--- MENÚ CONSULTORIO ---");
            System.out.println("1. Dar de alta médico");
            System.out.println("2. Dar de alta consulta");
            System.out.println("3. Dar de baja médico y sus consultas");
            System.out.println("4. Cambiar fecha de Navidad/Año Nuevo");
            System.out.println("5. Mostrar pacientes por día");
            System.out.println("0. Salir");
            System.out.print("Elija opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion){
                case 1:
                    System.out.print("ID Médico: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Nombre: "); String nombre = sc.nextLine();
                    System.out.print("Apellido: "); String apellido = sc.nextLine();
                    System.out.print("Años de experiencia: "); int exp = sc.nextInt(); sc.nextLine();
                    c.altaMedico(new Medico(id,nombre,apellido,exp));
                    break;

                case 2:
                    System.out.print("CI Paciente: "); int ci = sc.nextInt(); sc.nextLine();
                    System.out.print("Nombre Paciente: "); String nPac = sc.nextLine();
                    System.out.print("Apellido Paciente: "); String aPac = sc.nextLine();
                    System.out.print("ID Médico: "); int idMed = sc.nextInt(); sc.nextLine();
                    System.out.print("Día: "); int dia = sc.nextInt(); sc.nextLine();
                    System.out.print("Mes: "); String mes = sc.nextLine();
                    System.out.print("Año: "); int anio = sc.nextInt(); sc.nextLine();
                    c.altaConsulta(new Consulta(ci,nPac,aPac,idMed,dia,mes,anio));
                    break;

                case 3:
                    System.out.print("Nombre Médico a eliminar: "); String nBaja = sc.nextLine();
                    System.out.print("Apellido Médico a eliminar: "); String aBaja = sc.nextLine();
                    c.bajaMedico(nBaja,aBaja);
                    break;

                case 4:
                    System.out.print("Nuevo mes: "); String nuevoMes = sc.nextLine();
                    System.out.print("Nuevo día: "); int nuevoDia = sc.nextInt(); sc.nextLine();
                    c.cambia(nuevoMes,nuevoDia);
                    break;

                case 5:
                    System.out.print("Día: "); int diaM = sc.nextInt(); sc.nextLine();
                    System.out.print("Mes: "); String mesM = sc.nextLine();
                    c.mostrarPacientesPorDia(diaM,mesM);
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }
        }
        sc.close();
    
    }
}
