import java.util.Scanner;

public class Exercicio9 {
    public static void main(String[] args) {
        double imc,altura,peso;

        System.out.println("Informe sua Altura");
        Scanner sc = new Scanner(System.in);
        altura = sc.nextDouble();

        System.out.println("Informe seu Peso");
        peso = sc.nextDouble();

        imc = peso / (altura*altura);

        System.out.println("Seu imc é : " +imc);

        if(imc<17){
            System.out.println("Você está muito abaixo do Peso Ideal");
        }else if(imc>=17 && imc<=18.49){
            System.out.println("Você está abaixo do Peso Ideal");
        }else if(imc>18.49 && imc <=24.99){
            System.out.println("Você está no peso Ideal");
        }else if (imc>24.99 && imc<=29.99){
            System.out.println("Você está acima do peso Ideal");
        }else if( imc>29.99 && imc<=34.99){
            System.out.println("Você está com obesidade tipo 1");
        }else if(imc>34.99 && imc <=39.99){
            System.out.println("Você está com Obesidade Tipo 2");
        }else{
            System.out.println("Você está com Obesidade Tipo 3");
        }


        }
    }
