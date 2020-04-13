package de.evia.axon.api.query;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.UUID;

@EqualsAndHashCode
@ToString
public class FindPromotionByCountryQuery {

    private final UUID articleId;
    private final Long organizationId;

    public FindPromotionByCountryQuery(UUID articleId, Long organizationId) {
        this.articleId = articleId;
        this.organizationId = organizationId;
    }

    public UUID getArticleId() {
        return articleId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }
}
