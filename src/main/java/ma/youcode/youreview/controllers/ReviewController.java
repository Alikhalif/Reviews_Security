package ma.youcode.youreview.controllers;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.youcode.youreview.models.dto.ReviewDto;
import ma.youcode.youreview.services.ReviewService;

@AllArgsConstructor

@Controller
@RequestMapping("/reviews")
public class ReviewController {

    private ReviewService reviewService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("reviews", reviewService.getAll());
        return "pages/review";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("newReview", new ReviewDto() );
        return "pages/addReview";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute @Valid ReviewDto reviewDto, BindingResult result) {
        if(result.hasErrors())
            return "/reviews/add?type=add";
        reviewService.create(reviewDto);
        return "redirect:/reviews";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable UUID id, @ModelAttribute @Validated ReviewDto reviewDto, Model model) {
        
        return "reviews/index";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable  UUID id) {
        return "reviews/index";
    }

    
}
