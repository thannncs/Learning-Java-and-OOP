import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {
        int niveis;

        System.out.println("Quantos niveis deve ter o triângulo ?");

        Scanner sc = new Scanner(System.in);

        niveis = sc.nextInt();

          for(int i = 0; i<=niveis;i++){
              for(int j = 0;j<i;j++) {
                  System.out.print("*");
              }
        System.out.println();
         }
    }
}