package com.paysgift.paymentservice.web.rest;

import com.paysgift.paymentservice.service.PaymentTransactionService;
import com.paysgift.paymentservice.service.dto.PaymentTransactionDTO;
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
 * REST controller for managing {@link com.paysgift.paymentservice.domain.PaymentTransaction}.
 */
@RestController
@RequestMapping("/api/payment-transactions")
public class PaymentTransactionResource {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentTransactionResource.class);

    private final PaymentTransactionService paymentTransactionService;

    public PaymentTransactionResource(PaymentTransactionService paymentTransactionService) {
        this.paymentTransactionService = paymentTransactionService;
    }

    /**
     * {@code GET  /payment-transactions} : get all the paymentTransactions.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of paymentTransactions in body.
     */
    @GetMapping("")
    public ResponseEntity<List<PaymentTransactionDTO>> getAllPaymentTransactions(
        @org.springdoc.core.annotations.ParameterObject Pageable pageable
    ) {
        LOG.debug("REST request to get a page of PaymentTransactions");
        Page<PaymentTransactionDTO> page = paymentTransactionService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /payment-transactions/:id} : get the "id" paymentTransaction.
     *
     * @param id the id of the paymentTransactionDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the paymentTransactionDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<PaymentTransactionDTO> getPaymentTransaction(@PathVariable("id") Long id) {
        LOG.debug("REST request to get PaymentTransaction : {}", id);
        Optional<PaymentTransactionDTO> paymentTransactionDTO = paymentTransactionService.findOne(id);
        return ResponseUtil.wrapOrNotFound(paymentTransactionDTO);
    }
}
