package com.paysgift.transaction.web.rest;

import com.paysgift.transaction.service.TransactionManualService;
import com.paysgift.transaction.service.dto.TransactionManualDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.paysgift.transaction.domain.TransactionManual}.
 */
@RestController
@RequestMapping("/api/transaction-manuals")
public class TransactionManualResource {

    private static final Logger LOG = LoggerFactory.getLogger(TransactionManualResource.class);

    private final TransactionManualService transactionManualService;

    public TransactionManualResource(TransactionManualService transactionManualService) {
        this.transactionManualService = transactionManualService;
    }

    /**
     * {@code GET  /transaction-manuals} : get all the transactionManuals.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of transactionManuals in body.
     */
    @GetMapping("")
    public ResponseEntity<List<TransactionManualDTO>> getAllTransactionManuals(
        @org.springdoc.core.annotations.ParameterObject Pageable pageable
    ) {
        LOG.debug("REST request to get a page of TransactionManuals");
        Page<TransactionManualDTO> page = transactionManualService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /transaction-manuals/:id} : get the "id" transactionManual.
     *
     * @param id the id of the transactionManualDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the transactionManualDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<TransactionManualDTO> getTransactionManual(@PathVariable("id") Long id) {
        LOG.debug("REST request to get TransactionManual : {}", id);
        Optional<TransactionManualDTO> transactionManualDTO = transactionManualService.findOne(id);
        return ResponseUtil.wrapOrNotFound(transactionManualDTO);
    }

    /**
     * {@code POST  /transaction-manuals} : Create a new transactionManual.
     *
     * @param transactionManualDTO the transactionManualDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new transactionManualDTO,
     * or with status {@code 400 (Bad Request)} if the transactionManual has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<TransactionManualDTO> createTransactionManual(@RequestBody TransactionManualDTO transactionManualDTO) throws URISyntaxException {
        LOG.debug("REST request to save TransactionManual : {}", transactionManualDTO);
        if (transactionManualDTO.getId() != null) {
            return ResponseEntity.badRequest().body(null); // A new transactionManual cannot already have an ID
        }
        TransactionManualDTO result = transactionManualService.save(transactionManualDTO);
        return ResponseEntity.created(new URI("/api/transaction-manuals/" + result.getId())).body(result);
    }

    /**
     * {@code PUT  /transaction-manuals} : Updates an existing transactionManual.
     *
     * @param transactionManualDTO the transactionManualDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated transactionManualDTO,
     * or with status {@code 400 (Bad Request)} if the transactionManualDTO is not valid,
     * or with status {@code 404 (Not Found)} if the transactionManualDTO doesn't exist,
     * or with status {@code 500 (Internal Server Error)} if the transactionManualDTO couldn't be updated.
     */
    @PutMapping("")
    public ResponseEntity<TransactionManualDTO> updateTransactionManual(@RequestBody TransactionManualDTO transactionManualDTO) {
        LOG.debug("REST request to update TransactionManual : {}", transactionManualDTO);
        if (transactionManualDTO.getId() == null) {
            return ResponseEntity.badRequest().body(null); // An existing transactionManual must have an ID
        }
        TransactionManualDTO result = transactionManualService.save(transactionManualDTO);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code DELETE  /transaction-manuals/:id} : delete the "id" transactionManual.
     *
     * @param id the id of the transactionManualDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransactionManual(@PathVariable Long id) {
        LOG.debug("REST request to delete TransactionManual : {}", id);
        transactionManualService.delete(id);
        return ResponseEntity.noContent().build(); // Return 204 No Content
    }
}
