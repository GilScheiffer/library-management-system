/**
 * Classe que representa um livro na biblioteca.
 * Armazena informações básicas sobre o livro, como título, autor e ano de publicação.
 * 
 * @author Gilberto Scheiffer
 */
public class Livro {
  private String titulo;
  private String autor;
  private String anoPublicacao;

  public Livro (String titulo, String autor, String anoPublicacao){
    this.titulo = titulo;
    this.autor = autor;
    this.anoPublicacao = anoPublicacao;
  }

  public String getInfo(){
    return " Titulo: " + titulo + " || Autor: " + autor + " || Ano de publicação: " + anoPublicacao;
  }

  public String getTitulo(){
    return titulo;
  }

  public String getAutor(){
    return autor;
  }

  public String getAnoPublicacao(){
    return anoPublicacao;
  }

  @Override
  public String toString() {
    return "Livro: " + titulo + " || Autor: " + autor + " || Ano de publicação: " + anoPublicacao;
  }
}