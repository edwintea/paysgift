package com.paysgift.orderservice.web.rest;

import com.paysgift.orderservice.service.CartDeleteService;
import com.paysgift.orderservice.service.dto.CartDeleteDTO;
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
 * REST controller for managing {@link com.paysgift.orderservice.domain.CartDelete}.
 */
@RestController
@RequestMapping("/api/cart-deletes")
public class CartDeleteResource {

    private static final Logger LOG = LoggerFactory.getLogger(CartDeleteResource.class);

    private final CartDeleteService cartDeleteService;

    public CartDeleteResource(CartDeleteService cartDeleteService) {
        this.cartDeleteService = cartDeleteService;
    }

    /**
     * {@code GET  /cart-deletes} : get all the cartDeletes.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of cartDeletes in body.
     */
    @GetMapping("")
    public ResponseEntity<List<CartDeleteDTO>> getAllCartDeletes(@org.springdoc.core.annotations.ParameterObject Pageable pageable) {
        LOG.debug("REST request to get a page of CartDeletes");
        Page<CartDeleteDTO> page = cartDeleteService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /cart-deletes/:id} : get the "id" cartDelete.
     *
     * @param id the id of the cartDeleteDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the cartDeleteDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<CartDeleteDTO> getCartDelete(@PathVariable("id") Long id) {
        LOG.debug("REST request to get CartDelete : {}", id);
        Optional<CartDeleteDTO> cartDeleteDTO = cartDeleteService.findOne(id);
        return ResponseUtil.wrapOrNotFound(cartDeleteDTO);
    }

    /**
     * {@code POST  /cart-deletes} : Create a new cartDelete.
     *
     * @param cartDeleteDTO the cartDeleteDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new cartDeleteDTO, or with status {@code 400 (Bad Request)} if the cartDelete has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<CartDeleteDTO> createCartDelete(@RequestBody CartDeleteDTO cartDeleteDTO) throws URISyntaxException {
        LOG.debug("REST request to save CartDelete : {}", cartDeleteDTO);
        if (cartDeleteDTO.getId() != null) {
            return ResponseEntity.badRequest().body(null); // A new cartDelete cannot already have an ID
        }
        CartDeleteDTO result = cartDeleteService.save(cartDeleteDTO);
        return ResponseEntity.created(new URI("/api/cart-deletes/" + result.getId())).body(result);
    }

    /**
     * {@code PUT  /cart-deletes} : Updates an existing cartDelete.
     *
     * @param cartDeleteDTO the cartDeleteDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated cartDeleteDTO,
     * or with status {@code 400 (Bad Request)} if the cartDeleteDTO is not valid,
     * or with status {@code 404 (Not Found)} if the cartDeleteDTO doesn't exist,
     * or with status {@code 500 (Internal Server Error)} if the cartDeleteDTO couldn't be updated.
     */
    @PutMapping("")
    public ResponseEntity<CartDeleteDTO> updateCartDelete(@RequestBody CartDeleteDTO cartDeleteDTO) {
        LOG.debug("REST request to update CartDelete : {}", cartDeleteDTO);
        if (cartDeleteDTO.getId() == null) {
            return ResponseEntity.badRequest().body(null); // An existing cartDelete must have an ID
        }
        CartDeleteDTO result = cartDeleteService.save(cartDeleteDTO);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code DELETE  /cart-deletes/:id} : delete the "id" cartDelete.
     *
     * @param id the id of the cartDeleteDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCartDelete(@PathVariable Long id) {
        LOG.debug("REST request to delete CartDelete : {}", id);
        cartDeleteService.delete(id);
        return ResponseEntity.noContent().build(); // Return 204 No Content
    }
}
