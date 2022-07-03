package nl.rabobank.service.authorizations;

import lombok.Builder;
import lombok.Value;
import nl.rabobank.enums.Authorization;
import nl.rabobank.service.account.Account;

@Value
@Builder(toBuilder = true)
public class PowerOfAttorney {
    String granteeName;
    String grantorName;
    Account account;
    Authorization authorization;
}
