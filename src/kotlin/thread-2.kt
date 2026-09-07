import kotlinx.coroutines.*

suspend fun saudar(nome: String, vezes: Int) {
    for (i in 1..vezes) {
        println("Olá, $nome! (mensagem $i)")
    }
}

fun main() = runBlocking {

    // Criar corrotina passando argumentos
    val tarefa = launch {
        saudar("Maria", 3)
    }

    // Aguardar a corrotina terminar
    tarefa.join()
}