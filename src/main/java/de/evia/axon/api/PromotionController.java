package de.evia.axon.api;

import de.evia.axon.api.dto.PromotionDTO;
import de.evia.axon.domain.query.PromotionEventView;
import de.evia.axon.domain.query.PromotionView;
import de.evia.axon.service.command.PromotionCommandService;
import de.evia.axon.service.query.PromotionQueryService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/promotions")
public class PromotionController {

    private final PromotionCommandService promotionCommandService;
    private final PromotionQueryService promotionQueryService;

    public PromotionController(PromotionCommandService promotionCommandService, PromotionQueryService promotionQueryService) {
        this.promotionCommandService = promotionCommandService;
        this.promotionQueryService = promotionQueryService;
    }

    @PostMapping
    public CompletableFuture<String> createPromotion(@RequestBody @Valid PromotionDTO promotionDTO) {


        return promotionCommandService.createPromotion(promotionDTO);
    }

    @GetMapping
    public CompletableFuture<List<PromotionView>> getPromotionBy(@RequestParam(name = "articleId", required = true) String articleId, @RequestParam(name = "organizationId", required = false ) Long organizationId) {
        UUID articleUUID = UUID.fromString(articleId);
        if (organizationId != null) {
            return promotionQueryService.getPromotionByArticleAndCountry(articleUUID, organizationId);
        } else {
            return promotionQueryService.getPromotionByArticle(articleUUID);
        }
    }

    @GetMapping("/{promotionId}/events")
    public List<Object> listEventsForAccount(@PathVariable(value = "promotionId") String promotionId){
        return promotionQueryService.listEventsForPromotion(promotionId);
    }

    @GetMapping("/events")
    public CompletableFuture<List<PromotionEventView>> getPromotionChangeEvents(@RequestParam(name = "articleId", required = true) String articleId){
        return promotionQueryService.getPromotionEventsByArticle(UUID.fromString(articleId));
    }
}
