package de.evia.axon.domain.command;

import de.evia.axon.api.command.CreateArticleCommand;
import de.evia.axon.api.event.ArticleCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class Article {

    @AggregateIdentifier
    private String articleId;
    private String articleName;

    public Article() {
        // needed for Axon Framework
    }

    @CommandHandler
    public Article(CreateArticleCommand command) {
        AggregateLifecycle.apply(new ArticleCreatedEvent(command.getArticleId(), command.getArticleName()));
    }

    @EventSourcingHandler
    public void on(ArticleCreatedEvent event) {
        articleId = event.getArticleId();
        articleName = event.getArticleName();
    }
}
