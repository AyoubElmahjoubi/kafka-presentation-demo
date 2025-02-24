package learningkafka.producer.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class WikimediaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(String message) {
        log.info("Sending Wikimedia message: {}", message);
        kafkaTemplate.send("presentation-kafka", message);
    }

}
