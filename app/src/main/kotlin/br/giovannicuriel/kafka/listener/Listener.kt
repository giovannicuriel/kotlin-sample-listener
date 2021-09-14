package br.giovannicuriel.kafka.listener

import br.giovannicuriel.kafka.DogAdoptionEvent
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class Listener {
    @KafkaListener(topics = ["br.giovannicuriel.dog_events_super"],
        autoStartup = "true",
        groupId = "dog-event-processors",
        properties = ["auto-offset-reset:latest"]
    )
    fun processDogAdoption(puppy: DogAdoptionEvent) {
        println("New puppy adopted! $puppy")
    }
}