package br.giovannicuriel.kafka.listener

import br.giovannicuriel.kafka.DogAdoptionEvent
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class Producer(
    @Value("\${kafka.topic}")
    private val topicName: String,
    private val template: KafkaTemplate<String, DogAdoptionEvent>,
    private val mapper: ObjectMapper
){

    fun send(request: DogAdoptionEvent) {
        println("[producer] Sending adoption event for dog ${request.payload.dog.name.toString()}")
        template.send(topicName, request.payload.dog.name.toString(), request)
    }
}
