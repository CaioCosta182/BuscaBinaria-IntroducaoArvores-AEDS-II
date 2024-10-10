package ex06maiorelementoarvorebinaria;

class No {
    int valor;
    No esquerda;
    No direita;

    public No(int valor) {
        this.valor = valor;
        esquerda = null;
        direita = null;
    }
}

class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        raiz = null;
    }

    // Método para adicionar um novo nó à árvore
    public void adicionar(int valor) {
        raiz = adicionarRecursivo(raiz, valor);
    }

    private No adicionarRecursivo(No atual, int valor) {
        if (atual == null) {
            return new No(valor);
        }

        if (valor < atual.valor) {
            atual.esquerda = adicionarRecursivo(atual.esquerda, valor);
        } else if (valor > atual.valor) {
            atual.direita = adicionarRecursivo(atual.direita, valor);
        }

        return atual;
    }

    // Método para encontrar o maior elemento da árvore
    public int encontrarMaiorElemento() {
        if (raiz == null) {
            throw new IllegalStateException("A árvore está vazia.");
        }
        return encontrarMaiorElementoRecursivo(raiz);
    }

    private int encontrarMaiorElementoRecursivo(No no) {
        if (no.direita == null) {
            return no.valor;
        }
        return encontrarMaiorElementoRecursivo(no.direita);
    }
}

public class Ex06MaiorElementoArvoreBinaria {

    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.adicionar(10);
        arvore.adicionar(5);
        arvore.adicionar(15);
        arvore.adicionar(3);
        arvore.adicionar(7);
        arvore.adicionar(12);
        arvore.adicionar(18);

        int maiorElemento = arvore.encontrarMaiorElemento();
        System.out.println("O maior elemento da árvore é: " + maiorElemento);
    }
}
