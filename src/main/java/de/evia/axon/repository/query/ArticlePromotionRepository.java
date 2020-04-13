package de.evia.axon.repository.query;

import de.evia.axon.domain.query.PromotionView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ArticlePromotionRepository extends JpaRepository<PromotionView, UUID> {

    public List<PromotionView> findByArticleIdAndOrganizationId(UUID articleId, Long id);
    public List<PromotionView> findByArticleId(UUID articleId);
}
