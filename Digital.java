/**
 * Classe que representa um livro digital na biblioteca.
 * Estende a classe Livro e armazena informações específicas de um livro digital, como formato, tamanho e URL.
 * 
 * @see Livro
 * @author Gilberto Scheiffer
 */
public class Digital extends Livro {
  private String formato;
  private double tamanho;
  private String url;

  
  public Digital(String titulo, String autor, String anoPublicacao, String formato, double tamanho, String url){
    super(titulo, autor, anoPublicacao);
    this.formato = formato;
    this.tamanho = tamanho;
    this.url = url;
  } 

  @Override
  public String getInfo(){
    return super.getInfo() + " || Formato: " + formato + " || Tamanho: " + tamanho + " || URL: " + url;
  }

  @Override
  public String toString() {
    return "Digital: " + super.getTitulo() +  " || Formato: " + formato + " || Tamanho: " + tamanho + " || URL: " + url;
  }
  
  public String baixar(Digital l){
    return url;
  }  
}