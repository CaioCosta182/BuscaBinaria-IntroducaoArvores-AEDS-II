package buscabinaria;

public class BuscaBinaria {

    public static int binarySearch(int[] vetor, int target) {
        int esquerda = 0;
        int direita = vetor.length - 1;

        while (esquerda <= direita) {
            int mid = esquerda + (direita - esquerda) / 2;

            // Verifica se o elemento está presente no meio
            if (vetor[mid] == target) {
                return mid;
            }

            // Se o elemento estiver na metade esquerda do array
            if (vetor[mid] < target) {
                esquerda = mid + 1;
            } // Se o elemento estiver na metade direita do array
            else {
                direita = mid - 1;
            }
        }

        // Se o elemento não estiver presente no array
        return -1;
    }

    // Método main para teste
    public static void main(String[] args) {
        int[] vetor = {2, 3, 4, 10, 40};
        int target = 10;
        int result = binarySearch(vetor, target);
        if (result == -1) {
            System.out.println("Elemento não encontrado no array.");
        } else {
            System.out.println("Elemento encontrado no índice: " + result);
        }
    }
}
