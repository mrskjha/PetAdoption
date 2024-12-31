package com.example.project.controller;

import com.example.project.model.Feature;
import com.example.project.service.FeatureService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class FeatureControllerTest {

    @Mock
    private FeatureService featureService;

    @InjectMocks
    private FeatureController featureController;

    private MockMvc mockMvc;
    private Feature pet;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(featureController).build();
        pet = new Feature();
        pet.setId(1L);
        pet.setName("Buddy");
        pet.setBreed("Golden Retriever");
        pet.setStatus("Available");
    }

    @Test
    public void testGetAllPets() throws Exception {
        when(featureService.getAllPets()).thenReturn(List.of(pet));

        mockMvc.perform(get("/api/pets"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$[0].name").value("Buddy"));
    }

    @Test
    public void testCreatePet() throws Exception {
        when(featureService.createPetListing(any(Feature.class))).thenReturn(pet);

        mockMvc.perform(post("/api/pets")
                .contentType("application/json")
                .content("{\"name\": \"Buddy\", \"breed\": \"Golden Retriever\", \"status\": \"Available\"}"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.name").value("Buddy"));
    }
}
