package com.paysgift.paymentservice.web.rest;

import com.paysgift.paymentservice.service.PaymentTransactionRecurringService;
import com.paysgift.paymentservice.service.dto.PaymentTransactionRecurringDTO;
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
 * REST controller for managing {@link com.paysgift.paymentservice.domain.PaymentTransactionRecurring}.
 */
@RestController
@RequestMapping("/api/payment-transaction-recurrings")
public class PaymentTransactionRecurringResource {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentTransactionRecurringResource.class);

    private final PaymentTransactionRecurringService paymentTransactionRecurringService;

    public PaymentTransactionRecurringResource(PaymentTransactionRecurringService paymentTransactionRecurringService) {
        this.paymentTransactionRecurringService = paymentTransactionRecurringService;
    }

    /**
     * {@code GET  /payment-transaction-recurrings} : get all the paymentTransactionRecurrings.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of paymentTransactionRecurrings in body.
     */
    @GetMapping("")
    public ResponseEntity<List<PaymentTransactionRecurringDTO>> getAllPaymentTransactionRecurrings(
        @org.springdoc.core.annotations.ParameterObject Pageable pageable
    ) {
        LOG.debug("REST request to get a page of PaymentTransactionRecurrings");
        Page<PaymentTransactionRecurringDTO> page = paymentTransactionRecurringService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /payment-transaction-recurrings/:id} : get the "id" paymentTransactionRecurring.
     *
     * @param id the id of the paymentTransactionRecurringDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the paymentTransactionRecurringDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<PaymentTransactionRecurringDTO> getPaymentTransactionRecurring(@PathVariable("id") Long id) {
        LOG.debug("REST request to get PaymentTransactionRecurring : {}", id);
        Optional<PaymentTransactionRecurringDTO> paymentTransactionRecurringDTO = paymentTransactionRecurringService.findOne(id);
        return ResponseUtil.wrapOrNotFound(paymentTransactionRecurringDTO);
    }
}
