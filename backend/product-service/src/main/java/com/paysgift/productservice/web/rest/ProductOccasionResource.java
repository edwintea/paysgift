package com.paysgift.productservice.web.rest;

import com.paysgift.productservice.service.ProductOccasionService;
import com.paysgift.productservice.service.dto.ProductOccasionDTO;
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
 * REST controller for managing {@link com.paysgift.productservice.domain.ProductOccasion}.
 */
@RestController
@RequestMapping("/api/product-occasions")
public class ProductOccasionResource {

    private static final Logger LOG = LoggerFactory.getLogger(ProductOccasionResource.class);

    private final ProductOccasionService productOccasionService;

    public ProductOccasionResource(ProductOccasionService productOccasionService) {
        this.productOccasionService = productOccasionService;
    }

    /**
     * {@code GET  /product-occasions} : get all the productOccasions.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of productOccasions in body.
     */
    @GetMapping("")
    public ResponseEntity<List<ProductOccasionDTO>> getAllProductOccasions(
        @org.springdoc.core.annotations.ParameterObject Pageable pageable
    ) {
        LOG.debug("REST request to get a page of ProductOccasions");
        Page<ProductOccasionDTO> page = productOccasionService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /product-occasions/:id} : get the "id" productOccasion.
     *
     * @param id the id of the productOccasionDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the productOccasionDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProductOccasionDTO> getProductOccasion(@PathVariable("id") Long id) {
        LOG.debug("REST request to get ProductOccasion : {}", id);
        Optional<ProductOccasionDTO> productOccasionDTO = productOccasionService.findOne(id);
        return ResponseUtil.wrapOrNotFound(productOccasionDTO);
    }

    /**
     * {@code POST  /product-occasions} : Create a new productOccasion.
     *
     * @param productOccasionDTO the productOccasionDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new productOccasionDTO, or with status {@code 400 (Bad Request)} if the productOccasion has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<ProductOccasionDTO> createProductOccasion(@RequestBody ProductOccasionDTO productOccasionDTO) throws URISyntaxException {
        LOG.debug("REST request to save ProductOccasion : {}", productOccasionDTO);
        if (productOccasionDTO.getId() != null) {
            return ResponseEntity.badRequest().header("Failure", "A new productOccasion cannot already have an ID").body(null);
        }
        ProductOccasionDTO result = productOccasionService.save(productOccasionDTO);
        return ResponseEntity.created(new URI("/api/product-occasions/" + result.getId()))
            .body(result);
    }

    /**
     * {@code PUT  /product-occasions} : Updates an existing productOccasion.
     *
     * @param productOccasionDTO the productOccasionDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated productOccasionDTO,
     * or with status {@code 400 (Bad Request)} if the productOccasionDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the productOccasionDTO couldn't be updated.
     */
    @PutMapping("")
    public ResponseEntity<ProductOccasionDTO> updateProductOccasion(@RequestBody ProductOccasionDTO productOccasionDTO) {
        LOG.debug("REST request to update ProductOccasion : {}", productOccasionDTO);
        if (productOccasionDTO.getId() == null) {
            return ResponseEntity.badRequest().header("Failure", "Invalid id").body(null);
        }
        ProductOccasionDTO result = productOccasionService.save(productOccasionDTO);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code DELETE  /product-occasions/:id} : delete the "id" productOccasion.
     *
     * @param id the id of the productOccasionDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductOccasion(@PathVariable Long id) {
        LOG.debug("REST request to delete ProductOccasion : {}", id);
        productOccasionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
