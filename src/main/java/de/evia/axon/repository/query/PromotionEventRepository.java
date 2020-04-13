package de.evia.axon.repository.query;

import de.evia.axon.domain.query.PromotionEventView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PromotionEventRepository extends JpaRepository<PromotionEventView, UUID> {
    public List<PromotionEventView> findByArticleId(UUID articleId);
}
