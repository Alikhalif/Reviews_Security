package ma.youcode.youreview.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
        System.out.println("noo");
        model.addAttribute("newReview", new ReviewDto() );
        return "pages/addReview";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute @Validated ReviewDto reviewDto, BindingResult result) {
        if(!result.hasErrors())
            return "reviews/add?type=add";
        reviewService.create(reviewDto);
        return "redirect:/reviews";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable UUID id, @ModelAttribute @Validated ReviewDto reviewDto, Model model, Authentication authentication) {
        System.out.println("update");
        if (authentication != null && authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("EDITOR"))) {
            System.out.println("dkhal");
            reviewService.update(id, reviewDto);
            return "redirect:/reviews";
        }
        return "reviews/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable  UUID id, Authentication authentication) {
        System.out.println("oookjkbjhb");
        if (authentication != null && authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))) {
            System.out.println("dkhal");
            reviewService.delete(id);
            return "redirect:/reviews";
        }
        return "redirect:/reviews";
    }

    
}
