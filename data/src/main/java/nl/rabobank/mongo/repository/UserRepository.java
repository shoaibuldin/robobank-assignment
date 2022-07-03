package nl.rabobank.mongo.repository;

import nl.rabobank.mongo.model.UserModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Spring Data MongoDB repository for the Accounts entity.
 */
@Repository
public interface UserRepository extends MongoRepository<UserModel, ObjectId> {

    Optional<UserModel> findByUsername(String username);

    Optional<UserModel> findByUsernameIgnoreCase(String login);
}
