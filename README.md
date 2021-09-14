# kotlin-sample-listener
A simple service that listens to messages via Kafka.

```bash

docker-compose up -d

# Register the avro schema, under subject "br.giovannicuriel.kafka.dog_adoption_event-value"

./gradlew clean build

# If you have no avro schema, but it does exist in Schema Registry, you could download it by executing
# ./gradlew downloadSchemasTask

curl localhost:8080/adoption -H 'Content-Type: application/json' -d '{
  "payload": {
    "id": "super-id-1",
    "dog": {
      "name": "tobias",
      "age": "3",
      "breed": "vira-lata",
      "weight": "2kg",
      "size": "small"
    },
    "owner": {
      "name": "eu mesmo",
      "age": "37"
    }
  }
}'

```