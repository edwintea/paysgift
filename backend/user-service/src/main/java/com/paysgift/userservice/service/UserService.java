package com.paysgift.userservice.service;

import com.paysgift.userservice.service.dto.UserDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.paysgift.userservice.domain.User}.
 */
public interface UserService {
    /**
     * Save a user.
     *
     * @param userDTO the entity to save.
     * @return the persisted entity.
     */
    UserDTO save(UserDTO userDTO);

    /**
     * Updates a user.
     *
     * @param userDTO the entity to update.
     * @return the persisted entity.
     */
    UserDTO update(UserDTO userDTO);

    /**
     * Partially updates a user.
     *
     * @param userDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<UserDTO> partialUpdate(UserDTO userDTO);

    /**
     * Get all the users.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<UserDTO> findAll(Pageable pageable);

    /**
     * Get the "id" user.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<UserDTO> findOne(Long id);

    /**
     * Delete the "id" user.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
