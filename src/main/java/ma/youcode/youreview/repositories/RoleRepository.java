package ma.youcode.youreview.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ma.youcode.youreview.models.documents.Role;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {}
