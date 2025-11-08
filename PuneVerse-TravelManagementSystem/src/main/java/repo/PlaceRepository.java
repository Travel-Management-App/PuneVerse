package repo;

import org.springframework.data.jpa.repository.JpaRepository;
import entity.Place;
import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Integer> {
 List<Place> findByCategory_CategoryId(Integer categoryId);
}
