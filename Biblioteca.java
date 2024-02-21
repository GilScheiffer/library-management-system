import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

  /**
  * Classe que representa a biblioteca.
  */
public class Biblioteca {
  private ArrayList<Livro> livros;
  private ArrayList<Usuario> usuarios;

  /**
   * Construtor da classe Biblioteca.
   * 
   * @param l Lista de livros
   * @param u Lista de usuários
   * @author Gilberto Scheiffer
   */
  public Biblioteca(ArrayList<Livro> l, ArrayList<Usuario> u) {
    this.livros = new ArrayList<>();
    this.usuarios = new ArrayList<>();
    this.livros.addAll(l);
    this.usuarios.addAll(u);
  }

  Av2Utils utl = new Av2Utils();

  /**
   * Método para cadastrar um usuário na biblioteca.
   * 
   * @param u      O usuário a ser cadastrado
   * @param tipoU  O tipo do usuário (aluno ou professor)
   * @author Gilberto Scheiffer
   * @author Alvaro Ribeiro
   */
  public void cadastrarUsuario(Usuario u, String tipoU) {
    Scanner sc = new Scanner(System.in);

    if (tipoU.toLowerCase().equals("aluno")) {
      int matricula = -1;
      
      try{
        System.out.println("Digite a matricula do aluno: ");
        matricula = sc.nextInt();
        sc.nextLine();
      } catch (InputMismatchException e) {
        utl.printErroTipoInvalido();
        sc.nextLine();
        sc.nextLine();
        return;
      }

      // Verifica se o usuário a matricula já existe
      if(utl.verificaId(matricula, this.usuarios)){
        return; 
      }

      Aluno a = new Aluno(u.getNome(), matricula);
      usuarios.add(a);

      utl.clearScreen();
      utl.printSucesso();
      sc.nextLine();

    } else if (tipoU.toLowerCase().equals("professor")) {
      int codigo = -1;
      
      try{
        System.out.println("Digite o codigo do professor: ");
        codigo = sc.nextInt();
        sc.nextLine();
      } catch (InputMismatchException e) {
        utl.printErroTipoInvalido();
        sc.nextLine();
        sc.nextLine();
        return;
      }

      // Verifica se o usuário a codigo já existe
      if(utl.verificaId(codigo, this.usuarios)){
        return; 
      }

      Professor p = new Professor(u.getNome(), codigo);
      usuarios.add(p);

      utl.clearScreen();
      utl.printSucesso();
      sc.nextLine();

    } else {
      utl.clearScreen();
      utl.printTipoErro();
      sc.nextLine();
      return;
    }
  }

  /**
   * Método para imprimir a lista de usuários cadastrados na biblioteca.
   * @author Gilberto Scheiffer
   * @author Alvaro Ribeiro
   */
  public void printUsuarios() {
    for (Usuario usu : usuarios) {
      System.out.println(usu.getInfo());
    }
  }

  /**
   * Método para cadastrar um livro na biblioteca.
   * 
   * @param l      O livro a ser cadastrado
   * @param tipoL  O tipo do livro (digital ou físico)
   * @author Gilberto Scheiffer
   * @author Alvaro Ribeiro
   */
  public void cadastrarLivro(Livro l, String tipoL) {
    Scanner sc = new Scanner(System.in);

    if (tipoL.toLowerCase().equals("digital")) {
      double tamanho = -1;

      System.out.println("Digite o formato do livro:");
      String formato = sc.nextLine();

      try{
        System.out.println("Digite o tamanho do livro(MB):");
        tamanho = sc.nextInt();
        sc.nextLine();
      } catch (InputMismatchException e) {
        System.out.println("Erro: Tipo de entrada inválido. Por favor, insira um valor númerico.");
        sc.nextLine();
        sc.nextLine();
        return;
      }

      System.out.println("Digite o url do livro:");
      String url = sc.nextLine();

      Digital d = new Digital(l.getTitulo(), l.getAutor(), l.getAnoPublicacao(), formato, tamanho, url);
      livros.add(d);

      utl.clearScreen();
      utl.printSucesso();
      sc.nextLine();

    } else if (tipoL.toLowerCase().equals("fisico")) {
      int copias = -1;

      try{
        System.out.println("Digite o numero de copias do livro:");
        copias = sc.nextInt();
        sc.nextLine();
      } catch (InputMismatchException e) {
        utl.printErroTipoInvalido();
        sc.nextLine();
        sc.nextLine();
        return;
      }

      Fisico f = new Fisico(l.getTitulo(), l.getAutor(), l.getAnoPublicacao(), copias);
      livros.add(f);

      utl.clearScreen();
      utl.printSucesso();
      sc.nextLine();

    } else {
      utl.clearScreen();
      utl.printTipoErro();
      sc.nextLine();
      return;
    }
  }

