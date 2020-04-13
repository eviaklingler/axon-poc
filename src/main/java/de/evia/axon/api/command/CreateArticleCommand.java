package de.evia.axon.api.command;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.axonframework.modelling.command.TargetAggregateIdentifier;


@EqualsAndHashCode
@ToString
public class CreateArticleCommand {

    @TargetAggregateIdentifier
    private final String articleId;
    private final String articleName;

    public CreateArticleCommand(String articleId, String articleName) {
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
