package br.giovannicuriel.kafka.listener

import br.giovannicuriel.kafka.DogAdoptionEvent
import org.apache.kafka.clients.admin.NewTopic
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.kafka.config.TopicBuilder
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class Producer(
    @Value("\${kafka.dog_topic}")
    private val topicName: String,
    private val template: KafkaTemplate<String, DogAdoptionEvent>
){

    fun send(request: DogAdoptionEvent) {
        println("[producer] Sending adoption event for dog ${request.payload.dog.name.toString()}")
        template.send(topicName, request.payload.dog.name.toString(), request)
    }

    @Bean
    fun topicExample(): NewTopic {
        return TopicBuilder.name(topicName)
            .partitions(1)
            .build();
    }
}