  /**
   * Método para imprimir a lista de livros cadastrados na biblioteca.
   * @author Gilberto Scheiffer
   * @author Alvaro Ribeiro
   */
  public void printLivros() {
    for(Livro liv : livros){
      System.out.println(liv.getInfo());
    }
  }

  /**
   * Método para remover um livro da biblioteca.
   * 
   * @param titulo O título do livro a ser removido
   * @param autor  O autor do livro a ser removido
   * @author Gilberto Scheiffer
   * @author Alvaro Ribeiro
   */
  public void removerLivro(String titulo, String autor) {
    Scanner sc = new Scanner(System.in);

    for (Livro liv : livros) {
      if (liv.getTitulo().toLowerCase().equals(titulo) && liv.getAutor().toLowerCase().equals(autor)) {
        livros.remove(liv);
        utl.clearScreen();
        utl.printRemovido();
        sc.nextLine();
        return;
      }
    }
    utl.clearScreen();
    utl.printNaoAchou();
    sc.nextLine();
  }

  /**
   * Método para buscar um livro na biblioteca pelo título e autor.
   * 
   * @param titulo O título do livro a ser buscado
   * @param autor  O autor do livro a ser buscado
   * @return       Uma lista de livros encontrados ou null se não encontrado
   * @author Gilberto Scheiffer
   * @author Alvaro Ribeiro
   */
  public ArrayList<Livro> buscarLivro(String titulo, String autor) {
    ArrayList<Livro> livrosEncontrados = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    for (Livro liv : livros) {
      if (liv.getTitulo().toLowerCase().equals(titulo.toLowerCase()) && liv.getAutor().toLowerCase().equals(autor.toLowerCase())) {
        livrosEncontrados.add(liv);
      }
    }

    if (livrosEncontrados.isEmpty()) {
      utl.clearScreen();
      System.out.println("Livro não encontrado!");
      sc.nextLine();
      return null;
    }

    return livrosEncontrados;
  }

  /**
   * Método para baixar um livro digital para um usuário.
   * 
   * @param u       O usuário que irá baixar o livro
   * @param livros  Uma lista de livros digitais a serem baixados
   * @author Gilberto Scheiffer
   * @author Alvaro Ribeiro
   */
  public void baixar(Usuario u, ArrayList<Livro> livros) {
    Scanner sc = new Scanner(System.in);
    Digital livro = null;

    if(livros == null){
      return;
    }

    if(livros.size() == 1){
      for (Livro liv : livros) {
        if(liv instanceof Fisico){
          utl.clearScreen();
          System.out.println("Livro somente na versão fisica!");
          sc.nextLine();
          return;
        } else {
          Digital d = (Digital) liv;
          livro = d;
        }
      }
    }

    if(livro == null){
      for (Livro liv : livros) {
        if(liv instanceof Digital){
          Digital d = (Digital) liv;
          livro = d;
        }
      }
    }

    if(livro == null){
      return; 
    }

    if (u instanceof Professor && u.getLivrosBaixados().size() == 2) {
      utl.clearScreen();
      System.out.println("Professor, limite de downloads atingido!");
      sc.nextLine();
      return;
    }
    
    u.baixarLivro(livro);
    utl.clearScreen();
    System.out.println("Realize seu download clicando aqui: " + livro.baixar(livro));
    sc.nextLine();
    return;
  }

