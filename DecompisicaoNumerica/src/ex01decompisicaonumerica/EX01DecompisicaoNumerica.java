
package ex01decompisicaonumerica;

/**
 *
 * @author caiocosta
 */
public class EX01DecompisicaoNumerica {

   

    public static void main(String[] args) {
        int n = 7;
        decompor(n, "");
    }

    public static void decompor(int n, String aux) {
        if (n == 0) {
            System.out.println(aux.substring(1));
            return;
        }

        for (int i = 1; i <= n; i++) {
            decompor(n - i, aux + "+" + i);
        }
    }
}
    

