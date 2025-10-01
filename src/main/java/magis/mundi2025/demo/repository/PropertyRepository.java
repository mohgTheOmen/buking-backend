package magis.mundi2025.demo.repository;

import magis.mundi2025.demo.model.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}
