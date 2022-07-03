package nl.rabobank.mongo.repository;

import nl.rabobank.enums.Authorization;
import nl.rabobank.mongo.model.PowerOfAttorneyModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data MongoDB repository for the Accounts entity.
 */
@Repository
public interface PowerOfAttorneyRepository extends MongoRepository<PowerOfAttorneyModel, ObjectId> {

    List<PowerOfAttorneyModel> findByGranteeName(String document);

    Optional<PowerOfAttorneyModel> findByGranteeNameAndGrantorNameAndAuthorization(
            String granteeName, String grantorName, Authorization authorization);
}
