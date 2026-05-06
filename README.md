# Tarefas API

API REST para gerenciamento de tarefas, desenvolvida com **Spring Boot + Kotlin**. Inclui uma interface web que roda diretamente no navegador ao subir o servidor.

---

## Tecnologias

- Kotlin 1.9.20
- Spring Boot 3.2.0
- Gradle 8.5 (wrapper incluído)
- Java 17
- Frontend em HTML/CSS/JS puro (servido pelo Spring Boot)

---

## Pré-requisitos

Antes de começar, você precisa ter instalado:

- **JDK 17 ou superior** — [download](https://adoptium.net/)
  - Verifique com: `java -version`

> O Gradle **não precisa ser instalado** — o projeto usa o Gradle Wrapper (`gradlew`), que baixa a versão correta automaticamente.

---

## Passo a passo após o git pull

### 1. Clonar o repositório

```bash
git clone <url-do-repositorio>
cd webapp-mobile-2
```

### 2. Subir o servidor

**Linux / macOS:**
```bash
./gradlew bootRun
```

**Windows (PowerShell):**
```bash
gradlew.bat bootRun
```

Na primeira execução o Gradle vai baixar as dependências — isso pode levar alguns minutos. Quando aparecer a linha abaixo, o servidor está pronto:

```
Started TarefasApiApplicationKt in X.XXX seconds
```

### 3. Acessar a interface

Abra o navegador em:

```
http://localhost:8080
```

A interface web carrega automaticamente e já se conecta à API.

---

## Endpoints da API

| Método | Rota | Descrição |
|--------|------|-----------|
| `GET` | `/tarefas` | Lista todas as tarefas |
| `GET` | `/tarefas/{id}` | Busca uma tarefa pelo ID |
| `POST` | `/tarefas` | Cria uma nova tarefa |
| `PUT` | `/tarefas/{id}` | Atualiza uma tarefa existente |
| `DELETE` | `/tarefas/{id}` | Remove uma tarefa |

### Exemplo de payload (POST / PUT)

```json
{
  "titulo": "Estudar Kotlin",
  "descricao": "Revisar coroutines e data classes"
}
```

---

## Executar os testes

```bash
# Linux / macOS
./gradlew test

# Windows
gradlew.bat test
```

---

## Estrutura do projeto

```
webapp-mobile-2/
├── src/
│   ├── main/
│   │   ├── kotlin/com/startup/tarefas/
│   │   │   ├── TarefasApiApplication.kt   # Entry point
│   │   │   ├── Tarefa.kt                  # Model
│   │   │   └── TarefaController.kt        # Endpoints REST
│   │   └── resources/
│   │       ├── static/
│   │       │   └── index.html             # Interface web
│   │       └── application.properties     # Configurações
│   └── test/
│       └── kotlin/com/startup/tarefas/
│           └── TarefaControllerTest.kt    # Testes de integração
├── build.gradle.kts
├── settings.gradle.kts
└── gradlew / gradlew.bat
```

---

## Observações

- Os dados são armazenados **em memória** — ao reiniciar o servidor, as tarefas são apagadas.
- O servidor sobe na porta **8080** por padrão.
