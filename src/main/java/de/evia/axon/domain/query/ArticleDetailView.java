package de.evia.axon.domain.query;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class ArticleDetailView {

    @Id
    private UUID articleId;
    private String articleName;

    public ArticleDetailView() {
    }

    public ArticleDetailView(UUID articleId, String articleName) {
        this.articleId = articleId;
        this.articleName = articleName;
    }

    public String getArticleName() {
        return articleName;
    }

    public UUID getArticleId() {
        return articleId;
    }
}
