package com.paysgift.paymentservice.web.rest;

import static com.paysgift.paymentservice.domain.PaymentCustomerSamsungAsserts.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paysgift.paymentservice.IntegrationTest;
import com.paysgift.paymentservice.domain.PaymentCustomerSamsung;
import com.paysgift.paymentservice.repository.PaymentCustomerSamsungRepository;
import com.paysgift.paymentservice.service.mapper.PaymentCustomerSamsungMapper;
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
 * Integration tests for the {@link PaymentCustomerSamsungResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class PaymentCustomerSamsungResourceIT {

    private static final String DEFAULT_SGI_UID = "AAAAAAAAAA";
    private static final String UPDATED_SGI_UID = "BBBBBBBBBB";

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL = "BBBBBBBBBB";

    private static final String DEFAULT_MOBILE_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_MOBILE_NUMBER = "BBBBBBBBBB";

    private static final Instant DEFAULT_CREATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_CREATED_BY = 1L;
    private static final Long UPDATED_CREATED_BY = 2L;

    private static final Instant DEFAULT_UPDATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_UPDATED_BY = 1L;
    private static final Long UPDATED_UPDATED_BY = 2L;

    private static final String ENTITY_API_URL = "/api/payment-customer-samsungs";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    @Autowired
    private ObjectMapper om;

    @Autowired
    private PaymentCustomerSamsungRepository paymentCustomerSamsungRepository;

    @Autowired
    private PaymentCustomerSamsungMapper paymentCustomerSamsungMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restPaymentCustomerSamsungMockMvc;

    private PaymentCustomerSamsung paymentCustomerSamsung;

    private PaymentCustomerSamsung insertedPaymentCustomerSamsung;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PaymentCustomerSamsung createEntity() {
        return new PaymentCustomerSamsung()
            .sgiUid(DEFAULT_SGI_UID)
            .name(DEFAULT_NAME)
            .email(DEFAULT_EMAIL)
            .mobileNumber(DEFAULT_MOBILE_NUMBER)
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
    public static PaymentCustomerSamsung createUpdatedEntity() {
        return new PaymentCustomerSamsung()
            .sgiUid(UPDATED_SGI_UID)
            .name(UPDATED_NAME)
            .email(UPDATED_EMAIL)
            .mobileNumber(UPDATED_MOBILE_NUMBER)
            .createdAt(UPDATED_CREATED_AT)
            .createdBy(UPDATED_CREATED_BY)
            .updatedAt(UPDATED_UPDATED_AT)
            .updatedBy(UPDATED_UPDATED_BY);
    }

    @BeforeEach
    void initTest() {
        paymentCustomerSamsung = createEntity();
    }

    @AfterEach
    void cleanup() {
        if (insertedPaymentCustomerSamsung != null) {
            paymentCustomerSamsungRepository.delete(insertedPaymentCustomerSamsung);
            insertedPaymentCustomerSamsung = null;
        }
    }

    @Test
    @Transactional
    void getAllPaymentCustomerSamsungs() throws Exception {
        // Initialize the database
        insertedPaymentCustomerSamsung = paymentCustomerSamsungRepository.saveAndFlush(paymentCustomerSamsung);

        // Get all the paymentCustomerSamsungList
        restPaymentCustomerSamsungMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(paymentCustomerSamsung.getId().intValue())))
            .andExpect(jsonPath("$.[*].sgiUid").value(hasItem(DEFAULT_SGI_UID)))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].email").value(hasItem(DEFAULT_EMAIL)))
            .andExpect(jsonPath("$.[*].mobileNumber").value(hasItem(DEFAULT_MOBILE_NUMBER)))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY.intValue())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedBy").value(hasItem(DEFAULT_UPDATED_BY.intValue())));
    }

    @Test
    @Transactional
    void getPaymentCustomerSamsung() throws Exception {
        // Initialize the database
        insertedPaymentCustomerSamsung = paymentCustomerSamsungRepository.saveAndFlush(paymentCustomerSamsung);

        // Get the paymentCustomerSamsung
        restPaymentCustomerSamsungMockMvc
            .perform(get(ENTITY_API_URL_ID, paymentCustomerSamsung.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(paymentCustomerSamsung.getId().intValue()))
            .andExpect(jsonPath("$.sgiUid").value(DEFAULT_SGI_UID))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.email").value(DEFAULT_EMAIL))
            .andExpect(jsonPath("$.mobileNumber").value(DEFAULT_MOBILE_NUMBER))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY.intValue()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()))
            .andExpect(jsonPath("$.updatedBy").value(DEFAULT_UPDATED_BY.intValue()));
    }

    @Test
    @Transactional
    void getNonExistingPaymentCustomerSamsung() throws Exception {
        // Get the paymentCustomerSamsung
        restPaymentCustomerSamsungMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    protected long getRepositoryCount() {
        return paymentCustomerSamsungRepository.count();
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

    protected PaymentCustomerSamsung getPersistedPaymentCustomerSamsung(PaymentCustomerSamsung paymentCustomerSamsung) {
        return paymentCustomerSamsungRepository.findById(paymentCustomerSamsung.getId()).orElseThrow();
    }

    protected void assertPersistedPaymentCustomerSamsungToMatchAllProperties(PaymentCustomerSamsung expectedPaymentCustomerSamsung) {
        assertPaymentCustomerSamsungAllPropertiesEquals(
            expectedPaymentCustomerSamsung,
            getPersistedPaymentCustomerSamsung(expectedPaymentCustomerSamsung)
        );
    }

    protected void assertPersistedPaymentCustomerSamsungToMatchUpdatableProperties(PaymentCustomerSamsung expectedPaymentCustomerSamsung) {
        assertPaymentCustomerSamsungAllUpdatablePropertiesEquals(
            expectedPaymentCustomerSamsung,
            getPersistedPaymentCustomerSamsung(expectedPaymentCustomerSamsung)
        );
    }
}
