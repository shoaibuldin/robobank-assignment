package nl.robobank.dummy;

import nl.rabobank.dto.AccountDTO;
import nl.rabobank.enums.AccountType;

public final class AccountDummy {

    public static AccountDTO fetchOnePaymentAccountDTO() {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setBalance(0.0);
        accountDTO.setAccountHolderName("paymentTestName");
        accountDTO.setAccountNumber("112233");
        accountDTO.setType(AccountType.PAYMENT);
        return accountDTO;
    }

    public static AccountDTO fetchOneSavingsAccountDTO() {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setBalance(0.0);
        accountDTO.setAccountHolderName("savingsTestName");
        accountDTO.setAccountNumber("112234");
        accountDTO.setType(AccountType.SAVINGS);
        return accountDTO;
    }

    public static AccountDTO fetchOneSecondPaymentAccountDTO() {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setBalance(0.0);
        accountDTO.setAccountHolderName("paymentTestName2");
        accountDTO.setAccountNumber("112244");
        accountDTO.setType(AccountType.PAYMENT);
        return accountDTO;
    }

    public static AccountDTO fetchOneSecondSavingsAccountDTO() {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setBalance(0.0);
        accountDTO.setAccountHolderName("savingsTestName2");
        accountDTO.setAccountNumber("112245");
        accountDTO.setType(AccountType.SAVINGS);
        return accountDTO;
    }

}
