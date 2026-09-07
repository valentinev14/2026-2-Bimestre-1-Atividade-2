import kotlinx.coroutines.*

fun main() = runBlocking {

    // Criar e iniciar a corrotina
    val tarefa = launch {
        println("Corrotina iniciada!")

        // Espera 2 segundos sem bloquear a thread
        delay(2000)

        println("Corrotina finalizada!")
    }

    // Aguardar a corrotina terminar
    tarefa.join()

    println("Programa principal finalizado!")
}