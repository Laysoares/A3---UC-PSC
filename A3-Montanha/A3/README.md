# Sistema de Registro - CRUD em Java

Este é um projeto de linha de comando em Java que realiza operações CRUD (Create, Read, Update, Delete) com persistência em arquivo `.txt`.

## 🚀 Funcionalidades

- Criar novo registro
- Listar todos os registros
- Buscar registro por ID
- Editar registro
- Excluir registro
- Persistência automática em `registros.txt`
- Validação de campos (nome não pode estar vazio)

## 📁 Estrutura de Pastas

```plaintext
Projeto/
├── src/
│   ├── Main.java
│   ├── MenuUI.java
│   ├── Registro.java
│   └── RegistroService.java
├── registros.txt         <-- arquivo de dados (gerado automaticamente)
├── lib/                  <-- (se houver bibliotecas externas)
└── README.md
