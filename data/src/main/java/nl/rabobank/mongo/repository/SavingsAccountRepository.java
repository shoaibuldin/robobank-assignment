package nl.rabobank.mongo.repository;

import nl.rabobank.enums.AccountType;
import nl.rabobank.mongo.model.SavingsAccountModel;
import nl.rabobank.service.account.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Spring Data MongoDB repository for the Accounts entity.
 */
@Repository
public interface SavingsAccountRepository extends MongoRepository<SavingsAccountModel, String> {
    Optional<Account> findByUserId(String userId, AccountType accountType);
}
