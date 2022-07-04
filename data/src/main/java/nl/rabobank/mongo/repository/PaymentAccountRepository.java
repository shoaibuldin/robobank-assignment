package nl.rabobank.mongo.repository;

import nl.rabobank.enums.AccountType;
import nl.rabobank.mongo.model.PaymentAccountModel;
import nl.rabobank.service.account.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Spring Data MongoDB repository for the Accounts entity.
 */
@Repository
public interface PaymentAccountRepository extends MongoRepository<PaymentAccountModel, String> {

    Optional<Account> findByUserId(String userId, AccountType accountType);

}
