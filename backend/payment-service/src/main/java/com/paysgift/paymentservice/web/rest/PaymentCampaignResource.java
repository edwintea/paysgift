package com.paysgift.paymentservice.web.rest;

import com.paysgift.paymentservice.service.PaymentCampaignService;
import com.paysgift.paymentservice.service.dto.PaymentCampaignDTO;
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
 * REST controller for managing {@link com.paysgift.paymentservice.domain.PaymentCampaign}.
 */
@RestController
@RequestMapping("/api/payment-campaigns")
public class PaymentCampaignResource {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentCampaignResource.class);

    private final PaymentCampaignService paymentCampaignService;

    public PaymentCampaignResource(PaymentCampaignService paymentCampaignService) {
        this.paymentCampaignService = paymentCampaignService;
    }

    /**
     * {@code GET  /payment-campaigns} : get all the paymentCampaigns.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of paymentCampaigns in body.
     */
    @GetMapping("")
    public ResponseEntity<List<PaymentCampaignDTO>> getAllPaymentCampaigns(
        @org.springdoc.core.annotations.ParameterObject Pageable pageable
    ) {
        LOG.debug("REST request to get a page of PaymentCampaigns");
        Page<PaymentCampaignDTO> page = paymentCampaignService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /payment-campaigns/:id} : get the "id" paymentCampaign.
     *
     * @param id the id of the paymentCampaignDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the paymentCampaignDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<PaymentCampaignDTO> getPaymentCampaign(@PathVariable("id") Long id) {
        LOG.debug("REST request to get PaymentCampaign : {}", id);
        Optional<PaymentCampaignDTO> paymentCampaignDTO = paymentCampaignService.findOne(id);
        return ResponseUtil.wrapOrNotFound(paymentCampaignDTO);
    }
}
