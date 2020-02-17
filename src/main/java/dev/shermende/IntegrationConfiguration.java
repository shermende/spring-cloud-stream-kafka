package dev.shermende;

import dev.shermende.binding.PayloadFlow;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.messaging.MessageChannel;

@Configuration
@EnableBinding({Processor.class, PayloadFlow.class})
public class IntegrationConfiguration {
    public static final String CHANNEL = "channel";

    @Bean(CHANNEL)
    public MessageChannel messageChannel() {
        return MessageChannels.publishSubscribe().get();
    }

    @Bean
    public IntegrationFlow sourceFlow(
        @Qualifier(CHANNEL) MessageChannel from,
        @Qualifier(Source.OUTPUT) MessageChannel to
    ) {
        return IntegrationFlows
            .from(from)
            .channel(to)
            .get();
    }

    @Bean
    public IntegrationFlow payloadFlow(
        @Qualifier(CHANNEL) MessageChannel from,
        @Qualifier(PayloadFlow.OUTPUT) MessageChannel to
    ) {
        return IntegrationFlows
            .from(from)
            .channel(to)
            .get();
    }

}
