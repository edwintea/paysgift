package com.paysgift.transaction.web.rest;

import com.paysgift.transaction.service.TransactionLogService;
import com.paysgift.transaction.service.dto.TransactionLogDTO;
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
 * REST controller for managing {@link com.paysgift.transaction.domain.TransactionLog}.
 */
@RestController
@RequestMapping("/api/transaction-logs")
public class TransactionLogResource {

    private static final Logger LOG = LoggerFactory.getLogger(TransactionLogResource.class);

    private final TransactionLogService transactionLogService;

    public TransactionLogResource(TransactionLogService transactionLogService) {
        this.transactionLogService = transactionLogService;
    }

    /**
     * {@code GET  /transaction-logs} : get all the transactionLogs.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of transactionLogs in body.
     */
    @GetMapping("")
    public ResponseEntity<List<TransactionLogDTO>> getAllTransactionLogs(
        @org.springdoc.core.annotations.ParameterObject Pageable pageable
    ) {
        LOG.debug("REST request to get a page of TransactionLogs");
        Page<TransactionLogDTO> page = transactionLogService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /transaction-logs/:id} : get the "id" transactionLog.
     *
     * @param id the id of the transactionLogDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the transactionLogDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<TransactionLogDTO> getTransactionLog(@PathVariable("id") Long id) {
        LOG.debug("REST request to get TransactionLog : {}", id);
        Optional<TransactionLogDTO> transactionLogDTO = transactionLogService.findOne(id);
        return ResponseUtil.wrapOrNotFound(transactionLogDTO);
    }

    /**
     * {@code POST  /transaction-logs} : Create a new transactionLog.
     *
     * @param transactionLogDTO the transactionLogDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new transactionLogDTO,
     * or with status {@code 400 (Bad Request)} if the transactionLog has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<TransactionLogDTO> createTransactionLog(@RequestBody TransactionLogDTO transactionLogDTO) throws URISyntaxException {
        LOG.debug("REST request to save TransactionLog : {}", transactionLogDTO);
        if (transactionLogDTO.getId() != null) {
            return ResponseEntity.badRequest().body(null); // A new transactionLog cannot already have an ID
        }
        TransactionLogDTO result = transactionLogService.save(transactionLogDTO);
        return ResponseEntity.created(new URI("/api/transaction-logs/" + result.getId())).body(result);
    }

    /**
     * {@code PUT  /transaction-logs} : Updates an existing transactionLog.
     *
     * @param transactionLogDTO the transactionLogDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated transactionLogDTO,
     * or with status {@code 400 (Bad Request)} if the transactionLogDTO is not valid,
     * or with status {@code 404 (Not Found)} if the transactionLogDTO doesn't exist,
     * or with status {@code 500 (Internal Server Error)} if the transactionLogDTO couldn't be updated.
     */
    @PutMapping("")
    public ResponseEntity<TransactionLogDTO> updateTransactionLog(@RequestBody TransactionLogDTO transactionLogDTO) {
        LOG.debug("REST request to update TransactionLog : {}", transactionLogDTO);
        if (transactionLogDTO.getId() == null) {
            return ResponseEntity.badRequest().body(null); // An existing transactionLog must have an ID
        }
        TransactionLogDTO result = transactionLogService.save(transactionLogDTO);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code DELETE  /transaction-logs/:id} : delete the "id" transactionLog.
     *
     * @param id the id of the transactionLogDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransactionLog(@PathVariable Long id) {
        LOG.debug("REST request to delete TransactionLog : {}", id);
        transactionLogService.delete(id);
        return ResponseEntity.noContent().build(); // Return 204 No Content
    }
}
