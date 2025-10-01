package magis.mundi2025.demo.service;

import lombok.RequiredArgsConstructor;
import magis.mundi2025.demo.model.entity.Property;
import magis.mundi2025.demo.repository.PropertyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
