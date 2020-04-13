package de.evia.axon.service.query;

import de.evia.axon.api.query.FindAllArticles;
import de.evia.axon.api.query.FindArticleDetailQuery;
import de.evia.axon.domain.query.ArticleDetailView;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class ArticleQueryServiceImpl implements ArticleQueryService {

    private final QueryGateway queryGateway;

    public ArticleQueryServiceImpl(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @Override
    public CompletableFuture<ArticleDetailView> getArticleDetail(UUID articleId) {
        return queryGateway.query(new FindArticleDetailQuery(articleId), ResponseTypes.instanceOf(ArticleDetailView.class));
    }

    @Override
    public CompletableFuture<List<ArticleDetailView>> getAllArticles() {
        return queryGateway.query(new FindAllArticles(), ResponseTypes.multipleInstancesOf(ArticleDetailView.class));
    }
}
