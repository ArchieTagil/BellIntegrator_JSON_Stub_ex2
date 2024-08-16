package BellIntegrator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerService {
    private Logger log = LoggerFactory.getLogger(KafkaConsumerService.class);

    @KafkaListener(topics = "postedmessages", groupId = "spring")
    public void receiveMessage(String message) {
        log.warn("message from kafka consumer: " + message);
    }
}
