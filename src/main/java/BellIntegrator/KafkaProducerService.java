package BellIntegrator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
//import org.springframework.kafka.support.SendResult;
//
//import java.util.concurrent.CompletableFuture;
//import java.util.concurrent.ExecutionException;

@Service
public class KafkaProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private Logger log = LoggerFactory.getLogger(KafkaConsumerService.class);

    @Autowired
    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public boolean sendMessage(String message) {
//        CompletableFuture<SendResult<String, String>> result =
        try {
            kafkaTemplate.send("postedmessages", message);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
