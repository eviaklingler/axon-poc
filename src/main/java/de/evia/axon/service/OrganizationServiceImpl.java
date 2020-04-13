package de.evia.axon.service;

import de.evia.axon.api.dto.CountryOrganizationDTO;
import de.evia.axon.domain.CountryOrganization;
import de.evia.axon.repository.OrganizationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository repository;

    public OrganizationServiceImpl(OrganizationRepository repository) {
        this.repository = repository;
    }

    @Override
    public CountryOrganization createOrganization(CountryOrganizationDTO organizationDTO) {

        return repository.save(toCountryOrganization(organizationDTO));
    }

    @Override
    public List<CountryOrganization> getAllOrganizations() {
        return repository.findAll();
    }

    private CountryOrganization toCountryOrganization(CountryOrganizationDTO organizationDTO) {
        CountryOrganization countryOrganization = new CountryOrganization();
        countryOrganization.setName(organizationDTO.getName());
        countryOrganization.setLocale(organizationDTO.getLocale());
        return countryOrganization;
    }
}
