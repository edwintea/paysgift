package com.paysgift.productservice.web.rest;

import com.paysgift.productservice.service.EvoucherDeliveryService;
import com.paysgift.productservice.service.dto.EvoucherDeliveryDTO;
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
 * REST controller for managing {@link com.paysgift.productservice.domain.EvoucherDelivery}.
 */
@RestController
@RequestMapping("/api/evoucher-deliveries")
public class EvoucherDeliveryResource {

    private static final Logger LOG = LoggerFactory.getLogger(EvoucherDeliveryResource.class);

    private final EvoucherDeliveryService evoucherDeliveryService;

    public EvoucherDeliveryResource(EvoucherDeliveryService evoucherDeliveryService) {
        this.evoucherDeliveryService = evoucherDeliveryService;
    }

    /**
     * {@code GET  /evoucher-deliveries} : get all the evoucherDeliveries.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of evoucherDeliveries in body.
     */
    @GetMapping("")
    public ResponseEntity<List<EvoucherDeliveryDTO>> getAllEvoucherDeliveries(
        @org.springdoc.core.annotations.ParameterObject Pageable pageable
    ) {
        LOG.debug("REST request to get a page of EvoucherDeliveries");
        Page<EvoucherDeliveryDTO> page = evoucherDeliveryService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /evoucher-deliveries/:id} : get the "id" evoucherDelivery.
     *
     * @param id the id of the evoucherDeliveryDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the evoucherDeliveryDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<EvoucherDeliveryDTO> getEvoucherDelivery(@PathVariable("id") Long id) {
        LOG.debug("REST request to get EvoucherDelivery : {}", id);
        Optional<EvoucherDeliveryDTO> evoucherDeliveryDTO = evoucherDeliveryService.findOne(id);
        return ResponseUtil.wrapOrNotFound(evoucherDeliveryDTO);
    }

    /**
     * {@code POST  /evoucher-deliveries} : Create a new evoucherDelivery.
     *
     * @param evoucherDeliveryDTO the evoucherDeliveryDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new evoucherDeliveryDTO, or with status {@code 400 (Bad Request)} if the evoucherDelivery has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<EvoucherDeliveryDTO> createEvoucherDelivery(@RequestBody EvoucherDeliveryDTO evoucherDeliveryDTO) throws URISyntaxException {
        LOG.debug("REST request to save EvoucherDelivery : {}", evoucherDeliveryDTO);
        if (evoucherDeliveryDTO.getId() != null) {
            return ResponseEntity.badRequest().header("Failure", "A new evoucherDelivery cannot already have an ID").body(null);
        }
        EvoucherDeliveryDTO result = evoucherDeliveryService.save(evoucherDeliveryDTO);
        return ResponseEntity.created(new URI("/api/evoucher-deliveries/" + result.getId()))
            .body(result);
    }

    /**
     * {@code PUT  /evoucher-deliveries} : Updates an existing evoucherDelivery.
     *
     * @param evoucherDeliveryDTO the evoucherDeliveryDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated evoucherDeliveryDTO,
     * or with status {@code 400 (Bad Request)} if the evoucherDeliveryDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the evoucherDeliveryDTO couldn't be updated.
     */
    @PutMapping("")
    public ResponseEntity<EvoucherDeliveryDTO> updateEvoucherDelivery(@RequestBody EvoucherDeliveryDTO evoucherDeliveryDTO) {
        LOG.debug("REST request to update EvoucherDelivery : {}", evoucherDeliveryDTO);
        if (evoucherDeliveryDTO.getId() == null) {
            return ResponseEntity.badRequest().header("Failure", "Invalid id").body(null);
        }
        EvoucherDeliveryDTO result = evoucherDeliveryService.save(evoucherDeliveryDTO);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code DELETE  /evoucher-deliveries/:id} : delete the "id" evoucherDelivery.
     *
     * @param id the id of the evoucherDeliveryDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvoucherDelivery(@PathVariable Long id) {
        LOG.debug("REST request to delete EvoucherDelivery : {}", id);
        evoucherDeliveryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
