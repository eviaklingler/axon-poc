package de.evia.axon.domain.query;

import de.evia.axon.api.event.PromotionCreatedEvent;
import de.evia.axon.api.query.FindPromotionByCountryQuery;
import de.evia.axon.api.query.FindPromotionEventsByArticleQuery;
import de.evia.axon.api.query.FindPromotionForAllCountries;
import de.evia.axon.repository.query.ArticlePromotionRepository;
import de.evia.axon.repository.query.PromotionEventRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Component
public class PromotionProjector {

    private final ArticlePromotionRepository repository;
    private final PromotionEventRepository eventRepository;

    public PromotionProjector(ArticlePromotionRepository repository, PromotionEventRepository eventRepository) {
        this.repository = repository;
        this.eventRepository = eventRepository;
    }

    @EventHandler
    public void on(PromotionCreatedEvent event) {
        UUID promotionId = UUID.fromString(event.getPromotionId());
        UUID articleId = UUID.fromString(event.getArticleId());
        Long organizationId = event.getOrganizationId();
        LocalDate promotionDate = event.getPromotionDate();
        long promotionQuantity = event.getPromotionQuantity();
        PromotionView articlePromotionView = new PromotionView(promotionId, articleId, organizationId, promotionDate, promotionQuantity);
        repository.save(articlePromotionView);
        PromotionEventView promotionEventView = new PromotionEventView(promotionId, articleId, organizationId, promotionDate, promotionQuantity);
        eventRepository.save(promotionEventView);
    }

    @QueryHandler
    public List<PromotionView> handle(FindPromotionByCountryQuery query) {
        return repository.findByArticleIdAndOrganizationId(query.getArticleId(), query.getOrganizationId());
    }

    @QueryHandler
    public List<PromotionView> handle(FindPromotionForAllCountries query) {
        return repository.findByArticleId(query.getArticleId());
    }

    @QueryHandler
    public List<PromotionEventView> handle(FindPromotionEventsByArticleQuery query) {
        return eventRepository.findByArticleId(query.getArticleId());
    }
}
