package dev.shermende.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SinkListener {
    private static final String GROUP = "kafka_groupId";
    private static final String PARTITION = "kafka_receivedPartitionId";

    @StreamListener(Sink.INPUT)
    public void input(Message<?> message) {
        log.info("[Group: {}] [Partition: {}] [Payload: {}]",
            message.getHeaders().get(GROUP), message.getHeaders().get(PARTITION), message.getPayload());
    }

}
