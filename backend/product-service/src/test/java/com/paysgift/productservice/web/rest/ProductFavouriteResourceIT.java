package com.paysgift.productservice.web.rest;

import static com.paysgift.productservice.domain.ProductFavouriteAsserts.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paysgift.productservice.IntegrationTest;
import com.paysgift.productservice.domain.ProductFavourite;
import com.paysgift.productservice.repository.ProductFavouriteRepository;
import com.paysgift.productservice.service.mapper.ProductFavouriteMapper;
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
 * Integration tests for the {@link ProductFavouriteResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class ProductFavouriteResourceIT {

    private static final Long DEFAULT_PRODUCT_ID = 1L;
    private static final Long UPDATED_PRODUCT_ID = 2L;

    private static final Long DEFAULT_CUSTOMER_ID = 1L;
    private static final Long UPDATED_CUSTOMER_ID = 2L;

    private static final Long DEFAULT_COUNTRY_ID = 1L;
    private static final Long UPDATED_COUNTRY_ID = 2L;

    private static final Long DEFAULT_CHANNEL_ID = 1L;
    private static final Long UPDATED_CHANNEL_ID = 2L;

    private static final Long DEFAULT_BRAND_ID = 1L;
    private static final Long UPDATED_BRAND_ID = 2L;

    private static final Instant DEFAULT_CREATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_CREATED_BY = 1L;
    private static final Long UPDATED_CREATED_BY = 2L;

    private static final Instant DEFAULT_UPDATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_UPDATED_BY = 1L;
    private static final Long UPDATED_UPDATED_BY = 2L;

    private static final String ENTITY_API_URL = "/api/product-favourites";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    @Autowired
    private ObjectMapper om;

    @Autowired
    private ProductFavouriteRepository productFavouriteRepository;

    @Autowired
    private ProductFavouriteMapper productFavouriteMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restProductFavouriteMockMvc;

    private ProductFavourite productFavourite;

    private ProductFavourite insertedProductFavourite;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ProductFavourite createEntity() {
        return new ProductFavourite()
            .productId(DEFAULT_PRODUCT_ID)
            .customerId(DEFAULT_CUSTOMER_ID)
            .countryId(DEFAULT_COUNTRY_ID)
            .channelId(DEFAULT_CHANNEL_ID)
            .brandId(DEFAULT_BRAND_ID)
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
    public static ProductFavourite createUpdatedEntity() {
        return new ProductFavourite()
            .productId(UPDATED_PRODUCT_ID)
            .customerId(UPDATED_CUSTOMER_ID)
            .countryId(UPDATED_COUNTRY_ID)
            .channelId(UPDATED_CHANNEL_ID)
            .brandId(UPDATED_BRAND_ID)
            .createdAt(UPDATED_CREATED_AT)
            .createdBy(UPDATED_CREATED_BY)
            .updatedAt(UPDATED_UPDATED_AT)
            .updatedBy(UPDATED_UPDATED_BY);
    }

    @BeforeEach
    public void initTest() {
        productFavourite = createEntity();
    }

    @AfterEach
    public void cleanup() {
        if (insertedProductFavourite != null) {
            productFavouriteRepository.delete(insertedProductFavourite);
            insertedProductFavourite = null;
        }
    }

    @Test
    @Transactional
    void getAllProductFavourites() throws Exception {
        // Initialize the database
        insertedProductFavourite = productFavouriteRepository.saveAndFlush(productFavourite);

        // Get all the productFavouriteList
        restProductFavouriteMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(productFavourite.getId().intValue())))
            .andExpect(jsonPath("$.[*].productId").value(hasItem(DEFAULT_PRODUCT_ID.intValue())))
            .andExpect(jsonPath("$.[*].customerId").value(hasItem(DEFAULT_CUSTOMER_ID.intValue())))
            .andExpect(jsonPath("$.[*].countryId").value(hasItem(DEFAULT_COUNTRY_ID.intValue())))
            .andExpect(jsonPath("$.[*].channelId").value(hasItem(DEFAULT_CHANNEL_ID.intValue())))
            .andExpect(jsonPath("$.[*].brandId").value(hasItem(DEFAULT_BRAND_ID.intValue())))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY.intValue())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedBy").value(hasItem(DEFAULT_UPDATED_BY.intValue())));
    }

    @Test
    @Transactional
    void getProductFavourite() throws Exception {
        // Initialize the database
        insertedProductFavourite = productFavouriteRepository.saveAndFlush(productFavourite);

        // Get the productFavourite
        restProductFavouriteMockMvc
            .perform(get(ENTITY_API_URL_ID, productFavourite.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(productFavourite.getId().intValue()))
            .andExpect(jsonPath("$.productId").value(DEFAULT_PRODUCT_ID.intValue()))
            .andExpect(jsonPath("$.customerId").value(DEFAULT_CUSTOMER_ID.intValue()))
            .andExpect(jsonPath("$.countryId").value(DEFAULT_COUNTRY_ID.intValue()))
            .andExpect(jsonPath("$.channelId").value(DEFAULT_CHANNEL_ID.intValue()))
            .andExpect(jsonPath("$.brandId").value(DEFAULT_BRAND_ID.intValue()))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY.intValue()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()))
            .andExpect(jsonPath("$.updatedBy").value(DEFAULT_UPDATED_BY.intValue()));
    }

    @Test
    @Transactional
    void getNonExistingProductFavourite() throws Exception {
        // Get the productFavourite
        restProductFavouriteMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    protected long getRepositoryCount() {
        return productFavouriteRepository.count();
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

    protected ProductFavourite getPersistedProductFavourite(ProductFavourite productFavourite) {
        return productFavouriteRepository.findById(productFavourite.getId()).orElseThrow();
    }

    protected void assertPersistedProductFavouriteToMatchAllProperties(ProductFavourite expectedProductFavourite) {
        assertProductFavouriteAllPropertiesEquals(expectedProductFavourite, getPersistedProductFavourite(expectedProductFavourite));
    }

    protected void assertPersistedProductFavouriteToMatchUpdatableProperties(ProductFavourite expectedProductFavourite) {
        assertProductFavouriteAllUpdatablePropertiesEquals(
            expectedProductFavourite,
            getPersistedProductFavourite(expectedProductFavourite)
        );
    }
}
