package com.paysgift.paymentservice.web.rest;

import com.paysgift.paymentservice.service.PaymentProviderService;
import com.paysgift.paymentservice.service.dto.PaymentProviderDTO;
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
 * REST controller for managing {@link com.paysgift.paymentservice.domain.PaymentProvider}.
 */
@RestController
@RequestMapping("/api/payment-providers")
public class PaymentProviderResource {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentProviderResource.class);

    private final PaymentProviderService paymentProviderService;

    public PaymentProviderResource(PaymentProviderService paymentProviderService) {
        this.paymentProviderService = paymentProviderService;
    }

    /**
     * {@code GET  /payment-providers} : get all the paymentProviders.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of paymentProviders in body.
     */
    @GetMapping("")
    public ResponseEntity<List<PaymentProviderDTO>> getAllPaymentProviders(
        @org.springdoc.core.annotations.ParameterObject Pageable pageable
    ) {
        LOG.debug("REST request to get a page of PaymentProviders");
        Page<PaymentProviderDTO> page = paymentProviderService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /payment-providers/:id} : get the "id" paymentProvider.
     *
     * @param id the id of the paymentProviderDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the paymentProviderDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<PaymentProviderDTO> getPaymentProvider(@PathVariable("id") Long id) {
        LOG.debug("REST request to get PaymentProvider : {}", id);
        Optional<PaymentProviderDTO> paymentProviderDTO = paymentProviderService.findOne(id);
        return ResponseUtil.wrapOrNotFound(paymentProviderDTO);
    }
}
