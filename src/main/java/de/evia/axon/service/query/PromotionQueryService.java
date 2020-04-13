package de.evia.axon.service.query;

import de.evia.axon.domain.query.PromotionEventView;
import de.evia.axon.domain.query.PromotionView;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface PromotionQueryService {
    public CompletableFuture<List<PromotionView>> getPromotionByArticleAndCountry(UUID articleId, Long organizationId);
    public CompletableFuture<List<PromotionView>> getPromotionByArticle(UUID articleId);
    public List<Object> listEventsForPromotion(String articleId);
    public CompletableFuture<List<PromotionEventView>> getPromotionEventsByArticle(UUID articleId);
}
