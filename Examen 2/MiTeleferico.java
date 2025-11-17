/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examen;

/**
 *
 * @author HP-RYZEN 5
 */
public class MiTeleferico {

    Linea[] lineas;
    float cantidadIngresos;

    public MiTeleferico() {
        lineas = new Linea[3];
        cantidadIngresos = 0;
    }

    public void agregarLinea(Linea l, int pos) {
        lineas[pos] = l;
    }

    public void agregarPersonaFila(Persona p, String linea) {
        for (Linea l : lineas) {
            if (l != null && l.getColor().equalsIgnoreCase(linea)) {
                l.agregarPersona(p);
            }
        }
    }

    public void agregarCabina(String linea) {
        for (Linea l : lineas) {
            if (l != null && l.getColor().equalsIgnoreCase(linea)) {
                l.agregarCabina(l.getCantidadCabinas() + 1);
            }
        }
    }

    // a) AGREGAR PRIMERA PERSONA A LA CABINA nroX
    public boolean agregarPrimeraPersonaCabina(String linea, int nroCabina) {
        for (Linea l : lineas) {
            if (l != null && l.getColor().equalsIgnoreCase(linea)) {

                Persona p = l.sacarPrimeraPersona();
                if (p == null) {
                    return false;
                }

                for (int i = 0; i < l.getCantidadCabinas(); i++) {
                    Cabina c = l.getCabinas()[i];

                    if (c.getNroCabina() == nroCabina) {
                        return c.agregarPersona(p);
                    }
                }
            }
        }
        return false;
    }

    // b) VERIFICAR TODAS LAS CABINAS
    public void verificarCabinas() {
        for (Linea l : lineas) {
            if (l != null) {
                for (int i = 0; i < l.getCantidadCabinas(); i++) {
                    Cabina c = l.getCabinas()[i];

                    if (c.getCantidadPersonas() > 10 || c.getPesoTotal() > 850) {
                        System.out.println("Cabina " + c.getNroCabina() + " de " + l.getColor() + " NO cumple reglas");
                    } else {
                        System.out.println("Cabina " + c.getNroCabina() + " de " + l.getColor() + " OK");
                    }
                }
            }
        }
    }

    // c) CALCULAR INGRESO TOTAL
    public float calcularIngresos() {
        cantidadIngresos = 0;

        for (Linea l : lineas) {
            if (l != null) {
                for (int i = 0; i < l.getCantidadCabinas(); i++) {
                    Cabina c = l.getCabinas()[i];

                    for (Persona p : c.getPersonasAbordo()) {
                        if (p != null) {
                            if (p.getEdad() < 26 || p.getEdad() > 60) {
                                cantidadIngresos += 1.5f;
                            } else {
                                cantidadIngresos += 3f;
                            }
                        }
                    }
                }
            }
        }
        return cantidadIngresos;
    }

    // d) LÍNEA CON MÁS INGRESO REGULAR (solo entre 26 y 60)
    public void lineaConMasIngresoRegular() {
        String mejor = "";
        float max = 0;

        for (Linea l : lineas) {
            if (l != null) {
                float total = 0;

                for (int i = 0; i < l.getCantidadCabinas(); i++) {
                    Cabina c = l.getCabinas()[i];

                    for (Persona p : c.getPersonasAbordo()) {
                        if (p != null && p.getEdad() >= 26 && p.getEdad() <= 60) {
                            total += 3;
                        }
                    }
                }

                if (total > max) {
                    max = total;
                    mejor = l.getColor();
                }
            }
        }

        System.out.println("Línea con mayor ingreso regular: " + mejor);
    }

    // EXTRA: MOSTRAR TODO
    public void mostrar() {
        System.out.println("========== MI TELEFÉRICO ==========");

        for (Linea l : lineas) {
            if (l != null) {
                System.out.println("\nLínea " + l.getColor());
                System.out.println("Cabinas:");

                for (int i = 0; i < l.getCantidadCabinas(); i++) {
                    Cabina c = l.getCabinas()[i];
                    System.out.println("  " + c);

                    for (Persona p : c.getPersonasAbordo()) {
                        if (p != null) {
                            System.out.println("    - " + p);
                        }
                    }
                }

                System.out.println("Fila:");
                for (int i = 0; i < l.getCantidadFila(); i++) {
                    System.out.println("   * " + l.getFilaPersonas()[i]);
                }
            }
        }

        System.out.println("\nIngresos totales: " + calcularIngresos() + " Bs");
    }
}
