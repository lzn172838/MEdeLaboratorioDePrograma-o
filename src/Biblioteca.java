import java.util.Scanner;

public class Biblioteca {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String[] biblioteca = new String[100];
        int quantidadeLivros = 0;

        while (true) {
            System.out.println("\nBiblioteca em Java:");
            System.out.println("Listar todos (1)");
            System.out.println("Adicionar Livro (2)");
            System.out.println("Buscar Livro (3)");
            System.out.println("Remover Livro (4)");
            System.out.println("Atualizar (5)");
            System.out.println("Sair (6)");

            if (!entrada.hasNextInt()) {
                System.out.println("\nEssa alternativa não existe. Digite uma opção válida.");
                entrada.nextLine();
                continue;
            }

            int opcao = entrada.nextInt();
            entrada.nextLine();

            if (opcao < 1 || opcao > 6) {
                System.out.println("\nEssa alternativa não existe.");
                continue;
            }

            if (opcao == 6) {
                System.exit(0);
            }

            if (opcao == 1) {
                if (quantidadeLivros == 0) {
                    System.out.println("A biblioteca está vazia.");
                } else {
                    System.out.println("Livros disponíveis:");
                    for (int i = 0; i < quantidadeLivros; i++) {
                        System.out.println("- " + biblioteca[i]);
                    }
                }
            }

            if (opcao == 2) {
                if (quantidadeLivros >= biblioteca.length) {
                    System.out.println("A biblioteca está cheia.");
                } else {
                    System.out.print("Digite o nome do livro: ");
                    biblioteca[quantidadeLivros++] = entrada.nextLine();
                    System.out.println("O livro foi adicionado.\n");
                }
            }

            if (opcao == 3) {
                System.out.print("Digite o nome do livro: ");
                String livro = entrada.nextLine();
                boolean encontrado = false;

                for (int i = 0; i < quantidadeLivros; i++) {
                    if (biblioteca[i].equalsIgnoreCase(livro)) {
                        System.out.println(livro + " faz parte da biblioteca.");
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println(livro + " não faz parte da biblioteca.");
                }
            }

            if (opcao == 4) {
                if (quantidadeLivros == 0) {
                    System.out.println("A biblioteca está vazia.");
                } else {
                    System.out.println("Livros disponíveis:");
                    for (int i = 0; i < quantidadeLivros; i++) {
                        System.out.println((i + 1) + ". " + biblioteca[i]);
                    }

                    System.out.print("Digite o número do livro que deseja remover: ");
                    if (entrada.hasNextInt()) {
                        int indice = entrada.nextInt() - 1;//-1 para se alinhar com o indice númerico dos arrays
                        entrada.nextLine();
                        if (indice >= 0 && indice < quantidadeLivros) {
                            for (int j = indice; j < quantidadeLivros - 1; j++) {// -1 serve para que a variavel indice esteja de acordo como
                            biblioteca[j] = biblioteca[j + 1];                   // indice de posição das arrays
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
                }
            }

            if (opcao == 5) {
                if (quantidadeLivros == 0) {
                    System.out.println("A biblioteca está vazia.");
                } else {
                    System.out.println("Livros disponíveis:");
                    for (int i = 0; i < quantidadeLivros; i++) {
                        System.out.println((i + 1) + ". " + biblioteca[i]);
                    }

                    System.out.print("Digite o número do livro que deseja atualizar: ");
                    if (entrada.hasNextInt()) {
                        int indice = entrada.nextInt() - 1; // -1 serve para que a variavel indice esteja de acordo como
                                                            // indice de posição das arrays igual na opção de remover
                        entrada.nextLine();
                        if (indice >= 0 && indice < quantidadeLivros) {
                            System.out.print("Digite o novo nome do livro: ");
                            biblioteca[indice] = entrada.nextLine();
                            System.out.println("Livro atualizado.");
                        } else {
                            System.out.println("Número inválido.");
                        }
                    } else {
                        System.out.println("Entrada inválida.");
                        entrada.nextLine();
                    }
                }
            }
        }
    }
}