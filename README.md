# A3-PSC
Realização do trabalho A3
# Entidade: Cliente de Loja de Roupa

## Nome
**ClienteDeLoja**

## Principais Atributos

- `id: UUID` — Identificador único do cliente.
- `nome: String` — Nome completo do cliente.
- `email: String` — Endereço de e-mail do cliente.
- `telefone: String` — Número de telefone para contato.
- `dataCadastro: Date` — Data de cadastro do cliente na loja.
- `historicoCompras: List<Compra>` — Lista contendo o histórico de compras realizadas pelo cliente.

## Justificativa de Relevância

A entidade **ClienteDeLoja** é essencial para o domínio de uma loja de roupas, pois representa a base de relacionamento entre a empresa e seus consumidores. Através dessa entidade, é possível armazenar informações importantes para a realização de vendas, envio de promoções personalizadas e análise de comportamento de compra, contribuindo diretamente para estratégias de marketing e fidelização.

## Diagrama de Classes

O diagrama de classes da entidade foi criado utilizando a notação UML, incluindo:

- **Atributos** com tipos e visibilidade.
- **Construtor** para inicialização dos principais atributos.
- **Getters e Setters** para manipulação controlada dos dados.
- **Métodos de Negócio**:
  - `adicionarCompra(compra: Compra): void` — Adiciona uma compra ao histórico.
  - `calcularValorTotalCompras(): Double` — Calcula o valor total gasto pelo cliente em compras.

## Arquivos no Repositório

- `ClienteDeLoja.drawio.pdf`: Arquivo contendo o diagrama de classes em formato PDF.
- `descricao.md`: Este arquivo de descrição em Markdown.

