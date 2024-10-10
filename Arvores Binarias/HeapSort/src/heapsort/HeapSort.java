package heapsort;

public class HeapSort {
    public static void main(String[] args) {
        int[] array = {38, 1, 4, 55, 8, 9, 0};
        heapSort(array);
        System.out.println("Array ordenado:");
        for (int numero : array) {
            System.out.print(numero + " ");
        }
    }

    public static void heapSort(int[] arr) {
        int tamanho = arr.length;

        // Construir heap (rearranjar o array)
        for (int i = tamanho / 2 - 1; i >= 0; i--) {
            heapify(arr, tamanho, i);
        }

        // Extrair um elemento por vez do heap
        for (int i = tamanho - 1; i >= 0; i--) {
            // Mover a raiz atual para o fim
            int temporario = arr[0];
            arr[0] = arr[i];
            arr[i] = temporario;

            // Chamar heapify no heap reduzido
            heapify(arr, i, 0);
        }
    }

    // Função para fazer heapify em uma subárvore com a raiz em i
    static void heapify(int[] arr, int tamanho, int i) {
        int maior = i;  // Inicializa maior como raiz
        int esquerda = 2 * i + 1;  // esquerda = 2*i + 1
        int direita = 2 * i + 2;  // direita = 2*i + 2

        // Se o filho à esquerda for maior que a raiz
        if (esquerda < tamanho && arr[esquerda] > arr[maior]) {
            maior = esquerda;
        }

        // Se o filho à direita for maior que o maior até agora
        if (direita < tamanho && arr[direita] > arr[maior]) {
            maior = direita;
        }

        // Se o maior não for a raiz
        if (maior != i) {
            int trocar = arr[i];
            arr[i] = arr[maior];
            arr[maior] = trocar;

            // Recursivamente fazer heapify na subárvore afetada
            heapify(arr, tamanho, maior);
        }
    }
}
