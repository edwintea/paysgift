package com.paysgift.userservice.web.rest;

import com.paysgift.userservice.service.UserService;
import com.paysgift.userservice.service.dto.UserDTO;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
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

/**
 * REST controller for managing {@link com.paysgift.userservice.domain.User}.
 */
@RestController
@RequestMapping("/api/users")
public class UserResource {

    private static final Logger LOG = LoggerFactory.getLogger(UserResource.class);

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    /**
     * {@code GET  /users} : get all the users.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of users in body.
     */
    @GetMapping("")
    public ResponseEntity<List<UserDTO>> getAllUsers(@org.springdoc.core.annotations.ParameterObject Pageable pageable) {
        LOG.debug("REST request to get a page of Users");
        Page<UserDTO> page = userService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /users/:id} : get the "id" user.
     *
     * @param id the id of the userDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the userDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser (@PathVariable("id") Long id) {
        LOG.debug("REST request to get User : {}", id);
        Optional<UserDTO> userDTO = userService.findOne(id);
        return ResponseUtil.wrapOrNotFound(userDTO);
    }

    /**
     * {@code POST  /users} : Create a new user.
     *
     * @param userDTO the userDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new userDTO, or with status {@code 400 (Bad Request)} if the user has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<UserDTO> createUser (@RequestBody UserDTO userDTO) throws URISyntaxException {
        LOG.debug("REST request to save User : {}", userDTO);
        if (userDTO.getId() != null) {
            return ResponseEntity.badRequest().body(null); // User should not have an ID when creating
        }
        UserDTO result = userService.save(userDTO);
        return ResponseEntity.created(new URI("/api/users/" + result.getId()))
            .body(result);
    }

    /**
     * {@code PUT  /users} : Updates an existing user.
     *
     * @param userDTO the userDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated userDTO,
     * or with status {@code 400 (Bad Request)} if the userDTO is not valid,
     * or with status {@code 404 (Not Found)} if the userDTO doesn't exist,
     * or with status {@code 500 (Internal Server Error)} if the userDTO couldn't be updated.
     */
    @PutMapping("")
    public ResponseEntity<UserDTO> updateUser (@RequestBody UserDTO userDTO) {
        LOG.debug("REST request to update User : {}", userDTO);
        if (userDTO.getId() == null) {
            return ResponseEntity.badRequest().body(null); // User must have an ID to update
        }
        UserDTO result = userService.save(userDTO);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code DELETE  /users/:id} : delete the "id" user.
     *
     * @param id the id of the userDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser (@PathVariable Long id) {
        LOG.debug("REST request to delete User : {}", id);
        userService.delete(id);
        return ResponseEntity.noContent().build(); // Return 204 No Content
    }
}
