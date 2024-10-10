package ex05verificarset1.t2saoidenticas;

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

    // Método para verificar se duas árvores são idênticas
    public boolean saoIdenticas(No no1, No no2) {
        if (no1 == null && no2 == null) {
            return true;
        }
        if (no1 == null || no2 == null) {
            return false;
        }
        return (no1.valor == no2.valor) && 
               saoIdenticas(no1.esquerda, no2.esquerda) && 
               saoIdenticas(no1.direita, no2.direita);
    }
}

public class Ex05VerificarSeT1T2SaoIdenticas {

    public static void main(String[] args) {
        ArvoreBinaria arvore1 = new ArvoreBinaria();
        ArvoreBinaria arvore2 = new ArvoreBinaria();

        // Adicionando nós na primeira árvore
        arvore1.adicionar(10);
        arvore1.adicionar(5);
        arvore1.adicionar(15);
        arvore1.adicionar(3);
        arvore1.adicionar(7);
        arvore1.adicionar(12);
        arvore1.adicionar(18);

        // Adicionando nós na segunda árvore
        arvore2.adicionar(10);
        arvore2.adicionar(5);
        arvore2.adicionar(15);
        arvore2.adicionar(3);
        arvore2.adicionar(7);
        arvore2.adicionar(12);
        arvore2.adicionar(18);

        // Verificando se as duas árvores são idênticas
        boolean saoIdenticas = arvore1.saoIdenticas(arvore1.raiz, arvore2.raiz);
        System.out.println("As árvores são idênticas? " + saoIdenticas);
    }
}
