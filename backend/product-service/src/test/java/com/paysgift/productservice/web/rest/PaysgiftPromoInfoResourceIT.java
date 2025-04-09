package com.paysgift.productservice.web.rest;

import static com.paysgift.productservice.domain.PaysgiftPromoInfoAsserts.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paysgift.productservice.IntegrationTest;
import com.paysgift.productservice.domain.PaysgiftPromoInfo;
import com.paysgift.productservice.repository.PaysgiftPromoInfoRepository;
import com.paysgift.productservice.service.mapper.PaysgiftPromoInfoMapper;
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
 * Integration tests for the {@link PaysgiftPromoInfoResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class PaysgiftPromoInfoResourceIT {

    private static final Long DEFAULT_PAYSGIFT_PROMO_ID = 1L;
    private static final Long UPDATED_PAYSGIFT_PROMO_ID = 2L;

    private static final Long DEFAULT_VOUCHER_ID = 1L;
    private static final Long UPDATED_VOUCHER_ID = 2L;

    private static final Instant DEFAULT_CREATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_CREATED_BY = 1L;
    private static final Long UPDATED_CREATED_BY = 2L;

    private static final Instant DEFAULT_UPDATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_UPDATED_BY = 1L;
    private static final Long UPDATED_UPDATED_BY = 2L;

    private static final String ENTITY_API_URL = "/api/paysgift-promo-infos";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    @Autowired
    private ObjectMapper om;

    @Autowired
    private PaysgiftPromoInfoRepository paysgiftPromoInfoRepository;

    @Autowired
    private PaysgiftPromoInfoMapper paysgiftPromoInfoMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restPaysgiftPromoInfoMockMvc;

    private PaysgiftPromoInfo paysgiftPromoInfo;

    private PaysgiftPromoInfo insertedPaysgiftPromoInfo;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PaysgiftPromoInfo createEntity() {
        return new PaysgiftPromoInfo()
            .paysgiftPromoId(DEFAULT_PAYSGIFT_PROMO_ID)
            .voucherId(DEFAULT_VOUCHER_ID)
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
    public static PaysgiftPromoInfo createUpdatedEntity() {
        return new PaysgiftPromoInfo()
            .paysgiftPromoId(UPDATED_PAYSGIFT_PROMO_ID)
            .voucherId(UPDATED_VOUCHER_ID)
            .createdAt(UPDATED_CREATED_AT)
            .createdBy(UPDATED_CREATED_BY)
            .updatedAt(UPDATED_UPDATED_AT)
            .updatedBy(UPDATED_UPDATED_BY);
    }

    @BeforeEach
    public void initTest() {
        paysgiftPromoInfo = createEntity();
    }

    @AfterEach
    public void cleanup() {
        if (insertedPaysgiftPromoInfo != null) {
            paysgiftPromoInfoRepository.delete(insertedPaysgiftPromoInfo);
            insertedPaysgiftPromoInfo = null;
        }
    }

    @Test
    @Transactional
    void getAllPaysgiftPromoInfos() throws Exception {
        // Initialize the database
        insertedPaysgiftPromoInfo = paysgiftPromoInfoRepository.saveAndFlush(paysgiftPromoInfo);

        // Get all the paysgiftPromoInfoList
        restPaysgiftPromoInfoMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(paysgiftPromoInfo.getId().intValue())))
            .andExpect(jsonPath("$.[*].paysgiftPromoId").value(hasItem(DEFAULT_PAYSGIFT_PROMO_ID.intValue())))
            .andExpect(jsonPath("$.[*].voucherId").value(hasItem(DEFAULT_VOUCHER_ID.intValue())))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY.intValue())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedBy").value(hasItem(DEFAULT_UPDATED_BY.intValue())));
    }

    @Test
    @Transactional
    void getPaysgiftPromoInfo() throws Exception {
        // Initialize the database
        insertedPaysgiftPromoInfo = paysgiftPromoInfoRepository.saveAndFlush(paysgiftPromoInfo);

        // Get the paysgiftPromoInfo
        restPaysgiftPromoInfoMockMvc
            .perform(get(ENTITY_API_URL_ID, paysgiftPromoInfo.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(paysgiftPromoInfo.getId().intValue()))
            .andExpect(jsonPath("$.paysgiftPromoId").value(DEFAULT_PAYSGIFT_PROMO_ID.intValue()))
            .andExpect(jsonPath("$.voucherId").value(DEFAULT_VOUCHER_ID.intValue()))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY.intValue()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()))
            .andExpect(jsonPath("$.updatedBy").value(DEFAULT_UPDATED_BY.intValue()));
    }

    @Test
    @Transactional
    void getNonExistingPaysgiftPromoInfo() throws Exception {
        // Get the paysgiftPromoInfo
        restPaysgiftPromoInfoMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    protected long getRepositoryCount() {
        return paysgiftPromoInfoRepository.count();
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

    protected PaysgiftPromoInfo getPersistedPaysgiftPromoInfo(PaysgiftPromoInfo paysgiftPromoInfo) {
        return paysgiftPromoInfoRepository.findById(paysgiftPromoInfo.getId()).orElseThrow();
    }

    protected void assertPersistedPaysgiftPromoInfoToMatchAllProperties(PaysgiftPromoInfo expectedPaysgiftPromoInfo) {
        assertPaysgiftPromoInfoAllPropertiesEquals(expectedPaysgiftPromoInfo, getPersistedPaysgiftPromoInfo(expectedPaysgiftPromoInfo));
    }

    protected void assertPersistedPaysgiftPromoInfoToMatchUpdatableProperties(PaysgiftPromoInfo expectedPaysgiftPromoInfo) {
        assertPaysgiftPromoInfoAllUpdatablePropertiesEquals(
            expectedPaysgiftPromoInfo,
            getPersistedPaysgiftPromoInfo(expectedPaysgiftPromoInfo)
        );
    }
}
