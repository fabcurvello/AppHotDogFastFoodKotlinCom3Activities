# App Hot Dog Fast Food com 3 Activities (Kotlin)

> Repositório didático: exercício prático de Android nativo com **Kotlin**, desenvolvido e aplicado em sala de aula pelo Prof. Fabricio Curvello.

## Sobre o projeto

Evolução do app de pedidos de cachorro-quente, agora dividido em **três telas**: montagem do pedido, confirmação e agradecimento.

## Contexto acadêmico

Exercício aplicado em sala de aula, usado como prática guiada com os alunos.

## O que o app faz

- **Tela 1**: o cliente informa o nome e escolhe proteína (`RadioGroup`), molhos (`CheckBox`) e acompanhamentos (`Switch`).
- **Tela 2**: recebe os dados por `Intent` e mostra o resumo do pedido, com opções de voltar ou avançar.
- **Tela 3**: agradece ao cliente pelo nome e permite iniciar um novo pedido, limpando a pilha de telas.

## Conceitos trabalhados em aula

- Navegação entre várias Activities com `Intent`
- Envio de vários dados com `putExtra` e recuperação com `intent.extras`
- Flags de Intent (`FLAG_ACTIVITY_CLEAR_TOP`, `FLAG_ACTIVITY_NEW_TASK`)
- Componentes de formulário e `ImageView` clicável
- Logs com `Log.i`

## Tecnologias

- **Kotlin**
- **Android SDK** (Android Studio)
- **Gradle**
- `minSdk 25` / `compileSdk 34`

## Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/fabcurvello/AppHotDogFastFoodKotlinCom3Activities.git
   ```
2. Abra a pasta no **Android Studio** e aguarde a sincronização do Gradle.
3. Execute em um emulador ou dispositivo físico com Android compatível com a API 25 ou superior.

## Veja também

Outros repositórios de aula com o mesmo tema:

- [appHotDogJava](https://github.com/fabcurvello/appHotDogJava)
- [appHotDogFastFoodKotlin](https://github.com/fabcurvello/appHotDogFastFoodKotlin)

## Autor

**Fabricio Curvello**: professor de desenvolvimento de software no SENAI-RJ (desde 1997) e em faculdades do grupo Ânima Educação (IBMR e UNA).

- GitHub: [github.com/fabcurvello](https://github.com/fabcurvello)
- LinkedIn: [linkedin.com/in/fabriciocurvello](https://www.linkedin.com/in/fabriciocurvello)
- YouTube: [@fabriciocurvello](https://www.youtube.com/@fabriciocurvello)
