import java.security.SecureRandom;
import java.util.Scanner;
import java.util.ArrayList ;
public class Main {
    public static void main(String[] args) {

        System.out.print("Bem vindo a repartição de Londrina \nPara utilizar o sistema insira uma das opções na linha de comando\n" + "\n" + "1-Emitir nova senha\n" +

                "\n" +
                "2-Desistir da fila.obs:informe o número para ser removido" +
                "\n" +
                "\n" +
                "3–Atender usuário" +
                "\n" +
                "\n" +
                "4–Buscar posição na fila.obs:informe o número a ser verificado" +
                "\n" +
                "\n" +
                "5–Imprimir fila "+
                "\n" +
                "\n" +
                "6-Sair"+"\n" +
                "\n" );


        ArrayList<Integer> fila = new ArrayList<Integer>();

        Scanner sc = new Scanner(System.in);

            int opt1 = sc.nextInt();
            while(opt1 != 6){
            switch (opt1) {
                case 1:
                    Senha.InsereElemento(fila);
                    break;
                case 2:
                    int senha = sc.nextInt();

                    Senha.DesisteFila(fila, senha);
                    break;
                case 3:
                    Senha.AtendeSenha(fila);
                    break;
                case 4:
                    if (!fila.isEmpty()){
                    int senhaindex = sc.nextInt();
                    System.out.print("Você está na posição ");
                    System.out.print(Senha.BuscaPosic(fila, senhaindex));
                    System.out.println(" da Fila");}
                    else {
                        System.out.println("A senha não está na lista");
                    }
                    break;
                case 5:
                    if (!fila.isEmpty()) {
                        System.out.println("As senhas que ainda faltam ser atendidas são: ");
                        for (int percorre : fila) {
                            System.out.println(percorre);
                        }
                    } else {
                        System.out.println("Não há senhas na fila");

                    }
                    break;
                default:
                    System.out.println("OPÇÃO INVÁLIDA"+
                            "\n" +"1-Emitir nova senha\n" +

                                    "\n" +
                                    "2-Desistir da fila.obs:informe o número para ser removido" +
                                    "\n" +
                                    "\n" +
                                    "3–Atender usuário" +
                                    "\n" +
                                    "\n" +
                                    "4–Buscar posição na fila.obs:informe o número a ser verificado" +
                                    "\n" +
                                    "\n" +
                                    "5–Imprimir fila "+
                                    "\n" +
                                    "\n" +
                                    "6-Sair"+"\n"
                            );
                     break;
            }

                opt1 = sc.nextInt();
            }


        }



        }




