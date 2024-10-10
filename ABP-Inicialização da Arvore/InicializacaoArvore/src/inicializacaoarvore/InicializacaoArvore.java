package inicializacaoarvore;

public class InicializacaoArvore {

    public static void main(String[] args) {
        NO[] nos = new NO[7]; 
        NO raiz = null;

        nos[0] = new NO(8);
        nos[1] = new NO(2);
        nos[2] = new NO(15);
        nos[3] = new NO(12);
        nos[4] = new NO(23);
        nos[5] = new NO(20);
        nos[6] = new NO(30);

        // Adiciona os nós à árvore
        for (NO no : nos) {
            raiz = adiciona(raiz, no);
        }

        // Exemplo de busca
        int chaveBusca = 30;
        
        NO resultadoBusca = busca(raiz, chaveBusca);
        if (resultadoBusca != null) {
            System.out.println("Chave " + chaveBusca + " encontrada na árvore.");
        } else {
            System.out.println("Chave " + chaveBusca + " não encontrada na árvore.");
        }
    }

    public static NO adiciona(NO raiz, NO no) {
        if (raiz == null)
            return no;
        if (no.chave < raiz.chave)
            raiz.esq = adiciona(raiz.esq, no);
            
        else if (no.chave > raiz.chave)
            raiz.dir = adiciona(raiz.dir, no);
           
        // Ignora chave igual (não faz nada)
        return raiz;
    }

    public static NO busca(NO raiz, int chave) {
        if (raiz == null || raiz.chave == chave)
            return raiz;
        if (chave < raiz.chave){
            System.out.println("Numero "+ raiz.chave + " encontrado  a esquerda");
            return busca(raiz.esq, chave);
        }else{
             System.out.println("Numero "+ raiz.chave + " encontrado a direita!!!");
            return busca(raiz.dir, chave);
        }
    }
}

class NO {
    int chave;
    NO esq, dir;

    public NO(int chave) {
        this.chave = chave;
        this.esq = null;
        this.dir = null;
    }
}


