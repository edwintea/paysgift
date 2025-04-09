package com.paysgift.notification.web.rest;

import com.paysgift.notification.service.SendMessageService;
import com.paysgift.notification.service.dto.SendMessageDTO;
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
 * REST controller for managing {@link com.paysgift.notification.domain.SendMessage}.
 */
@RestController
@RequestMapping("/api/send-messages")
public class SendMessageResource {

    private static final Logger LOG = LoggerFactory.getLogger(SendMessageResource.class);

    private final SendMessageService sendMessageService;

    public SendMessageResource(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    /**
     * {@code GET  /send-messages} : get all the sendMessages.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of sendMessages in body.
     */
    @GetMapping("")
    public ResponseEntity<List<SendMessageDTO>> getAllSendMessages(@org.springdoc.core.annotations.ParameterObject Pageable pageable) {
        LOG.debug("REST request to get a page of SendMessages");
        Page<SendMessageDTO> page = sendMessageService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /send-messages/:id} : get the "id" sendMessage.
     *
     * @param id the id of the sendMessageDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the sendMessageDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<SendMessageDTO> getSendMessage(@PathVariable("id") Long id) {
        LOG.debug("REST request to get SendMessage : {}", id);
        Optional<SendMessageDTO> sendMessageDTO = sendMessageService.findOne(id);
        return ResponseUtil.wrapOrNotFound(sendMessageDTO);
    }

    /**
     * {@code POST  /send-messages} : Create a new sendMessage.
     *
     * @param sendMessageDTO the sendMessageDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new sendMessageDTO, or with status {@code 400 (Bad Request)} if the sendMessage has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<SendMessageDTO> createSendMessage(@RequestBody SendMessageDTO sendMessageDTO) throws URISyntaxException {
        LOG.debug("REST request to save SendMessage : {}", sendMessageDTO);
        if (sendMessageDTO.getId() != null) {
            return ResponseEntity.badRequest().body(null); // A new sendMessage cannot already have an ID
        }
        SendMessageDTO result = sendMessageService.save(sendMessageDTO);
        return ResponseEntity.created(new URI("/api/send-messages/" + result.getId())).body(result);
    }

    /**
     * {@code PUT  /send-messages} : Updates an existing sendMessage.
     *
     * @param sendMessageDTO the sendMessageDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated sendMessageDTO,
     * or with status {@code 400 (Bad Request)} if the sendMessageDTO is not valid,
     * or with status {@code 404 (Not Found)} if the sendMessageDTO doesn't exist,
     * or with status {@code 500 (Internal Server Error)} if the sendMessageDTO couldn't be updated.
     */
    @PutMapping("")
    public ResponseEntity<SendMessageDTO> updateSendMessage(@RequestBody SendMessageDTO sendMessageDTO) {
        LOG.debug("REST request to update SendMessage : {}", sendMessageDTO);
        if (sendMessageDTO.getId() == null) {
            return ResponseEntity.badRequest().body(null); // An existing sendMessage must have an ID
        }
        SendMessageDTO result = sendMessageService.save(sendMessageDTO);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code DELETE  /send-messages/:id} : delete the "id" sendMessage.
     *
     * @param id the id of the sendMessageDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSendMessage(@PathVariable Long id) {
        LOG.debug("REST request to delete SendMessage : {}", id);
        sendMessageService.delete(id);
        return ResponseEntity.noContent().build(); // Return 204 No Content
    }
}
