package distrsystems.htwproject.veganrecipesratingdataservice.services;


import distrsystems.htwproject.veganrecipesratingdataservice.commands.RatingForm;
import distrsystems.htwproject.veganrecipesratingdataservice.converters.RatingFormToRating;
import distrsystems.htwproject.veganrecipesratingdataservice.domain.Rating;
import distrsystems.htwproject.veganrecipesratingdataservice.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    private RatingRepository ratingRepository;
    private RatingFormToRating ratingFormToRating;

    @Autowired
    public RatingServiceImpl(RatingRepository ratingRepository, RatingFormToRating ratingFormToRating) {
        this.ratingRepository = ratingRepository;
        this.ratingFormToRating = ratingFormToRating;
    }


    @Override
    public List<Rating> listAll() {
        List<Rating> ratings = new ArrayList<>();
        ratingRepository.findAll().forEach(ratings::add); //fun with Java 8
        return ratings;
    }

    @Override
    public Rating getById(Long id) {
        return ratingRepository.findById(id).orElse(null);
    }

    @Override
    public Rating create(Rating rating) {
        ratingRepository.save(rating);
        return rating;
    }

    @Override
    public Rating update(Long id, Rating rating) {
        if (null == ratingRepository.findById(id)) {
            return null;
        }
        rating.setId(id);
        ratingRepository.save(rating);
        return rating;
    }

    @Override
    public void delete(Long id) {
        ratingRepository.deleteById(id);

    }

}
