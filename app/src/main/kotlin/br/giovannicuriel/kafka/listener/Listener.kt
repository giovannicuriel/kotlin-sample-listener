package br.giovannicuriel.kafka.listener

import br.giovannicuriel.kafka.DogAdoptionEvent
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class Listener(
    @Value("\${kafka.dog_topic}")
    val topics: Array<String>
) {
    @KafkaListener(topics = ["br.giovannicuriel.kafka.dog_adoption_event"], // could not find a easy way to get this value from application.yml
        autoStartup = "true",
        groupId = "dog-event-processors",
        properties = ["auto-offset-reset:latest"]
    )
    fun processDogAdoption(puppy: DogAdoptionEvent) {
        println("New puppy adopted! $puppy")
    }
}