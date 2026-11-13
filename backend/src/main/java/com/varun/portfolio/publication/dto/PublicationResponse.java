package com.varun.portfolio.publication.dto;

import com.varun.portfolio.publication.Publication;
import java.time.LocalDate;

public record PublicationResponse(
        String title,
        String publisher,
        LocalDate publishedDate,
        String url
) {
    public static PublicationResponse from(Publication publication) {
        return new PublicationResponse(
                publication.getTitle(),
                publication.getPublisher(),
                publication.getPublishedDate(),
                publication.getUrl()
        );
    }
}