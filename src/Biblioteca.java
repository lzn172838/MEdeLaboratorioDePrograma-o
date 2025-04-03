import java.util.ArrayList;
import java.util.Scanner;


public class Biblioteca { // 'Classe Biblioteca' é a classe principal que vai dar início ao nosso programa.
    private static final ArrayList<String> biblioteca = new ArrayList<>(); // Essa linha se refere ao Array(Lista), criado para organizar os livros.

    public static void Menu() {
        Scanner entrada = new Scanner(System.in);

        //Menu com o CRUD, "sair" e "seguir".
        System.out.println("\nBiblioteca em Java:"); // Título no topo para melhor organização.
        System.out.println("Listar todos (1)"); // Read.
        System.out.println("Adicionar Livro (2)"); //Create.
        System.out.println("Buscar Livro (3)"); // Search.
        System.out.println("Remover Livro (4)"); // Delete.
        System.out.println("Atualizar(5)"); // Update.
        System.out.println("Sair (6)"); // Sair.

        if (!entrada.hasNextInt()) { // O parâmetro encontrado nesse if tem como finalidade verificar se a entrada é número antes de seguir.
            System.out.println("\nEssa alternativa não existe. Digite uma opção válida.");
            entrada.nextLine();
            Menu();

        } else {
            int a = entrada.nextInt();

            if (a < 1 || a > 6) { // Caso o usuário digite um núemro menor do que 1 (negativo) ou maior do que 6, o código imprima uma mensagem.
                System.out.println("Essa alternativa não existe.");
                Menu();
            }

            if(a == 6) { // A partir da execução dessa estrutura, no momento em que o usuário digitar "6", o programa irá parar.
                System.exit(0);
            }

            if(a == 1) { // Chama a classe listar.
                listar();
            }

            if(a == 2){ // Chama a classe adicionar.
                adicionar();
            }

            if(a == 3){ // Chama a classe buscar.
                buscar();
            }

            if(a == 4){ // Chama a classe remover.
                remover();
            }

            if(a == 5){ // Chama a classe atualizar.
                atualizar();
            }
        }
        entrada.close();
    }

    public static void Voltar () { // Essa classe serve para dar continuidade ao programa, fazendo com que em uma só execução seja possível realizar todas as funcionalidades.
       while(true){
        Scanner entrada = new Scanner (System.in);
        System.out.println("\nDeseja voltar para o Menu e acessar outra funcionalidade? Sim/Não");
        String resposta = entrada.nextLine();

        if(resposta.equals("Sim") || resposta.equals("sim")){ // equals.(parâmetro) significa basicamente o '==', porém como se trata de igualdade em strings se utiliza esse termo.
            Menu();
            break;
        }
        if(resposta.equals("Não") || resposta.equals("não") || resposta.equals("Nao") || resposta.equals("nao")){
            System.exit(0);
        }
        
    }
        
    }

    public static void listar(){ // A classe listar imprime todos os livros encontrados dentro da lista.
        if (biblioteca.isEmpty()) {
            System.out.println("A biblioteca está vazia."); // Caso a lista esteja vazia, utilizando o termo 'biblioteca.isEmpty', uma mensagem é imprimida.
        } else {
            System.out.println("Livros disponíveis:");
            for (String livro : biblioteca) {
                System.out.println("- " + livro);
            }
        }
        Voltar();
    }

    public static void adicionar(){ // A classe adicionar tem como finalizar criar um input para o nome do livro e adicioná-lo, através do 'add', à String Biblioteca.
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite o nome do livro:");
        String livro = entrada.nextLine();
        biblioteca.add(livro);
        System.out.println("O livro foi adicionado.\n");
        Voltar();
    }

    public static void buscar(){ // A classe buscar tem como objetivo pedir o nome do livro e, através do termo 'contains' saber se esse livro está contido ou não dentro da lista. Dependendo da resposta uma mensagem diferente vai ser imprimida.
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite o nome do livro:");
        String livro = entrada.nextLine();

        if (biblioteca.contains(livro)){
            System.out.println(livro+" faz parte da biblioteca.");
        }else{
            System.out.println(livro+" não faz parte da biblioteca.");
        }
        Voltar();
    }

    public static void atualizar(){ // Essa classa se refere a atualização do nome de um livro que já pertencia a biblioteca. Através da criação de novas variáveis como 'livroAntigo' e 'livroNovo', além do termo 'set'.
        Scanner entrada = new Scanner (System.in);
        System.out.print("Digite o nome do livro: ");
        String livroAntigo = entrada.nextLine();

        if (biblioteca.contains(livroAntigo)) {
            System.out.print("Digite o novo nome do livro: ");
            String livroNovo = entrada.nextLine();
            biblioteca.set(biblioteca.indexOf(livroAntigo), livroNovo);
            System.out.println("Livro atualizado.");
        } else {
            System.out.println("O livro não está na biblioteca.");
        }
        Voltar();
    }

    public static void remover () { // Essa é a classe onde os livros são removidas pela ação 'biblioteca.remove(livro)', caso estejam dentro da biblioteca.
        Scanner entrada = new Scanner (System.in);
        System.out.println("Digite o nome do livro:");
        String livro = entrada.nextLine();

        if(biblioteca.remove(livro)) {
            System.out.print("O livro foi removido.");
        }else{
            System.out.println("O livro não está na biblioteca.");
        } 
        Voltar();
    }
    

    public static void main(String[] args) { // Tal classe dará início a execução do programa, chamando as classes anteriores e colocando-as em prática.
        Menu();
    }
}