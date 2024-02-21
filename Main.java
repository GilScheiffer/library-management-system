import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * Classe principal que contém o método main para interação com o usuário.
 */
class Main {

  /**
   * Método principal responsável pela execução e interação com o usuário.
   * 
   * @param args Argumentos passados por linha de comando
   */
  public static void main(String[] args) {
    ArrayList<Livro> livros = new ArrayList<>();
    ArrayList<Usuario> usuarios = new ArrayList<>();
    
    // Adicionando 5 alunos e 5 professores
    for (int i = 1; i <= 5; i++) {
      Aluno aluno = new Aluno("A " + i, 1000 + i);
      Professor professor = new Professor("P " + i, 2000 + i);

      usuarios.add(aluno);
      usuarios.add(professor);
    }

    // Adicionando 5 livros digitais e 5 livros físicos
    for (int i = 1; i <= 5; i++) {
      Digital livroDigital = new Digital("Digital" + i, "AutorD" + i, "2023", "PDF", 10.5, "url" + i);
      Fisico livroFisico = new Fisico("Fisico" + i, "AutorF" + i, "2023", 10);

      livros.add(livroDigital);
      livros.add(livroFisico);
    }
    
    Biblioteca b = new Biblioteca(livros, usuarios);
    Av2Utils utl = new Av2Utils();
    Scanner sc = new Scanner(System.in);
    int opcao = 0;

    do{
      try{
        utl.clearScreen();
        System.out.println("Bem Vindo a Biblioteca!\n\n-----------------------\n");
        System.out.println("Escolha uma opção:\n");
        System.out.println("1 - Cadastrar usuário");
        System.out.println("2 - Lista de Usuarios");
        System.out.println("3 - Buscar Usuarios");
        System.out.println("4 - Cadastrar Livros");
        System.out.println("5 - Lista de Livros");
        System.out.println("6 - Remover Livros");
        System.out.println("7 - Buscar Livros");
        System.out.println("8 - Emprestar Livros");
        System.out.println("9 - Baixar Livro");
        System.out.println("10 - Devolver Emprestimo");
        System.out.println("11 - Sair");
        
        opcao = sc.nextInt();
        sc.nextLine();
      } catch (InputMismatchException e) {
        System.out.println("Erro: Tipo de entrada inválido. Por favor, insira um número inteiro.");
        sc.nextLine();
        sc.nextLine();
        continue;
      }
      
      switch(opcao){
          // Cadastrar Usuario
        case 1:
          utl.clearScreen();
          System.out.println("Digite o nome do usuário:");
          String nome = sc.nextLine();
          
          System.out.println("Digite o tipo de usuário (aluno ou professor):");
          String tipoU = sc.nextLine();
          
          Usuario usuario = new Usuario(nome);

          b.cadastrarUsuario(usuario, tipoU);
          break;
          
          // Lista de Usuarios
        case 2:
          utl.clearScreen();
          System.out.println("Lista de usuarios:");
          b.printUsuarios();
          sc.nextLine();
          break;

          // Buscar Usuarios
        case 3:
          int id = -1;
          try{
            utl.clearScreen();
            System.out.println("Digite o ID do usuário(matricula ou codigo):");
            id = sc.nextInt();
            sc.nextLine();
          } catch (InputMismatchException e) {
            System.out.println("Erro: Tipo de entrada inválido. Por favor, insira um número inteiro.");
            sc.nextLine();
            sc.nextLine();
            break;
          }
          
          System.out.println(b.buscarUsuario(id));
          sc.nextLine();
          break;
          
          // Cadastrar Livros
        case 4:
          utl.clearScreen();
          
          System.out.println("Digite o titulo do livro:");
          String tituloCadastrar = sc.nextLine();
          
          System.out.println("Digite o autor desse livro:");
          String autor = sc.nextLine();
          
          System.out.println("Digite o ano de publicação do livro:");
          String anoPublicacao = sc.nextLine();

          System.out.println("Digite o tipo do livro(digital ou fisico):");
          String tipoL = sc.nextLine();
          
          Livro livro = new Livro(tituloCadastrar, autor, anoPublicacao);
          b.cadastrarLivro(livro, tipoL);
          
          break;
          
          // Lista de Livros
        case 5:
          utl.clearScreen();
          
          System.out.println("Lista de livros:");
          b.printLivros();
          sc.nextLine();
          break;
          
          // Remover Livros
        case 6:
          utl.clearScreen();
          
          System.out.println("Digite o titulo do livro a ser removido:");
          String tituloRemover = sc.nextLine();

          System.out.println("Digite o autor desse livro:");
          String autorRemover = sc.nextLine();
          
          b.removerLivro(tituloRemover, autorRemover);
          break;
          
          // Buscar Livros
        case 7:
          utl.clearScreen();
          System.out.println("Digite o titulo do livro a ser buscado:");
          String tituloBusca = sc.nextLine();
          
          System.out.println("Digite o autor desse livro:");
          String autorBusca = sc.nextLine();
          
          utl.printList(b.buscarLivro(tituloBusca, autorBusca));
          sc.nextLine();
          break;

          // Emprestar Livros
        case 8:
          int idUsuario = -1;
          
          utl.clearScreen();
          System.out.println("Digite o titulo do livro a ser emprestado:");
          String tituloEmprestimo = sc.nextLine();

          System.out.println("Digite o autor desse livro:");
          String autorEmprestimo = sc.nextLine();

          try{
            System.out.println("Digite o ID do usuario que ira receber:");
            idUsuario = sc.nextInt();
            sc.nextLine();
          } catch (InputMismatchException e) {
            System.out.println("Erro: Tipo de entrada inválido. Por favor, insira um número inteiro.");
            sc.nextLine();
            sc.nextLine();
            break;
          }
          
          b.realizarEmprestimo(b.buscarUsuario(idUsuario), b.buscarLivro(tituloEmprestimo, autorEmprestimo));
          break;

          // Baixar Livros
        case 9:
          int idUsuarioBaixar = -1;
          
          utl.clearScreen();
          System.out.println("Digite o titulo do livro a ser baixado:");
          String tituloBaixar = sc.nextLine();

          System.out.println("Digite o autor desse livro:");
          String autorBaixar = sc.nextLine();

          try{
            System.out.println("Digite o ID do usuario que ira receber:");
            idUsuarioBaixar = sc.nextInt();
            sc.nextLine();
          } catch (InputMismatchException e) {
            System.out.println("Erro: Tipo de entrada inválido. Por favor, insira um número inteiro.");
            sc.nextLine();
            sc.nextLine();
            break;
          }

          b.baixar(b.buscarUsuario(idUsuarioBaixar), b.buscarLivro(tituloBaixar, autorBaixar));
          break;
          
          // Devolver Livros
        case 10:
          int idUsuarioDevolver = -1;
          
          utl.clearScreen();
          System.out.println("Digite o titulo do livro a ser devolvido:");
          String tituloDevolver = sc.nextLine();

          System.out.println("Digite o autor desse livro:");
          String autorDevolver = sc.nextLine();

          try{
            System.out.println("Digite o ID do usuario que ira devolver:");
            idUsuarioDevolver = sc.nextInt();
            sc.nextLine();
          } catch (InputMismatchException e) {
            System.out.println("Erro: Tipo de entrada inválido. Por favor, insira um número inteiro.");
            sc.nextLine();
            sc.nextLine();
            break;
          }
          
          b.devolverEmprestimo(b.buscarUsuario(idUsuarioDevolver), b.buscarLivro(tituloDevolver, autorDevolver));
          break;
          
          // Sair
        case 11:
          utl.clearScreen();
          System.out.println("Saindo...");
          break;
          
          // Opção fora do menu
        default:
          utl.clearScreen();
          utl.printTipoErro();
          sc.nextLine();
          break;
        }
    }while(opcao != 11);
    sc.close();
  }
}