package magis.mundi2025.demo.controller;

import lombok.RequiredArgsConstructor;
import magis.mundi2025.demo.converter.PropertyConverter;
import magis.mundi2025.demo.model.dto.PropertyDTO;
import magis.mundi2025.demo.service.PropertyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/properties")
@RequiredArgsConstructor
public class PropertyController {
    private final PropertyService propertyService;
    private final PropertyConverter propertyConverter;

    @GetMapping
    public ResponseEntity<List<PropertyDTO>> getAllProperties() {
        var properties = propertyService.getAllProperties();
        var propertyDTOs = properties.stream()
                .map(propertyConverter::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(propertyDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropertyDTO> getPropertyById(@PathVariable Long id) {
        var property = propertyService.getPropertyById(id);
        var propertyDTO = propertyConverter.convertToDTO(property);
        return ResponseEntity.ok(propertyDTO);
    }
}
