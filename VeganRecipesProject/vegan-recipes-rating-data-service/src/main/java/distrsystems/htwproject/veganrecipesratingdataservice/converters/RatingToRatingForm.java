package distrsystems.htwproject.veganrecipesratingdataservice.converters;

import distrsystems.htwproject.veganrecipesratingdataservice.commands.RatingForm;
import distrsystems.htwproject.veganrecipesratingdataservice.domain.Rating;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RatingToRatingForm implements Converter<Rating, RatingForm> {

    @Override
    public RatingForm convert(Rating rating) {
        RatingForm ratingForm = new RatingForm();
        ratingForm.setId(rating.getId());
        ratingForm.setRecipeId(rating.getRecipeId());
        ratingForm.setRating(rating.getRating());

        return ratingForm;
    }

}
