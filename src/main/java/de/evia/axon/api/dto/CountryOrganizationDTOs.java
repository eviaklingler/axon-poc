package de.evia.axon.api.dto;

import java.util.ArrayList;
import java.util.List;

public class CountryOrganizationDTOs {
    private List<CountryOrganizationDTO> organizations;

    public CountryOrganizationDTOs() {
        this.organizations = new ArrayList<>();
    }

    public void setOrganizations(List<CountryOrganizationDTO> organizations) {
        this.organizations = organizations;
    }

    public List<CountryOrganizationDTO> getOrganizations() {
        return organizations;
    }
}
