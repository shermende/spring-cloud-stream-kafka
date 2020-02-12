package dev.shermende;

import dev.shermende.binding.PayloadFlow;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@EnableBinding({Source.class, Sink.class, PayloadFlow.class})
public class SpringCloudStreamKafkaApplication implements CommandLineRunner {

    private final MessageChannel channel;

    public SpringCloudStreamKafkaApplication(
            @Qualifier("channel") MessageChannel channel
    ) {
        this.channel = channel;
    }

    @Override
    public void run(String... args) throws Exception {
        channel.send(getMessage());
    }

    private Message<Payload> getMessage() {
        return MessageBuilder.withPayload(getPayload()).build();
    }

    private Payload getPayload() {
        return Payload.builder().channel(String.valueOf(System.currentTimeMillis())).build();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudStreamKafkaApplication.class, args);
    }

}
