package de.evia.axon.api.dto;

import javax.validation.constraints.NotNull;
import java.util.Locale;

public class CountryOrganizationDTO {

    private long id;
    @NotNull
    private String name;
    @NotNull
    private Locale locale;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}
