import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe utilitária com métodos de apoio para interação com o usuário.
 * Possui métodos para limpar a tela, imprimir mensagens e auxiliar na verificação de tipos.
 * 
 * @author Gilberto Scheiffer
 */
public class Av2Utils {
  /**
   * Método para Limpar a tela do usuario.
   * 
   */
  public void clearScreen() {
    try {
      final String os = System.getProperty("os.name");

      if (os.contains("Windows")) {
        // Se o sistema for Windows
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      } else {
        // Se for Linux, Unix ou Mac
        System.out.print("\033[H\033[2J");
        System.out.flush();
      }
    } catch (Exception e) {
      System.out.println("Erro ao limpar a tela: " + e.getMessage());
    }
  }

  public void printSucesso(){
    System.out.println("Cadastrado realizado com sucesso!!");
  }

  public void printTipoErro(){
    System.out.println("Tipo invalido!!");
  }

  public void printRemovido(){
    System.out.println("Removido com sucesso!!");
  }

  public void printNaoAchou(){
    System.out.println("Informação não encontrada!!");
  }

  public void printIdIgual(){
    System.out.println("ID ja existente!");
  }

  public void printErroTipoInvalido(){
    System.out.println("Erro: Tipo de entrada inválido. Por favor, insira um número inteiro.");
  }

  public void printList(ArrayList<Livro> livros){
    if(livros == null){
      return;
    }
    
    System.out.println("Lista de livros:");
    for(Livro l: livros){
      System.out.println(l);
    }
  }

  /**
   * Método para verificar o tipo do livro na lista.
   * 
   * @param livrosV do tipo lista do tipo Livro
   * @return Uma variavel do tipo Fisico
   * @author Gilberto Scheiffer
   * @author Alvaro Ribeiro
   */
  public Fisico verificaFisico(ArrayList<Livro> livrosV){
    Scanner sc = new Scanner(System.in);
    Fisico livroV = null;

    if(livrosV.size() == 1){
      for (Livro liv : livrosV) {
        if(liv instanceof Digital){
          clearScreen();
          System.out.println("Livro somente na versão digital!");
          sc.nextLine();
          return null;
        } else {
          Fisico f = (Fisico) liv;
          livroV = f;
        }
      }
    }

    if(livroV == null){
      for (Livro liv : livrosV) {
        if(liv instanceof Fisico){
          Fisico f = (Fisico) liv;
          livroV = f;
        }
      }
    }
    return livroV;
  }

  public boolean verificaId(int id,ArrayList<Usuario> usuariosI){
    Scanner sc = new Scanner(System.in);
    
    for (Usuario usuario : usuariosI) {
      if (usuario instanceof Aluno){
        Aluno a = (Aluno) usuario;
        if (id == a.getMatricula()){
          clearScreen();
          printIdIgual();
          sc.nextLine();
          return true;
        }
      } else {
        Professor p = (Professor) usuario;
        if (id == p.getCodigo()){
          clearScreen();
          printIdIgual();
          sc.nextLine();
          return true;
        }
      }
    }
    return false;
  }
  
}