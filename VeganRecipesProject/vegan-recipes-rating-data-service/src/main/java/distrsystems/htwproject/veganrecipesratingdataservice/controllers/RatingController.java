package distrsystems.htwproject.veganrecipesratingdataservice.controllers;

import distrsystems.htwproject.veganrecipesratingdataservice.commands.RatingForm;
import distrsystems.htwproject.veganrecipesratingdataservice.converters.RatingToRatingForm;
import distrsystems.htwproject.veganrecipesratingdataservice.domain.Rating;
import distrsystems.htwproject.veganrecipesratingdataservice.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RatingController {

    private RatingService ratingService;

    private RatingToRatingForm ratingToRatingForm;

    @Autowired
    public void setRatingToRatingForm(RatingToRatingForm ratingToRatingForm) {
        this.ratingToRatingForm = ratingToRatingForm;
    }

    @Autowired
    public void setRatingService(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/rating/list";
    }

    @RequestMapping({"/rating/list", "/rating"})
    public ResponseEntity<List> listRatings(Model model){
        List<Rating> ratings = ratingService.listAll();
        //model.addAttribute("ratings", ratings);
        return ResponseEntity.ok(ratings);
    }

    @RequestMapping("/rating/show/{id}")
    public ResponseEntity<Rating> getRating(@PathVariable String id, Model model){
        Rating rating = ratingService.getById(Long.valueOf(id));

        if (rating == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(rating);
        }
    }

    @RequestMapping("rating/edit/{id}")
    public String edit(@PathVariable String id, Model model){
        Rating rating = ratingService.getById(Long.valueOf(id));
        RatingForm ratingForm = ratingToRatingForm.convert(rating);

        model.addAttribute("ratingForm", ratingForm);
        return "rating/ratingform";
    }

    @RequestMapping("/rating/new")
    public String newRating(Model model){
        model.addAttribute("ratingForm", new RatingForm());
        return "rating/ratingform";
    }

    @RequestMapping(value = "/rating", method = RequestMethod.POST)
    public String saveOrUpdateRating(@Valid RatingForm ratingForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "rating/ratingform";
        }

        Rating savedRating = ratingService.saveOrUpdateRatingForm(ratingForm);

        return "redirect:/rating/show/" + savedRating.getId();
    }

    @RequestMapping("/rating/delete/{id}")
    public String delete(@PathVariable String id){
        ratingService.delete(Long.valueOf(id));
        return "redirect:/rating/list";
    }

}
