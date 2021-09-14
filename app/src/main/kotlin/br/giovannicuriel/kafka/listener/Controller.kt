package br.giovannicuriel.kafka.listener

import br.giovannicuriel.kafka.DogAdoptionEvent
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletResponse

@RestController
class Controller(
    private val producer: Producer,
    private val mapper: ObjectMapper
){
    @PostMapping("/adoption")
    @ResponseStatus(HttpStatus.CREATED)
    fun createAdoption(@RequestBody request: DogAdoptionEvent) {
        producer.send(request)
    }
    @GetMapping("/adoption/sample")
    fun getSampleAdoption(response: HttpServletResponse): String {
        val obj = SampleDataGenerator.generateRandomDataFromSchema("src/main/avro/br.giovannicuriel.kafka.dog_adoption_event-value.avsc")
        response.addHeader("Content-Type", "application/json")
        return obj
    }
}
