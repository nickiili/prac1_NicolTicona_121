/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examen_ultimo;

/**
 *
 * @author HP-RYZEN 5
 */


public class Medico {

    private int idMedico;
    private String NombreMed;
    private String Apmedico;
    private int aniosExp;

    public Medico(int idMedico, String NombreMed, String Apmedico, int aniosExp) {
        this.idMedico = idMedico;
        this.NombreMed = NombreMed;
        this.Apmedico = Apmedico;
        this.aniosExp = aniosExp;
    }

    public Medico() {
    }

    public int getIdMedico() {
        return idMedico;
    }

    public String getNombreMed() {
        return NombreMed;
    }

    public String getApmedico() {
        return Apmedico;
    }

    public int getAniosExp() {
        return aniosExp;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public void setNombreMed(String NombreMed) {
        this.NombreMed = NombreMed;
    }

    public void setApmedico(String Apmedico) {
        this.Apmedico = Apmedico;
    }

    public void setAniosExp(int aniosExp) {
        this.aniosExp = aniosExp;
    }

    @Override
    public String toString() {
        return "Medico{" + "idMedico=" + idMedico + ", NombreMed=" + NombreMed
                + ", Apmedico=" + Apmedico + ", aniosExp=" + aniosExp + '}';
    }
}
