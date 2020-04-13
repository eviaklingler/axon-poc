package de.evia.axon.api.query;

import java.util.UUID;

public class FindPromotionEventsByArticleQuery {
    private final UUID articleId;

    public FindPromotionEventsByArticleQuery(UUID articleId) {
        this.articleId = articleId;
    }

    public UUID getArticleId() {
        return articleId;
    }
}
