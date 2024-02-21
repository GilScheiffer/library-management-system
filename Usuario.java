import java.util.ArrayList;

/**
 * Classe que representa um usuário na biblioteca.
 * Responsável por armazenar informações sobre os livros emprestados, baixados e em posse.
 * 
 * @author Gilberto Scheiffer
 */
public class Usuario {
  private String nome;
  private ArrayList<Fisico> livrosEmprestados;
  private ArrayList<Digital> livrosBaixados;
  private ArrayList<Fisico> livrosEmPosse;

  public Usuario(String nome){
    this.nome = nome;
    livrosEmprestados = new ArrayList<>();
    livrosBaixados = new ArrayList<>();
    livrosEmPosse = new ArrayList<>();
  }

  public String getInfo(){
    return " Nome: " + nome;
  }

  public String getNome(){
    return nome;
  }

  public ArrayList<Fisico> getLivrosEmprestados(){
    return livrosEmprestados;
  }

  public ArrayList<Fisico> getLivrosEmPosse(){
    return livrosEmPosse;
  }

  public ArrayList<Digital> getLivrosBaixados(){
    return livrosBaixados;
  }
  
  public void pegarLivro(Livro livro){
    Fisico f = (Fisico) livro;
    livrosEmPosse.add(f);
    livrosEmprestados.add(f);
  }

  /**
   * Método para verificar se o usuario ja pegou um livro.
   * 
   * @param livro do tipo Livro
   * @return false se o usuario ja pegou um livro igual e true se o usuario não pegou um livro igual.
   * @author Gilberto Scheiffer
   * @author Alvaro Ribeiro
   */
  public boolean verificaHistorico(Livro livro){
    for(Livro livroEmprestado : livrosEmprestados){
      if(livro == livroEmprestado){
        return false;
      }
    }
    return true;
  }

  /**
   * Método para verificar se o usuario ta em posse do livro.
   * 
   * @param livro do tipo Livro
   * @return true se o usuario tem o livro na lista e false se o usuario não tiver.
   * @author Gilberto Scheiffer
   * @author Alvaro Ribeiro
   */
  public boolean verificaPosse(Livro livro){
      for(Livro livroEmPosse : livrosEmPosse){
        if(livro == livroEmPosse){
          return true;
        }
      }
    return false;
  }

  public void devolverLivro(Fisico livro){
    livrosEmPosse.remove(livro);
  }

  public void baixarLivro(Digital livro){
    livrosBaixados.add(livro);
  }
}
