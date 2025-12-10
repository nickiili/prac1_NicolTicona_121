/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examen_ultimo;

/**
 *
 * @author HP-RYZEN 5
 */



public class Consulta {

    private int ci;
    private String nomPaciente;
    private String ApPaciente;
    private int idMed;
    private int dia;
    private String mes;
    private int anio;

    public Consulta(int ci, String nomPaciente, String ApPaciente, int idMed, int dia, String mes, int anio) {
        this.ci = ci;
        this.nomPaciente = nomPaciente;
        this.ApPaciente = ApPaciente;
        this.idMed = idMed;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public Consulta() {
    }

    public int getCi() {
        return ci;
    }

    public String getNomPaciente() {
        return nomPaciente;
    }

    public String getApPaciente() {
        return ApPaciente;
    }

    public int getIdMed() {
        return idMed;
    }

    public int getDia() {
        return dia;
    }

    public String getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public void setNomPaciente(String nomPaciente) {
        this.nomPaciente = nomPaciente;
    }

    public void setApPaciente(String ApPaciente) {
        this.ApPaciente = ApPaciente;
    }

    public void setIdMed(int idMed) {
        this.idMed = idMed;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "Consulta{" + "ci=" + ci + ", nomPaciente=" + nomPaciente
                + ", ApPaciente=" + ApPaciente + ", idMed=" + idMed
                + ", dia=" + dia + ", mes=" + mes + ", anio=" + anio + '}';
    }
}
