package com.paysgift.productservice.web.rest;

import com.paysgift.productservice.service.ProductFavouriteService;
import com.paysgift.productservice.service.dto.ProductFavouriteDTO;
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
 * REST controller for managing {@link com.paysgift.productservice.domain.ProductFavourite}.
 */
@RestController
@RequestMapping("/api/product-favourites")
public class ProductFavouriteResource {

    private static final Logger LOG = LoggerFactory.getLogger(ProductFavouriteResource.class);

    private final ProductFavouriteService productFavouriteService;

    public ProductFavouriteResource(ProductFavouriteService productFavouriteService) {
        this.productFavouriteService = productFavouriteService;
    }

    /**
     * {@code GET  /product-favourites} : get all the productFavourites.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of productFavourites in body.
     */
    @GetMapping("")
    public ResponseEntity<List<ProductFavouriteDTO>> getAllProductFavourites(
        @org.springdoc.core.annotations.ParameterObject Pageable pageable
    ) {
        LOG.debug("REST request to get a page of ProductFavourites");
        Page<ProductFavouriteDTO> page = productFavouriteService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /product-favourites/:id} : get the "id" productFavourite.
     *
     * @param id the id of the productFavouriteDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the productFavouriteDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProductFavouriteDTO> getProductFavourite(@PathVariable("id") Long id) {
        LOG.debug("REST request to get ProductFavourite : {}", id);
        Optional<ProductFavouriteDTO> productFavouriteDTO = productFavouriteService.findOne(id);
        return ResponseUtil.wrapOrNotFound(productFavouriteDTO);
    }

    /**
     * {@code POST  /product-favourites} : Create a new productFavourite.
     *
     * @param productFavouriteDTO the productFavouriteDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new productFavouriteDTO, or with status {@code 400 (Bad Request)} if the productFavourite has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<ProductFavouriteDTO> createProductFavourite(@RequestBody ProductFavouriteDTO productFavouriteDTO) throws URISyntaxException {
        LOG.debug("REST request to save ProductFavourite : {}", productFavouriteDTO);
        if (productFavouriteDTO.getId() != null) {
            return ResponseEntity.badRequest().header("Failure", "A new productFavourite cannot already have an ID").body(null);
        }
        ProductFavouriteDTO result = productFavouriteService.save(productFavouriteDTO);
        return ResponseEntity.created(new URI("/api/product-favourites/" + result.getId()))
            .body(result);
    }

    /**
     * {@code PUT  /product-favourites} : Updates an existing productFavourite.
     *
     * @param productFavouriteDTO the productFavouriteDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated productFavouriteDTO,
     * or with status {@code 400 (Bad Request)} if the productFavouriteDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the productFavouriteDTO couldn't be updated.
     */
    @PutMapping("")
    public ResponseEntity<ProductFavouriteDTO> updateProductFavourite(@RequestBody ProductFavouriteDTO productFavouriteDTO) {
        LOG.debug("REST request to update ProductFavourite : {}", productFavouriteDTO);
        if (productFavouriteDTO.getId() == null) {
            return ResponseEntity.badRequest().header("Failure", "Invalid id").body(null);
        }
        ProductFavouriteDTO result = productFavouriteService.save(productFavouriteDTO);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code DELETE  /product-favourites/:id} : delete the "id" productFavourite.
     *
     * @param id the id of the productFavouriteDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductFavourite(@PathVariable Long id) {
        LOG.debug("REST request to delete ProductFavourite : {}", id);
        productFavouriteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
