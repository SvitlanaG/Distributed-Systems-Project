package distrsystems.htwproject.veganrecipesratingdataservice.controllers;

import distrsystems.htwproject.veganrecipesratingdataservice.domain.Rating;
import distrsystems.htwproject.veganrecipesratingdataservice.models.UserRating;
import distrsystems.htwproject.veganrecipesratingdataservice.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
public class RatingController {

    private RatingService ratingService;


    @Autowired
    public void setRatingService(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @RequestMapping({"/rating/list", "/rating"})
    public ResponseEntity<List> listRatings(){
        List<Rating> ratings = ratingService.listAll();
        return ResponseEntity.ok(ratings);
    }

    @RequestMapping({"/userrating/list"})
    public UserRating getUserRating() {
        List<Rating> ratings = ratingService.listAll();

        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);

        return userRating;
    }

    @RequestMapping(value = "/rating/show/{id}")
    public ResponseEntity<Rating> getRating(@PathVariable Long id){
        Rating rating = ratingService.getById(id);

        if (rating == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(rating);
        }
    }

    @RequestMapping(value = "rating/edit/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Rating> update(@RequestBody Rating rating, @PathVariable Long id) {

        Rating updatedRating = ratingService.update(id, rating);
        if (updatedRating == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedRating);
        }


    }

    @RequestMapping(value = "/rating/new", method = RequestMethod.POST)
    public ResponseEntity<Rating> create(@RequestBody Rating rating) {
        Rating createdRating = ratingService.create(rating);
        if (createdRating == null) {
            return ResponseEntity.notFound().build();
        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/rating/show/{id}")
                    .buildAndExpand(createdRating.getId())
                    .toUri();

            return ResponseEntity.created(uri)
                    .body(createdRating);
        }
    }


    @RequestMapping(value = "/rating/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteRating(@PathVariable Long id) {
        ratingService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
