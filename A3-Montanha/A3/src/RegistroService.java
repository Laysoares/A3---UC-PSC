import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class RegistroService {
    private List<Registro> registros = new ArrayList<>();
    private int contadorId = 1;
    private final String CAMINHO_ARQUIVO = "registros.txt";

    //CONSTRUTOR
    public RegistroService() {
        carregarDoArquivo(); // ← Aqui! Carrega os dados ao iniciar o serviço
    }
    

    public void criarRegistro(String nome) {
        try {
            if (nome == null || nome.trim().isEmpty()) {
                throw new DadoInvalido("O nome não pode estar vazio.");
            }

            registros.add(new Registro(contadorId++, nome));
            salvarEmArquivo(); // salva após modificação
            System.out.println("Registro criado com sucesso!");

        } catch (DadoInvalido e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void listarRegistros() {
        if (registros.isEmpty()) {
            System.out.println("Nenhum registro encontrado.");
        } else {
            registros.forEach(System.out::println);
        }
    }

    public void buscarRegistro(int id) {
        Registro r = encontrarRegistro(id);
        System.out.println((r != null) ? "Registro encontrado: " + r : "Registro não encontrado.");
    }

    public void editarRegistro(int id, String novoNome) {
        Registro r = encontrarRegistro(id);
        if (r != null) {
            r.nome = novoNome;
            salvarEmArquivo();
            System.out.println("Registro atualizado com sucesso!");
        } else {
            System.out.println("Registro não encontrado.");
        }
    }

    public void excluirRegistro(int id) {
        Registro r = encontrarRegistro(id);
        if (r != null) {
            registros.remove(r);
            salvarEmArquivo();
            System.out.println("Registro excluído com sucesso!");
        } else {
            System.out.println("Registro não encontrado.");
        }
    }

    private Registro encontrarRegistro(int id) {
        for (Registro r : registros) {
            if (r.id == id)
                return r;
        }
        return null;
    }

    // Gravar os dados no arquivo
    private void salvarEmArquivo() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CAMINHO_ARQUIVO))) {
            for (Registro r : registros) {
                writer.println(r.id + "," + r.nome);
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }

    // Carregar os dados do arquivo ao iniciar
    public void carregarDoArquivo() {
        File arquivo = new File(CAMINHO_ARQUIVO);
        if (!arquivo.exists())
            return;

        try (Scanner scanner = new Scanner(arquivo)) {
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] partes = linha.split(",", 2);
                int id = Integer.parseInt(partes[0]);
                String nome = partes[1];
                registros.add(new Registro(id, nome));
                contadorId = Math.max(contadorId, id + 1);
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar arquivo: " + e.getMessage());
        }
    }

}
