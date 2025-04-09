package com.paysgift.paymentservice.web.rest;

import com.paysgift.paymentservice.service.PaymentListService;
import com.paysgift.paymentservice.service.dto.PaymentListDTO;
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
 * REST controller for managing {@link com.paysgift.paymentservice.domain.PaymentList}.
 */
@RestController
@RequestMapping("/api/payment-lists")
public class PaymentListResource {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentListResource.class);

    private final PaymentListService paymentListService;

    public PaymentListResource(PaymentListService paymentListService) {
        this.paymentListService = paymentListService;
    }

    /**
     * {@code GET  /payment-lists} : get all the paymentLists.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of paymentLists in body.
     */
    @GetMapping("")
    public ResponseEntity<List<PaymentListDTO>> getAllPaymentLists(@org.springdoc.core.annotations.ParameterObject Pageable pageable) {
        LOG.debug("REST request to get a page of PaymentLists");
        Page<PaymentListDTO> page = paymentListService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /payment-lists/:id} : get the "id" paymentList.
     *
     * @param id the id of the paymentListDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the paymentListDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<PaymentListDTO> getPaymentList(@PathVariable("id") Long id) {
        LOG.debug("REST request to get PaymentList : {}", id);
        Optional<PaymentListDTO> paymentListDTO = paymentListService.findOne(id);
        return ResponseUtil.wrapOrNotFound(paymentListDTO);
    }
}
