package com.paysgift.paymentservice.web.rest;

import com.paysgift.paymentservice.service.PaymentTransactionRetryingService;
import com.paysgift.paymentservice.service.dto.PaymentTransactionRetryingDTO;
import java.util.List;
import java.util.Optional;
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

/**
 * REST controller for managing {@link com.paysgift.paymentservice.domain.PaymentTransactionRetrying}.
 */
@RestController
@RequestMapping("/api/payment-transaction-retryings")
public class PaymentTransactionRetryingResource {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentTransactionRetryingResource.class);

    private final PaymentTransactionRetryingService paymentTransactionRetryingService;

    public PaymentTransactionRetryingResource(PaymentTransactionRetryingService paymentTransactionRetryingService) {
        this.paymentTransactionRetryingService = paymentTransactionRetryingService;
    }

    /**
     * {@code GET  /payment-transaction-retryings} : get all the paymentTransactionRetryings.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of paymentTransactionRetryings in body.
     */
    @GetMapping("")
    public ResponseEntity<List<PaymentTransactionRetryingDTO>> getAllPaymentTransactionRetryings(
        @org.springdoc.core.annotations.ParameterObject Pageable pageable
    ) {
        LOG.debug("REST request to get a page of PaymentTransactionRetryings");
        Page<PaymentTransactionRetryingDTO> page = paymentTransactionRetryingService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /payment-transaction-retryings/:id} : get the "id" paymentTransactionRetrying.
     *
     * @param id the id of the paymentTransactionRetryingDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the paymentTransactionRetryingDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<PaymentTransactionRetryingDTO> getPaymentTransactionRetrying(@PathVariable("id") Long id) {
        LOG.debug("REST request to get PaymentTransactionRetrying : {}", id);
        Optional<PaymentTransactionRetryingDTO> paymentTransactionRetryingDTO = paymentTransactionRetryingService.findOne(id);
        return ResponseUtil.wrapOrNotFound(paymentTransactionRetryingDTO);
    }
}
