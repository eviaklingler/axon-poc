package de.evia.axon.api;

import de.evia.axon.api.dto.CountryOrganizationDTO;
import de.evia.axon.api.dto.CountryOrganizationDTOs;
import de.evia.axon.domain.CountryOrganization;
import de.evia.axon.service.OrganizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {

    private OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @PostMapping
    public ResponseEntity<CountryOrganizationDTO> createOrganization(@RequestBody @Valid CountryOrganizationDTO organizationDTO) {
        CountryOrganization organization = organizationService.createOrganization(organizationDTO);

        return ResponseEntity.ok(toCountryOrganizationDTO(organization));
    }

    private static CountryOrganizationDTOs toCountryOrganizationDTOs(List<CountryOrganization> organizations) {
        List<CountryOrganizationDTO> orgs = new ArrayList<>();
        for (CountryOrganization country : organizations) {
            orgs.add(toCountryOrganizationDTO(country));
        }
        CountryOrganizationDTOs countryOrganizationDTOs = new CountryOrganizationDTOs();
        countryOrganizationDTOs.setOrganizations(orgs);
        return countryOrganizationDTOs;
    }

    private static CountryOrganizationDTO toCountryOrganizationDTO(CountryOrganization organization) {
        CountryOrganizationDTO countryOrganization = new CountryOrganizationDTO();
        countryOrganization.setId(organization.getId());
        countryOrganization.setLocale(organization.getLocale());
        countryOrganization.setName(organization.getName());
        return countryOrganization;
    }

    @GetMapping
    public ResponseEntity<CountryOrganizationDTOs> getAllOrganization() {
        List<CountryOrganization> organizations = organizationService.getAllOrganizations();

        return ResponseEntity.ok(toCountryOrganizationDTOs(organizations));
    }

}
