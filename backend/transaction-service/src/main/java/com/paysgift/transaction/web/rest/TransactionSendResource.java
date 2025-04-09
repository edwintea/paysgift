package com.paysgift.transaction.web.rest;

import com.paysgift.transaction.service.TransactionSendService;
import com.paysgift.transaction.service.dto.TransactionSendDTO;
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
 * REST controller for managing {@link com.paysgift.transaction.domain.TransactionSend}.
 */
@RestController
@RequestMapping("/api/transaction-sends")
public class TransactionSendResource {

    private static final Logger LOG = LoggerFactory.getLogger(TransactionSendResource.class);

    private final TransactionSendService transactionSendService;

    public TransactionSendResource(TransactionSendService transactionSendService) {
        this.transactionSendService = transactionSendService;
    }

    /**
     * {@code GET  /transaction-sends} : get all the transactionSends.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of transactionSends in body.
     */
    @GetMapping("")
    public ResponseEntity<List<TransactionSendDTO>> getAllTransactionSends(
        @org.springdoc.core.annotations.ParameterObject Pageable pageable
    ) {
        LOG.debug("REST request to get a page of TransactionSends");
        Page<TransactionSendDTO> page = transactionSendService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /transaction-sends/:id} : get the "id" transactionSend.
     *
     * @param id the id of the transactionSendDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the transactionSendDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<TransactionSendDTO> getTransactionSend(@PathVariable("id") Long id) {
        LOG.debug("REST request to get TransactionSend : {}", id);
        Optional<TransactionSendDTO> transactionSendDTO = transactionSendService.findOne(id);
        return ResponseUtil.wrapOrNotFound(transactionSendDTO);
    }

    /**
     * {@code POST  /transaction-sends} : Create a new transactionSend.
     *
     * @param transactionSendDTO the transactionSendDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new transactionSendDTO,
     * or with status {@code 400 (Bad Request)} if the transactionSend has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<TransactionSendDTO> createTransactionSend(@RequestBody TransactionSendDTO transactionSendDTO) throws URISyntaxException {
        LOG.debug("REST request to save TransactionSend : {}", transactionSendDTO);
        if (transactionSendDTO.getId() != null) {
            return ResponseEntity.badRequest().body(null); // A new transactionSend cannot already have an ID
        }
        TransactionSendDTO result = transactionSendService.save(transactionSendDTO);
        return ResponseEntity.created(new URI("/api/transaction-sends/" + result.getId())).body(result);
    }

    /**
     * {@code PUT  /transaction-sends} : Updates an existing transactionSend.
     *
     * @param transactionSendDTO the transactionSendDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated transactionSendDTO,
     * or with status {@code 400 (Bad Request)} if the transactionSendDTO is not valid,
     * or with status {@code 404 (Not Found)} if the transactionSendDTO doesn't exist,
     * or with status {@code 500 (Internal Server Error)} if the transactionSendDTO couldn't be updated.
     */
    @PutMapping("")
    public ResponseEntity<TransactionSendDTO> updateTransactionSend(@RequestBody TransactionSendDTO transactionSendDTO) {
        LOG.debug("REST request to update TransactionSend : {}", transactionSendDTO);
        if (transactionSendDTO.getId() == null) {
            return ResponseEntity.badRequest().body(null); // An existing transactionSend must have an ID
        }
        TransactionSendDTO result = transactionSendService.save(transactionSendDTO);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code DELETE  /transaction-sends/:id} : delete the "id" transactionSend.
     *
     * @param id the id of the transactionSendDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransactionSend(@PathVariable Long id) {
        LOG.debug("REST request to     deleteTransactionSend : {}", id);
        transactionSendService.delete(id);
        return ResponseEntity.noContent().build(); // Return 204 No Content
    }
}
