package com.paysgift.productservice.web.rest;

import com.paysgift.productservice.service.PaysgiftPromoInfoService;
import com.paysgift.productservice.service.dto.PaysgiftPromoInfoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
 * REST controller for managing {@link com.paysgift.productservice.domain.PaysgiftPromoInfo}.
 */
@RestController
@RequestMapping("/api/paysgift-promo-infos")
public class PaysgiftPromoInfoResource {

    private static final Logger LOG = LoggerFactory.getLogger(PaysgiftPromoInfoResource.class);

    private final PaysgiftPromoInfoService paysgiftPromoInfoService;

    public PaysgiftPromoInfoResource(PaysgiftPromoInfoService paysgiftPromoInfoService) {
        this.paysgiftPromoInfoService = paysgiftPromoInfoService;
    }

    /**
     * {@code GET  /paysgift-promo-infos} : get all the paysgiftPromoInfos.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of paysgiftPromoInfos in body.
     */
    @GetMapping("")
    public ResponseEntity<List<PaysgiftPromoInfoDTO>> getAllPaysgiftPromoInfos(
        @org.springdoc.core.annotations.ParameterObject Pageable pageable
    ) {
        LOG.debug("REST request to get a page of PaysgiftPromoInfos");
        Page<PaysgiftPromoInfoDTO> page = paysgiftPromoInfoService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /paysgift-promo-infos/:id} : get the "id" paysgiftPromoInfo.
     *
     * @param id the id of the paysgiftPromoInfoDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the paysgiftPromoInfoDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<PaysgiftPromoInfoDTO> getPaysgiftPromoInfo(@PathVariable("id") Long id) {
        LOG.debug("REST request to get PaysgiftPromoInfo : {}", id);
        Optional<PaysgiftPromoInfoDTO> paysgiftPromoInfoDTO = paysgiftPromoInfoService.findOne(id);
        return ResponseUtil.wrapOrNotFound(paysgiftPromoInfoDTO);
    }

    /**
     * {@code POST  /paysgift-promo-infos} : Create a new paysgiftPromoInfo.
     *
     * @param paysgiftPromoInfoDTO the paysgiftPromoInfoDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new paysgiftPromoInfoDTO, or with status {@code 400 (Bad Request)} if the paysgiftPromoInfo has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<PaysgiftPromoInfoDTO> createPaysgiftPromoInfo(@RequestBody PaysgiftPromoInfoDTO paysgiftPromoInfoDTO) throws URISyntaxException {
        LOG.debug("REST request to save PaysgiftPromoInfo : {}", paysgiftPromoInfoDTO);
        if (paysgiftPromoInfoDTO.getId() != null) {
            return ResponseEntity.badRequest().header("Failure", "A new paysgiftPromoInfo cannot already have an ID").body(null);
        }
        PaysgiftPromoInfoDTO result = paysgiftPromoInfoService.save(paysgiftPromoInfoDTO);
        return ResponseEntity.created(new URI("/api/paysgift-promo-infos/" + result.getId()))
            .body(result);
    }

    /**
     * {@code PUT  /paysgift-promo-infos} : Updates an existing paysgiftPromoInfo.
     *
     * @param paysgiftPromoInfoDTO the paysgiftPromoInfoDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated paysgiftPromoInfoDTO,
     * or with status {@code 400 (Bad Request)} if the paysgiftPromoInfoDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the paysgiftPromoInfoDTO couldn't be updated.
     */
    @PutMapping("")
    public ResponseEntity<PaysgiftPromoInfoDTO> updatePaysgiftPromoInfo(@RequestBody PaysgiftPromoInfoDTO paysgiftPromoInfoDTO) {
        LOG.debug("REST request to update PaysgiftPromoInfo : {}", paysgiftPromoInfoDTO);
        if (paysgiftPromoInfoDTO.getId() == null) {
            return ResponseEntity.badRequest().header("Failure", "Invalid id").body(null);
        }
        PaysgiftPromoInfoDTO result = paysgiftPromoInfoService.save(paysgiftPromoInfoDTO);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code DELETE  /paysgift-promo-infos/:id} : delete the "id" paysgiftPromoInfo.
     *
     * @param id the id of the paysgiftPromoInfoDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaysgiftPromoInfo(@PathVariable Long id) {
        LOG.debug("REST request to delete PaysgiftPromoInfo : {}", id);
        paysgiftPromoInfoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
