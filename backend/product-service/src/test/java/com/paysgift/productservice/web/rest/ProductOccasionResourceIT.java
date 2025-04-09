package com.paysgift.productservice.web.rest;

import static com.paysgift.productservice.domain.ProductOccasionAsserts.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paysgift.productservice.IntegrationTest;
import com.paysgift.productservice.domain.ProductOccasion;
import com.paysgift.productservice.repository.ProductOccasionRepository;
import com.paysgift.productservice.service.mapper.ProductOccasionMapper;
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
 * Integration tests for the {@link ProductOccasionResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class ProductOccasionResourceIT {

    private static final Long DEFAULT_PRODUCT_ID = 1L;
    private static final Long UPDATED_PRODUCT_ID = 2L;

    private static final Long DEFAULT_OCCASION_ID = 1L;
    private static final Long UPDATED_OCCASION_ID = 2L;

    private static final Instant DEFAULT_CREATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_CREATED_BY = 1L;
    private static final Long UPDATED_CREATED_BY = 2L;

    private static final Instant DEFAULT_UPDATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_UPDATED_BY = 1L;
    private static final Long UPDATED_UPDATED_BY = 2L;

    private static final String ENTITY_API_URL = "/api/product-occasions";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    @Autowired
    private ObjectMapper om;

    @Autowired
    private ProductOccasionRepository productOccasionRepository;

    @Autowired
    private ProductOccasionMapper productOccasionMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restProductOccasionMockMvc;

    private ProductOccasion productOccasion;

    private ProductOccasion insertedProductOccasion;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ProductOccasion createEntity() {
        return new ProductOccasion()
            .productId(DEFAULT_PRODUCT_ID)
            .occasionId(DEFAULT_OCCASION_ID)
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
    public static ProductOccasion createUpdatedEntity() {
        return new ProductOccasion()
            .productId(UPDATED_PRODUCT_ID)
            .occasionId(UPDATED_OCCASION_ID)
            .createdAt(UPDATED_CREATED_AT)
            .createdBy(UPDATED_CREATED_BY)
            .updatedAt(UPDATED_UPDATED_AT)
            .updatedBy(UPDATED_UPDATED_BY);
    }

    @BeforeEach
    public void initTest() {
        productOccasion = createEntity();
    }

    @AfterEach
    public void cleanup() {
        if (insertedProductOccasion != null) {
            productOccasionRepository.delete(insertedProductOccasion);
            insertedProductOccasion = null;
        }
    }

    @Test
    @Transactional
    void getAllProductOccasions() throws Exception {
        // Initialize the database
        insertedProductOccasion = productOccasionRepository.saveAndFlush(productOccasion);

        // Get all the productOccasionList
        restProductOccasionMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(productOccasion.getId().intValue())))
            .andExpect(jsonPath("$.[*].productId").value(hasItem(DEFAULT_PRODUCT_ID.intValue())))
            .andExpect(jsonPath("$.[*].occasionId").value(hasItem(DEFAULT_OCCASION_ID.intValue())))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY.intValue())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedBy").value(hasItem(DEFAULT_UPDATED_BY.intValue())));
    }

    @Test
    @Transactional
    void getProductOccasion() throws Exception {
        // Initialize the database
        insertedProductOccasion = productOccasionRepository.saveAndFlush(productOccasion);

        // Get the productOccasion
        restProductOccasionMockMvc
            .perform(get(ENTITY_API_URL_ID, productOccasion.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(productOccasion.getId().intValue()))
            .andExpect(jsonPath("$.productId").value(DEFAULT_PRODUCT_ID.intValue()))
            .andExpect(jsonPath("$.occasionId").value(DEFAULT_OCCASION_ID.intValue()))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY.intValue()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()))
            .andExpect(jsonPath("$.updatedBy").value(DEFAULT_UPDATED_BY.intValue()));
    }

    @Test
    @Transactional
    void getNonExistingProductOccasion() throws Exception {
        // Get the productOccasion
        restProductOccasionMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    protected long getRepositoryCount() {
        return productOccasionRepository.count();
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

    protected ProductOccasion getPersistedProductOccasion(ProductOccasion productOccasion) {
        return productOccasionRepository.findById(productOccasion.getId()).orElseThrow();
    }

    protected void assertPersistedProductOccasionToMatchAllProperties(ProductOccasion expectedProductOccasion) {
        assertProductOccasionAllPropertiesEquals(expectedProductOccasion, getPersistedProductOccasion(expectedProductOccasion));
    }

    protected void assertPersistedProductOccasionToMatchUpdatableProperties(ProductOccasion expectedProductOccasion) {
        assertProductOccasionAllUpdatablePropertiesEquals(expectedProductOccasion, getPersistedProductOccasion(expectedProductOccasion));
    }
}
