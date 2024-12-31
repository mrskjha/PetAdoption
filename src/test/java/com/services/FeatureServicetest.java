package com.example.project.service;

import com.example.project.model.Feature;
import com.example.project.repository.FeatureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

public class FeatureServiceTest {

    @Mock
    private FeatureRepository featureRepository;

    @InjectMocks
    private FeatureServiceImpl featureService;

    private Feature pet;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        pet = new Feature();
        pet.setId(1L);
        pet.setName("Buddy");
        pet.setBreed("Golden Retriever");
        pet.setStatus("Available");
    }

    @Test
    public void testCreatePetListing() {
        when(featureRepository.save(any(Feature.class))).thenReturn(pet);

        Feature createdPet = featureService.createPetListing(pet);

        assertNotNull(createdPet);
        assertEquals("Buddy", createdPet.getName());
        verify(featureRepository, times(1)).save(any(Feature.class));
    }

    @Test
    public void testGetPetById() {
        when(featureRepository.findById(1L)).thenReturn(Optional.of(pet));

        Feature foundPet = featureService.getPetById(1L);

        assertNotNull(foundPet);
        assertEquals("Buddy", foundPet.getName());
        assertEquals("Golden Retriever", foundPet.getBreed());
    }
}
