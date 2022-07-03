package nl.rabobank.rest;

import nl.rabobank.dto.PowerOfAttorneyDTO;
import nl.rabobank.service.authorizations.PowerOfAttorneyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/**
 * REST controller for managing Power of attorney.
 */
@RestController
@RequestMapping(path = "/api/powerofattorney")
public class PowerOfAttorneyController {

    private final Logger log = LoggerFactory.getLogger(PowerOfAttorneyController.class);
    private final PowerOfAttorneyService powerOfAttorneyService;

    public PowerOfAttorneyController(PowerOfAttorneyService powerOfAttorneyService) {
        this.powerOfAttorneyService = powerOfAttorneyService;
    }

    /**
     * {@code POST  /accounts} : Create a new power of attorney.
     *
     * @param powerOfAttorneyDTO the accountsDTO to powerOfAttorneyDTO.
     * @return the {@link PowerOfAttorneyDTO} with status {@code 201 (Created)} and with body the new powerOfAttorneyDTO.
     * @throws Exception if incorrect.
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public ResponseEntity<PowerOfAttorneyDTO> createPowerOfAttorney(@Valid @RequestBody PowerOfAttorneyDTO powerOfAttorneyDTO) throws Exception {
        log.debug("REST request to store power of attorney  : {}", powerOfAttorneyDTO);

        PowerOfAttorneyDTO result = powerOfAttorneyService.createPowerOfAttorney(powerOfAttorneyDTO);
        return ResponseEntity
                .created(new URI("/api/powerofattorney/" + powerOfAttorneyDTO.getGrantorName()))
                .body(result);
    }

    /**
     * {@code GET  /accounts} : List power of attorney of user logged in.
     *
     * @return the {@link List<PowerOfAttorneyDTO>} with status {@code 200 (GetAll)} and with body the List of Power of Attorney, or with status {@code 404 (Not Found)} if no data.
     * @throws NotFoundException if no data found.
     */
    @GetMapping()
    public ResponseEntity<List<PowerOfAttorneyDTO>> fetchByGranteeName() {
        log.debug("REST request to fetch power of attorney as per user");

        List<PowerOfAttorneyDTO> result = powerOfAttorneyService.fetchByGranteeName();

        if (result.isEmpty()) {
            throw new NotFoundException("No power of attorney found");
        }

        return ResponseEntity.ok().body(result);
    }
}