package de.evia.axon.service.command;
import de.evia.axon.api.dto.ArticleDTO;

import java.util.concurrent.CompletableFuture;

public interface ArticleCommandService {
    public CompletableFuture<String> createArticle(ArticleDTO article);
}
