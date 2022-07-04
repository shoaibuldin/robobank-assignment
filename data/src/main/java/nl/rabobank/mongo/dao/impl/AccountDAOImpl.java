package nl.rabobank.mongo.dao.impl;import nl.rabobank.dao.AccountDAO;import nl.rabobank.enums.AccountType;import nl.rabobank.mongo.factory.AccountFactory;import nl.rabobank.mongo.repository.PaymentAccountRepository;import nl.rabobank.service.account.Account;import org.slf4j.Logger;import org.slf4j.LoggerFactory;import org.springframework.context.annotation.Primary;import org.springframework.stereotype.Service;import java.util.Optional;@Service@Primarypublic class AccountDAOImpl implements AccountDAO {    final PaymentAccountRepository paymentAccountRepository;    final AccountFactory accountFactory;    private final Logger log = LoggerFactory.getLogger(AccountDAOImpl.class);    public AccountDAOImpl(PaymentAccountRepository paymentAccountRepository, AccountFactory accountFactory) {        this.paymentAccountRepository = paymentAccountRepository;        this.accountFactory = accountFactory;    }    @Override    public Account save(Account account) {        log.debug("Save account {}", account);        return accountFactory.getType(account.getType()).save(account);    }    @Override    public Optional<Account> findByUserId(String userId, AccountType type) {        log.debug("Find by User ID {}", userId);        return accountFactory.getType(type).findByUserId(userId, type);    }}