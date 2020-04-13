package de.evia.axon.api.query;

import java.util.UUID;

public class FindPromotionForAllCountries {
    private final UUID articleId;

    public FindPromotionForAllCountries(UUID articleId) {
        this.articleId = articleId;
    }

    public UUID getArticleId() {
        return articleId;
    }

}
