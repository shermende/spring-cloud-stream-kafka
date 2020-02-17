package dev.shermende;

import dev.shermende.binding.PayloadFlow;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.test.binder.MessageCollector;

@SpringBootTest
class SpringCloudStreamKafkaApplicationTests {

    @Autowired
    private Processor processor;

    @Autowired
    private PayloadFlow payloadFlow;

    @Autowired
    private MessageCollector collector;

    @Test
    public void processor() {
        final String payload = (String) collector.forChannel(processor.output()).poll().getPayload();
        Assertions.assertTrue(payload.contains("channel"));
    }

    @Test
    public void payloadFlow() {
        final String payload = (String) collector.forChannel(payloadFlow.output()).poll().getPayload();
        Assertions.assertTrue(payload.contains("channel"));
    }

}
