/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea;

import datos.Asiento;
import datos.Avion;
import datos.Pasajero;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Version usando la consola
 *
 * @author JJSC
 */
public class AerolineaConsola {

    public static void main(String[] args) throws IOException {
        Avion avion;
        Pasajero pasajero;
        Asiento asiento;
        List<Asiento> asientos;
        List<Pasajero> pasajeros;

        String categoria, ubicacion;
        String nombre, identificacion, fechaNac;

        String continuar;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        /**
         * Inicializamos todas los objetos locales
         */
        avion = new Avion();
        asientos = new ArrayList();
        pasajeros = new ArrayList();

        /**
         * Ciclo principal
         */
        while (true) {
            /**
             * Bloque de pregunta de categoria
             */
            do {
                System.out.println("-- Categoria --");
                System.out.println("1. PRIMERA CLASE");
                System.out.println("2. CLASE ECONOMICA");
                System.out.print("Diga la categoria clase (2): ");
                categoria = br.readLine();

                categoria = categoria.trim();

                if ((categoria == null) || categoria.isEmpty()) {
                    categoria = "2";
                }

                if (categoria.equals("1") || categoria.equals("2")) {
                    break;
                }
            } while (true);
            System.out.println();

            switch (categoria.charAt(0)) {
                case '1':
                    categoria = "PRIMERA CLASE";
                    break;
                case '2':
                    categoria = "CLASE ECONOMICA";
                    break;
            }

            /**
             * Bloque de pregunta de ubicacion
             */
            do {
                System.out.println("-- Asiento --");
                System.out.println("V. VENTANA");
                System.out.println("P. PASILLO");
                System.out.print("Diga la ubicacion (V): ");
                ubicacion = br.readLine();

                if ((ubicacion == null) || ubicacion.isEmpty()) {
                    ubicacion = "V";
                }

                ubicacion = ubicacion.trim().toUpperCase();

                if (ubicacion.equals("V") || ubicacion.equals("P")) {
                    break;
                }
            } while (true);
            System.out.println();

            switch (ubicacion.charAt(0)) {
                case 'V':
                    ubicacion = "VENTANA";
                    break;
                case 'P':
                    ubicacion = "PASILLO";
                    break;
            }

            /**
             * Confirmacion de los dos bloques primarios de pregunta
             */
            do {
                System.out.println("-----------------------------------");
                System.out.println("Categoria: " + categoria);
                System.out.println("Ubicacion: " + ubicacion);
                System.out.print("¿ Datos correctos ? (S)i (N)o (A)bortar: ");
                continuar = br.readLine();
                continuar = continuar.trim().toUpperCase();
                if ((continuar.charAt(0) == 'S') || (continuar.charAt(0) == 'N')) {
                    break;
                }
                if (continuar.charAt(0) == 'A') {
                    System.out.println("Terminado");
                    System.exit(0);
                }
            } while (true);

            if (continuar.charAt(0) == 'N') {
                System.out.println();
                continue;
            }
            System.out.println();

            /**
             * Datos del pasajero
             */
            do {
                System.out.println("-- Pasajero --");
                System.out.print("Nombre: ");
                nombre = br.readLine();
                System.out.print("Identificacion: ");
                identificacion = br.readLine();
                System.out.print("Fecha Nacimiento (dd/MM/yyyy): ");
                fechaNac = br.readLine();
                System.out.print("¿ Datos correctos ? (S)i (N)o (A)bortar: ");
                continuar = br.readLine();
                continuar = continuar.trim().toUpperCase();
                if (continuar.charAt(0) == 'S') {
                    break;
                }
                if (continuar.charAt(0) == 'N') {
                    System.out.println("\n");
                    continue;
                }
                if (continuar.charAt(0) == 'A') {
                    System.out.println("Terminado");
                    System.exit(0);
                }
            } while (true);
            System.out.println();

            /**
             * Crea el objeto pasajero
             */
            pasajero = new Pasajero(nombre, identificacion, fechaNac);
            
            
            /**
             * Reservar el asiento para el pasajero y brindar alternativas 
             * si una categoria y/o seccion estan llenas.
             * 
             * Chequea validez del asiento y que no haya repeticion del pasajero
             * dado por su identificacion.
             */
            boolean cicloUbicacion = true;
            boolean cicloCategoria = false;
            int contador = 1;
            do {
                if (contador == 4) {
                    System.out.println("El proximo vuelo sale en X horas");
                    break;
                }
                asientos.clear();
                asientos = avion.getAsientosDisponibles(categoria, ubicacion);
                if (asientos.size() == 0) {
                    System.out.println("No hay asientos en " + categoria + " con ubicacion " + ubicacion);
                    System.out.print("¿ Desea ver otras alternativas (S)i (N)o (A)bortar: ");
                    continuar = br.readLine();
                    continuar = continuar.trim().toUpperCase();

                    if (continuar.charAt(0) == 'N') {
                        System.out.println();
                        break;
                    }
                    if (continuar.charAt(0) == 'A') {
                        System.out.println("Terminado");
                        System.exit(0);
                    }

                    if (continuar.charAt(0) == 'S') {
                        if (cicloUbicacion) {
                            if (ubicacion.equals("VENTANA")) {
                                ubicacion = "PASILLO";
                            } else {
                                ubicacion = "VENTANA";
                            }
                        }
                        if (cicloCategoria) {
                            if (categoria.equals("PRIMERA CLASE")) {
                                categoria = "CLASE ECONOMICA";
                            } else {
                                categoria = "PRIMERA CLASE";
                            }
                        }
                        contador++;
                        switch (contador) {
                            case 2:
                                cicloCategoria = true;
                                cicloUbicacion = false;
                            case 3:
                                cicloCategoria = false;
                                cicloUbicacion = true;
                        }
                        System.out.println();
                    }
                } else {
                    asiento = asientos.get(0);
                    try {
                        avion.reservaAsiento(asiento, pasajero);
                    } catch (Error e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                }
            } while (true);
            System.out.println();

            /**
             * Bloque final de opciones 
             */
            do {
                System.out.print("Opciones de pasajeros (N)uevo (L)istar (E)stadistica (A)bortar: ");
                continuar = br.readLine();
                continuar = continuar.trim().toUpperCase();

                if (continuar.charAt(0) == 'N') {
                    System.out.println();
                    break;
                }
                
                if (continuar.charAt(0) == 'L') {
                    Map asientosAvion = avion.getAsientos(); 
                    for (Iterator<Asiento> it = asientosAvion.keySet().iterator(); it.hasNext(); ) {
                        asiento = it.next();
                        pasajero = (Pasajero)asientosAvion.get(asiento);
                        if (pasajero != null) {
                            System.out.println(asiento+" "+pasajero);
                        }
                    }
                }

                if (continuar.charAt(0) == 'E') {
                    System.out.println(avion.getEstadisticaPasajeros());
                }

                if (continuar.charAt(0) == 'A') {
                    System.out.println("Terminado");
                    System.exit(0);
                }
                System.out.println();
            } while (true);
        }
    }
}
