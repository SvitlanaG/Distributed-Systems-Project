package distrsystems.htwproject.veganrecipesratingdataservice.services;

import distrsystems.htwproject.veganrecipesratingdataservice.domain.Rating;

import java.util.List;

public interface RatingService {

    List<Rating> listAll();

    Rating getById(Long id);

    Rating create(Rating rating);

    Rating update(Long id, Rating rating);

    void delete(Long id);
}
