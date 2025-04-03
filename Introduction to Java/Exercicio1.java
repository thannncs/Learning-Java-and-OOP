
//Faça um programa que imprima na tela o seu nome 100 vezes. O seu nome deve
//ser passado como parâmetro para o programa.


public class Exercicio1 {
   static public void main(String[] args){

   int contador = 0 ;

    do {
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
            contador++;
        }
    }
    while(contador<100);


   }

}
