package de.evia.axon.api;

import de.evia.axon.api.dto.ArticleDTO;
import de.evia.axon.domain.query.ArticleDetailView;
import de.evia.axon.service.command.ArticleCommandService;
import de.evia.axon.service.query.ArticleQueryService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    private ArticleCommandService articleCommandService;
    private ArticleQueryService articleQueryService;

    public ArticleController(ArticleCommandService articleCommandService, ArticleQueryService articleQueryService) {
        this.articleCommandService = articleCommandService;
        this.articleQueryService = articleQueryService;
    }

    @PostMapping
    public CompletableFuture<String> createArticle(@RequestBody @Valid ArticleDTO articleDTO) {
        return articleCommandService.createArticle(articleDTO);
    }

    @GetMapping("/{articleId}")
    public CompletableFuture<ArticleDetailView> getArticleDetails(@PathVariable("articleId") String articleId) {
        return articleQueryService.getArticleDetail(UUID.fromString(articleId));
    }

    @GetMapping
    public CompletableFuture<List<ArticleDetailView>> getAllArticles() {
        return articleQueryService.getAllArticles();
    }
}

