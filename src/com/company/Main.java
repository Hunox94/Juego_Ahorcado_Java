package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        // Declaramos las variables.
        String palabras[] = {"AMOR", "BAJO", "GIRO", "HUMANO", "IDEA", "JOVEN", "LABOR", "MIRAR", "NUEVO", "OLOR", "POCO", "QUERER", "RUTA"};
        String pista1[] = {"Cariño", "Pequeño", "Rotación", "Hombre" , "Imagen", "Adolescente", "Faena", "Ver", "Reciente", "Fragancia", "Escaso", "Amar", "Itinerario"};
        Random random = new Random();
        int palabraAleatoria = random.nextInt(palabras.length);
        String palabra = palabras[palabraAleatoria];
        char letras[] = new char[palabra.length()];
        int fallos = 0;
        int pistasUsadas = 0;
        boolean acertada = false;
        Scanner scanner = new Scanner(System.in);

        // Inicializar letras con guiones
        for (int i = 0; i < letras.length; i++) {
            letras[i] = '-';
        }

        // Juego
        while (!acertada && fallos < 10) {
            // Mostrar barras separadas por guiones
            for (int i = 0; i < letras.length; i++) {
                System.out.print(letras[i] + " - ");
            }
            System.out.println();

            // Mostrar menú
            System.out.println("1. Comprobar letra");
            System.out.println("2. Pedir pista");
            System.out.println("3. Resumen resultados");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Comprobar letra
                    System.out.print("Introduce una letra: ");
                    char letra = scanner.next().charAt(0);
                    boolean repetida = false;
                    for (int i = 0; i < letras.length; i++) {
                        if (letra == letras[i]) {
                            repetida = true;
                            break;
                        }
                    }

                    if (repetida) {
                        System.out.println("Letra repetida");
                    } else {
                        boolean encontrada = false;
                        for (int i = 0; i < palabra.length(); i++) {
                            if (letra == palabra.charAt(i)) {
                                letras[i] = letra;
                                encontrada = true;
                            }
                        }

                        if (!encontrada) {
                            fallos++;
                            System.out.println("Letra no encontrada");
                        } else {
                            // Comprobar si se ha acertado la palabra
                            acertada = true;
                            for (int i = 0; i < letras.length; i++) {
                                if (letras[i] == '-') {
                                    acertada = false;
                                    break;
                                }
                            }
                        }
                    }
                    break;
                case 2:
                    // Pedir pista
                    if (pistasUsadas < 3) {
                        System.out.println(pista1[palabraAleatoria]);
                        pistasUsadas++;
                    } else {
                        System.out.println("Ya no puedes pedir más pistas");
                    }
                    break;
                case 3:
                    // Resumen resultados
                    System.out.println("Fallos: " + fallos);
                    System.out.println("Pistas usadas: " + pistasUsadas);
                    break;
            }
        }
        // Mostrar resultado final
        if (acertada) {
            System.out.println("Felicidades, has acertado la palabra!");
        } else if (fallos >= 10) {
            System.out.println("Lo siento, has fallado 10 veces. La palabra era " + palabra);
        }
    }
    }


