package de.evia.axon.domain.query;

import de.evia.axon.api.event.ArticleCreatedEvent;
import de.evia.axon.api.query.FindAllArticles;
import de.evia.axon.api.query.FindArticleDetailQuery;
import de.evia.axon.repository.query.ArticleDetailViewRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ArticleProjector {

    private final ArticleDetailViewRepository repository;

    public ArticleProjector(ArticleDetailViewRepository repository) {
        this.repository = repository;
    }

    @EventHandler
    public void on(ArticleCreatedEvent event) {
        ArticleDetailView articleDetailView = new ArticleDetailView(UUID.fromString(event.getArticleId()), event.getArticleName());
        repository.save(articleDetailView);
    }

    @QueryHandler
    public Optional<ArticleDetailView> handle(FindArticleDetailQuery query){
        return repository.findById(query.getArticleId());
    }

    @QueryHandler
    public List<ArticleDetailView> handle(FindAllArticles query){
        return repository.findAll();
    }
}
