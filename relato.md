## Introdução

Introdução
Este relato faz parte do processo avaliativo da disciplina de Sistemas Operacionais no curso superior em Análise e Desenvolvimento de Sistemas, ofertado na Diretoria Acadêmica de Gestão e Tecnologia da Informação no Campus Natal-Central do Instituto Federal de Educação, Ciência e Tecnologia do Rio Grande do Norte.

Tem como objetivo principal relatar como implementar linhas de execução na linguagem Kotlin.

O grupo é formado por Ana Letícia, Iago e Valentine


### Informações gerais sobre Kotlin

O Kotlin é uma linguagem de programação moderna, multiparadigma e estaticamente tipada, desenvolvida para rodar primariamente sobre a Máquina Virtual Java (JVM), além de possuir suporte para compilação nativa e JavaScript. Seu principal objetivo é unir a programação orientada a objetos e funcional em uma sintaxe concisa, segura e totalmente interoperável com o ecossistema Java.

No que tange à concorrência, o Kotlin adota o modelo de corrotinas (coroutines). Elas funcionam como "threads leves" (lightweight threads), permitindo executar operações assíncronas de forma altamente eficiente sem incorrer no alto custo de alocação de recursos e trocas de contexto característicos das threads tradicionais gerenciadas diretamente pelo sistema operacional.


### Criando linhas de execução

O processo de criação de linhas de execução leves em Kotlin baseia-se na utilização de escopos de corrotina, como o runBlocking, que atua como uma ponte entre o código síncrono tradicional e o mundo assíncrono, bloqueando temporariamente a thread principal até que todas as operações internas sejam concluídas.

A inicialização de uma nova linha de execução concorrente é feita através da função de construção launch. Durante a implementação do primeiro exemplo, a experiência demonstrou o uso da função de suspensão delay, que pausa a execução da tarefa por um intervalo determinado (por exemplo, 2 segundos) sem congelar a thread subjacente. O fluxo principal é sincronizado utilizando o método join sobre a referência da tarefa, garantindo que o programa aguarde o término do processo antes de encerrar.

### Passando valores para linhas de execução

Para cenários onde as linhas de execução precisam receber parâmetros e executar rotinas personalizadas, o processo envolve a declaração de funções com o modificador suspend. O modificador de suspensão permite que a função seja pausada e retomada de forma segura dentro do ecossistema de corrotinas.

Durante essa etapa da atividade, o processo consistiu em definir uma função parametrizada para receber valores específicos — como uma string de identificação e um contador numérico — e invocá-la de dentro do bloco de execução assíncrona gerado pelo launch. A passagem de argumentos ocorreu de maneira direta, mantendo a clareza do código e permitindo que o escopo interno processasse os dados repassados enquanto a sincronização final era garantida pelo método de espera correspondente.

### Múltiplas linhas de execução

A implementação de múltiplas linhas de execução simultâneas exigiu uma estratégia de gerenciamento em lote para coordenar vários processos concorrentes. O processo foi estruturado instanciando uma lista mutável para armazenar as referências individuais de cada tarefa gerada.

Em seguida, utilizou-se uma estrutura de repetição para disparar múltiplos trabalhadores concorrentes em paralelo, cada um simulando um tempo de processamento próprio mediado por atrasos programados. Para mensurar o ganho de desempenho do paralelismo, a rotina incorporou a captura de marcas temporais do sistema antes e depois da execução. O controle de término foi realizado iterando sobre a lista de tarefas para aplicar o método de espera em cada uma delas individualmente, garantindo que o cálculo do tempo total só ocorresse após a finalização de todos os fluxos concorrentes.

## Considerações finais

O desenvolvimento desta atividade prática proporcionou uma compreensão sobre a concorrência moderna utilizando corrotinas em Kotlin. Observou-se que a abstração de threads leves simplifica consideravelmente a estruturação de códigos assíncronos e paralelos, oferecendo alta performance e legibilidade superior em comparação aos mecanismos tradicionais de baixo nível. O uso do ambiente Docker assegurou a padronização e o correto isolamento de dependências durante todo o processo de compilação e execução.