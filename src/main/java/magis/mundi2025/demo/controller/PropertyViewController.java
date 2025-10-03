package magis.mundi2025.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import magis.mundi2025.demo.converter.PropertyConverter;
import magis.mundi2025.demo.model.entity.Property;
import magis.mundi2025.demo.service.PropertyService;

@Controller
@RequiredArgsConstructor
public class PropertyViewController {
    private final PropertyService propertyService;
    private final PropertyConverter propertyConverter;

    @GetMapping("/properties")
    public String viewAllProperties(Model model) {
        var properties = propertyService.getAllProperties();
        var propertyDTOs = properties.stream()
                .map(propertyConverter::convertToDTO)
                .collect(Collectors.toList());
        model.addAttribute("properties", propertyDTOs);
        return "properties";
    }

    @GetMapping("/properties/{id}")
    public String viewPropertyDetails(@PathVariable Long id, Model model) {
        var property = propertyService.getPropertyById(id);
        var propertyDTO = propertyConverter.convertToDTO(property);
        model.addAttribute("property", propertyDTO);
        return "property-details";
    }

    @GetMapping("/properties/search")
    public String searchProperties(@RequestParam(value = "query", required = false) String query, Model model) {
        List<Property> properties = null;
        if (query != null && !query.trim().isEmpty()) {
            properties = propertyService.searchProperties(query);
        }
        var propertyDTOs = properties == null ? List.of() : properties.stream()
                .map(propertyConverter::convertToDTO)
                .collect(Collectors.toList());
        model.addAttribute("properties", propertyDTOs);
        model.addAttribute("searchQuery", query);
        return "properties-search";
    }

    @GetMapping("/bookings")
    public String viewBookings(Model model) {
        // Placeholder for bookings data
        model.addAttribute("bookings", List.of());
        return "bookings";
    }

    @PostMapping("/bookings")
    public String bookRoom(@RequestParam Long roomId, Model model) {
        // Placeholder for booking logic
        // Add booking logic here
        model.addAttribute("message", "Room booked successfully!");
        return "redirect:/bookings";
    }
}
