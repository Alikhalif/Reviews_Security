package ma.youcode.youreview.services;

import java.util.List;
import java.util.UUID;

import ma.youcode.youreview.models.dto.ReviewDto;

public interface ReviewService {
    
    ReviewDto create(ReviewDto reviewDto);
    List<ReviewDto> getAll();
    ReviewDto findByID(UUID uuid);
    ReviewDto update(UUID uuid, ReviewDto reviewDto); 
    void delete(UUID uuid);
    ReviewDto reporte(UUID uuid);
    List<ReviewDto> getReportedReviews();
}
