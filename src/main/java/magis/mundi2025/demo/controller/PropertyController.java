package magis.mundi2025.demo.controller;

import lombok.RequiredArgsConstructor;
import magis.mundi2025.demo.model.dto.PropertyDTO;
import magis.mundi2025.demo.model.dto.RoomDTO;
import magis.mundi2025.demo.model.entity.Property;
import magis.mundi2025.demo.model.entity.Room;
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

    @GetMapping
    public ResponseEntity<List<PropertyDTO>> getAllProperties() {
        var properties = propertyService.getAllProperties();
        var propertyDTOs = properties.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(propertyDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropertyDTO> getPropertyById(@PathVariable Long id) {
        var property = propertyService.getPropertyById(id);
        var propertyDTO = convertToDTO(property);
        return ResponseEntity.ok(propertyDTO);
    }

    private PropertyDTO convertToDTO(Property property) {
        PropertyDTO dto = new PropertyDTO();
        dto.setId(property.getId());
        dto.setName(property.getName());
        dto.setAddress(property.getAddress());
        dto.setDescription(property.getDescription());
        dto.setStarRating(property.getStarRating());
        dto.setImageUrl(property.getImageUrl());
        dto.setRooms(property.getRooms().stream()
                .map(this::convertToRoomDTO)
                .collect(Collectors.toList()));
        return dto;
    }

    private RoomDTO convertToRoomDTO(Room room) {
        RoomDTO dto = new RoomDTO();
        dto.setId(room.getId());
        dto.setRoomNumber(room.getRoomNumber());
        dto.setRoomType(room.getRoomType());
        dto.setPricePerNight(room.getPricePerNight());
        dto.setCapacity(room.getCapacity());
        dto.setImageUrl(room.getImageUrl());
        dto.setPropertyId(room.getProperty().getId());
        return dto;
    }
}


