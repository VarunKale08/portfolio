package com.varun.portfolio.publication;

import com.varun.portfolio.publication.dto.PublicationResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PublicationService {

    private final PublicationRepository publicationRepository;

    public PublicationService(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }

    public List<PublicationResponse> getAll() {
        return publicationRepository.findAllByOrderByDisplayOrderAsc()
                .stream()
                .map(PublicationResponse::from)
                .toList();
    }
}