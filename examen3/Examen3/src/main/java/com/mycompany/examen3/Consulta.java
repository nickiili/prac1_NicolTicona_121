package com.mycompany.examen3;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author HP-RYZEN 5
 */
public class Consulta {

    private int ci;
    private String nombrePaciente;
    private String apellidoPaciente;
    private int idMed;
    private int dia, mes, anio; // Ojo: diagrama dice mes:String, pero abajo dice int. Usaré int por lógica o String si prefieres. Asumo String según diagrama.
    private String mesStr; // Ajuste: El diagrama dice "mes:String"

    public Consulta(int ci, String nombre, String apellido, int idMed, int dia, String mes, int anio) {
        this.ci = ci;
        this.nombrePaciente = nombre;
        this.apellidoPaciente = apellido;
        this.idMed = idMed;
        this.dia = dia;
        this.mesStr = mes;
        this.anio =…
[9:42 a. m.
        , 8/12/2025] April U: package programa;
        import java.io.File;
        import java.util.ArrayList;



    

    public class Consultorio {

        private String consultas; // Ruta carpeta consultas
        private String medicos;   // Ruta carpeta medicos

        public Consultorio(String consultas, String medicos) {
            this.consultas = consultas;
            this.medicos = medicos;
        }

        // Helpers para cargar listas (Igual a Tienda.java)
        public ArrayList<Medico> cargarMedicos() {
            ArrayList<Medico> lista = new ArrayList<>();
            File folder = new File(medicos);
            if (folder.listFiles() != null) {
                for (File f : folder.listFiles()) {
                    if (f.getName().endsWith(".json")) {
                        Medico m = new Medico();
                        m.cargar(f.getPath());
                        lista.add(m);
                    }
                }
            }
            return lista;
        }

        public ArrayList<Consulta> cargarConsultas() {
            ArrayList<Consulta> lista = new ArrayList<>();
            File folder = new File(consultas);
            if (folder.listFiles() != null) {
                for (File f : folder.listFiles()) {
                    if (f.getName().endsWith(".json")) {
                        Consulta c = new Consulta();
                        c.cargar(f.getPath());
                        lista.add(c);
                    }
                }
            }
            return lista;
        }

        // --- INCISO B: BAJA POR NOMBRE Y SUS CONSULTAS ---
        public void darBajaMedico(String nombreX, String apellidoY) {
            ArrayList<Medico> listaMedicos = cargarMedicos();
            int idEncontrado = -1;

            // 1. Buscar al médico
            for (Medico m : listaMedicos) {
                if (m.getNombreMed().equals(nombreX) && m.getApellidoMed().equals(apellidoY)) {
                    idEncontrado = m.getIdMed();
                    m.baja(); // Elimina el archivo del médico
                    System.out.println(">> Medico encontrado y eliminado.");
                    break;
                }
            }

            // 2. Eliminación en Cascada (Sus consultas)
            if (idEncontrado != -1) {
                ArrayList<Consulta> listaConsultas = cargarConsultas();
                for (Consulta c : listaConsultas) {
                    if (c.getIdMed() == idEncontrado) {
                        c.baja(); // Elimina el archivo de la consulta
                        System.out.println(">> Consulta asociada eliminada.");
                    }
                }
            } else {
                System.out.println("Medico no encontrado.");
            }
        }

        // --- INCISO C: CAMBIAR NAVIDAD A AÑO NUEVO ---
        public void cambiarNavidad() {
            ArrayList<Consulta> lista = cargarConsultas();
            for (Consulta c : lista) {
                // Verifica si es 25 de Diciembre
                if (c.getDia() == 25 && c.getMes().equalsIgnoreCase("Diciembre")) {
                    // Actualizar en memoria
                    c.setDia(1);
                    c.setMes("Enero");
                    c.setAnio(c.anio + 1); // Pasamos al siguiente año (lógica opcional pero correcta)

                    // Persistir el cambio (Sobreescribe el archivo)
                    c.alta();
                    System.out.println(">> Fecha de consulta actualizada para Año Nuevo.");
                }
            }
        }

    }
