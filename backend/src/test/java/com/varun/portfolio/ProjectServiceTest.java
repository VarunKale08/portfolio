package com.varun.portfolio.project;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.varun.portfolio.common.NotFoundException;

@ExtendWith(MockitoExtension.class)
class ProjectServiceTest {

    @Mock
    private ProjectRepository repository;      // the fake

    @InjectMocks
    private ProjectService service;            // the real service, given the fake

    @Test
    void getBySlugThrowsWhenProjectDoesNotExist() {
        when(repository.findBySlug("missing")).thenReturn(Optional.empty());

        assertThatThrownBy(() -> service.getBySlug("missing"))
                .isInstanceOf(NotFoundException.class)
                .hasMessageContaining("missing");
    }

    @Test
    void getAllReturnsEmptyListWhenThereAreNoProjects() {
        when(repository.findAllByOrderByFeaturedDescDisplayOrderAsc()).thenReturn(List.of());

        assertThat(service.getAll()).isEmpty();
    }
}