package com.paysgift.notification.repository;

import com.paysgift.notification.domain.SendWhatsApp;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the SendWhatsApp entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SendWhatsAppRepository extends JpaRepository<SendWhatsApp, Long> {}
