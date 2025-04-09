package com.paysgift.paymentservice.web.rest;

import static com.paysgift.paymentservice.domain.PaymentTransactionRetryingAsserts.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paysgift.paymentservice.IntegrationTest;
import com.paysgift.paymentservice.domain.PaymentTransactionRetrying;
import com.paysgift.paymentservice.repository.PaymentTransactionRetryingRepository;
import com.paysgift.paymentservice.service.mapper.PaymentTransactionRetryingMapper;
import jakarta.persistence.EntityManager;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link PaymentTransactionRetryingResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class PaymentTransactionRetryingResourceIT {

    private static final Long DEFAULT_PAYMENT_TRANSACTION_RECURRING_ID = 1L;
    private static final Long UPDATED_PAYMENT_TRANSACTION_RECURRING_ID = 2L;

    private static final String DEFAULT_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_STATUS = "BBBBBBBBBB";

    private static final Integer DEFAULT_ATTEMPT_RETRY = 1;
    private static final Integer UPDATED_ATTEMPT_RETRY = 2;

    private static final Instant DEFAULT_DATETIME_RETRY = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_DATETIME_RETRY = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_DATETIME_NEXT_RETRY = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_DATETIME_NEXT_RETRY = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Boolean DEFAULT_SEND_CALLBACK = false;
    private static final Boolean UPDATED_SEND_CALLBACK = true;

    private static final Integer DEFAULT_SEND_CALLBACK_ATTEMPT = 1;
    private static final Integer UPDATED_SEND_CALLBACK_ATTEMPT = 2;

    private static final Boolean DEFAULT_SEND_EMAIL = false;
    private static final Boolean UPDATED_SEND_EMAIL = true;

    private static final Integer DEFAULT_SEND_EMAIL_ATTEMPT = 1;
    private static final Integer UPDATED_SEND_EMAIL_ATTEMPT = 2;

    private static final Instant DEFAULT_CREATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_CREATED_BY = 1L;
    private static final Long UPDATED_CREATED_BY = 2L;

    private static final Instant DEFAULT_UPDATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_UPDATED_BY = 1L;
    private static final Long UPDATED_UPDATED_BY = 2L;

    private static final String ENTITY_API_URL = "/api/payment-transaction-retryings";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    @Autowired
    private ObjectMapper om;

    @Autowired
    private PaymentTransactionRetryingRepository paymentTransactionRetryingRepository;

    @Autowired
    private PaymentTransactionRetryingMapper paymentTransactionRetryingMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restPaymentTransactionRetryingMockMvc;

    private PaymentTransactionRetrying paymentTransactionRetrying;

    private PaymentTransactionRetrying insertedPaymentTransactionRetrying;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PaymentTransactionRetrying createEntity() {
        return new PaymentTransactionRetrying()
            .paymentTransactionRecurringId(DEFAULT_PAYMENT_TRANSACTION_RECURRING_ID)
            .status(DEFAULT_STATUS)
            .attemptRetry(DEFAULT_ATTEMPT_RETRY)
            .datetimeRetry(DEFAULT_DATETIME_RETRY)
            .datetimeNextRetry(DEFAULT_DATETIME_NEXT_RETRY)
            .sendCallback(DEFAULT_SEND_CALLBACK)
            .sendCallbackAttempt(DEFAULT_SEND_CALLBACK_ATTEMPT)
            .sendEmail(DEFAULT_SEND_EMAIL)
            .sendEmailAttempt(DEFAULT_SEND_EMAIL_ATTEMPT)
            .createdAt(DEFAULT_CREATED_AT)
            .createdBy(DEFAULT_CREATED_BY)
            .updatedAt(DEFAULT_UPDATED_AT)
            .updatedBy(DEFAULT_UPDATED_BY);
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PaymentTransactionRetrying createUpdatedEntity() {
        return new PaymentTransactionRetrying()
            .paymentTransactionRecurringId(UPDATED_PAYMENT_TRANSACTION_RECURRING_ID)
            .status(UPDATED_STATUS)
            .attemptRetry(UPDATED_ATTEMPT_RETRY)
            .datetimeRetry(UPDATED_DATETIME_RETRY)
            .datetimeNextRetry(UPDATED_DATETIME_NEXT_RETRY)
            .sendCallback(UPDATED_SEND_CALLBACK)
            .sendCallbackAttempt(UPDATED_SEND_CALLBACK_ATTEMPT)
            .sendEmail(UPDATED_SEND_EMAIL)
            .sendEmailAttempt(UPDATED_SEND_EMAIL_ATTEMPT)
            .createdAt(UPDATED_CREATED_AT)
            .createdBy(UPDATED_CREATED_BY)
            .updatedAt(UPDATED_UPDATED_AT)
            .updatedBy(UPDATED_UPDATED_BY);
    }

    @BeforeEach
    void initTest() {
        paymentTransactionRetrying = createEntity();
    }

    @AfterEach
    void cleanup() {
        if (insertedPaymentTransactionRetrying != null) {
            paymentTransactionRetryingRepository.delete(insertedPaymentTransactionRetrying);
            insertedPaymentTransactionRetrying = null;
        }
    }

    @Test
    @Transactional
    void getAllPaymentTransactionRetryings() throws Exception {
        // Initialize the database
        insertedPaymentTransactionRetrying = paymentTransactionRetryingRepository.saveAndFlush(paymentTransactionRetrying);

        // Get all the paymentTransactionRetryingList
        restPaymentTransactionRetryingMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(paymentTransactionRetrying.getId().intValue())))
            .andExpect(jsonPath("$.[*].paymentTransactionRecurringId").value(hasItem(DEFAULT_PAYMENT_TRANSACTION_RECURRING_ID.intValue())))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].attemptRetry").value(hasItem(DEFAULT_ATTEMPT_RETRY)))
            .andExpect(jsonPath("$.[*].datetimeRetry").value(hasItem(DEFAULT_DATETIME_RETRY.toString())))
            .andExpect(jsonPath("$.[*].datetimeNextRetry").value(hasItem(DEFAULT_DATETIME_NEXT_RETRY.toString())))
            .andExpect(jsonPath("$.[*].sendCallback").value(hasItem(DEFAULT_SEND_CALLBACK)))
            .andExpect(jsonPath("$.[*].sendCallbackAttempt").value(hasItem(DEFAULT_SEND_CALLBACK_ATTEMPT)))
            .andExpect(jsonPath("$.[*].sendEmail").value(hasItem(DEFAULT_SEND_EMAIL)))
            .andExpect(jsonPath("$.[*].sendEmailAttempt").value(hasItem(DEFAULT_SEND_EMAIL_ATTEMPT)))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY.intValue())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedBy").value(hasItem(DEFAULT_UPDATED_BY.intValue())));
    }

    @Test
    @Transactional
    void getPaymentTransactionRetrying() throws Exception {
        // Initialize the database
        insertedPaymentTransactionRetrying = paymentTransactionRetryingRepository.saveAndFlush(paymentTransactionRetrying);

        // Get the paymentTransactionRetrying
        restPaymentTransactionRetryingMockMvc
            .perform(get(ENTITY_API_URL_ID, paymentTransactionRetrying.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(paymentTransactionRetrying.getId().intValue()))
            .andExpect(jsonPath("$.paymentTransactionRecurringId").value(DEFAULT_PAYMENT_TRANSACTION_RECURRING_ID.intValue()))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS))
            .andExpect(jsonPath("$.attemptRetry").value(DEFAULT_ATTEMPT_RETRY))
            .andExpect(jsonPath("$.datetimeRetry").value(DEFAULT_DATETIME_RETRY.toString()))
            .andExpect(jsonPath("$.datetimeNextRetry").value(DEFAULT_DATETIME_NEXT_RETRY.toString()))
            .andExpect(jsonPath("$.sendCallback").value(DEFAULT_SEND_CALLBACK))
            .andExpect(jsonPath("$.sendCallbackAttempt").value(DEFAULT_SEND_CALLBACK_ATTEMPT))
            .andExpect(jsonPath("$.sendEmail").value(DEFAULT_SEND_EMAIL))
            .andExpect(jsonPath("$.sendEmailAttempt").value(DEFAULT_SEND_EMAIL_ATTEMPT))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY.intValue()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()))
            .andExpect(jsonPath("$.updatedBy").value(DEFAULT_UPDATED_BY.intValue()));
    }

    @Test
    @Transactional
    void getNonExistingPaymentTransactionRetrying() throws Exception {
        // Get the paymentTransactionRetrying
        restPaymentTransactionRetryingMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    protected long getRepositoryCount() {
        return paymentTransactionRetryingRepository.count();
    }

    protected void assertIncrementedRepositoryCount(long countBefore) {
        assertThat(countBefore + 1).isEqualTo(getRepositoryCount());
    }

    protected void assertDecrementedRepositoryCount(long countBefore) {
        assertThat(countBefore - 1).isEqualTo(getRepositoryCount());
    }

    protected void assertSameRepositoryCount(long countBefore) {
        assertThat(countBefore).isEqualTo(getRepositoryCount());
    }

    protected PaymentTransactionRetrying getPersistedPaymentTransactionRetrying(PaymentTransactionRetrying paymentTransactionRetrying) {
        return paymentTransactionRetryingRepository.findById(paymentTransactionRetrying.getId()).orElseThrow();
    }

    protected void assertPersistedPaymentTransactionRetryingToMatchAllProperties(
        PaymentTransactionRetrying expectedPaymentTransactionRetrying
    ) {
        assertPaymentTransactionRetryingAllPropertiesEquals(
            expectedPaymentTransactionRetrying,
            getPersistedPaymentTransactionRetrying(expectedPaymentTransactionRetrying)
        );
    }

    protected void assertPersistedPaymentTransactionRetryingToMatchUpdatableProperties(
        PaymentTransactionRetrying expectedPaymentTransactionRetrying
    ) {
        assertPaymentTransactionRetryingAllUpdatablePropertiesEquals(
            expectedPaymentTransactionRetrying,
            getPersistedPaymentTransactionRetrying(expectedPaymentTransactionRetrying)
        );
    }
}
