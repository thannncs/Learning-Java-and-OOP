import java.util.Scanner;

public class Exercicio8 {
    public static void main(String[] args) {

        int n;
        int anterior = 0;
        int atual = 1;

        System.out.println("Digite a posição N na cadeia de Fibonacci que deseja");
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        if (n == 0) {
            System.out.println("O numero de Fibonacci na posição 0 é 0");

        } else if (n == 1) {
            System.out.println("O numero de Fibonacci na posição 1 é 1");
        } else {
            for (int i = 2; i <= n; i++) {
                int proximo = anterior + atual;
                anterior = atual;
                atual = proximo;
            }
            System.out.println("O numero de Fibonacci na prosição " +n+ " é " +atual);
        }
    }
}