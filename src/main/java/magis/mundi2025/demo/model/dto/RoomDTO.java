package magis.mundi2025.demo.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RoomDTO {
    private Long id;
    private String roomNumber;
    private String roomType;
    private BigDecimal pricePerNight;
    private Integer capacity;
    private String imageUrl;
    private Long propertyId;
}


