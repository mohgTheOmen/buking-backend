package magis.mundi2025.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import magis.mundi2025.demo.model.entity.Property;
import magis.mundi2025.demo.repository.PropertyRepository;

// TESTING: Here we will implement the search function

@Service
@RequiredArgsConstructor
public class PropertyService {
    private final PropertyRepository propertyRepository;

    public List<Property> getAllProperties() {
        return propertyRepository.findAll();
    }

    public Property getPropertyById(Long id) {
        return propertyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found"));
    }

    public List<Property> searchProperties(String name) {
        return propertyRepository.findByNameIgnoreCase(name);
    }
}
