package distrsystems.htwproject.veganrecipesratingdataservice.converters;

import distrsystems.htwproject.veganrecipesratingdataservice.commands.RatingForm;
import distrsystems.htwproject.veganrecipesratingdataservice.domain.Rating;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class RatingFormToRating implements Converter<RatingForm, Rating> {

    @Override
    public Rating convert(RatingForm ratingForm) {
        Rating rating = new Rating();
        if (ratingForm.getId() != null  && !StringUtils.isEmpty(ratingForm.getId())) {
            rating.setId(new Long(ratingForm.getId()));
        }
        rating.setRecipeId(ratingForm.getRecipeId());
        rating.setRating(ratingForm.getRating());

        return rating;
    }

}
