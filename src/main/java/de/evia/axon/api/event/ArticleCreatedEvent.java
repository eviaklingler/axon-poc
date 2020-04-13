package de.evia.axon.api.event;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class ArticleCreatedEvent {

    private final String articleId;
    private final String articleName;

    public ArticleCreatedEvent(String articleId, String articleName) {
        this.articleId = articleId;
        this.articleName = articleName;
    }

    public String getArticleId() {
        return articleId;
    }

    public String getArticleName() {
        return articleName;
    }
}
