package de.evia.axon.domain.query;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class PromotionView {
    @Id
    private UUID promotionId;
    private UUID articleId;
    private Long organizationId;
    private LocalDate promotionDate;
    private long promotionQuantity;

    public PromotionView() {
    }

    public PromotionView(UUID promotionId, UUID articleId, Long organizationId, LocalDate promotionDate, long promotionQuantity) {
        this.promotionId = promotionId;
        this.articleId = articleId;
        this.organizationId = organizationId;
        this.promotionDate = promotionDate;
        this.promotionQuantity = promotionQuantity;
    }

    public UUID getPromotionId() {
        return promotionId;
    }

    public UUID getArticleId() {
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
