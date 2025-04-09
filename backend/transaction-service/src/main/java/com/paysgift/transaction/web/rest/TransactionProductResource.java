package com.paysgift.transaction.web.rest;

import com.paysgift.transaction.service.TransactionProductService;
import com.paysgift.transaction.service.dto.TransactionProductDTO;
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
 * REST controller for managing {@link com.paysgift.transaction.domain.TransactionProduct}.
 */
@RestController
@RequestMapping("/api/transaction-products")
public class TransactionProductResource {

    private static final Logger LOG = LoggerFactory.getLogger(TransactionProductResource.class);

    private final TransactionProductService transactionProductService;

    public TransactionProductResource(TransactionProductService transactionProductService) {
        this.transactionProductService = transactionProductService;
    }

    /**
     * {@code GET  /transaction-products} : get all the transactionProducts.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of transactionProducts in body.
     */
    @GetMapping("")
    public ResponseEntity<List<TransactionProductDTO>> getAllTransactionProducts(
        @org.springdoc.core.annotations.ParameterObject Pageable pageable
    ) {
        LOG.debug("REST request to get a page of TransactionProducts");
        Page<TransactionProductDTO> page = transactionProductService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /transaction-products/:id} : get the "id" transactionProduct.
     *
     * @param id the id of the transactionProductDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the transactionProductDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<TransactionProductDTO> getTransactionProduct(@PathVariable("id") Long id) {
        LOG.debug("REST request to get TransactionProduct : {}", id);
        Optional<TransactionProductDTO> transactionProductDTO = transactionProductService.findOne(id);
        return ResponseUtil.wrapOrNotFound(transactionProductDTO);
    }

    /**
     * {@code POST  /transaction-products} : Create a new transactionProduct.
     *
     * @param transactionProductDTO the transactionProductDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new transactionProductDTO,
     * or with status {@code 400 (Bad Request)} if the transactionProduct has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<TransactionProductDTO> createTransactionProduct(@RequestBody TransactionProductDTO transactionProductDTO) throws URISyntaxException {
        LOG.debug("REST request to save TransactionProduct : {}", transactionProductDTO);
        if (transactionProductDTO.getId() != null) {
            return ResponseEntity.badRequest().body(null); // A new transactionProduct cannot already have an ID
        }
        TransactionProductDTO result = transactionProductService.save(transactionProductDTO);
        return ResponseEntity.created(new URI("/api/transaction-products/" + result.getId())).body(result);
    }

    /**
     * {@code PUT  /transaction-products} : Updates an existing transactionProduct.
     *
     * @param transactionProductDTO the transactionProductDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated transactionProductDTO,
     * or with status {@code 400 (Bad Request)} if the transactionProductDTO is not valid,
     * or with status {@code 404 (Not Found)} if the transactionProductDTO doesn't exist,
     * or with status {@code 500 (Internal Server Error)} if the transactionProductDTO couldn't be updated.
     */
    @PutMapping("")
    public ResponseEntity<TransactionProductDTO> updateTransactionProduct(@RequestBody TransactionProductDTO transactionProductDTO) {
        LOG.debug("REST request to update TransactionProduct : {}", transactionProductDTO);
        if (transactionProductDTO.getId() == null) {
            return ResponseEntity.badRequest().body(null); // An existing transactionProduct must have an ID
        }
        TransactionProductDTO result = transactionProductService.save(transactionProductDTO);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code DELETE  /transaction-products/:id} : delete the "id" transactionProduct.
     *
     * @param id the id of the transactionProductDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransactionProduct(@PathVariable Long id) {
        LOG.debug("REST request to delete TransactionProduct : {}", id);
        transactionProductService.delete(id);
        return ResponseEntity.noContent().build(); // Return 204 No Content
    }
}
