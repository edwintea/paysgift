package com.paysgift.productservice.web.rest;

import com.paysgift.productservice.service.CouponCodeService;
import com.paysgift.productservice.service.dto.CouponCodeDTO;
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
 * REST controller for managing {@link com.paysgift.productservice.domain.CouponCode}.
 */
@RestController
@RequestMapping("/api/coupon-codes")
public class CouponCodeResource {

    private static final Logger LOG = LoggerFactory.getLogger(CouponCodeResource.class);

    private final CouponCodeService couponCodeService;

    public CouponCodeResource(CouponCodeService couponCodeService) {
        this.couponCodeService = couponCodeService;
    }

    /**
     * {@code GET  /coupon-codes} : get all the couponCodes.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of couponCodes in body.
     */
    @GetMapping("")
    public ResponseEntity<List<CouponCodeDTO>> getAllCouponCodes(@org.springdoc.core.annotations.ParameterObject Pageable pageable) {
        LOG.debug("REST request to get a page of CouponCodes");
        Page<CouponCodeDTO> page = couponCodeService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /coupon-codes/:id} : get the "id" couponCode.
     *
     * @param id the id of the couponCodeDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the couponCodeDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<CouponCodeDTO> getCouponCode(@PathVariable("id") Long id) {
        LOG.debug("REST request to get CouponCode : {}", id);
        Optional<CouponCodeDTO> couponCodeDTO = couponCodeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(couponCodeDTO);
    }

    /**
     * {@code POST  /coupon-codes} : Create a new couponCode.
     *
     * @param couponCodeDTO the couponCodeDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new couponCodeDTO, or with status {@code 400 (Bad Request)} if the couponCode has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<CouponCodeDTO> createCouponCode(@RequestBody CouponCodeDTO couponCodeDTO) throws URISyntaxException {
        LOG.debug("REST request to save CouponCode : {}", couponCodeDTO);
        if (couponCodeDTO.getId() != null) {
            return ResponseEntity.badRequest().header("Failure", "A new couponCode cannot already have an ID").body(null);
        }
        CouponCodeDTO result = couponCodeService.save(couponCodeDTO);
        return ResponseEntity.created(new URI("/api/coupon-codes/" + result.getId()))
            .body(result);
    }

    /**
     * {@code PUT  /coupon-codes} : Updates an existing couponCode.
     *
     * @param couponCodeDTO the couponCodeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated couponCodeDTO,
     * or with status {@code 400 (Bad Request)} if the couponCodeDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the couponCodeDTO couldn't be updated.
     */
    @PutMapping("")
    public ResponseEntity<CouponCodeDTO> updateCouponCode(@RequestBody CouponCodeDTO couponCodeDTO) {
        LOG.debug("REST request to update CouponCode : {}", couponCodeDTO);
        if (couponCodeDTO.getId() == null) {
            return ResponseEntity.badRequest().header("Failure", "Invalid id").body(null);
        }
        CouponCodeDTO result = couponCodeService.save(couponCodeDTO);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code DELETE  /coupon-codes/:id} : delete the "id" couponCode.
     *
     * @param id the id of the couponCodeDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCouponCode(@PathVariable Long id) {
        LOG.debug("REST request to delete CouponCode : {}", id);
        couponCodeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
