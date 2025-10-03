package magis.mundi2025.demo.model.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class RoomDTO {
    private Long id;
    private String roomNumber;
    private String roomType;
    private BigDecimal pricePerNight;
    private Integer capacity;
    private String imageUrl;
    private Long propertyId;
    private String propertyName;
    private String propertyAddress;
    private Integer propertyStarRating;
}


