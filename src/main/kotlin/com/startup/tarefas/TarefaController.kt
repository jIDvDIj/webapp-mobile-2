package com.startup.tarefas

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/tarefas")
class TarefaController {

    private val tarefas = mutableListOf<Tarefa>()
    private var contador = 1L

    @GetMapping
    fun listar(): List<Tarefa> = tarefas

    @GetMapping("/{id}")
    fun buscar(@PathVariable id: Long): ResponseEntity<Tarefa> {
        val tarefa = tarefas.find { it.id == id }
        return if (tarefa != null) ResponseEntity.ok(tarefa)
        else ResponseEntity.notFound().build()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun criar(@RequestBody tarefa: Tarefa): Tarefa {
        tarefa.id = contador++
        tarefas.add(tarefa)
        return tarefa
    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @RequestBody nova: Tarefa): ResponseEntity<Tarefa> {
        val tarefa = tarefas.find { it.id == id } ?: return ResponseEntity.notFound().build()
        tarefa.titulo = nova.titulo
        tarefa.descricao = nova.descricao
        return ResponseEntity.ok(tarefa)
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long): ResponseEntity<Void> {
        val removido = tarefas.removeIf { it.id == id }
        return if (removido) ResponseEntity.noContent().build()
        else ResponseEntity.notFound().build()
    }
}
