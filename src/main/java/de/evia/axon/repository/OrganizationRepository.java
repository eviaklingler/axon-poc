package de.evia.axon.repository;

import de.evia.axon.domain.CountryOrganization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<CountryOrganization, Long> {
}
