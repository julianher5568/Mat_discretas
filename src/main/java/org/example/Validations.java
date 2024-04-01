package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Validations {

    public static boolean isNumeric(Scanner scanner){
        try {
            while (!scanner.hasNextInt()) {
                System.out.println("No ha ingresado un número entero. Por favor, inténtelo de nuevo:");
                scanner.next();
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

/*    public static ArrayList<String> getArray(ArrayList<String> conjunto, int numElements){
        try {
            Scanner scanner = new Scanner(System.in);
            boolean hayrepetido = false;

            while (!hayrepetido){
                hayrepetido = repetido(conjunto);
                if (hayrepetido) {
                    System.out.println("Hay elementos repetidos");
                    System.out.println("Ingrese nuevamente todos los elementos del conjunto.");
                    for (int i = 0; i < numElements; i++) {
                        System.out.print("Elemento " + (i+1) + ": ");
                        conjunto.add(i, scanner.next());
                        }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return conjunto;
    }

    public static boolean repetido(ArrayList<String> array){
        for (int i = 0; i < array.size(); i++) {
            for (int j = 1; j < array.size(); j++) {
                if (array.get(i).equals(array.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }*/
}