package com.paysgift.notification.repository;

import com.paysgift.notification.domain.SendEmail;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the SendEmail entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SendEmailRepository extends JpaRepository<SendEmail, Long> {}
