import java.util.Scanner;

public class MenuUI {
    private final Scanner scanner = new Scanner(System.in);
    private final RegistroService service = new RegistroService();

    public void exibirMenu() {
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Criar novo registro");
            System.out.println("2. Listar todos os registros");
            System.out.println("3. Buscar registro (por identificador)");
            System.out.println("4. Editar registro");
            System.out.println("5. Excluir registro");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar o buffer

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite o nome do registro: ");
                    String nome = scanner.nextLine();
                    service.criarRegistro(nome);
                }
                case 2 -> service.listarRegistros();
                case 3 -> {
                    System.out.print("Digite o ID do registro: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    service.buscarRegistro(id);
                }
                case 4 -> {
                    System.out.print("Digite o ID do registro: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite o novo nome: ");
                    String novoNome = scanner.nextLine();
                    service.editarRegistro(id, novoNome);
                }
                case 5 -> {
                    System.out.print("Digite o ID do registro: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    service.excluirRegistro(id);
                }
                case 6 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 6);
    }
}
