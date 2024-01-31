package ma.youcode.youreview.repositories;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ma.youcode.youreview.models.documents.User;

@Repository
public interface UserRepository extends MongoRepository<User, UUID> {

    User findByUserName(String userName);
}
