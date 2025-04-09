package com.paysgift.productservice.web.rest;

import com.paysgift.productservice.service.PaysgiftPromoService;
import com.paysgift.productservice.service.dto.PaysgiftPromoDTO;
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
 * REST controller for managing {@link com.paysgift.productservice.domain.PaysgiftPromo}.
 */
@RestController
@RequestMapping("/api/paysgift-promos")
public class PaysgiftPromoResource {

    private static final Logger LOG = LoggerFactory.getLogger(PaysgiftPromoResource.class);

    private final PaysgiftPromoService paysgiftPromoService;

    public PaysgiftPromoResource(PaysgiftPromoService paysgiftPromoService) {
        this.paysgiftPromoService = paysgiftPromoService;
    }

    /**
     * {@code GET  /paysgift-promos} : get all the paysgiftPromos.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of paysgiftPromos in body.
     */
    @GetMapping("")
    public ResponseEntity<List<PaysgiftPromoDTO>> getAllPaysgiftPromos(@org.springdoc.core.annotations.ParameterObject Pageable pageable) {
        LOG.debug("REST request to get a page of PaysgiftPromos");
        Page<PaysgiftPromoDTO> page = paysgiftPromoService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /paysgift-promos/:id} : get the "id" paysgiftPromo.
     *
     * @param id the id of the paysgiftPromoDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the paysgiftPromoDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<PaysgiftPromoDTO> getPaysgiftPromo(@PathVariable("id") Long id) {
        LOG.debug("REST request to get PaysgiftPromo : {}", id);
        Optional<PaysgiftPromoDTO> paysgiftPromoDTO = paysgiftPromoService.findOne(id);
        return ResponseUtil.wrapOrNotFound(paysgiftPromoDTO);
    }

    /**
     * {@code POST  /paysgift-promos} : Create a new paysgiftPromo.
     *
     * @param paysgiftPromoDTO the paysgiftPromoDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new paysgiftPromoDTO, or with status {@code 400 (Bad Request)} if the paysgiftPromo has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<PaysgiftPromoDTO> createPaysgiftPromo(@RequestBody PaysgiftPromoDTO paysgiftPromoDTO) throws URISyntaxException {
        LOG.debug("REST request to save PaysgiftPromo : {}", paysgiftPromoDTO);
        if (paysgiftPromoDTO.getId() != null) {
            return ResponseEntity.badRequest().header("Failure", "A new paysgiftPromo cannot already have an ID").body(null);
        }
        PaysgiftPromoDTO result = paysgiftPromoService.save(paysgiftPromoDTO);
        return ResponseEntity.created(new URI("/api/paysgift-promos/" + result.getId()))
            .body(result);
    }

    /**
     * {@code PUT  /paysgift-promos} : Updates an existing paysgiftPromo.
     *
     * @param paysgiftPromoDTO the paysgiftPromoDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated paysgiftPromoDTO,
     * or with status {@code 400 (Bad Request)} if the paysgiftPromoDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the paysgiftPromoDTO couldn't be updated.
     */
    @PutMapping("")
    public ResponseEntity<PaysgiftPromoDTO> updatePaysgiftPromo(@RequestBody PaysgiftPromoDTO paysgiftPromoDTO) {
        LOG.debug("REST request to update PaysgiftPromo : {}", paysgiftPromoDTO);
        if (paysgiftPromoDTO.getId() == null) {
            return ResponseEntity.badRequest().header("Failure", "Invalid id").body(null);
        }
        PaysgiftPromoDTO result = paysgiftPromoService.save(paysgiftPromoDTO);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code DELETE  /paysgift-promos/:id} : delete the "id" paysgiftPromo.
     *
     * @param id the id of the paysgiftPromoDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaysgiftPromo(@PathVariable Long id) {
        LOG.debug("REST request to delete PaysgiftPromo : {}", id);
        paysgiftPromoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
