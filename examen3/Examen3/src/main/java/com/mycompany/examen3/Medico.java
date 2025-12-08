package com.mycompany.examen3;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author HP-RYZEN 5
 */
public class Medico {

    // Atributos del diagrama (NO AGREGAR MÁS)
    private int idMed;
    private String nombreMed;
    private String apellidoMed;
    private int aniosExperiencia;

    public Medico(int idMed, String nombreMed, String apellidoMed, int aniosExperiencia) {
        this.idMed = idMed;
        this.nombreMed = nombreMed;
        this.apellidoMed = apellidoMed;
        this.aniosExperiencia = aniosExperiencia;
    }

    // Constructor vacío necesario para GSON
    public Medico() {
    }

    // --- MÉTODOS DE PERSISTENCIA (Patrón del Profe) ---
    public void alta() {
        // Generamos ruta relativa
        String ruta = "ArchivoMedico/medico" + this.idMed + ".json";
        Gson gson = new Gson();
        try {
            // Aseguramos que la carpeta exista (truco para que no falle)
            new File("archivosMedicos").mkdirs();

            FileWriter w = new FileWriter(ruta);
            gson.toJson(this, w);
            w.close();
            System.out.println("Medico guardado: " + this.nombreMed);
        } catch (Exception e) {
            System.out.println("Error alta medico: " + e);
        }
    }

    public void baja() {
        String ruta = "ArchivoMedico/medico" + this.idMed + ".json";
        File archivo = new File(ruta);
        if (archivo.delete()) {
            System.out.println("Medico eliminado: " + this.idMed);
        } else {
            System.out.println("Error eliminando medico (¿Quizás no existe?)");
        }
    }

    public void cargar(String ruta) {
        Gson gson = new Gson();
        try {
            FileReader r = new FileReader(ruta);
            Medico aux = gson.fromJson(r, Medico.class);
            // Copiamos datos a this
            this.idMed = aux.getIdMed();
            this.nombreMed = aux.getNombreMed();
            this.apellidoMed = aux.getApellidoMed();
            this.aniosExperiencia = aux.getAniosExperiencia();
            r.close();
        } catch (Exception e) {
            System.out.println("Error cargar: " + e);
        }
    }

    // Getters necesarios para la lógica del Consultorio
    public int getIdMed() {
        return idMed;
    }

    public String getNombreMed() {
        return nombreMed;
    }

    public String getApellidoMed() {
        return apellidoMed;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }
}
