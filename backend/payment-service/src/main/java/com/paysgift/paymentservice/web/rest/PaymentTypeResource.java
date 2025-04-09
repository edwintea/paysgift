package com.paysgift.paymentservice.web.rest;

import com.paysgift.paymentservice.service.PaymentTypeService;
import com.paysgift.paymentservice.service.dto.PaymentTypeDTO;
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
 * REST controller for managing {@link com.paysgift.paymentservice.domain.PaymentType}.
 */
@RestController
@RequestMapping("/api/payment-types")
public class PaymentTypeResource {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentTypeResource.class);

    private final PaymentTypeService paymentTypeService;

    public PaymentTypeResource(PaymentTypeService paymentTypeService) {
        this.paymentTypeService = paymentTypeService;
    }

    /**
     * {@code GET  /payment-types} : get all the paymentTypes.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of paymentTypes in body.
     */
    @GetMapping("")
    public ResponseEntity<List<PaymentTypeDTO>> getAllPaymentTypes(@org.springdoc.core.annotations.ParameterObject Pageable pageable) {
        LOG.debug("REST request to get a page of PaymentTypes");
        Page<PaymentTypeDTO> page = paymentTypeService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /payment-types/:id} : get the "id" paymentType.
     *
     * @param id the id of the paymentTypeDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the paymentTypeDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<PaymentTypeDTO> getPaymentType(@PathVariable("id") Long id) {
        LOG.debug("REST request to get PaymentType : {}", id);
        Optional<PaymentTypeDTO> paymentTypeDTO = paymentTypeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(paymentTypeDTO);
    }
}
