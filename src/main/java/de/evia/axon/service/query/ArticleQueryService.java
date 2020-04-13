package de.evia.axon.service.query;

import de.evia.axon.domain.query.ArticleDetailView;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface ArticleQueryService {
    public CompletableFuture<ArticleDetailView> getArticleDetail(UUID articleId);
    public CompletableFuture<List<ArticleDetailView>> getAllArticles();
}
