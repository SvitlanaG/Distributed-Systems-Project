package distrsystems.htwproject.veganrecipesratingdataservice.services;

import distrsystems.htwproject.veganrecipesratingdataservice.commands.RatingForm;
import distrsystems.htwproject.veganrecipesratingdataservice.domain.Rating;

import java.util.List;

public interface RatingService {

    List<Rating> listAll();

    Rating getById(Long id);

    Rating saveOrUpdate(Rating rating);

    void delete(Long id);

    Rating saveOrUpdateRatingForm(RatingForm ratingForm);
}
