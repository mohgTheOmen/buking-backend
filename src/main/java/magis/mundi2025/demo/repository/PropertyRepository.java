package magis.mundi2025.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import magis.mundi2025.demo.model.entity.Property;

public interface PropertyRepository extends JpaRepository<Property, Long> {
    List<Property> findByNameContainingIgnoreCaseOrAddressContainingIgnoreCase(String name, String address);
}
