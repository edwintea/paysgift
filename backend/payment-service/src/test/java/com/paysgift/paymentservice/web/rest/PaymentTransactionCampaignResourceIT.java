package com.paysgift.paymentservice.web.rest;

import static com.paysgift.paymentservice.domain.PaymentTransactionCampaignAsserts.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paysgift.paymentservice.IntegrationTest;
import com.paysgift.paymentservice.domain.PaymentTransactionCampaign;
import com.paysgift.paymentservice.repository.PaymentTransactionCampaignRepository;
import com.paysgift.paymentservice.service.mapper.PaymentTransactionCampaignMapper;
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
 * Integration tests for the {@link PaymentTransactionCampaignResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class PaymentTransactionCampaignResourceIT {

    private static final Long DEFAULT_PAYMENT_TRANSACTION_ID = 1L;
    private static final Long UPDATED_PAYMENT_TRANSACTION_ID = 2L;

    private static final Integer DEFAULT_CYCLE = 1;
    private static final Integer UPDATED_CYCLE = 2;

    private static final Instant DEFAULT_HIT_DATETIME = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_HIT_DATETIME = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Boolean DEFAULT_HIT_STATUS = false;
    private static final Boolean UPDATED_HIT_STATUS = true;

    private static final Instant DEFAULT_CREATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_CREATED_BY = 1L;
    private static final Long UPDATED_CREATED_BY = 2L;

    private static final Instant DEFAULT_UPDATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_UPDATED_BY = 1L;
    private static final Long UPDATED_UPDATED_BY = 2L;

    private static final String ENTITY_API_URL = "/api/payment-transaction-campaigns";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    @Autowired
    private ObjectMapper om;

    @Autowired
    private PaymentTransactionCampaignRepository paymentTransactionCampaignRepository;

    @Autowired
    private PaymentTransactionCampaignMapper paymentTransactionCampaignMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restPaymentTransactionCampaignMockMvc;

    private PaymentTransactionCampaign paymentTransactionCampaign;

    private PaymentTransactionCampaign insertedPaymentTransactionCampaign;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PaymentTransactionCampaign createEntity() {
        return new PaymentTransactionCampaign()
            .paymentTransactionId(DEFAULT_PAYMENT_TRANSACTION_ID)
            .cycle(DEFAULT_CYCLE)
            .hitDatetime(DEFAULT_HIT_DATETIME)
            .hitStatus(DEFAULT_HIT_STATUS)
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
    public static PaymentTransactionCampaign createUpdatedEntity() {
        return new PaymentTransactionCampaign()
            .paymentTransactionId(UPDATED_PAYMENT_TRANSACTION_ID)
            .cycle(UPDATED_CYCLE)
            .hitDatetime(UPDATED_HIT_DATETIME)
            .hitStatus(UPDATED_HIT_STATUS)
            .createdAt(UPDATED_CREATED_AT)
            .createdBy(UPDATED_CREATED_BY)
            .updatedAt(UPDATED_UPDATED_AT)
            .updatedBy(UPDATED_UPDATED_BY);
    }

    @BeforeEach
    void initTest() {
        paymentTransactionCampaign = createEntity();
    }

    @AfterEach
    void cleanup() {
        if (insertedPaymentTransactionCampaign != null) {
            paymentTransactionCampaignRepository.delete(insertedPaymentTransactionCampaign);
            insertedPaymentTransactionCampaign = null;
        }
    }

    @Test
    @Transactional
    void getAllPaymentTransactionCampaigns() throws Exception {
        // Initialize the database
        insertedPaymentTransactionCampaign = paymentTransactionCampaignRepository.saveAndFlush(paymentTransactionCampaign);

        // Get all the paymentTransactionCampaignList
        restPaymentTransactionCampaignMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(paymentTransactionCampaign.getId().intValue())))
            .andExpect(jsonPath("$.[*].paymentTransactionId").value(hasItem(DEFAULT_PAYMENT_TRANSACTION_ID.intValue())))
            .andExpect(jsonPath("$.[*].cycle").value(hasItem(DEFAULT_CYCLE)))
            .andExpect(jsonPath("$.[*].hitDatetime").value(hasItem(DEFAULT_HIT_DATETIME.toString())))
            .andExpect(jsonPath("$.[*].hitStatus").value(hasItem(DEFAULT_HIT_STATUS)))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY.intValue())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedBy").value(hasItem(DEFAULT_UPDATED_BY.intValue())));
    }

    @Test
    @Transactional
    void getPaymentTransactionCampaign() throws Exception {
        // Initialize the database
        insertedPaymentTransactionCampaign = paymentTransactionCampaignRepository.saveAndFlush(paymentTransactionCampaign);

        // Get the paymentTransactionCampaign
        restPaymentTransactionCampaignMockMvc
            .perform(get(ENTITY_API_URL_ID, paymentTransactionCampaign.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(paymentTransactionCampaign.getId().intValue()))
            .andExpect(jsonPath("$.paymentTransactionId").value(DEFAULT_PAYMENT_TRANSACTION_ID.intValue()))
            .andExpect(jsonPath("$.cycle").value(DEFAULT_CYCLE))
            .andExpect(jsonPath("$.hitDatetime").value(DEFAULT_HIT_DATETIME.toString()))
            .andExpect(jsonPath("$.hitStatus").value(DEFAULT_HIT_STATUS))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY.intValue()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()))
            .andExpect(jsonPath("$.updatedBy").value(DEFAULT_UPDATED_BY.intValue()));
    }

    @Test
    @Transactional
    void getNonExistingPaymentTransactionCampaign() throws Exception {
        // Get the paymentTransactionCampaign
        restPaymentTransactionCampaignMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    protected long getRepositoryCount() {
        return paymentTransactionCampaignRepository.count();
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

    protected PaymentTransactionCampaign getPersistedPaymentTransactionCampaign(PaymentTransactionCampaign paymentTransactionCampaign) {
        return paymentTransactionCampaignRepository.findById(paymentTransactionCampaign.getId()).orElseThrow();
    }

    protected void assertPersistedPaymentTransactionCampaignToMatchAllProperties(
        PaymentTransactionCampaign expectedPaymentTransactionCampaign
    ) {
        assertPaymentTransactionCampaignAllPropertiesEquals(
            expectedPaymentTransactionCampaign,
            getPersistedPaymentTransactionCampaign(expectedPaymentTransactionCampaign)
        );
    }

    protected void assertPersistedPaymentTransactionCampaignToMatchUpdatableProperties(
        PaymentTransactionCampaign expectedPaymentTransactionCampaign
    ) {
        assertPaymentTransactionCampaignAllUpdatablePropertiesEquals(
            expectedPaymentTransactionCampaign,
            getPersistedPaymentTransactionCampaign(expectedPaymentTransactionCampaign)
        );
    }
}
