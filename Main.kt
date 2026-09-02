import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    println("Iniciando a execução das tarefas...")

    val tempoTotal = measureTimeMillis {
        // launch cria uma nova corrotina sem bloquear a thread principal
        val tarefa1 = launch { processarDados(1, 1500L) }
        val tarefa2 = launch { processarDados(2, 1000L) }
        val tarefa3 = launch { processarDados(3, 2000L) }

        joinAll(tarefa1, tarefa2, tarefa3)
    }

    println("Todas as tarefas foram concluídas em $tempoTotal ms.")
}

suspend fun processarDados(id: Int, tempoEspera: Long) {
    println("Tarefa $id: Iniciou o processamento.")
    
    delay(tempoEspera) 
    
    println("Tarefa $id: Finalizou após $tempoEspera ms.")
}