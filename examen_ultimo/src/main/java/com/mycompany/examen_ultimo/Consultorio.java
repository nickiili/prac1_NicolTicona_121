/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examen_ultimo;

/**
 *
 * @author HP-RYZEN 5
 */

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Consultorio {
    private String medicos;
    private String consultas;

    public Consultorio(String med, String con) {
        this.medicos = med;
        this.consultas = con;

        try {
            File f = new File(this.medicos);
            if(!f.exists()) {
                try(FileWriter nuevo = new FileWriter(this.medicos)) {
                    new Gson().toJson(new ArrayList<Medico>(), nuevo);
                }
            }
        } catch(Exception e) { System.out.println(e); }

        try {
            File f2 = new File(this.consultas);
            if(!f2.exists()) {
                try(FileWriter nuevo2 = new FileWriter(this.consultas)) {
                    new Gson().toJson(new ArrayList<Consulta>(), nuevo2);
                }
            }
        } catch(Exception e) { System.out.println(e); }
    }

    public List<Medico> leerMedicos(){
        try {
            File arch = new File(this.medicos);
            if (!arch.exists()) return new ArrayList<>();
            Type lista = new TypeToken<List<Medico>>() {}.getType();
            List<Medico> resultado = new Gson().fromJson(new FileReader(this.medicos), lista);
            return resultado != null ? resultado : new ArrayList<>();
        } catch(Exception e) { System.out.println(e); return new ArrayList<>(); }
    }

    public List<Consulta> leerConsutas(){
        try {
            File arch = new File(this.consultas);
            if (!arch.exists()) return new ArrayList<>();
            Type lista = new TypeToken<List<Consulta>>() {}.getType();
            List<Consulta> resultado = new Gson().fromJson(new FileReader(this.consultas), lista);
            return resultado != null ? resultado : new ArrayList<>();
        } catch(Exception e) { System.out.println(e); return new ArrayList<>(); }
    }

    public void modificarM(List<Medico> lista){
        try(FileWriter escritor = new FileWriter(this.medicos)) {
            new Gson().toJson(lista, escritor);
        } catch(Exception e) { System.out.println(e); }
    }

    public void modificarC(List<Consulta> lista){
        try(FileWriter escritor = new FileWriter(this.consultas)) {
            new Gson().toJson(lista, escritor);
        } catch(Exception e) { System.out.println(e); }
    }

    public void altaMedico(Medico m){
        List<Medico> todas = this.leerMedicos();
        todas.add(m);
        this.modificarM(todas);
        System.out.println("Médico agregado con éxito");
    }

    public void altaConsulta(Consulta c){
        List<Consulta> todas = this.leerConsutas();
        todas.add(c);
        this.modificarC(todas);
        System.out.println("Consulta agregada con éxito");
    }

    public void bajaMedico(String nombre, String apellido){
        List<Medico> medicos = this.leerMedicos();
        List<Consulta> consultas = this.leerConsutas();

        Medico eliminado = null;
        for(Medico m : medicos) {
            if(m.getNombreMed().equals(nombre) && m.getApmedico().equals(apellido)) {
                eliminado = m;
                break;
            }
        }

        if(eliminado != null){
            medicos.remove(eliminado);

            List<Consulta> nuevas = new ArrayList<>();
            for(Consulta c : consultas){
                if(c.getIdMed() != eliminado.getIdMedico()){
                    nuevas.add(c);
                }
            }

            this.modificarM(medicos);
            this.modificarC(nuevas);

            System.out.println("Médico y sus consultas eliminadas.");
        } else {
            System.out.println("Médico no encontrado.");
        }
    }

    public void cambia(String m, int d){
        List<Consulta> consultas = this.leerConsutas();
        for(Consulta c : consultas){
            if ((c.getDia() == 25 || c.getDia() == 31) && c.getMes().equals("diciembre")){
                c.setDia(d);
                c.setMes(m);
            }
        }
        this.modificarC(consultas);
        System.out.println("Fechas de consultas modificadas");
    }

    public void mostrarPacientesPorDia(int dia, String mes){
        List<Consulta> consultas = this.leerConsutas();
        System.out.println("Pacientes del " + dia + " de " + mes + ":");
        for(Consulta c : consultas){
            if(c.getDia() == dia && c.getMes().equalsIgnoreCase(mes)){
                System.out.println(c.getNomPaciente() + " " + c.getApPaciente());
            }
        }
    }
}