  /**
   * Método para realizar o empréstimo de um livro para um usuário.
   * 
   * @param u       O usuário que irá receber o livro emprestado
   * @param livros  Uma lista de livros a serem emprestados
   * @author Gilberto Scheiffer
   * @author Alvaro Ribeiro
   */
  public void realizarEmprestimo (Usuario u, ArrayList<Livro> livros){
    Scanner sc = new Scanner(System.in);
    Fisico livro = null;

    if(livros == null){
      return;
    }

    livro = utl.verificaFisico(livros);

    if(livro == null){
      return;
    }
    
    if (u instanceof Aluno) {
      if (u.getLivrosEmPosse().size() == 5) {
        utl.clearScreen();
        System.out.println("Limite de empréstimos atingido!");
        sc.nextLine();
        return;
      } else if (livro.getCopiasDisponiveis() > 0) {
        if (u.verificaHistorico(livro)) {
          u.pegarLivro(livro);
          livro.emprestar();
          utl.clearScreen();
          System.out.println("Empréstimo realizado com sucesso");
          sc.nextLine();
          return;
        } else {
          utl.clearScreen();
          System.out.println("Aluno já pegou este livro emprestado uma vez!");
          sc.nextLine();
          return;
        }
      } else {
        utl.clearScreen();
        System.out.println("Não há cópias disponíveis!");
        sc.nextLine();
        return;
      }
    } else if (u instanceof Professor) {
      if (livro.getCopiasDisponiveis() > 0) {
          if (u.verificaHistorico(livro)) {
            u.pegarLivro(livro);
            livro.emprestar();
            utl.clearScreen();
            System.out.println("Empréstimo realizado com sucesso");
            sc.nextLine();
            return;
          } else {
            utl.clearScreen();
            System.out.println("Professor já pegou este livro emprestado uma vez!");
            sc.nextLine();
            return;
          }
      } else {
        utl.clearScreen();
        System.out.println("Não há cópias disponíveis!");
        sc.nextLine();
        return;
      }
    } else {
      utl.clearScreen();
      utl.printTipoErro();
      sc.nextLine();
      return;
    }
  }
    
  /**
   * Método para devolver um livro emprestado por um usuário.
   * 
   * @param u       O usuário que irá devolver o livro
   * @param livros  Uma lista de livros a serem devolvidos
   * @author Gilberto Scheiffer
   * @author Alvaro Ribeiro
   */
  public void devolverEmprestimo (Usuario u, ArrayList<Livro> livros){
    Scanner sc = new Scanner(System.in);
    Fisico livro = null;

    if(livros == null){
      return;
    }

    livro = utl.verificaFisico(livros);

    if(livro == null){
      return;
    }

    if (u.verificaPosse(livro)){
      u.devolverLivro(livro);
      livro.devolver();
      
      utl.clearScreen();
      System.out.println("Devolução realizada com sucesso!");
      sc.nextLine();
      return;
    } else {
      utl.clearScreen();
      System.out.println("Usuario não possui este livro!");
      sc.nextLine();
      return;
    }
  }

  /**
   * Método para buscar um usuário na biblioteca pelo ID.
   * 
   * @param idBusca O ID do usuário a ser buscado
   * @return        O usuário encontrado ou null se não encontrado
   * @author Gilberto Scheiffer
   * @author Alvaro Ribeiro
   */
  public Usuario buscarUsuario(int idBusca) {
    for (Usuario usu : usuarios) {
      if (usu instanceof Aluno) {
        Aluno aluno = (Aluno) usu;
        if (aluno.getMatricula() == idBusca) {
          return aluno;
        }
      } else if (usu instanceof Professor) {
        Professor professor = (Professor) usu;
        if (professor.getCodigo() == idBusca) {
          return professor;
        }
      }
    }
    utl.clearScreen();
    utl.printNaoAchou();
    return null;
  }
}