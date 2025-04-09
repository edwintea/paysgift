package com.paysgift.productservice.web.rest;

import com.paysgift.productservice.service.DiscountService;
import com.paysgift.productservice.service.dto.DiscountDTO;
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
 * REST controller for managing {@link com.paysgift.productservice.domain.Discount}.
 */
@RestController
@RequestMapping("/api/discounts")
public class DiscountResource {

    private static final Logger LOG = LoggerFactory.getLogger(DiscountResource.class);

    private final DiscountService discountService;

    public DiscountResource(DiscountService discountService) {
        this.discountService = discountService;
    }

    /**
     * {@code GET  /discounts} : get all the discounts.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of discounts in body.
     */
    @GetMapping("")
    public ResponseEntity<List<DiscountDTO>> getAllDiscounts(@org.springdoc.core.annotations.ParameterObject Pageable pageable) {
        LOG.debug("REST request to get a page of Discounts");
        Page<DiscountDTO> page = discountService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /discounts/:id} : get the "id" discount.
     *
     * @param id the id of the discountDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the discountDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<DiscountDTO> getDiscount(@PathVariable("id") Long id) {
        LOG.debug("REST request to get Discount : {}", id);
        Optional<DiscountDTO> discountDTO = discountService.findOne(id);
        return ResponseUtil.wrapOrNotFound(discountDTO);
    }

    /**
     * {@code POST  /discounts} : Create a new discount.
     *
     * @param discountDTO the discountDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new discountDTO, or with status {@code 400 (Bad Request)} if the discount has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<DiscountDTO> createDiscount(@RequestBody DiscountDTO discountDTO) throws URISyntaxException {
        LOG.debug("REST request to save Discount : {}", discountDTO);
        if (discountDTO.getId() != null) {
            return ResponseEntity.badRequest().header("Failure", "A new discount cannot already have an ID").body(null);
        }
        DiscountDTO result = discountService.save(discountDTO);
        return ResponseEntity.created(new URI("/api/discounts/" + result.getId()))
            .body(result);
    }

    /**
     * {@code PUT  /discounts} : Updates an existing discount.
     *
     * @param discountDTO the discountDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated discountDTO,
     * or with status {@code 400 (Bad Request)} if the discountDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the discountDTO couldn't be updated.
     */
    @PutMapping("")
    public ResponseEntity<DiscountDTO> updateDiscount(@RequestBody DiscountDTO discountDTO) {
        LOG.debug("REST request to update Discount : {}", discountDTO);
        if (discountDTO.getId() == null) {
            return ResponseEntity.badRequest().header("Failure", "Invalid id").body(null);
        }
        DiscountDTO result = discountService.save(discountDTO);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code DELETE  /discounts/:id} : delete the "id" discount.
     *
     * @param id the id of the discountDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiscount(@PathVariable Long id) {
        LOG.debug("REST request to delete Discount : {}", id);
        discountService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
