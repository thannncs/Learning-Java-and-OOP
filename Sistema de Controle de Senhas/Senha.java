import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.ArrayList ;
public class Senha {

  public static void InsereElemento(ArrayList<Integer> fila){
      SecureRandom novasenha = new SecureRandom();
      fila.add(novasenha.nextInt(100));
  }

  public static void DesisteFila(ArrayList<Integer>fila,int senha){
      if(fila.contains(senha)){
          fila.remove(Integer.valueOf(senha));
      }
      else{
          System.out.println("A senha não foi encontrada");
      }
  }

   public static void AtendeSenha(ArrayList<Integer>fila) {
       if (fila.size() > 0) {
           int tamanho = fila.size() - 1;
           fila.remove(tamanho);
       } else {
           System.out.println("Não há senhas para serem atendidas");
       }
   }

   public static int BuscaPosic(ArrayList<Integer>fila,int senhaindex){
      return fila.indexOf(senhaindex);
   }


}
