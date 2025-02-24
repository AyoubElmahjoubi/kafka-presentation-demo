package learningkafka.producer.stream;


import learningkafka.producer.producer.WikimediaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class ProducerConsumeWikimedia {

    private final WebClient webClient;
    private final WikimediaProducer producer;

    public ProducerConsumeWikimedia( WebClient.Builder webClient ,WikimediaProducer producer) {
        this.producer = producer;
        this.webClient = webClient.baseUrl("https://stream.wikimedia.org/v2").build();
    }

    public void consumeWikimediaAndPublish() {
        webClient.get()
                .uri("/stream/recentchange")
                .retrieve()
                .bodyToFlux(String.class)
                .subscribe(producer::send);
    }
}
