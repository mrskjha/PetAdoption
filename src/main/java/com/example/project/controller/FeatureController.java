package com.example.project.controller;

import com.example.project.model.Feature;
import com.example.project.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/features")
public class FeatureController {

    @Autowired
    private FeatureService featureService;

    // Get all features
    @GetMapping
    public List<Feature> getAllFeatures() {
        return featureService.getAllFeatures();
    }

    // Get a feature by ID
    @GetMapping("/{id}")
    public ResponseEntity<Feature> getFeatureById(@PathVariable Long id) {
        return ResponseEntity.ok(featureService.getFeatureById(id));
    }

    // Create a new feature
    @PostMapping
    public ResponseEntity<Feature> createFeature(@Valid @RequestBody Feature feature) {
        return ResponseEntity.ok(featureService.createFeature(feature));
    }

    // Update a feature
    @PutMapping("/{id}")
    public ResponseEntity<Feature> updateFeature(
            @PathVariable Long id,
            @Valid @RequestBody Feature feature) {
        return ResponseEntity.ok(featureService.updateFeature(id, feature));
    }

    // Delete a feature
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeature(@PathVariable Long id) {
        featureService.deleteFeature(id);
        return ResponseEntity.noContent().build();
    }
}
