package ma.youcode.youreview.repositories;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ma.youcode.youreview.models.documents.Review;

@Repository
public interface ReviewRepository extends MongoRepository<Review, UUID> {}
