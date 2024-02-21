/**
 * Classe que representa um professor na biblioteca.
 * Estende a classe Usuario e armazena informações específicas do professor, como código.
 * 
 * @see Usuario
 * @author Gilberto Scheiffer
 */
public class Professor extends Usuario {
  private int codigo;

  public Professor(String nome, int codigo){
    super(nome);
    this.codigo = codigo;
  }

  public int getCodigo(){
    return codigo;
  }

  @Override
  public String getInfo(){
    return super.getInfo() + " || Código: " + codigo;
  }

  @Override
  public String toString() {
    return "Professor: " + super.getNome() + ", Código: " + codigo;
  }
}