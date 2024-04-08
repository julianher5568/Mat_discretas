package org.example;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Ingrese el número de elementos que serán analizados: ");
            //isNumeric(sc);
            int numElements = sc.nextInt();
            String[] elements = new String[numElements];
            int numSubconjuntos = (int) Math.pow(2, numElements);
            //System.out.println(numSubconjuntos);
            System.out.println("A continuación ingrese los elementos que desee: ");
            for (int i = 0; i < numElements; i++) {
                System.out.print(STR."Elemento \{i + 1}: ");
                elements[i] = sc.next();
            }
            System.out.println(STR."Conjunto principal: \{Arrays.toString(elements)}");
            System.out.println(STR."La cantidad de subconjuntos es: \{numSubconjuntos}");
            for (int i = 0; i < numSubconjuntos; i++) {
                System.out.print(STR."Subconjunto \{i + 1}: {");
                boolean conjuntoVacio = true;
                for (int j = 0; j < numElements; j++) {
                    if ((i & (1 << j)) > 0) {
                        System.out.print(STR."\{elements[j]} ");
                        conjuntoVacio = false;
                    }
                }
                if (conjuntoVacio) {
                    System.out.print("Ø");
                }
                System.out.println("}");
            }
            List<List<List<String>>> partitions = partitions(elements);
            int partitionCount = 0;
            for (List<List<String>> partitionSet : partitions) {
                partitionCount++;
                System.out.println(STR."Partición \{partitionCount}:");
                for (List<String> partition : partitionSet) {
                    System.out.println(partition);
                }
                System.out.println();
            }
            System.out.println(STR."Número total de particiones: \{partitionCount}");
        }
    }
    public static List<List<List<String>>> partitions(String[] elements) {
        List<List<List<String>>> result = new ArrayList<>();
        if (elements.length == 0) {
            return result;
        }
        List<List<String>> firstPartition = new ArrayList<>();
        firstPartition.add(new ArrayList<>());
        firstPartition.getFirst().add(elements[0]);
        result.add(firstPartition);
        for (int i = 1; i < elements.length; i++) {
            String currentElement = elements[i];
            List<List<List<String>>> newPartitions = new ArrayList<>();
            for (List<List<String>> partitionSet : result) {
                for (List<String> partition : partitionSet) {
                    List<String> newPartition = new ArrayList<>(partition);
                    newPartition.add(currentElement);
                    List<List<String>> newPartitionSet = new ArrayList<>(partitionSet);
                    newPartitionSet.remove(partition);
                    newPartitionSet.add(newPartition);
                    newPartitions.add(newPartitionSet);
                }
                List<String> newPartition = new ArrayList<>();
                newPartition.add(currentElement);
                partitionSet.add(newPartition);
                newPartitions.add(partitionSet);
            }
            result = newPartitions;
        }
        return result;
    }
}