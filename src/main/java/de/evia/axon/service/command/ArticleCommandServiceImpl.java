package de.evia.axon.service.command;

import de.evia.axon.api.command.CreateArticleCommand;
import de.evia.axon.api.dto.ArticleDTO;
import de.evia.axon.util.Asserts;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.common.IdentifierFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ArticleCommandServiceImpl implements ArticleCommandService {

    private final CommandGateway commandGateway;

    private final IdentifierFactory identifierFactory;

    public ArticleCommandServiceImpl(CommandGateway commandGateway, IdentifierFactory identifierFactory) {
        this.commandGateway = commandGateway;
        this.identifierFactory = identifierFactory;
    }

    @Override
    public CompletableFuture<String> createArticle(ArticleDTO article) {
        Asserts.isNotNull(article, "article");

        return commandGateway.send(new CreateArticleCommand(
                identifierFactory.generateIdentifier(),
                article.getName()));
    }
}
