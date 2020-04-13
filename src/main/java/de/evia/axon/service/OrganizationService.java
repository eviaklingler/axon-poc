package de.evia.axon.service;

import de.evia.axon.api.dto.CountryOrganizationDTO;
import de.evia.axon.domain.CountryOrganization;

import java.util.List;

public interface OrganizationService {

    public CountryOrganization createOrganization(CountryOrganizationDTO organizationDTO);

    public List<CountryOrganization> getAllOrganizations();
}
