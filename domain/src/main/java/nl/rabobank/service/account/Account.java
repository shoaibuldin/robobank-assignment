package nl.rabobank.service.account;

import nl.rabobank.enums.AccountType;

public interface Account {
    String getAccountNumber();

    String getAccountHolderName();

    Double getBalance();

    AccountType getType();
}
