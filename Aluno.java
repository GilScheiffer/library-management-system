/**
 * Classe que representa um aluno na biblioteca.
 * Estende a classe Usuario e armazena informações específicas do aluno, como matrícula.
 * 
 * @see Usuario
 * @author Gilberto Scheiffer
 */
public class Aluno extends Usuario {
  private int matricula;

  public Aluno(String nome, int matricula){
    super(nome);
    this.matricula = matricula;
  }

  public int getMatricula(){
    return matricula;
  }

  @Override
  public String getInfo(){
    return super.getInfo() + " || Matricula: " + matricula;
  }

  @Override
  public String toString() {
    return "Aluno: " + super.getNome() + ", Matrícula: " + matricula;
  }
}
