package com.paysgift.orderservice.web.rest;

import static com.paysgift.orderservice.domain.CartDeleteAsserts.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paysgift.orderservice.IntegrationTest;
import com.paysgift.orderservice.domain.CartDelete;
import com.paysgift.orderservice.repository.CartDeleteRepository;
import com.paysgift.orderservice.service.mapper.CartDeleteMapper;
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
 * Integration tests for the {@link CartDeleteResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class CartDeleteResourceIT {

    private static final Long DEFAULT_TRANSACTION_DETAIL_ID = 1L;
    private static final Long UPDATED_TRANSACTION_DETAIL_ID = 2L;

    private static final Long DEFAULT_CUSTOMER_ID = 1L;
    private static final Long UPDATED_CUSTOMER_ID = 2L;

    private static final Long DEFAULT_COUNTRY_ID = 1L;
    private static final Long UPDATED_COUNTRY_ID = 2L;

    private static final Long DEFAULT_CLIENT_ID = 1L;
    private static final Long UPDATED_CLIENT_ID = 2L;

    private static final Long DEFAULT_CHANNEL_ID = 1L;
    private static final Long UPDATED_CHANNEL_ID = 2L;

    private static final Long DEFAULT_BRAND_ID = 1L;
    private static final Long UPDATED_BRAND_ID = 2L;

    private static final Long DEFAULT_PRODUCT_ID = 1L;
    private static final Long UPDATED_PRODUCT_ID = 2L;

    private static final Integer DEFAULT_QTY = 1;
    private static final Integer UPDATED_QTY = 2;

    private static final Instant DEFAULT_CREATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_CREATED_BY = 1L;
    private static final Long UPDATED_CREATED_BY = 2L;

    private static final Instant DEFAULT_UPDATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_UPDATED_BY = 1L;
    private static final Long UPDATED_UPDATED_BY = 2L;

    private static final String ENTITY_API_URL = "/api/cart-deletes";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    @Autowired
    private ObjectMapper om;

    @Autowired
    private CartDeleteRepository cartDeleteRepository;

    @Autowired
    private CartDeleteMapper cartDeleteMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restCartDeleteMockMvc;

    private CartDelete cartDelete;

    private CartDelete insertedCartDelete;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static CartDelete createEntity() {
        return new CartDelete()
            .transactionDetailId(DEFAULT_TRANSACTION_DETAIL_ID)
            .customerId(DEFAULT_CUSTOMER_ID)
            .countryId(DEFAULT_COUNTRY_ID)
            .clientId(DEFAULT_CLIENT_ID)
            .channelId(DEFAULT_CHANNEL_ID)
            .brandId(DEFAULT_BRAND_ID)
            .productId(DEFAULT_PRODUCT_ID)
            .qty(DEFAULT_QTY)
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
    public static CartDelete createUpdatedEntity() {
        return new CartDelete()
            .transactionDetailId(UPDATED_TRANSACTION_DETAIL_ID)
            .customerId(UPDATED_CUSTOMER_ID)
            .countryId(UPDATED_COUNTRY_ID)
            .clientId(UPDATED_CLIENT_ID)
            .channelId(UPDATED_CHANNEL_ID)
            .brandId(UPDATED_BRAND_ID)
            .productId(UPDATED_PRODUCT_ID)
            .qty(UPDATED_QTY)
            .createdAt(UPDATED_CREATED_AT)
            .createdBy(UPDATED_CREATED_BY)
            .updatedAt(UPDATED_UPDATED_AT)
            .updatedBy(UPDATED_UPDATED_BY);
    }

    @BeforeEach
    void initTest() {
        cartDelete = createEntity();
    }

    @AfterEach
    void cleanup() {
        if (insertedCartDelete != null) {
            cartDeleteRepository.delete(insertedCartDelete);
            insertedCartDelete = null;
        }
    }

    @Test
    @Transactional
    void getAllCartDeletes() throws Exception {
        // Initialize the database
        insertedCartDelete = cartDeleteRepository.saveAndFlush(cartDelete);

        // Get all the cartDeleteList
        restCartDeleteMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(cartDelete.getId().intValue())))
            .andExpect(jsonPath("$.[*].transactionDetailId").value(hasItem(DEFAULT_TRANSACTION_DETAIL_ID.intValue())))
            .andExpect(jsonPath("$.[*].customerId").value(hasItem(DEFAULT_CUSTOMER_ID.intValue())))
            .andExpect(jsonPath("$.[*].countryId").value(hasItem(DEFAULT_COUNTRY_ID.intValue())))
            .andExpect(jsonPath("$.[*].clientId").value(hasItem(DEFAULT_CLIENT_ID.intValue())))
            .andExpect(jsonPath("$.[*].channelId").value(hasItem(DEFAULT_CHANNEL_ID.intValue())))
            .andExpect(jsonPath("$.[*].brandId").value(hasItem(DEFAULT_BRAND_ID.intValue())))
            .andExpect(jsonPath("$.[*].productId").value(hasItem(DEFAULT_PRODUCT_ID.intValue())))
            .andExpect(jsonPath("$.[*].qty").value(hasItem(DEFAULT_QTY)))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY.intValue())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedBy").value(hasItem(DEFAULT_UPDATED_BY.intValue())));
    }

    @Test
    @Transactional
    void getCartDelete() throws Exception {
        // Initialize the database
        insertedCartDelete = cartDeleteRepository.saveAndFlush(cartDelete);

        // Get the cartDelete
        restCartDeleteMockMvc
            .perform(get(ENTITY_API_URL_ID, cartDelete.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(cartDelete.getId().intValue()))
            .andExpect(jsonPath("$.transactionDetailId").value(DEFAULT_TRANSACTION_DETAIL_ID.intValue()))
            .andExpect(jsonPath("$.customerId").value(DEFAULT_CUSTOMER_ID.intValue()))
            .andExpect(jsonPath("$.countryId").value(DEFAULT_COUNTRY_ID.intValue()))
            .andExpect(jsonPath("$.clientId").value(DEFAULT_CLIENT_ID.intValue()))
            .andExpect(jsonPath("$.channelId").value(DEFAULT_CHANNEL_ID.intValue()))
            .andExpect(jsonPath("$.brandId").value(DEFAULT_BRAND_ID.intValue()))
            .andExpect(jsonPath("$.productId").value(DEFAULT_PRODUCT_ID.intValue()))
            .andExpect(jsonPath("$.qty").value(DEFAULT_QTY))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY.intValue()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()))
            .andExpect(jsonPath("$.updatedBy").value(DEFAULT_UPDATED_BY.intValue()));
    }

    @Test
    @Transactional
    void getNonExistingCartDelete() throws Exception {
        // Get the cartDelete
        restCartDeleteMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    protected long getRepositoryCount() {
        return cartDeleteRepository.count();
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

    protected CartDelete getPersistedCartDelete(CartDelete cartDelete) {
        return cartDeleteRepository.findById(cartDelete.getId()).orElseThrow();
    }

    protected void assertPersistedCartDeleteToMatchAllProperties(CartDelete expectedCartDelete) {
        assertCartDeleteAllPropertiesEquals(expectedCartDelete, getPersistedCartDelete(expectedCartDelete));
    }

    protected void assertPersistedCartDeleteToMatchUpdatableProperties(CartDelete expectedCartDelete) {
        assertCartDeleteAllUpdatablePropertiesEquals(expectedCartDelete, getPersistedCartDelete(expectedCartDelete));
    }
}
