package ma.youcode.youreview.controllers;

import java.util.UUID;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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

    @GetMapping("/update/{id}")
    public String update(@PathVariable UUID id, Model model) {
        System.out.println("ok ------- ");
        ReviewDto reviewDto = reviewService.findByID(id);
        model.addAttribute("review", reviewDto);
        return "pages/updateReview";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable UUID id, @ModelAttribute @Validated ReviewDto reviewDto, Model model) {
        reviewService.update(id,reviewDto);
        return "redirect:/reviews";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable  UUID id, Authentication authentication) {
        if (authentication != null && authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))) {
            System.out.println("dkhal");
            reviewService.delete(id);
            return "redirect:/reviews";
        }
        return "redirect:/reviews";
    }

    @GetMapping("/reporte/{id}")
    public String report(@PathVariable UUID id) {
        reviewService.reporte(id);
        return "redirect:/reviews";
    }

    @GetMapping("/reportes")
    public String reportedReviews(Model model) {
        model.addAttribute("reportedReviews", reviewService.getReportedReviews());
        return "pages/reportedReviews";
    }

    
}
