package de.evia.axon.api.query;


import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.UUID;

@EqualsAndHashCode
@ToString
public class FindArticleDetailQuery {

    private final UUID articleId;

    public FindArticleDetailQuery(UUID articleId) {
        this.articleId = articleId;
    }

    public UUID getArticleId() {
        return articleId;
    }
}
