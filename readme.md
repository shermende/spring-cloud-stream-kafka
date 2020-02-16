# Spring cloud stream kafka

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=shermende_spring-cloud-stream-kafka&metric=alert_status)](https://sonarcloud.io/dashboard?id=shermende_spring-cloud-stream-kafka)
[![CircleCI](https://circleci.com/gh/shermende/spring-cloud-stream-kafka.svg?style=svg)](https://circleci.com/gh/shermende/spring-cloud-stream-kafka)

## Run
```
$ docker-compose up -d --build
$ ./gradlew bootRun
```
* localhost:9000 - [kafkadrop](https://github.com/obsidiandynamics/kafdrop). kafka web ui

## References
* [Guide](https://dzone.com/articles/spring-cloud-stream-with-kafka)
* [Spring docs](https://docs.spring.io/spring-cloud-stream/docs/Chelsea.SR2/reference/htmlsingle/)
* [Partitioning and multithreading](https://stackoverflow.com/questions/25896109/in-apache-kafka-why-cant-there-be-more-consumer-instances-than-partitions)
* [Spring cloud stream kafka DLQ](https://stackoverflow.com/questions/51247113/correctly-manage-dlq-in-spring-cloud-stream-kafka)
* [Kafka DLQ explain](https://www.confluent.io/blog/kafka-connect-deep-dive-error-handling-dead-letter-queues/)
###### Keywords: spring integration, spring cloud stream kafka