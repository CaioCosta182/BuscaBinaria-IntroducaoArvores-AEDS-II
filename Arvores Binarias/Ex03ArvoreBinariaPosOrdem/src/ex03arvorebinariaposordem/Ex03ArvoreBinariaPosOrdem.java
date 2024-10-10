package ex03arvorebinariaposordem;

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

    // Método para realizar o percurso pós-ordem
    public void percursoPosOrdem() {
        percursoPosOrdemRecursivo(raiz);
    }

    private void percursoPosOrdemRecursivo(No no) {
        if (no != null) {
            percursoPosOrdemRecursivo(no.esquerda);
            percursoPosOrdemRecursivo(no.direita);
            System.out.print(no.valor + " ");
        }
    }
}

public class Ex03ArvoreBinariaPosOrdem {

    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.adicionar(10);
        arvore.adicionar(5);
        arvore.adicionar(15);
        arvore.adicionar(3);
        arvore.adicionar(7);
        arvore.adicionar(12);
        arvore.adicionar(18);

        System.out.println("Percurso em pós-ordem:");
        arvore.percursoPosOrdem();
    }
}
