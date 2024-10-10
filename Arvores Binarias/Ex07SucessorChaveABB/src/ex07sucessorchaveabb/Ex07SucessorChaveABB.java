package ex07sucessorchaveabb;

class No {
    int valor;
    No esquerda;
    No direita;
    No pai;

    public No(int valor) {
        this.valor = valor;
        esquerda = null;
        direita = null;
        pai = null;
    }
}

class ArvoreBinariaDeBusca {
    No raiz;

    public ArvoreBinariaDeBusca() {
        raiz = null;
    }

    // Método para adicionar um novo nó à árvore
    public void adicionar(int valor) {
        raiz = adicionarRecursivo(raiz, null, valor);
    }

    private No adicionarRecursivo(No atual, No pai, int valor) {
        if (atual == null) {
            No novoNo = new No(valor);
            novoNo.pai = pai;
            return novoNo;
        }

        if (valor < atual.valor) {
            atual.esquerda = adicionarRecursivo(atual.esquerda, atual, valor);
        } else if (valor > atual.valor) {
            atual.direita = adicionarRecursivo(atual.direita, atual, valor);
        }

        return atual;
    }

    // Método para encontrar o sucessor de uma chave
    public No encontrarSucessor(int valor) {
        No atual = buscarNo(raiz, valor);
        if (atual == null) {
            return null; // Valor não encontrado na árvore
        }
        return encontrarSucessorNo(atual);
    }

    private No buscarNo(No no, int valor) {
        if (no == null || no.valor == valor) {
            return no;
        }

        if (valor < no.valor) {
            return buscarNo(no.esquerda, valor);
        } else {
            return buscarNo(no.direita, valor);
        }
    }

    private No encontrarSucessorNo(No no) {
        if (no.direita != null) {
            return encontrarMinimo(no.direita);
        }

        No pai = no.pai;
        while (pai != null && no == pai.direita) {
            no = pai;
            pai = pai.pai;
        }
        return pai;
    }

    private No encontrarMinimo(No no) {
        while (no.esquerda != null) {
            no = no.esquerda;
        }
        return no;
    }
}

public class Ex07SucessorChaveABB {

    public static void main(String[] args) {
        ArvoreBinariaDeBusca arvore = new ArvoreBinariaDeBusca();

        arvore.adicionar(20);
        arvore.adicionar(10);
        arvore.adicionar(30);
        arvore.adicionar(5);
        arvore.adicionar(15);
        arvore.adicionar(25);
        arvore.adicionar(35);

        int chave = 10;
        No sucessor = arvore.encontrarSucessor(chave);

        if (sucessor != null) {
            System.out.println("O sucessor de " + chave + " é " + sucessor.valor);
        } else {
            System.out.println("Não há sucessor para a chave " + chave);
        }
    }
}
