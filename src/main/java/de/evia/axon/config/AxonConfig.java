package de.evia.axon.config;

import de.evia.axon.domain.command.Article;
import org.axonframework.common.DefaultIdentifierFactory;
import org.axonframework.common.IdentifierFactory;
import org.axonframework.common.caching.Cache;
import org.axonframework.common.caching.WeakReferenceCache;
import org.axonframework.config.EventProcessingConfigurer;
import org.axonframework.eventhandling.TrackingEventProcessorConfiguration;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonConfig {
    private static final Logger logger = LoggerFactory.getLogger(AxonConfig.class);

    @Bean
    public EventSourcingRepository<Article> articleRepository(EventStore eventStore, Cache cache) {
        return EventSourcingRepository.builder(Article.class).cache(cache).eventStore(eventStore).build();
    }

    @Bean
    public IdentifierFactory identifierFactory() {
        return new DefaultIdentifierFactory();
    }

    @Bean
    public Cache cache() {
        return new WeakReferenceCache();
    }

    @Autowired
    public void config(EventProcessingConfigurer configurer) {
        configurer.registerTrackingEventProcessorConfiguration(
                c -> TrackingEventProcessorConfiguration.forParallelProcessing(8).andBatchSize(500)
        );
    }


}
