package com.paysgift.productservice.web.rest;

import com.paysgift.productservice.service.ProductImageService;
import com.paysgift.productservice.service.dto.ProductImageDTO;
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
 * REST controller for managing {@link com.paysgift.productservice.domain.ProductImage}.
 */
@RestController
@RequestMapping("/api/product-images")
public class ProductImageResource {

    private static final Logger LOG = LoggerFactory.getLogger(ProductImageResource.class);

    private final ProductImageService productImageService;

    public ProductImageResource(ProductImageService productImageService) {
        this.productImageService = productImageService;
    }

    /**
     * {@code GET  /product-images} : get all the productImages.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of productImages in body.
     */
    @GetMapping("")
    public ResponseEntity<List<ProductImageDTO>> getAllProductImages(@org.springdoc.core.annotations.ParameterObject Pageable pageable) {
        LOG.debug("REST request to get a page of ProductImages");
        Page<ProductImageDTO> page = productImageService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /product-images/:id} : get the "id" productImage.
     *
     * @param id the id of the productImageDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the productImageDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProductImageDTO> getProductImage(@PathVariable("id") Long id) {
        LOG.debug("REST request to get ProductImage : {}", id);
        Optional<ProductImageDTO> productImageDTO = productImageService.findOne(id);
        return ResponseUtil.wrapOrNotFound(productImageDTO);
    }

    /**
     * {@code POST  /product-images} : Create a new productImage.
     *
     * @param productImageDTO the productImageDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new productImageDTO, or with status {@code 400 (Bad Request)} if the productImage has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<ProductImageDTO> createProductImage(@RequestBody ProductImageDTO productImageDTO) throws URISyntaxException {
        LOG.debug("REST request to save ProductImage : {}", productImageDTO);
        if (productImageDTO.getId() != null) {
            return ResponseEntity.badRequest().header("Failure", "A new productImage cannot already have an ID").body(null);
        }
        ProductImageDTO result = productImageService.save(productImageDTO);
        return ResponseEntity.created(new URI("/api/product-images/" + result.getId()))
            .body(result);
    }

    /**
     * {@code PUT  /product-images} : Updates an existing productImage.
     *
     * @param productImageDTO the productImageDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated productImageDTO,
     * or with status {@code 400 (Bad Request)} if the productImageDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the productImageDTO couldn't be updated.
     */
    @PutMapping("")
    public ResponseEntity<ProductImageDTO> updateProductImage(@RequestBody ProductImageDTO productImageDTO) {
        LOG.debug("REST request to update ProductImage : {}", productImageDTO);
        if (productImageDTO.getId() == null) {
            return ResponseEntity.badRequest().header("Failure", "Invalid id").body(null);
        }
        ProductImageDTO result = productImageService.save(productImageDTO);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code DELETE  /product-images/:id} : delete the "id" productImage.
     *
     * @param id the id of the productImageDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductImage(@PathVariable Long id) {
        LOG.debug("REST request to delete ProductImage : {}", id);
        productImageService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
