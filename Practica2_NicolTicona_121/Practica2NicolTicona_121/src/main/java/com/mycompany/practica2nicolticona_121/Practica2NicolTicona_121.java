/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practica2nicolticona_121;

/**
 *
 * @author HP-RYZEN 5
 */
//Nicol Yanina Ticona Aduviri
//R.U:1855987
public class Practica2NicolTicona_121 {

    public static void main(String[] args) {
        double[] v1 = {5, 1, 1};
        double[] v2 = {-3, 5, 6};

        AlgebraVectorial av = new AlgebraVectorial(v1, v2);

        System.out.println("¿Perpendiculares (c)? " + av.esPerpendicular());
        System.out.println("¿Perpendiculares (a)? " + av.esPerpendicular("a"));
        System.out.println("¿Perpendiculares (d)? " + av.esPerpendicular("d"));
        System.out.println("¿Paralelos (f)? " + av.esParalela());
        System.out.println("¿Paralelos (e)? " + av.esParalela("e"));

        double[] proy = av.proyeccion();
        System.out.println("Proyección de a sobre b: (" + proy[0] + ", " + proy[1] + ", " + proy[2] + ")");
        System.out.println("Componente de a en b: " + av.componente());
        
        System.out.println("------------------------------------------------");
        Vector a = new Vector(8, 1, 4);
        Vector b = new Vector(3, 9, 2);

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        System.out.println("a + b = " + a.suma(b));
        System.out.println("2 * a = " + a.multiplicarPorEscalar(2));
        System.out.println("|a| = " + a.longitud());
        System.out.println("Normal de a = " + a.normalizar());
        System.out.println("a · b = " + a.productoEscalar(b));
        System.out.println("a × b = " + a.productoVectorial(b));
        
        System.out.println("------------------------------------------------");
        double[] v01 = {6, 1, 5};
        double[] v02 = {-4, -2, 2};

        Figura1 f1 = new Figura1(v01, v02);

        System.out.println("¿a es perpendicular a b ? " 
                            + f1.EsPerpendicularConDiagonales());
        
        System.out.println("-----------------------------------------------");
        double[] v001 = {3, 4, -1};  // vector a
        double[] v002 = {5, 2, 5};  // vector b

        Figura2 f2 = new Figura2(v1, v2);

        double[] proye = f2.proyeccion();
        double comp = f2.componente();

        System.out.println("Vector a = (3, 4, 0)");
        System.out.println("Vector b = (5, 0, 0)");
        System.out.println("Proyección de a sobre b: (" + proye[0] + ", " + proye[1] + ", " + proye[2] + ")");
        System.out.println("Componente de a en b: " + comp);
    }
}
