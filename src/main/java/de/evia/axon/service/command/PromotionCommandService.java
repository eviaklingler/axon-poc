package de.evia.axon.service.command;

import de.evia.axon.api.dto.PromotionDTO;

import java.util.concurrent.CompletableFuture;

public interface PromotionCommandService {
    public CompletableFuture<String> createPromotion(PromotionDTO promotionDTO);
}
