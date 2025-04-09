package com.paysgift.paymentservice.web.rest;

import com.paysgift.paymentservice.service.PaymentCustomerSamsungService;
import com.paysgift.paymentservice.service.dto.PaymentCustomerSamsungDTO;
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
 * REST controller for managing {@link com.paysgift.paymentservice.domain.PaymentCustomerSamsung}.
 */
@RestController
@RequestMapping("/api/payment-customer-samsungs")
public class PaymentCustomerSamsungResource {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentCustomerSamsungResource.class);

    private final PaymentCustomerSamsungService paymentCustomerSamsungService;

    public PaymentCustomerSamsungResource(PaymentCustomerSamsungService paymentCustomerSamsungService) {
        this.paymentCustomerSamsungService = paymentCustomerSamsungService;
    }

    /**
     * {@code GET  /payment-customer-samsungs} : get all the paymentCustomerSamsungs.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of paymentCustomerSamsungs in body.
     */
    @GetMapping("")
    public ResponseEntity<List<PaymentCustomerSamsungDTO>> getAllPaymentCustomerSamsungs(
        @org.springdoc.core.annotations.ParameterObject Pageable pageable
    ) {
        LOG.debug("REST request to get a page of PaymentCustomerSamsungs");
        Page<PaymentCustomerSamsungDTO> page = paymentCustomerSamsungService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /payment-customer-samsungs/:id} : get the "id" paymentCustomerSamsung.
     *
     * @param id the id of the paymentCustomerSamsungDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the paymentCustomerSamsungDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<PaymentCustomerSamsungDTO> getPaymentCustomerSamsung(@PathVariable("id") Long id) {
        LOG.debug("REST request to get PaymentCustomerSamsung : {}", id);
        Optional<PaymentCustomerSamsungDTO> paymentCustomerSamsungDTO = paymentCustomerSamsungService.findOne(id);
        return ResponseUtil.wrapOrNotFound(paymentCustomerSamsungDTO);
    }
}
