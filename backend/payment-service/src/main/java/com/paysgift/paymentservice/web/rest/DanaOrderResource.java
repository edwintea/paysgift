package com.paysgift.paymentservice.web.rest;

import com.paysgift.paymentservice.service.DanaOrderService;
import com.paysgift.paymentservice.service.dto.DanaOrderDTO;
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
 * REST controller for managing {@link com.paysgift.paymentservice.domain.DanaOrder}.
 */
@RestController
@RequestMapping("/api/dana-orders")
public class DanaOrderResource {

    private static final Logger LOG = LoggerFactory.getLogger(DanaOrderResource.class);

    private final DanaOrderService danaOrderService;

    public DanaOrderResource(DanaOrderService danaOrderService) {
        this.danaOrderService = danaOrderService;
    }

    /**
     * {@code GET  /dana-orders} : get all the danaOrders.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of danaOrders in body.
     */
    @GetMapping("")
    public ResponseEntity<List<DanaOrderDTO>> getAllDanaOrders(@org.springdoc.core.annotations.ParameterObject Pageable pageable) {
        LOG.debug("REST request to get a page of DanaOrders");
        Page<DanaOrderDTO> page = danaOrderService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /dana-orders/:id} : get the "id" danaOrder.
     *
     * @param id the id of the danaOrderDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the danaOrderDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<DanaOrderDTO> getDanaOrder(@PathVariable("id") Long id) {
        LOG.debug("REST request to get DanaOrder : {}", id);
        Optional<DanaOrderDTO> danaOrderDTO = danaOrderService.findOne(id);
        return ResponseUtil.wrapOrNotFound(danaOrderDTO);
    }
}
