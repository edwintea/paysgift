package com.paysgift.notification.web.rest;

import com.paysgift.notification.service.SendWhatsAppService;
import com.paysgift.notification.service.dto.SendWhatsAppDTO;
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
 * REST controller for managing {@link com.paysgift.notification.domain.SendWhatsApp}.
 */
@RestController
@RequestMapping("/api/send-whats-apps")
public class SendWhatsAppResource {

    private static final Logger LOG = LoggerFactory.getLogger(SendWhatsAppResource.class);

    private final SendWhatsAppService sendWhatsAppService;

    public SendWhatsAppResource(SendWhatsAppService sendWhatsAppService) {
        this.sendWhatsAppService = sendWhatsAppService;
    }

    /**
     * {@code GET  /send-whats-apps} : get all the sendWhatsApps.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of sendWhatsApps in body.
     */
    @GetMapping("")
    public ResponseEntity<List<SendWhatsAppDTO>> getAllSendWhatsApps(@org.springdoc.core.annotations.ParameterObject Pageable pageable) {
        LOG.debug("REST request to get a page of SendWhatsApps");
        Page<SendWhatsAppDTO> page = sendWhatsAppService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /send-whats-apps/:id} : get the "id" sendWhatsApp.
     *
     * @param id the id of the sendWhatsAppDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the sendWhatsAppDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<SendWhatsAppDTO> getSendWhatsApp(@PathVariable("id") Long id) {
        LOG.debug("REST request to get SendWhatsApp : {}", id);
        Optional<SendWhatsAppDTO> sendWhatsAppDTO = sendWhatsAppService.findOne(id);
        return ResponseUtil.wrapOrNotFound(sendWhatsAppDTO);
    }

    /**
     * {@code POST  /send-whats-apps} : Create a new sendWhatsApp.
     *
     * @param sendWhatsAppDTO the sendWhatsAppDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new sendWhatsAppDTO, or with status {@code 400 (Bad Request)} if the sendWhatsApp has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<SendWhatsAppDTO> createSendWhatsApp(@RequestBody SendWhatsAppDTO sendWhatsAppDTO) throws URISyntaxException {
        LOG.debug("REST request to save SendWhatsApp : {}", sendWhatsAppDTO);
        if (sendWhatsAppDTO.getId() != null) {
            return ResponseEntity.badRequest().body(null); // A new sendWhatsApp cannot already have an ID
        }
        SendWhatsAppDTO result = sendWhatsAppService.save(sendWhatsAppDTO);
        return ResponseEntity.created(new URI("/api/send-whats-apps/" + result.getId())).body(result);
    }

/**
 * {@code PUT  /send-whats-apps} : Updates an existing sendWhatsApp.
 *
 * @param sendWhatsAppDTO the sendWhatsAppDTO to update.
 * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated sendWhatsAppDTO,
 * or with status {@code 404 (Not Found)} if the sendWhatsAppDTO doesn't exist,
 * or with status {@code 500 (Internal Server Error)} if the sendWhatsAppDTO couldn't be updated.
 */
@PutMapping("")
public ResponseEntity<SendWhatsAppDTO> updateSendWhatsApp(@RequestBody SendWhatsAppDTO sendWhatsAppDTO) {
    LOG.debug("REST request to update SendWhatsApp : {}", sendWhatsAppDTO);
    if (sendWhatsAppDTO.getId() == null) {
        return ResponseEntity.badRequest().body(null); // An existing sendWhatsApp must have an ID
    }
    SendWhatsAppDTO result = sendWhatsAppService.save(sendWhatsAppDTO);
    return ResponseEntity.ok().body(result);
}

    /**
     * {@code DELETE  /send-whats-apps/:id} : delete the "id" sendWhatsApp.
     *
     * @param id the id of the sendWhatsAppDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSendWhatsApp(@PathVariable Long id) {
        LOG.debug("REST request to delete SendWhatsApp : {}", id);
        sendWhatsAppService.delete(id);
        return ResponseEntity.noContent().build(); // Return 204 No Content
    }
}
