package com.startup.tarefas

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@SpringBootTest
@AutoConfigureMockMvc
class TarefaControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun `deve listar tarefas vazia inicialmente`() {
        mockMvc.perform(get("/tarefas"))
            .andExpect(status().isOk)
            .andExpect(content().json("[]"))
    }

    @Test
    fun `deve criar uma tarefa`() {
        val json = """{"titulo":"Estudar Kotlin","descricao":"Praticar Spring Boot"}"""
        mockMvc.perform(
            post("/tarefas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
        )
            .andExpect(status().isCreated)
            .andExpect(jsonPath("$.id").exists())
            .andExpect(jsonPath("$.titulo").value("Estudar Kotlin"))
    }

    @Test
    fun `deve retornar 404 ao buscar tarefa inexistente`() {
        mockMvc.perform(get("/tarefas/9999"))
            .andExpect(status().isNotFound)
    }
}
