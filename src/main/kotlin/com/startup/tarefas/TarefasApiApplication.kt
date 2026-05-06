package com.startup.tarefas

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TarefasApiApplication

fun main(args: Array<String>) {
    runApplication<TarefasApiApplication>(*args)
}
