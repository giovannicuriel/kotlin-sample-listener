package br.giovannicuriel.kafka.listener

import br.giovannicuriel.kafka.DogAdoptionEvent
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.clients.admin.NewTopic
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpStatus
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller(
    private val producer: Producer
){
    @PostMapping("/adoption")
    @ResponseStatus(HttpStatus.CREATED)
    fun createAdoption(@RequestBody request: DogAdoptionEvent) {
        producer.send(request)

    }

}
