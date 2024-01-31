package ma.youcode.youreview.services.implementations;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import ma.youcode.youreview.models.documents.Review;
import ma.youcode.youreview.models.dto.ReviewDto;
import ma.youcode.youreview.repositories.ReviewRepository;
import ma.youcode.youreview.services.ReviewService;

@AllArgsConstructor

@Service
public class ReviewServiceImpl implements ReviewService {

    private ModelMapper modelMapper;
    private ReviewRepository reviewRepository;

    @Override
    public ReviewDto create(ReviewDto reviewDto) {
        Review review = modelMapper.map(reviewDto, Review.class);
        return modelMapper.map(reviewRepository.save(review), ReviewDto.class);
    }

    @Override
    public List<ReviewDto> getAll() {
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream()
                .map(review -> modelMapper.map(review, ReviewDto.class))
                .toList();
    }

    @Override
    public ReviewDto update(UUID uuid, ReviewDto reviewDto) {
        Review review = modelMapper.map(reviewDto, Review.class);
        if (!reviewRepository.existsById(uuid))
            throw new RuntimeException("test");
        reviewDto.setId(uuid);
        Optional.ofNullable(review.getTitle()).ifPresent(reviewDto::setTitle);
        Optional.ofNullable(review.getMessage()).ifPresent(reviewDto::setMessage);
        Optional.ofNullable(review.getReactions()).ifPresent(reviewDto::setReactions);
        return modelMapper.map(reviewRepository.save(review), ReviewDto.class);
    }

    @Override
    public void delete(UUID uuid) {
        if (!reviewRepository.existsById(uuid))
            throw new RuntimeException("test");
        reviewRepository.deleteById(uuid);
    }

    @Override
    public ReviewDto findByID(UUID uuid) {
        Review review = reviewRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("test"));
        return modelMapper.map(review, ReviewDto.class);
    }
}
