# 🎯 Java Clean Architecture - CodeChella

[![Java](https://img.shields.io/badge/Java-17-ED8B00?style=flat-square&logo=openjdk&logoColor=white)](https://openjdk.org/projects/jdk/17/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.2-6DB33F?style=flat-square&logo=spring&logoColor=white)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-336791?style=flat-square&logo=postgresql&logoColor=white)](https://www.postgresql.org/)
[![Maven](https://img.shields.io/badge/Maven-Build%20Tool-C71A36?style=flat-square&logo=apache-maven&logoColor=white)](https://maven.apache.org/)

> 🎪 Sistema de gerenciamento de usuários para venda de ingressos de eventos, implementado seguindo os princípios da **Clean Architecture**.

## 📋 Índice

- [🎯 Sobre o Projeto](#-sobre-o-projeto)
- [🏛️ Arquitetura](#-arquitetura)
- [📂 Estrutura de Camadas](#-estrutura-de-camadas)
- [🚀 Tecnologias](#-tecnologias)
- [📦 Instalação e Execução](#-instalação-e-execução)
- [🧪 Testes](#-testes)
- [📐 Princípios Aplicados](#-princípios-aplicados)
- [🎓 Aprendizados](#-aprendizados)

## 🎯 Sobre o Projeto

O **CodeChella** é uma aplicação backend desenvolvida para demonstrar a implementação prática dos conceitos de **Clean Architecture** em Java. O sistema gerencia usuários que participam de eventos, com funcionalidades completas de CRUD.

### ✨ Funcionalidades

- ✅ **Cadastro de usuários** com validação de CPF
- ✅ **Listagem de usuários** cadastrados
- ✅ **Alteração de dados** de usuários existentes
- ✅ **Exclusão de usuários** do sistema
- ✅ **Gerenciamento de endereços** associados aos usuários
- ✅ **Validações de domínio** integradas

## 🏛️ Arquitetura

Este projeto implementa a **Clean Architecture**, proposta por Robert C. Martin (Uncle Bob), organizando o código em camadas bem definidas com separação clara de responsabilidades.

```
┌─────────────────────────────────────────────────────────────┐
│                     🌐 FRAMEWORKS & DRIVERS                 │
│     (Spring Boot, PostgreSQL, JPA, Web Controllers)        │
├─────────────────────────────────────────────────────────────┤
│                   🔧 INTERFACE ADAPTERS                     │
│        (Gateways, Repositories, Config, Mappers)           │
├─────────────────────────────────────────────────────────────┤
│                    📋 APPLICATION LAYER                     │
│              (Use Cases, Business Rules)                   │
├─────────────────────────────────────────────────────────────┤
│                      💎 DOMAIN LAYER                       │
│           (Entities, Value Objects, Domain Logic)          │
└─────────────────────────────────────────────────────────────┘
```

### 🎯 Direção de Dependências

As dependências **sempre** apontam para dentro, garantindo que:
- ✅ O domínio não conhece infraestrutura
- ✅ As regras de negócio são independentes
- ✅ Facilita testes e manutenção
- ✅ Permite troca de tecnologias sem impacto no core

## 📂 Estrutura de Camadas

### 💎 **Domain Layer** (Núcleo)
```
src/main/java/br/com/alura/codechella/domain/
├── entities/
│   └── usuario/
│       └── Usuario.java                 # 👤 Entidade principal do usuário
└── Endereco.java                        # 🏠 Value Object para endereço
```

**Responsabilidades:**
- 🧠 Regras de negócio fundamentais
- 🔒 Validações de domínio (ex: formato CPF)
- 📊 Entidades e objetos de valor
- 🚫 **ZERO dependências externas**

### 📋 **Application Layer** (Casos de Uso)
```
src/main/java/br/com/alura/codechella/application/
└── usecases/
    ├── ListarUsuariosUseCase.java       # 📋 Listar todos os usuários
    ├── AlterarUsuarioUseCase.java       # ✏️ Alterar dados do usuário
    └── ExcluirUsuarioUseCase.java       # 🗑️ Remover usuário
```

**Responsabilidades:**
- 🎭 Orquestração de regras de negócio
- 🔄 Coordenação entre domínio e infraestrutura
- 📝 Implementação de casos de uso específicos
- 🎯 Manutenção de estado da aplicação

### 🔧 **Infrastructure Layer** (Adaptadores)
```
src/main/java/br/com/alura/codechella/infra/
├── gateways/
│   └── RepositorioDeUsuarioEmArquivo.java    # 💾 Implementação em memória
└── persistence/
    └── UsuarioRepository.java                # 🗄️ Repository JPA
```

**Responsabilidades:**
- 🔌 Implementação de interfaces do domínio
- 💾 Acesso a dados (database, arquivos, APIs)
- 🌐 Comunicação com sistemas externos
- 🔄 Mapeamento entre camadas

### ⚙️ **Configuration Layer** (Injeção de Dependência)
```
src/main/java/br/com/alura/codechella/config/
└── UsuarioConfig.java                   # 🔧 Configuração Spring
```

**Responsabilidades:**
- 🔗 Configuração de beans Spring
- 💉 Injeção de dependências
- 🔧 Wiring entre camadas
- ⚙️ Setup de infraestrutura

## 🚀 Tecnologias

| Categoria | Tecnologia | Versão | Descrição |
|-----------|------------|--------|-----------|
| **Core** | Java | 17 | ☕ Linguagem principal |
| **Framework** | Spring Boot | 3.2.2 | 🚀 Framework web e DI |
| **Banco** | PostgreSQL | Latest | 🐘 Banco de dados relacional |
| **ORM** | Spring Data JPA | 3.2.2 | 🗄️ Mapeamento objeto-relacional |
| **Build** | Maven | Latest | 📦 Gerenciamento de dependências |
| **Testes** | JUnit 5 | Latest | 🧪 Framework de testes |

## 📦 Instalação e Execução

### 📋 **Pré-requisitos**

- ☕ **Java 17** ou superior
- 🐘 **PostgreSQL** em execução
- 📦 **Maven** (ou use o wrapper incluído)

### 🔧 **Configuração do Banco**

1. **Crie o banco de dados:**
```sql
CREATE DATABASE codechella_db;
```

2. **Configure as variáveis de ambiente:**
```bash
# Windows (PowerShell)
$env:DB_HOST="localhost"
$env:DB_USER="seu_usuario"
$env:DB_PASSWORD="sua_senha"

# Linux/Mac
export DB_HOST=localhost
export DB_USER=seu_usuario
export DB_PASSWORD=sua_senha
```

### 🚀 **Executando a Aplicação**

```bash
# Clone o repositório
git clone <url-do-repositorio>
cd java-clean-architecture

# Execute com Maven Wrapper (recomendado)
./mvnw spring-boot:run

# Ou com Maven instalado
mvn spring-boot:run
```

### � **Usando Docker (Opcional)**

```yaml
# docker-compose.yml
version: '3.8'
services:
  postgres:
    image: postgres:15
    environment:
      POSTGRES_DB: codechella_db
      POSTGRES_USER: codechella
      POSTGRES_PASSWORD: password
    ports:
      - "5432:5432"
```

```bash
docker-compose up -d
```

## 🧪 Testes

### 🏃‍♂️ **Executando Testes**

```bash
# Todos os testes
./mvnw test

# Apenas testes unitários
./mvnw test -Dtest="**/*Test"

# Com relatório de cobertura
./mvnw test jacoco:report
```

### 📊 **Estrutura de Testes**

```
src/test/java/
├── domain/
│   └── entities/
│       └── usuario/
│           └── UsuarioTest.java         # 🧪 Testes da entidade Usuario
└── CodechellaApplicationTests.java      # 🔧 Teste de contexto Spring
```

### ✅ **Exemplos de Testes**

```java
@Test
public void naoDeveCadastrarUsuarioComCpfNoFormatoInvalido() {
    // ❌ CPF inválido deve lançar exceção
    Assertions.assertThrows(IllegalArgumentException.class,
        () -> new Usuario("123456.789-99", "João", 
                         LocalDate.parse("1990-09-08"), 
                         "email@email.com"));
}

@Test
public void deveCriarUsuarioUsandoFabricaDeUsuario() {
    // ✅ Factory pattern para criação válida
    FabricaDeUsuario fabrica = new FabricaDeUsuario();
    Usuario usuario = fabrica.comNomeCpfNascimento("Emily", 
                                                  "654.123.897-88",
                                                  LocalDate.parse("2000-10-01"));
    
    Assertions.assertEquals("Emily", usuario.getNome());
}
```

## 📐 Princípios Aplicados

### 🎯 **SOLID Principles**

| Princípio | Aplicação no Projeto |
|-----------|---------------------|
| **S**RP | 📋 Cada classe tem uma única responsabilidade bem definida |
| **O**CP | 🔧 Extensível via interfaces, fechado para modificações |
| **L**SP | 🔄 Implementações respeitam contratos das interfaces |
| **I**SP | 🎯 Interfaces específicas e coesas |
| **D**IP | 🔗 Dependências abstratas, não concretas |

### 🏛️ **Clean Architecture Benefits**

- ✅ **Independência de Framework**: Core não depende do Spring
- ✅ **Independência de Database**: Pode trocar PostgreSQL por outro
- ✅ **Independência de UI**: Backend desacoplado do frontend
- ✅ **Testabilidade**: Cada camada pode ser testada isoladamente
- ✅ **Flexibilidade**: Mudanças na infraestrutura não afetam regras de negócio

### 🔄 **Dependency Inversion em Ação**

```java
// ❌ Dependência concreta (violação)
public class ListarUsuariosUseCase {
    private PostgreSQLUsuarioRepository repo; // Acoplamento forte
}

// ✅ Dependência abstrata (correto)
public class ListarUsuariosUseCase {
    private final RepositorioDeUsuario repositorio; // Interface
    
    public ListarUsuariosUseCase(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }
}
```

## 🎓 Aprendizados

### 💡 **Principais Conceitos Demonstrados**

1. **🏗️ Separação de Camadas**
   - Domain: Regras de negócio puras
   - Application: Orquestração de casos de uso
   - Infrastructure: Detalhes técnicos

2. **🔗 Inversão de Dependências**
   - Use Cases dependem de abstrações
   - Infraestrutura implementa interfaces do domínio

3. **🧪 Facilidade de Testes**
   - Mocks simples para interfaces
   - Testes rápidos sem infraestrutura

4. **🔄 Flexibilidade Arquitetural**
   - Troca de persistência sem alterar regras
   - Adição de features isoladamente

### 📈 **Próximos Passos**

- [ ] 🌐 Adicionar controllers REST
- [ ] 📊 Implementar DTOs para API
- [ ] 🔐 Adicionar autenticação/autorização
- [ ] 📈 Incluir métricas e observabilidade
- [ ] 🧪 Expandir cobertura de testes
- [ ] 📝 Documentação da API (Swagger)

### 🎯 **Cenários de Uso Ideais**

- ✅ **Sistemas críticos** com regras complexas
- ✅ **Aplicações de longa duração** que evoluem
- ✅ **Equipes grandes** com especialistas em diferentes camadas
- ✅ **Produtos que precisam de alta testabilidade**

---

## 📚 Referências

- 📖 [Clean Architecture - Robert C. Martin](https://www.amazon.com/Clean-Architecture-Craftsmans-Software-Structure/dp/0134494164)
- 🎓 [Curso Alura - Arquitetura Java](https://www.alura.com.br/)
- 🌐 [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- 🔧 [Maven Documentation](https://maven.apache.org/guides/)

---

**💡 Dica:** Este projeto é ideal para estudar os princípios fundamentais da Clean Architecture em Java. Cada commit e estrutura foi pensada para demonstrar conceitos específicos de arquitetura limpa.

**🎯 Objetivo:** Capacitar desenvolvedores a implementar sistemas robustos, testáveis e evolutivos seguindo as melhores práticas da indústria.


