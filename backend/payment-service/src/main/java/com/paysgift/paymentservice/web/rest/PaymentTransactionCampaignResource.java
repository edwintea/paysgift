package com.paysgift.paymentservice.web.rest;

import com.paysgift.paymentservice.service.PaymentTransactionCampaignService;
import com.paysgift.paymentservice.service.dto.PaymentTransactionCampaignDTO;
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
 * REST controller for managing {@link com.paysgift.paymentservice.domain.PaymentTransactionCampaign}.
 */
@RestController
@RequestMapping("/api/payment-transaction-campaigns")
public class PaymentTransactionCampaignResource {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentTransactionCampaignResource.class);

    private final PaymentTransactionCampaignService paymentTransactionCampaignService;

    public PaymentTransactionCampaignResource(PaymentTransactionCampaignService paymentTransactionCampaignService) {
        this.paymentTransactionCampaignService = paymentTransactionCampaignService;
    }

    /**
     * {@code GET  /payment-transaction-campaigns} : get all the paymentTransactionCampaigns.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of paymentTransactionCampaigns in body.
     */
    @GetMapping("")
    public ResponseEntity<List<PaymentTransactionCampaignDTO>> getAllPaymentTransactionCampaigns(
        @org.springdoc.core.annotations.ParameterObject Pageable pageable
    ) {
        LOG.debug("REST request to get a page of PaymentTransactionCampaigns");
        Page<PaymentTransactionCampaignDTO> page = paymentTransactionCampaignService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /payment-transaction-campaigns/:id} : get the "id" paymentTransactionCampaign.
     *
     * @param id the id of the paymentTransactionCampaignDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the paymentTransactionCampaignDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<PaymentTransactionCampaignDTO> getPaymentTransactionCampaign(@PathVariable("id") Long id) {
        LOG.debug("REST request to get PaymentTransactionCampaign : {}", id);
        Optional<PaymentTransactionCampaignDTO> paymentTransactionCampaignDTO = paymentTransactionCampaignService.findOne(id);
        return ResponseUtil.wrapOrNotFound(paymentTransactionCampaignDTO);
    }
}
