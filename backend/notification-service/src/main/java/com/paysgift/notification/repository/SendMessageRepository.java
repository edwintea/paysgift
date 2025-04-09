package com.paysgift.notification.repository;

import com.paysgift.notification.domain.SendMessage;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the SendMessage entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SendMessageRepository extends JpaRepository<SendMessage, Long> {}
