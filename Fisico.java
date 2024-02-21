/**
 * Classe que representa um livro físico na biblioteca.
 * Estende a classe Livro e armazena informações específicas de um livro físico, como o número de cópias disponíveis.
 * 
 * @see Livro
 * @author Gilberto Scheiffer
 */
public class Fisico extends Livro {
  private int copiasDisponiveis;

  public Fisico(String titulo, String autor, String anoPublicacao, int copiasDisponiveis){
    super(titulo, autor, anoPublicacao);
    this.copiasDisponiveis = copiasDisponiveis;
  }

  @Override
  public String getInfo(){
    return super.getInfo() + " || Copias Disponiveis: " + copiasDisponiveis;
  }
  
  @Override
  public String toString() {
    return "Fisico: " + super.getTitulo() + " || Copias Disponiveis: " + copiasDisponiveis;
  }

  public int getCopiasDisponiveis() {
    return copiasDisponiveis;
  }

  public void emprestar(){
    copiasDisponiveis--;
  }

  public void devolver(){
    copiasDisponiveis++;
  }
}