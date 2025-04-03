import java.util.Scanner;
public class Exercicio7 {
    public static void main(String[] args) {

        int niveis;
        int repeticoes;
        int r = 0;

        System.out.println("Quantos niveis deve ter o triângulo ?");

        Scanner sc = new Scanner(System.in);
        niveis = sc.nextInt();
        System.out.println("Quantos tringulos serão ?");
        repeticoes = sc.nextInt();


        do {
            for (int i = 0; i <= niveis; i++) {
                for (int j = 0; j < i; j++) {
                    System.out.print("*");
                }
                System.out.println();

            }
         r++;
        } while (r < repeticoes);
    }

}