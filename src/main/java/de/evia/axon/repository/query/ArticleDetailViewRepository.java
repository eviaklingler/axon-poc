package de.evia.axon.repository.query;

import de.evia.axon.domain.query.ArticleDetailView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ArticleDetailViewRepository extends JpaRepository<ArticleDetailView, UUID> {
}
