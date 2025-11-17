/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examen;

/**
 *
 * @author HP-RYZEN 5
 */
public class Cabina {

    private int nroCabina;
    private Persona[] personasAbordo;

    public Cabina(int nroCabina) {
        this.nroCabina = nroCabina;
        this.personasAbordo = new Persona[10]; // max 10 personas
    }

    public int getNroCabina() {
        return nroCabina;
    }

    public Persona[] getPersonasAbordo() {
        return personasAbordo;
    }

    public int getCantidadPersonas() {
        int c = 0;
        for (Persona p : personasAbordo) {
            if (p != null) {
                c++;
            }
        }
        return c;
    }

    public float getPesoTotal() {
        float total = 0;
        for (Persona p : personasAbordo) {
            if (p != null) {
                total += p.getPesoPersona();
            }
        }
        return total;
    }

    public boolean agregarPersona(Persona p) {
        if (getCantidadPersonas() == 10) {
            return false;
        }
        if (getPesoTotal() + p.getPesoPersona() > 850) {
            return false;
        }

        for (int i = 0; i < personasAbordo.length; i++) {
            if (personasAbordo[i] == null) {
                personasAbordo[i] = p;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Cabina " + nroCabina + " (" + getCantidadPersonas() + " personas)";
    }
}
