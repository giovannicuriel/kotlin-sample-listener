package br.giovannicuriel.kafka.listener

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder

@Configuration
class KafkaTopicConfiguration(
    @Value("\$kafka.dog_topic")
    val topic: String
) {

    @Bean
    fun topicExample(): NewTopic {
        return TopicBuilder.name(topic)
            .partitions(1)
            .build();
    }
}