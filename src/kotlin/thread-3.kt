import kotlinx.coroutines.*

suspend fun trabalhador(numero: Int, tempoTrabalho: Long) {
    println("Trabalhador $numero começou")
    delay(tempoTrabalho * 1000) 
    println("Trabalhador $numero terminou (levou ${tempoTrabalho}s)")
}

fun main() = runBlocking {
    println("Iniciando 5 trabalhadores...")
    
    // 1. Pegar o tempo inicial manualmente
    val inicio = System.currentTimeMillis()
    
    // 2. Criar uma lista vazia e mutável para guardar as corrotinas (Jobs)
    val tarefas = mutableListOf<Job>()
    
    // 3. Criar e iniciar as 5 corrotinas usando um for explícito
    for (i in 0 until 5) {
        // Criar corrotina passando argumentos, idêntico ao Código 2
        val tarefa = launch {
            trabalhador(i, 2)
        }
        tarefas.add(tarefa)
    }
    
    // 4. Aguardar cada corrotina terminar usando outro for explícito
    for (tarefa in tarefas) {
        tarefa.join()
    }
    
    // 5. Pegar o tempo final e calcular a diferença manualmente
    val fim = System.currentTimeMillis()
    val tempoTotalS = (fim - inicio) / 1000.0
    
    println("\nTodos os trabalhadores terminaram!")
    println("Tempo total: %.2fs".format(tempoTotalS))
    println("(Se fosse sequencial, levaria ~10s)")
}