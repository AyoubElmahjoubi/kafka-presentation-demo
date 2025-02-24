package learningkafka.producer.controller;


import learningkafka.producer.stream.ProducerConsumeWikimedia;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProducerController {

    private final ProducerConsumeWikimedia consumer;

    @GetMapping("/get-wikimedia-event")
    public void startPublishing(){
        consumer.consumeWikimediaAndPublish();
    }

}
