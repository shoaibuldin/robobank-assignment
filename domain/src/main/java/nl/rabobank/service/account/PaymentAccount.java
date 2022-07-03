package nl.rabobank.service.account;

import lombok.Builder;
import lombok.Value;
import nl.rabobank.enums.AccountType;

@Builder
@Value
public class PaymentAccount implements Account {

    String accountNumber;
    String accountHolderName;
    Double balance;

    String userId;

    AccountType type;
}
