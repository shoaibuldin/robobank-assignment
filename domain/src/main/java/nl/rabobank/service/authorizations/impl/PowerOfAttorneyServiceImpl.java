package nl.rabobank.service.authorizations.impl;import nl.rabobank.dao.AccountDAO;import nl.rabobank.dao.PowerOfAttorneyDAO;import nl.rabobank.dao.UserDAO;import nl.rabobank.dto.PowerOfAttorneyDTO;import nl.rabobank.service.account.Account;import nl.rabobank.service.authorizations.PowerOfAttorney;import nl.rabobank.service.authorizations.PowerOfAttorneyService;import org.slf4j.Logger;import org.slf4j.LoggerFactory;import org.springframework.security.core.context.SecurityContextHolder;import org.springframework.stereotype.Service;import java.util.List;import java.util.Optional;import java.util.stream.Collectors;@Servicepublic class PowerOfAttorneyServiceImpl implements PowerOfAttorneyService {    private final Logger log = LoggerFactory.getLogger(PowerOfAttorneyServiceImpl.class);    private final AccountDAO accountDAO;    private final PowerOfAttorneyDAO powerOfAttorneyDAO;    private final UserDAO userDAO;    public PowerOfAttorneyServiceImpl(AccountDAO accountDAO, PowerOfAttorneyDAO powerOfAttorneyDAO, UserDAO userDAO) {        this.accountDAO = accountDAO;        this.powerOfAttorneyDAO = powerOfAttorneyDAO;        this.userDAO = userDAO;    }    @Override    public PowerOfAttorneyDTO createPowerOfAttorney(PowerOfAttorneyDTO powerOfAttorneyDTO) {        log.debug("save power of attorney : {}", powerOfAttorneyDTO);        String username = SecurityContextHolder.getContext().getAuthentication().getName();        String userId = userDAO.findByUsername(username).getId();        Optional<Account> account = accountDAO.findByUserId(userId, powerOfAttorneyDTO.getAccountType());        PowerOfAttorney powerOfAttorney = PowerOfAttorney.builder()                .granteeName(username)                .grantorName(powerOfAttorneyDTO.getGrantorName())                .account(account.get())                .authorization(powerOfAttorneyDTO.getAuthorization())                .build();        PowerOfAttorney powerOfAttorney1 = powerOfAttorneyDAO.save(powerOfAttorney);        return new PowerOfAttorneyDTO(powerOfAttorney1);    }    @Override    public List<PowerOfAttorneyDTO> fetchByGranteeName() {        log.debug("get power of attorney by user : {}");        String username = SecurityContextHolder.getContext().getAuthentication().getName();        return powerOfAttorneyDAO.findByGranteeName(username)                .stream().map(PowerOfAttorneyDTO::new)                .collect(Collectors.toList());    }}