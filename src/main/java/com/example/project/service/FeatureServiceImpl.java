package com.example.project.service;

import com.example.project.exception.ResourceNotFoundException;
import com.example.project.model.Feature;
import com.example.project.repository.FeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeatureServiceImpl implements FeatureService {

    @Autowired
    private FeatureRepository featureRepository;

    @Override
    public List<Feature> getAllFeatures() {
        return featureRepository.findAll();
    }

    @Override
    public Feature getFeatureById(Long id) {
        return featureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Feature not found with ID: " + id));
    }

    @Override
    public Feature createFeature(Feature feature) {
        return featureRepository.save(feature);
    }

    @Override
    public Feature updateFeature(Long id, Feature feature) {
        Feature existingFeature = getFeatureById(id);
        existingFeature.setName(feature.getName());
        existingFeature.setDescription(feature.getDescription());
        return featureRepository.save(existingFeature);
    }

    @Override
    public void deleteFeature(Long id) {
        Feature existingFeature = getFeatureById(id);
        featureRepository.delete(existingFeature);
    }
}
