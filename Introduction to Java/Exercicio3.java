import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Exercicio3 {
    public static void main(String[] args) {
        String nome;
        int contador = 0;
        int repeticoes;
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite qual Nome deve ser impresso");
        nome = sc.next();
        System.out.println("Quantas vezes deve ser impresso ?");
        repeticoes= sc.nextInt();

        while(contador<repeticoes){
            System.out.println(nome);
            contador++;

        }

        }
    }
