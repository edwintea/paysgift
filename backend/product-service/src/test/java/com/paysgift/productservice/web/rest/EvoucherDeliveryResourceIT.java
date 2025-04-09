package com.paysgift.productservice.web.rest;

import static com.paysgift.productservice.domain.EvoucherDeliveryAsserts.*;
import static com.paysgift.productservice.web.rest.TestUtil.sameNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paysgift.productservice.IntegrationTest;
import com.paysgift.productservice.domain.EvoucherDelivery;
import com.paysgift.productservice.repository.EvoucherDeliveryRepository;
import com.paysgift.productservice.service.mapper.EvoucherDeliveryMapper;
import jakarta.persistence.EntityManager;
import java.math.BigDecimal;
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
 * Integration tests for the {@link EvoucherDeliveryResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class EvoucherDeliveryResourceIT {

    private static final Long DEFAULT_COUNTRY_ID = 1L;
    private static final Long UPDATED_COUNTRY_ID = 2L;

    private static final String DEFAULT_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_TYPE = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_PRICE = new BigDecimal(1);
    private static final BigDecimal UPDATED_PRICE = new BigDecimal(2);

    private static final Instant DEFAULT_CREATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_CREATED_BY = 1L;
    private static final Long UPDATED_CREATED_BY = 2L;

    private static final Instant DEFAULT_UPDATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_UPDATED_BY = 1L;
    private static final Long UPDATED_UPDATED_BY = 2L;

    private static final String ENTITY_API_URL = "/api/evoucher-deliveries";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    @Autowired
    private ObjectMapper om;

    @Autowired
    private EvoucherDeliveryRepository evoucherDeliveryRepository;

    @Autowired
    private EvoucherDeliveryMapper evoucherDeliveryMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restEvoucherDeliveryMockMvc;

    private EvoucherDelivery evoucherDelivery;

    private EvoucherDelivery insertedEvoucherDelivery;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static EvoucherDelivery createEntity() {
        return new EvoucherDelivery()
            .countryId(DEFAULT_COUNTRY_ID)
            .type(DEFAULT_TYPE)
            .price(DEFAULT_PRICE)
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
    public static EvoucherDelivery createUpdatedEntity() {
        return new EvoucherDelivery()
            .countryId(UPDATED_COUNTRY_ID)
            .type(UPDATED_TYPE)
            .price(UPDATED_PRICE)
            .createdAt(UPDATED_CREATED_AT)
            .createdBy(UPDATED_CREATED_BY)
            .updatedAt(UPDATED_UPDATED_AT)
            .updatedBy(UPDATED_UPDATED_BY);
    }

    @BeforeEach
    public void initTest() {
        evoucherDelivery = createEntity();
    }

    @AfterEach
    public void cleanup() {
        if (insertedEvoucherDelivery != null) {
            evoucherDeliveryRepository.delete(insertedEvoucherDelivery);
            insertedEvoucherDelivery = null;
        }
    }

    @Test
    @Transactional
    void getAllEvoucherDeliveries() throws Exception {
        // Initialize the database
        insertedEvoucherDelivery = evoucherDeliveryRepository.saveAndFlush(evoucherDelivery);

        // Get all the evoucherDeliveryList
        restEvoucherDeliveryMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(evoucherDelivery.getId().intValue())))
            .andExpect(jsonPath("$.[*].countryId").value(hasItem(DEFAULT_COUNTRY_ID.intValue())))
            .andExpect(jsonPath("$.[*].type").value(hasItem(DEFAULT_TYPE)))
            .andExpect(jsonPath("$.[*].price").value(hasItem(sameNumber(DEFAULT_PRICE))))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY.intValue())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedBy").value(hasItem(DEFAULT_UPDATED_BY.intValue())));
    }

    @Test
    @Transactional
    void getEvoucherDelivery() throws Exception {
        // Initialize the database
        insertedEvoucherDelivery = evoucherDeliveryRepository.saveAndFlush(evoucherDelivery);

        // Get the evoucherDelivery
        restEvoucherDeliveryMockMvc
            .perform(get(ENTITY_API_URL_ID, evoucherDelivery.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(evoucherDelivery.getId().intValue()))
            .andExpect(jsonPath("$.countryId").value(DEFAULT_COUNTRY_ID.intValue()))
            .andExpect(jsonPath("$.type").value(DEFAULT_TYPE))
            .andExpect(jsonPath("$.price").value(sameNumber(DEFAULT_PRICE)))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY.intValue()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()))
            .andExpect(jsonPath("$.updatedBy").value(DEFAULT_UPDATED_BY.intValue()));
    }

    @Test
    @Transactional
    void getNonExistingEvoucherDelivery() throws Exception {
        // Get the evoucherDelivery
        restEvoucherDeliveryMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    protected long getRepositoryCount() {
        return evoucherDeliveryRepository.count();
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

    protected EvoucherDelivery getPersistedEvoucherDelivery(EvoucherDelivery evoucherDelivery) {
        return evoucherDeliveryRepository.findById(evoucherDelivery.getId()).orElseThrow();
    }

    protected void assertPersistedEvoucherDeliveryToMatchAllProperties(EvoucherDelivery expectedEvoucherDelivery) {
        assertEvoucherDeliveryAllPropertiesEquals(expectedEvoucherDelivery, getPersistedEvoucherDelivery(expectedEvoucherDelivery));
    }

    protected void assertPersistedEvoucherDeliveryToMatchUpdatableProperties(EvoucherDelivery expectedEvoucherDelivery) {
        assertEvoucherDeliveryAllUpdatablePropertiesEquals(
            expectedEvoucherDelivery,
            getPersistedEvoucherDelivery(expectedEvoucherDelivery)
        );
    }
}
