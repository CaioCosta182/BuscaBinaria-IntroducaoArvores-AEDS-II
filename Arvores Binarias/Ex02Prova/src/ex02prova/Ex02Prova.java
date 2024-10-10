/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex02prova;

/**
 *
 * @author caiocosta
 */
public class Ex02Prova {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
public class ElementFrequency {

    // Busca pela primeira ocorrência de N
    public static int findFirstOccurrence(int[] V, int N) {
        int left = 0, right = V.length - 1;
        int firstOccurrence = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (V[mid] == N) {
                firstOccurrence = mid;
                right = mid - 1; // Continue procurando à esquerda
            } else if (V[mid] < N) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return firstOccurrence;
    }

    // Busca pela última ocorrência de N
    public static int findLastOccurrence(int[] V, int N) {
        int left = 0, right = V.length - 1;
        int lastOccurrence = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (V[mid] == N) {
                lastOccurrence = mid;
                left = mid + 1; // Continue procurando à direita
            } else if (V[mid] < N) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return lastOccurrence;
    }

    public static int countOccurrences(int[] V, int N) {
        int first = findFirstOccurrence(V, N);
        if (first == -1) {
            return 0; // N não está presente no vetor
        }

        int last = findLastOccurrence(V, N);
        return last - first + 1;
    }

    public static void main(String[] args) {
        int[] V = {1, 2, 2, 2, 3, 4, 5, 5, 5, 5, 6, 7}; // Exemplo de vetor ordenado
        int N = 5;

        int occurrences = countOccurrences(V, N);
        System.out.println("O elemento " + N + " aparece " + occurrences + " vezes no vetor.");
    }
}
