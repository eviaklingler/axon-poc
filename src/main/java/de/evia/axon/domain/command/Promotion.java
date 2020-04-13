package de.evia.axon.domain.command;

import de.evia.axon.api.command.CreatePromotionCommand;
import de.evia.axon.api.event.PromotionCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.time.LocalDate;

@Aggregate
public class Promotion {

    @AggregateIdentifier
    private String promotionId;
    private String articleId;
    private Long organizationId;
    private long promotionQuantity;
    private LocalDate promotionDate;

    public Promotion() {
        // needed by Axon
    }

    @CommandHandler
    public Promotion(CreatePromotionCommand command) {
        AggregateLifecycle.apply(new PromotionCreatedEvent(
                command.getPromotionId(),
                command.getArticleId(),
                command.getOrganizationId(),
                command.getPromotionDate(),
                command.getPromotionQuantity()));
    }

    @EventSourcingHandler
    public void on(PromotionCreatedEvent event) {
        this.promotionId = event.getPromotionId();
        this.articleId = event.getArticleId();
        this.organizationId = event.getOrganizationId();
        this.promotionDate = event.getPromotionDate();
        this.promotionQuantity = event.getPromotionQuantity();
    }


}
