package magis.mundi2025.demo.controller;

import lombok.RequiredArgsConstructor;
import magis.mundi2025.demo.model.dto.PropertyDTO;
import magis.mundi2025.demo.model.dto.RoomDTO;
import magis.mundi2025.demo.model.entity.Property;
import magis.mundi2025.demo.model.entity.Room;
import magis.mundi2025.demo.service.PropertyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class PropertyViewController {
    private final PropertyService propertyService;

    @GetMapping("/properties")
    public String listProperties(Model model) {
        var properties = propertyService.getAllProperties().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        model.addAttribute("properties", properties);
        return "properties";
    }

    @GetMapping("/properties/{id}")
    public String propertyDetails(@PathVariable Long id, Model model) {
        var property = convertToDTO(propertyService.getPropertyById(id));
        model.addAttribute("property", property);
        return "property-details";
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
