package de.evia.axon.api.dto;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class PromotionDTO {
    @NotNull
    private String articleId;
    @NotNull
    private Long organizationId;
    @NotNull
    private long promotionQuantity;
    @NotNull
    private LocalDate promotionDate;


    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public long getPromotionQuantity() {
        return promotionQuantity;
    }

    public void setPromotionQuantity(long promotionQuantity) {
        this.promotionQuantity = promotionQuantity;
    }

    public LocalDate getPromotionDate() {
        return promotionDate;
    }

    public void setPromotionDate(LocalDate promotionDate) {
        this.promotionDate = promotionDate;
    }
}
