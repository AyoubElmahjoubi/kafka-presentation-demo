package learningkafka.consumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class WikimediaConsumer {

    @KafkaListener(topics = "presentation-kafka" , groupId = "Tdi")
    public void consumeEvent(String message) {
        log.info("Consumed message: {}", message);
    }
}
