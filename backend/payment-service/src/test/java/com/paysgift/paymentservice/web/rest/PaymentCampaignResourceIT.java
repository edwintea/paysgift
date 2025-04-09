package com.paysgift.paymentservice.web.rest;

import static com.paysgift.paymentservice.domain.PaymentCampaignAsserts.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paysgift.paymentservice.IntegrationTest;
import com.paysgift.paymentservice.domain.PaymentCampaign;
import com.paysgift.paymentservice.repository.PaymentCampaignRepository;
import com.paysgift.paymentservice.service.mapper.PaymentCampaignMapper;
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
 * Integration tests for the {@link PaymentCampaignResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class PaymentCampaignResourceIT {

    private static final Long DEFAULT_CAMPAIGN_ID = 1L;
    private static final Long UPDATED_CAMPAIGN_ID = 2L;

    private static final Integer DEFAULT_FREE_MONTH = 1;
    private static final Integer UPDATED_FREE_MONTH = 2;

    private static final Instant DEFAULT_VALID_FROM = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_VALID_FROM = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_VALID_TO = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_VALID_TO = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_CREATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_CREATED_BY = 1L;
    private static final Long UPDATED_CREATED_BY = 2L;

    private static final Long DEFAULT_UPDATED_AT = 1L;
    private static final Long UPDATED_UPDATED_AT = 2L;

    private static final Long DEFAULT_UPDATED_BY = 1L;
    private static final Long UPDATED_UPDATED_BY = 2L;

    private static final String ENTITY_API_URL = "/api/payment-campaigns";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    @Autowired
    private ObjectMapper om;

    @Autowired
    private PaymentCampaignRepository paymentCampaignRepository;

    @Autowired
    private PaymentCampaignMapper paymentCampaignMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restPaymentCampaignMockMvc;

    private PaymentCampaign paymentCampaign;

    private PaymentCampaign insertedPaymentCampaign;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PaymentCampaign createEntity() {
        return new PaymentCampaign()
            .campaignId(DEFAULT_CAMPAIGN_ID)
            .freeMonth(DEFAULT_FREE_MONTH)
            .validFrom(DEFAULT_VALID_FROM)
            .validTo(DEFAULT_VALID_TO)
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
    public static PaymentCampaign createUpdatedEntity() {
        return new PaymentCampaign()
            .campaignId(UPDATED_CAMPAIGN_ID)
            .freeMonth(UPDATED_FREE_MONTH)
            .validFrom(UPDATED_VALID_FROM)
            .validTo(UPDATED_VALID_TO)
            .createdAt(UPDATED_CREATED_AT)
            .createdBy(UPDATED_CREATED_BY)
            .updatedAt(UPDATED_UPDATED_AT)
            .updatedBy(UPDATED_UPDATED_BY);
    }

    @BeforeEach
    void initTest() {
        paymentCampaign = createEntity();
    }

    @AfterEach
    void cleanup() {
        if (insertedPaymentCampaign != null) {
            paymentCampaignRepository.delete(insertedPaymentCampaign);
            insertedPaymentCampaign = null;
        }
    }

    @Test
    @Transactional
    void getAllPaymentCampaigns() throws Exception {
        // Initialize the database
        insertedPaymentCampaign = paymentCampaignRepository.saveAndFlush(paymentCampaign);

        // Get all the paymentCampaignList
        restPaymentCampaignMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(paymentCampaign.getId().intValue())))
            .andExpect(jsonPath("$.[*].campaignId").value(hasItem(DEFAULT_CAMPAIGN_ID.intValue())))
            .andExpect(jsonPath("$.[*].freeMonth").value(hasItem(DEFAULT_FREE_MONTH)))
            .andExpect(jsonPath("$.[*].validFrom").value(hasItem(DEFAULT_VALID_FROM.toString())))
            .andExpect(jsonPath("$.[*].validTo").value(hasItem(DEFAULT_VALID_TO.toString())))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY.intValue())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.intValue())))
            .andExpect(jsonPath("$.[*].updatedBy").value(hasItem(DEFAULT_UPDATED_BY.intValue())));
    }

    @Test
    @Transactional
    void getPaymentCampaign() throws Exception {
        // Initialize the database
        insertedPaymentCampaign = paymentCampaignRepository.saveAndFlush(paymentCampaign);

        // Get the paymentCampaign
        restPaymentCampaignMockMvc
            .perform(get(ENTITY_API_URL_ID, paymentCampaign.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(paymentCampaign.getId().intValue()))
            .andExpect(jsonPath("$.campaignId").value(DEFAULT_CAMPAIGN_ID.intValue()))
            .andExpect(jsonPath("$.freeMonth").value(DEFAULT_FREE_MONTH))
            .andExpect(jsonPath("$.validFrom").value(DEFAULT_VALID_FROM.toString()))
            .andExpect(jsonPath("$.validTo").value(DEFAULT_VALID_TO.toString()))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY.intValue()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.intValue()))
            .andExpect(jsonPath("$.updatedBy").value(DEFAULT_UPDATED_BY.intValue()));
    }

    @Test
    @Transactional
    void getNonExistingPaymentCampaign() throws Exception {
        // Get the paymentCampaign
        restPaymentCampaignMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    protected long getRepositoryCount() {
        return paymentCampaignRepository.count();
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

    protected PaymentCampaign getPersistedPaymentCampaign(PaymentCampaign paymentCampaign) {
        return paymentCampaignRepository.findById(paymentCampaign.getId()).orElseThrow();
    }

    protected void assertPersistedPaymentCampaignToMatchAllProperties(PaymentCampaign expectedPaymentCampaign) {
        assertPaymentCampaignAllPropertiesEquals(expectedPaymentCampaign, getPersistedPaymentCampaign(expectedPaymentCampaign));
    }

    protected void assertPersistedPaymentCampaignToMatchUpdatableProperties(PaymentCampaign expectedPaymentCampaign) {
        assertPaymentCampaignAllUpdatablePropertiesEquals(expectedPaymentCampaign, getPersistedPaymentCampaign(expectedPaymentCampaign));
    }
}
