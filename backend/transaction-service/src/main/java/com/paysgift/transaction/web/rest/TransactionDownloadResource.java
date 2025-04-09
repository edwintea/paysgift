package com.paysgift.transaction.web.rest;

import com.paysgift.transaction.service.TransactionDownloadService;
import com.paysgift.transaction.service.dto.TransactionDownloadDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
 * REST controller for managing {@link com.paysgift.transaction.domain.TransactionDownload}.
 */
@RestController
@RequestMapping("/api/transaction-downloads")
public class TransactionDownloadResource {

    private static final Logger LOG = LoggerFactory.getLogger(TransactionDownloadResource.class);

    private final TransactionDownloadService transactionDownloadService;

    public TransactionDownloadResource(TransactionDownloadService transactionDownloadService) {
        this.transactionDownloadService = transactionDownloadService;
    }

    /**
     * {@code GET  /transaction-downloads} : get all the transactionDownloads.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of transactionDownloads in body.
     */
    @GetMapping("")
    public ResponseEntity<List<TransactionDownloadDTO>> getAllTransactionDownloads(
        @org.springdoc.core.annotations.ParameterObject Pageable pageable
    ) {
        LOG.debug("REST request to get a page of TransactionDownloads");
        Page<TransactionDownloadDTO> page = transactionDownloadService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /transaction-downloads/:id} : get the "id" transactionDownload.
     *
     * @param id the id of the transactionDownloadDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the transactionDownloadDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<TransactionDownloadDTO> getTransactionDownload(@PathVariable("id") Long id) {
        LOG.debug("REST request to get TransactionDownload : {}", id);
        Optional<TransactionDownloadDTO> transactionDownloadDTO = transactionDownloadService.findOne(id);
        return ResponseUtil.wrapOrNotFound(transactionDownloadDTO);
    }

    /**
     * {@code POST  /transaction-downloads} : Create a new transactionDownload.
     *
     * @param transactionDownloadDTO the transactionDownloadDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new transactionDownloadDTO,
     * or with status {@code 400 (Bad Request)} if the transactionDownload has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<TransactionDownloadDTO> createTransactionDownload(@RequestBody TransactionDownloadDTO transactionDownloadDTO) throws URISyntaxException {
        LOG.debug("REST request to save TransactionDownload : {}", transactionDownloadDTO);
        if (transactionDownloadDTO.getId() != null) {
            return ResponseEntity.badRequest().body(null); // A new transactionDownload cannot already have an ID
        }
        TransactionDownloadDTO result = transactionDownloadService.save(transactionDownloadDTO);
        return ResponseEntity.created(new URI("/api/transaction-downloads/" + result.getId())).body(result);
    }

    /**
     * {@code PUT  /transaction-downloads} : Updates an existing transactionDownload.
     *
     * @param transactionDownloadDTO the transactionDownloadDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated transactionDownloadDTO,
     * or with status {@code 400 (Bad Request)} if the transactionDownloadDTO is not valid,
     * or with status {@code 404 (Not Found)} if the transactionDownloadDTO doesn't exist,
     * or with status {@code 500 (Internal Server Error)} if the transactionDownloadDTO couldn't be updated.
     */
    @PutMapping("")
    public ResponseEntity<TransactionDownloadDTO> updateTransactionDownload(@RequestBody TransactionDownloadDTO transactionDownloadDTO) {
        LOG.debug("REST request to update TransactionDownload : {}", transactionDownloadDTO);
        if (transactionDownloadDTO.getId() == null) {
            return ResponseEntity.badRequest().body(null); // An existing transactionDownload must have an ID
        }
        TransactionDownloadDTO result = transactionDownloadService.save(transactionDownloadDTO);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code DELETE  /transaction-downloads/:id} : delete the "id" transactionDownload.
     *
     * @param id the id of the transactionDownloadDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransactionDownload(@PathVariable Long id) {
        LOG.debug("REST request to delete TransactionDownload : {}", id);
        transactionDownloadService.delete(id);
        return ResponseEntity.noContent().build(); // Return 204 No Content
    }
}
