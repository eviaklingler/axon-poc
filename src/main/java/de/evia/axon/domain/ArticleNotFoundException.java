package de.evia.axon.domain;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ArticleNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1518440584190922771L;

    public ArticleNotFoundException(String message) {
        super(message);
    }
}
