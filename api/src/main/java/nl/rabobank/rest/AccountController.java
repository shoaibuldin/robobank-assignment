package nl.rabobank.rest;

import nl.rabobank.dto.AccountDTO;
import nl.rabobank.mongo.model.PaymentAccountModel;
import nl.rabobank.mongo.model.SavingsAccountModel;
import nl.rabobank.service.account.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

/**
 * REST controller for managing {@link PaymentAccountModel} and {@link SavingsAccountModel}.
 */
@RestController
@RequestMapping(path = "/api/accounts")
public class AccountController {

    private final Logger log = LoggerFactory.getLogger(AccountController.class);
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * {@code POST  /accounts} : Create a new accounts.
     *
     * @param accountsDTO the AccountDTO to create.
     * @return the {@link AccountDTO} with status {@code 201 (Created)} and with body the new AccountDTO.
     * @throws Exception if incorrect.
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public ResponseEntity<AccountDTO> save(@RequestBody @Valid AccountDTO accountsDTO) throws Exception {
        log.debug("REST request to save account : {}", accountsDTO);

        AccountDTO result = accountService.save(accountsDTO);

        return ResponseEntity
                .created(new URI("/api/accounts/" + result.getAccountNumber()))
                .body(result);
    }
}
