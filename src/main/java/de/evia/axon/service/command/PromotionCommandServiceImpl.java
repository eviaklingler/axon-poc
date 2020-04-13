package de.evia.axon.service.command;

import de.evia.axon.api.command.CreatePromotionCommand;
import de.evia.axon.api.dto.PromotionDTO;
import de.evia.axon.domain.ArticleNotFoundException;
import de.evia.axon.domain.CountryOrganization;
import de.evia.axon.domain.OrganizationNotFoundException;
import de.evia.axon.repository.OrganizationRepository;
import de.evia.axon.util.Asserts;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.common.IdentifierFactory;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class PromotionCommandServiceImpl implements PromotionCommandService {

    private final CommandGateway commandGateway;

    private final IdentifierFactory identifierFactory;

    private final EventStore eventStore;

    private final OrganizationRepository organizationRepository;

    public PromotionCommandServiceImpl(CommandGateway commandGateway, IdentifierFactory identifierFactory, EventStore eventStore, OrganizationRepository organizationRepository) {
        this.commandGateway = commandGateway;
        this.identifierFactory = identifierFactory;
        this.eventStore = eventStore;
        this.organizationRepository = organizationRepository;
    }

    @Override
    public CompletableFuture<String> createPromotion(PromotionDTO promotionDTO) {
        String articleId = promotionDTO.getArticleId();
        Long organizationId = promotionDTO.getOrganizationId();
        Asserts.isNotNull(promotionDTO, "promotionDTO");
        checkArticleExists(articleId);
        checkOrganizationExists(organizationId);

        return commandGateway.send(new CreatePromotionCommand(
                identifierFactory.generateIdentifier(),
                articleId,
                organizationId,
                promotionDTO.getPromotionDate(),
                promotionDTO.getPromotionQuantity()));
    }

    private void checkOrganizationExists(Long organizationId) {
        Optional<CountryOrganization> organizationExists = this.organizationRepository.findById(organizationId);
        if (!organizationExists.isPresent()) {
            throw new OrganizationNotFoundException("Country Organization for id=" + organizationId + " does not exist.");
        }
    }

    private void checkArticleExists(String articleId) {
        Optional<Long> articleExists = eventStore.lastSequenceNumberFor(articleId);
        if (!articleExists.isPresent()) {
            throw new ArticleNotFoundException("Article for id=" + articleId + " does not exist.");
        }
    }
}
