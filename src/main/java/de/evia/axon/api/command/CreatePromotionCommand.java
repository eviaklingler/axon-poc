package de.evia.axon.api.command;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.time.LocalDate;

@EqualsAndHashCode
@ToString
public class CreatePromotionCommand {

    @TargetAggregateIdentifier
    private final String promotionId;

    private final String articleId;
    private final Long organizationId;
    private final LocalDate promotionDate;
    private final long promotionQuantity;

    public CreatePromotionCommand(String promotionId, String articleId, Long organizationId, LocalDate promotionDate, long promotionQuantity) {
        this.promotionId = promotionId;
        this.articleId = articleId;
        this.organizationId = organizationId;
        this.promotionDate = promotionDate;
        this.promotionQuantity = promotionQuantity;
    }

    public String getPromotionId() {
        return promotionId;
    }

    public String getArticleId() {
        return articleId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public LocalDate getPromotionDate() {
        return promotionDate;
    }

    public long getPromotionQuantity() {
        return promotionQuantity;
    }
}
