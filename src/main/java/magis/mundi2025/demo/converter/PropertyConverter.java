package magis.mundi2025.demo.converter;

import lombok.RequiredArgsConstructor;
import magis.mundi2025.demo.model.dto.PropertyDTO;
import magis.mundi2025.demo.model.dto.RoomDTO;
import magis.mundi2025.demo.model.entity.Property;
import magis.mundi2025.demo.model.entity.Room;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PropertyConverter {

    public PropertyDTO convertToDTO(Property property) {
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
