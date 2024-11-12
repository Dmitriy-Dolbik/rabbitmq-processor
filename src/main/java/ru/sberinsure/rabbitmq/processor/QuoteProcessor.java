package ru.sberinsure.rabbitmq.processor;

import io.smallrye.common.annotation.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import ru.sberinsure.rabbitmq.processor.model.Quote;

import java.util.Random;

/**
 * A bean consuming data from the "quote-requests" RabbitMQ queue and giving out a random quote.
 * The result is pushed to the "quotes" RabbitMQ exchange.
 */
@ApplicationScoped
public class QuoteProcessor {

    private final Random random = new Random();

    @Incoming("requests")
    @Outgoing("quotes")
    @Blocking
    public Quote precess(String quoteRequest) throws InterruptedException {
        // simulate some hard-working task
        Thread.sleep(1000);
        return new Quote(quoteRequest, random.nextInt(100));
    }

}