package nl.robobank.dummy;

import nl.rabobank.dto.PowerOfAttorneyDTO;
import nl.rabobank.enums.AccountType;
import nl.rabobank.enums.Authorization;

public final class PowerOfAttorneyDummy {

    public static PowerOfAttorneyDTO fetchOneWritePowerOfDummyDTOForSavings() {
        PowerOfAttorneyDTO powerOfAttorneyDTO = new PowerOfAttorneyDTO();
        powerOfAttorneyDTO.setAccountType(AccountType.SAVINGS);
        powerOfAttorneyDTO.setAuthorization(Authorization.WRITE);
        powerOfAttorneyDTO.setGrantorName("shoaib");

        return powerOfAttorneyDTO;
    }

    public static PowerOfAttorneyDTO fetchOneWritePowerOfDummyDTOForPayment() {
        PowerOfAttorneyDTO powerOfAttorneyDTO = new PowerOfAttorneyDTO();
        powerOfAttorneyDTO.setAccountType(AccountType.PAYMENT);
        powerOfAttorneyDTO.setAuthorization(Authorization.WRITE);
        powerOfAttorneyDTO.setGrantorName("shoaib");

        return powerOfAttorneyDTO;
    }

    public static PowerOfAttorneyDTO fetchOneReadPowerOfDummyDTOForSavings() {
        PowerOfAttorneyDTO powerOfAttorneyDTO = new PowerOfAttorneyDTO();
        powerOfAttorneyDTO.setAccountType(AccountType.SAVINGS);
        powerOfAttorneyDTO.setAuthorization(Authorization.READ);
        powerOfAttorneyDTO.setGrantorName("shoaib");

        return powerOfAttorneyDTO;
    }

    public static PowerOfAttorneyDTO fetchOneReadPowerOfDummyDTOForPayment() {
        PowerOfAttorneyDTO powerOfAttorneyDTO = new PowerOfAttorneyDTO();
        powerOfAttorneyDTO.setAccountType(AccountType.PAYMENT);
        powerOfAttorneyDTO.setAuthorization(Authorization.READ);
        powerOfAttorneyDTO.setGrantorName("shoaib");

        return powerOfAttorneyDTO;
    }
}
