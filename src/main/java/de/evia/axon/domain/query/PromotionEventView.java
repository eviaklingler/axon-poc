package de.evia.axon.domain.query;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class PromotionEventView {
    @Id
    private UUID promotionId;
    private UUID articleId;
    private Long organizationId;
    private LocalDate promotionDateOld;
    private LocalDate promotionDateNew;
    private long promotionQuantityOld;
    private long promotionQuantityNew;


    public PromotionEventView() {
    }

    public PromotionEventView(UUID promotionId, UUID articleId, Long organizationId, LocalDate promotionDateNew, long promotionQuantityNew) {
        this.promotionId = promotionId;
        this.articleId = articleId;
        this.organizationId = organizationId;
        this.promotionDateOld = null;
        this.promotionDateNew = promotionDateNew;
        this.promotionQuantityOld = 0L;
        this.promotionQuantityNew = promotionQuantityNew;
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

    public LocalDate getPromotionDateOld() {
        return promotionDateOld;
    }

    public LocalDate getPromotionDateNew() {
        return promotionDateNew;
    }

    public long getPromotionQuantityOld() {
        return promotionQuantityOld;
    }

    public long getPromotionQuantityNew() {
        return promotionQuantityNew;
    }
}
