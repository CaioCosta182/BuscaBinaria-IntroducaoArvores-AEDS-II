package buscabinaria;
public class BuscaBinariaRecursiva {
   
    // Método recursivo para buscar um elemento em um array ordenado
    // Retorna o índice do elemento se encontrado, senão retorna -1
    public static int buscaBinaria(int[] vetor, int target) {
        return buscaBinariaRecursiva(vetor, target, 0, vetor.length - 1);
    }

    // Função auxiliar recursiva para executar a busca binária
    private static int buscaBinariaRecursiva(int[] vetor, int target, int esquerda, int direita) {
        if (esquerda <= direita) {
            int meio = esquerda + (direita - esquerda) / 2;

            // Verifica se o elemento está presente no meio
            if (vetor[meio] == target)
                return meio;

            // Se o elemento estiver na metade esquerda do array
            if (vetor[meio] < target)
                return buscaBinariaRecursiva(vetor, target, meio + 1, direita);
            // Se o elemento estiver na metade direita do array
            else
                return buscaBinariaRecursiva(vetor, target, esquerda, meio - 1);
        }

        // Se o elemento não estiver presente no array
        return -1;
    }

    // Método main para teste
    public static void main(String[] args) {
        int[] vetor = { 2, 3, 4, 10, 40, 76, 94 };
        int target = 76;
        int result = buscaBinaria(vetor, target);
        if (result == -1)
            System.out.println("Elemento não encontrado no array.");
        else
            System.out.println("Elemento encontrado no índice: " + result);
    }
}


