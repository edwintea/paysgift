package com.paysgift.notification.web.rest;

import com.paysgift.notification.service.SendEmailService;
import com.paysgift.notification.service.dto.SendEmailDTO;
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
 * REST controller for managing {@link com.paysgift.notification.domain.SendEmail}.
 */
@RestController
@RequestMapping("/api/send-emails")
public class SendEmailResource {

    private static final Logger LOG = LoggerFactory.getLogger(SendEmailResource.class);

    private final SendEmailService sendEmailService;

    public SendEmailResource(SendEmailService sendEmailService) {
        this.sendEmailService = sendEmailService;
    }

    /**
     * {@code GET  /send-emails} : get all the sendEmails.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of sendEmails in body.
     */
    @GetMapping("")
    public ResponseEntity<List<SendEmailDTO>> getAllSendEmails(@org.springdoc.core.annotations.ParameterObject Pageable pageable) {
        LOG.debug("REST request to get a page of SendEmails");
        Page<SendEmailDTO> page = sendEmailService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /send-emails/:id} : get the "id" sendEmail.
     *
     * @param id the id of the sendEmailDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the sendEmailDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<SendEmailDTO> getSendEmail(@PathVariable("id") Long id) {
        LOG.debug("REST request to get SendEmail : {}", id);
        Optional<SendEmailDTO> sendEmailDTO = sendEmailService.findOne(id);
        return ResponseUtil.wrapOrNotFound(sendEmailDTO);
    }

    /**
     * {@code POST  /send-emails} : Create a new sendEmail.
     *
     * @param sendEmailDTO the sendEmailDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new sendEmailDTO, or with status {@code 400 (Bad Request)} if the sendEmail has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<SendEmailDTO> createSendEmail(@RequestBody SendEmailDTO sendEmailDTO) throws URISyntaxException {
        LOG.debug("REST request to save SendEmail : {}", sendEmailDTO);
        if (sendEmailDTO.getId() != null) {
            return ResponseEntity.badRequest().body(null); // A new sendEmail cannot already have an ID
        }
        SendEmailDTO result = sendEmailService.save(sendEmailDTO);
        return ResponseEntity.created(new URI("/api/send-emails/" + result.getId())).body(result);
    }

    /**
     * {@code PUT  /send-emails} : Updates an existing sendEmail.
     *
     * @param sendEmailDTO the sendEmailDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated sendEmailDTO,
     * or with status {@code 400 (Bad Request)} if the sendEmailDTO is not valid,
     * or with status {@code 404 (Not Found)} if the sendEmailDTO doesn't exist,
     * or with status {@code 500 (Internal Server Error)} if the sendEmailDTO couldn't be updated.
     */
    @PutMapping("")
    public ResponseEntity<SendEmailDTO> updateSendEmail(@RequestBody SendEmailDTO sendEmailDTO) {
        LOG.debug("REST request to update SendEmail : {}", sendEmailDTO);
        if (sendEmailDTO.getId() == null) {
            return ResponseEntity.badRequest().body(null); // An existing sendEmail must have an ID
        }
        SendEmailDTO result = sendEmailService.save(sendEmailDTO);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code DELETE  /send-emails/:id} : delete the "id" sendEmail.
     *
     * @param id the id of the sendEmailDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSendEmail(@PathVariable Long id) {
        LOG.debug("REST request to delete SendEmail : {}", id);
        sendEmailService.delete(id);
        return ResponseEntity.noContent().build(); // Return 204 No Content
    }
}
