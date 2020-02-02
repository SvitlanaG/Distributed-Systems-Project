package distrsystems.htwproject.veganrecipesratingdataservice.repositories;

import distrsystems.htwproject.veganrecipesratingdataservice.domain.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {

}
