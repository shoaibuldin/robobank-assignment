package nl.rabobank.dto;import lombok.Data;import lombok.NoArgsConstructor;import nl.rabobank.enums.AccountType;import nl.rabobank.enums.Authorization;import nl.rabobank.service.authorizations.PowerOfAttorney;import javax.validation.constraints.NotNull;/** * Power of attorney Request object for storing a new authorization. */@Data@NoArgsConstructorpublic class PowerOfAttorneyDTO {    @NotNull    private AccountType accountType;    @NotNull    private Authorization authorization;    @NotNull    private String grantorName;    private String granteeName;    public PowerOfAttorneyDTO(PowerOfAttorney powerOfAttorney) {        this.accountType = powerOfAttorney.getAccount().getType();        this.authorization = powerOfAttorney.getAuthorization();        this.grantorName = powerOfAttorney.getGrantorName();        this.granteeName = powerOfAttorney.getGranteeName();    }}