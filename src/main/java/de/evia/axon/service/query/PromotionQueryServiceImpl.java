package de.evia.axon.service.query;

import de.evia.axon.api.query.FindPromotionByCountryQuery;
import de.evia.axon.api.query.FindPromotionEventsByArticleQuery;
import de.evia.axon.api.query.FindPromotionForAllCountries;
import de.evia.axon.domain.query.PromotionEventView;
import de.evia.axon.domain.query.PromotionView;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class PromotionQueryServiceImpl implements PromotionQueryService {

    private QueryGateway queryGateway;

    private EventStore eventStore;

    public PromotionQueryServiceImpl(QueryGateway queryGateway, EventStore eventStore) {
        this.queryGateway = queryGateway;
        this.eventStore = eventStore;
    }

    @Override
    public CompletableFuture<List<PromotionView>> getPromotionByArticleAndCountry(UUID articleId, Long organizationId) {
        return queryGateway.query(new FindPromotionByCountryQuery(articleId, organizationId), ResponseTypes.multipleInstancesOf(PromotionView.class));
    }

    @Override
    public CompletableFuture<List<PromotionView>> getPromotionByArticle(UUID articleId) {
        return queryGateway.query(new FindPromotionForAllCountries(articleId), ResponseTypes.multipleInstancesOf(PromotionView.class));
    }

    @Override
    public List<Object> listEventsForPromotion(String promotionId) {

        return eventStore.readEvents(promotionId).asStream().map( s -> s.getPayload()).collect(Collectors.toList());
    }

    @Override
    public CompletableFuture<List<PromotionEventView>> getPromotionEventsByArticle(UUID articleId) {
        return queryGateway.query(new FindPromotionEventsByArticleQuery(articleId), ResponseTypes.multipleInstancesOf(PromotionEventView.class));
    }
}
