package magis.mundi2025.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import magis.mundi2025.demo.converter.PropertyConverter;
import magis.mundi2025.demo.model.dto.PropertyDTO;
import magis.mundi2025.demo.model.dto.RoomDTO;
import magis.mundi2025.demo.service.PropertyService;

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

    @GetMapping("/search")
    public ResponseEntity<List<PropertyDTO>> searchProperties(@RequestParam("query") String query) {
        var properties = propertyService.searchProperties(query);
        var propertyDTOs = properties.stream()
            .map(propertyConverter::convertToDTO)
            .collect(Collectors.toList());
        return ResponseEntity.ok(propertyDTOs);
    }

    private static final List<String> BOOKED_ROOM_IDS = List.of("101", "A102", "L1", "201", "B201", "L3");

    @GetMapping("/bookings")
    public ResponseEntity<List<RoomDTO>> getBookedRooms() {
        var properties = propertyService.getAllProperties();
        var bookedRooms = properties.stream()
            .flatMap(property -> property.getRooms().stream())
            .filter(room -> BOOKED_ROOM_IDS.contains(room.getRoomNumber()))
            .collect(Collectors.toList());
        var roomDTOs = bookedRooms.stream()
            .map(propertyConverter::convertToRoomDTO)
            .collect(Collectors.toList());
        return ResponseEntity.ok(roomDTOs);
    }
}
