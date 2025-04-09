package com.paysgift.productservice.web.rest;

import static com.paysgift.productservice.domain.PaysgiftPromoAsserts.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paysgift.productservice.IntegrationTest;
import com.paysgift.productservice.domain.PaysgiftPromo;
import com.paysgift.productservice.repository.PaysgiftPromoRepository;
import com.paysgift.productservice.service.mapper.PaysgiftPromoMapper;
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
 * Integration tests for the {@link PaysgiftPromoResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class PaysgiftPromoResourceIT {

    private static final Boolean DEFAULT_IS_ACTIVE = false;
    private static final Boolean UPDATED_IS_ACTIVE = true;

    private static final String DEFAULT_BANNER_IMAGE = "AAAAAAAAAA";
    private static final String UPDATED_BANNER_IMAGE = "BBBBBBBBBB";

    private static final String DEFAULT_BANNER_URL = "AAAAAAAAAA";
    private static final String UPDATED_BANNER_URL = "BBBBBBBBBB";

    private static final Instant DEFAULT_CREATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_CREATED_BY = 1L;
    private static final Long UPDATED_CREATED_BY = 2L;

    private static final Instant DEFAULT_UPDATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_UPDATED_BY = 1L;
    private static final Long UPDATED_UPDATED_BY = 2L;

    private static final String ENTITY_API_URL = "/api/paysgift-promos";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    @Autowired
    private ObjectMapper om;

    @Autowired
    private PaysgiftPromoRepository paysgiftPromoRepository;

    @Autowired
    private PaysgiftPromoMapper paysgiftPromoMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restPaysgiftPromoMockMvc;

    private PaysgiftPromo paysgiftPromo;

    private PaysgiftPromo insertedPaysgiftPromo;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PaysgiftPromo createEntity() {
        return new PaysgiftPromo()
            .isActive(DEFAULT_IS_ACTIVE)
            .bannerImage(DEFAULT_BANNER_IMAGE)
            .bannerUrl(DEFAULT_BANNER_URL)
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
    public static PaysgiftPromo createUpdatedEntity() {
        return new PaysgiftPromo()
            .isActive(UPDATED_IS_ACTIVE)
            .bannerImage(UPDATED_BANNER_IMAGE)
            .bannerUrl(UPDATED_BANNER_URL)
            .createdAt(UPDATED_CREATED_AT)
            .createdBy(UPDATED_CREATED_BY)
            .updatedAt(UPDATED_UPDATED_AT)
            .updatedBy(UPDATED_UPDATED_BY);
    }

    @BeforeEach
    public void initTest() {
        paysgiftPromo = createEntity();
    }

    @AfterEach
    public void cleanup() {
        if (insertedPaysgiftPromo != null) {
            paysgiftPromoRepository.delete(insertedPaysgiftPromo);
            insertedPaysgiftPromo = null;
        }
    }

    @Test
    @Transactional
    void getAllPaysgiftPromos() throws Exception {
        // Initialize the database
        insertedPaysgiftPromo = paysgiftPromoRepository.saveAndFlush(paysgiftPromo);

        // Get all the paysgiftPromoList
        restPaysgiftPromoMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(paysgiftPromo.getId().intValue())))
            .andExpect(jsonPath("$.[*].isActive").value(hasItem(DEFAULT_IS_ACTIVE)))
            .andExpect(jsonPath("$.[*].bannerImage").value(hasItem(DEFAULT_BANNER_IMAGE)))
            .andExpect(jsonPath("$.[*].bannerUrl").value(hasItem(DEFAULT_BANNER_URL)))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY.intValue())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedBy").value(hasItem(DEFAULT_UPDATED_BY.intValue())));
    }

    @Test
    @Transactional
    void getPaysgiftPromo() throws Exception {
        // Initialize the database
        insertedPaysgiftPromo = paysgiftPromoRepository.saveAndFlush(paysgiftPromo);

        // Get the paysgiftPromo
        restPaysgiftPromoMockMvc
            .perform(get(ENTITY_API_URL_ID, paysgiftPromo.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(paysgiftPromo.getId().intValue()))
            .andExpect(jsonPath("$.isActive").value(DEFAULT_IS_ACTIVE))
            .andExpect(jsonPath("$.bannerImage").value(DEFAULT_BANNER_IMAGE))
            .andExpect(jsonPath("$.bannerUrl").value(DEFAULT_BANNER_URL))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY.intValue()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()))
            .andExpect(jsonPath("$.updatedBy").value(DEFAULT_UPDATED_BY.intValue()));
    }

    @Test
    @Transactional
    void getNonExistingPaysgiftPromo() throws Exception {
        // Get the paysgiftPromo
        restPaysgiftPromoMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    protected long getRepositoryCount() {
        return paysgiftPromoRepository.count();
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

    protected PaysgiftPromo getPersistedPaysgiftPromo(PaysgiftPromo paysgiftPromo) {
        return paysgiftPromoRepository.findById(paysgiftPromo.getId()).orElseThrow();
    }

    protected void assertPersistedPaysgiftPromoToMatchAllProperties(PaysgiftPromo expectedPaysgiftPromo) {
        assertPaysgiftPromoAllPropertiesEquals(expectedPaysgiftPromo, getPersistedPaysgiftPromo(expectedPaysgiftPromo));
    }

    protected void assertPersistedPaysgiftPromoToMatchUpdatableProperties(PaysgiftPromo expectedPaysgiftPromo) {
        assertPaysgiftPromoAllUpdatablePropertiesEquals(expectedPaysgiftPromo, getPersistedPaysgiftPromo(expectedPaysgiftPromo));
    }
}
