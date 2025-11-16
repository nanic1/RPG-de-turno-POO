# RPG de Turno - Projeto em Java

Este projeto implementa um RPG de turno simples utilizando **POO
(Programação Orientada a Objetos)**.\
Inclui dois aplicativos principais:

### **1️ AppInterativo.java** - Versão interativa com Scanner

### **2️ AppRoteiro.java** - Execução totalmente determinística, sem entrada do usuário

O projeto segue conceitos como:

-   Herança (`Personagem`, `Guerreiro`, `Mago`, `Inimigo`)\
-   Composição (`Inventario`, `Item`)\
-   Associação unidirecional e bidirecional\
-   Sobrescrita de métodos\
-   Encapsulamento\
-   Polimorfismo em ações (`Acoes`)

------------------------------------------------------------------------

# Estrutura do Projeto

    src/
     ├── AppInterativo.java
     ├── AppRoteiro.java
     └── dominio/
         ├── Entidade.java
         ├── Personagem.java
         ├── Guerreiro.java
         ├── Mago.java
         ├── Inimigo.java
         ├── Habilidade.java
         ├── TipoHabilidade.java
         ├── Item.java
         ├── Inventario.java
         ├── Jogador.java
         ├── Acoes.java

------------------------------------------------------------------------

# Como Compilar

> É necessário ter **JDK 17+** instalado.

Abra o terminal na pasta `src/` e execute:

``` bash
javac dominio/*.java App.java AppRoteiro.java
```

------------------------------------------------------------------------

# Como Executar

### **Executar o App principal (versão com Scanner)**

``` bash
java App
```

### **Executar o AppRoteiro (versão determinística)**

``` bash
java AppRoteiro
```

# Representantes do grupo

- Pedro de Castro Kurtz (202407278752)
- Gabriel Maccachero Araujo (202501441823)
- Victor Coutinho
