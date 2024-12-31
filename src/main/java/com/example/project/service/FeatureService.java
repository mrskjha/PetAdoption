package com.example.project.service;

import com.example.project.model.Feature;

import java.util.List;

public interface FeatureService {
    List<Feature> getAllFeatures();
    Feature getFeatureById(Long id);
    Feature createFeature(Feature feature);
    Feature updateFeature(Long id, Feature feature);
    void deleteFeature(Long id);
}
