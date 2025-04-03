import java.util.Scanner;

public class Biblioteca2 {
    private static String[] biblioteca = new String[100]; // Vetor com capacidade para 100 livros.
    private static int quantidadeLivros = 0;

    public static void Menu() {
        Scanner entrada = new Scanner(System.in);

        //Menu com o CRUD, "sair" e "seguir"
        System.out.println("\nBiblioteca em Java:");
        System.out.println("Listar todos (1)");// Read.
        System.out.println("Adicionar Livro (2)");//Create.
        System.out.println("Buscar Livro (3)");// Search.
        System.out.println("Remover Livro (4)");// Delete.
        System.out.println("Atualizar(5)");// Update.
        System.out.println("Sair (6)");// Sair.

        if (!entrada.hasNextInt()) {
            System.out.println("\nEssa alternativa não existe. Digite uma opção válida.");
            entrada.nextLine();
            Menu();
        } else {
            int a = entrada.nextInt();
            entrada.nextLine();

            if (a < 1 || a > 6) {// O parâmetro encontrado nesse if tem como finalidade verificar se a entrada é número antes de seguir.
                System.out.println("\nEssa alternativa não existe.");
                Menu();
            } else if (a == 6) { // A partir da execução dessa estrutura, no momento em que o usuário digitar "6", o programa irá parar.
                System.exit(0);
            } else if (a == 1) {
                listar();
            } else if (a == 2) {
                adicionar();
            } else if (a == 3) {
                buscar();
            } else if (a == 4) {
                remover();
            } else if (a == 5) {
                atualizar();
            }
        }
    }

    public static void Voltar() {
        while(true){
        Scanner entrada = new Scanner(System.in);
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

    public static void listar() {// A classe listar imprime todos os livros encontrados dentro da lista.
        if (quantidadeLivros == 0) {
            System.out.println("A biblioteca está vazia.");// Caso a lista esteja vazia, utilizando o termo 'biblioteca.isEmpty', uma mensagem é imprimida.
        } else {
            System.out.println("Livros disponíveis:");
            for (int i = 0; i < quantidadeLivros; i++) {
                System.out.println("- " + biblioteca[i]);
            }
        }
        Voltar();
    }

    public static void adicionar() {// A classe adicionar tem como finalizar criar um input para o nome do livro e adicioná-lo, através do 'add', à String Biblioteca.
        if (quantidadeLivros >= biblioteca.length) {
            System.out.println("A biblioteca está cheia.");
        } else {
            Scanner entrada = new Scanner(System.in);
            System.out.print("Digite o nome do livro: ");
            String livro = entrada.nextLine();
            biblioteca[quantidadeLivros++] = livro;
            System.out.println("O livro foi adicionado.\n");
        }
        Voltar();
    }

    public static void buscar() {// A classe buscar tem como objetivo pedir o nome do livro e, através do termo 'contains' saber se esse livro está contido ou não dentro da lista. Dependendo da resposta uma mensagem diferente vai ser imprimida.
        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite o nome do livro: ");
        String livro = entrada.nextLine();

        for (int i = 0; i < quantidadeLivros; i++) {
            if (biblioteca[i].equalsIgnoreCase(livro)) {
                System.out.println(livro + " faz parte da biblioteca.");
                Voltar();
                return;
            }
        }
        System.out.println(livro + " não faz parte da biblioteca.");
        Voltar();
    }

    public static void atualizar() {// Essa classa se refere a atualização do nome de um livro que já pertencia a biblioteca. Através da criação de novas variáveis como 'livroAntigo' e 'livroNovo', além do termo 'set'.
        if (quantidadeLivros == 0) {
            System.out.println("A biblioteca está vazia.");
            Voltar();
            return;
        }

        Scanner entrada = new Scanner(System.in);
        System.out.println("Livros disponíveis:");
        for (int i = 0; i < quantidadeLivros; i++) {
            System.out.println((i + 1) + ". " + biblioteca[i]);
        }

        System.out.print("Digite o número do livro que deseja atualizar: ");
        if (entrada.hasNextInt()) {
            int indice = entrada.nextInt() - 1;
            entrada.nextLine();
             if (indice >= 0 && indice < quantidadeLivros) {
                System.out.print("Digite o novo nome do livro: ");
                biblioteca[indice] = entrada.nextLine();
                System.out.println("Livro atualizado.");
            } else {
                System.out.println("Número inválido.");
            }
        } 
        else {
            System.out.println("Entrada inválida.");
            entrada.nextLine();
        }
        Voltar();
       
    }

    public static void remover() {
        if (quantidadeLivros == 0) {
            System.out.println("A biblioteca está vazia.");
            Voltar();
            return;
        }

        Scanner entrada = new Scanner(System.in);
        System.out.println("Livros disponíveis:");
        for (int i = 0; i < quantidadeLivros; i++) {
            System.out.println((i + 1) + ". " + biblioteca[i]);
        }

        System.out.print("Digite o número do livro que deseja remover: ");
        if (entrada.hasNextInt()) {
            int indice = entrada.nextInt() - 1;
            entrada.nextLine();
            if (indice >= 0 && indice < quantidadeLivros) {
                for (int j = indice; j < quantidadeLivros - 1; j++) {
                    biblioteca[j] = biblioteca[j + 1];
                }
                biblioteca[--quantidadeLivros] = null;
                System.out.println("O livro foi removido.");
            } else {
                System.out.println("Número inválido.");
            }
        } else {
            System.out.println("Entrada inválida.");
            entrada.nextLine();
        }
        Voltar();
    }

    public static void main(String[] args) {
        Menu();
    }
}


