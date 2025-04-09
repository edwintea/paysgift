package com.paysgift.transaction.web.rest;

import static com.paysgift.transaction.domain.TransactionDownloadAsserts.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paysgift.transaction.IntegrationTest;
import com.paysgift.transaction.domain.TransactionDownload;
import com.paysgift.transaction.repository.TransactionDownloadRepository;
import com.paysgift.transaction.service.mapper.TransactionDownloadMapper;
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
 * Integration tests for the {@link TransactionDownloadResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class TransactionDownloadResourceIT {

    private static final Long DEFAULT_TRANSACTION_ID = 1L;
    private static final Long UPDATED_TRANSACTION_ID = 2L;

    private static final Long DEFAULT_CUSTOMER_ID = 1L;
    private static final Long UPDATED_CUSTOMER_ID = 2L;

    private static final String DEFAULT_REASON = "AAAAAAAAAA";
    private static final String UPDATED_REASON = "BBBBBBBBBB";

    private static final Instant DEFAULT_CREATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_CREATED_BY = 1L;
    private static final Long UPDATED_CREATED_BY = 2L;

    private static final Instant DEFAULT_UPDATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_UPDATED_BY = 1L;
    private static final Long UPDATED_UPDATED_BY = 2L;

    private static final String ENTITY_API_URL = "/api/transaction-downloads";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    @Autowired
    private ObjectMapper om;

    @Autowired
    private TransactionDownloadRepository transactionDownloadRepository;

    @Autowired
    private TransactionDownloadMapper transactionDownloadMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restTransactionDownloadMockMvc;

    private TransactionDownload transactionDownload;

    private TransactionDownload insertedTransactionDownload;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static TransactionDownload createEntity() {
        return new TransactionDownload()
            .transactionId(DEFAULT_TRANSACTION_ID)
            .customerId(DEFAULT_CUSTOMER_ID)
            .reason(DEFAULT_REASON)
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
    public static TransactionDownload createUpdatedEntity() {
        return new TransactionDownload()
            .transactionId(UPDATED_TRANSACTION_ID)
            .customerId(UPDATED_CUSTOMER_ID)
            .reason(UPDATED_REASON)
            .createdAt(UPDATED_CREATED_AT)
            .createdBy(UPDATED_CREATED_BY)
            .updatedAt(UPDATED_UPDATED_AT)
            .updatedBy(UPDATED_UPDATED_BY);
    }

    @BeforeEach
    void initTest() {
        transactionDownload = createEntity();
    }

    @AfterEach
    void cleanup() {
        if (insertedTransactionDownload != null) {
            transactionDownloadRepository.delete(insertedTransactionDownload);
            insertedTransactionDownload = null;
        }
    }

    @Test
    @Transactional
    void getAllTransactionDownloads() throws Exception {
        // Initialize the database
        insertedTransactionDownload = transactionDownloadRepository.saveAndFlush(transactionDownload);

        // Get all the transactionDownloadList
        restTransactionDownloadMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(transactionDownload.getId().intValue())))
            .andExpect(jsonPath("$.[*].transactionId").value(hasItem(DEFAULT_TRANSACTION_ID.intValue())))
            .andExpect(jsonPath("$.[*].customerId").value(hasItem(DEFAULT_CUSTOMER_ID.intValue())))
            .andExpect(jsonPath("$.[*].reason").value(hasItem(DEFAULT_REASON)))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY.intValue())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedBy").value(hasItem(DEFAULT_UPDATED_BY.intValue())));
    }

    @Test
    @Transactional
    void getTransactionDownload() throws Exception {
        // Initialize the database
        insertedTransactionDownload = transactionDownloadRepository.saveAndFlush(transactionDownload);

        // Get the transactionDownload
        restTransactionDownloadMockMvc
            .perform(get(ENTITY_API_URL_ID, transactionDownload.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(transactionDownload.getId().intValue()))
            .andExpect(jsonPath("$.transactionId").value(DEFAULT_TRANSACTION_ID.intValue()))
            .andExpect(jsonPath("$.customerId").value(DEFAULT_CUSTOMER_ID.intValue()))
            .andExpect(jsonPath("$.reason").value(DEFAULT_REASON))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY.intValue()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()))
            .andExpect(jsonPath("$.updatedBy").value(DEFAULT_UPDATED_BY.intValue()));
    }

    @Test
    @Transactional
    void getNonExistingTransactionDownload() throws Exception {
        // Get the transactionDownload
        restTransactionDownloadMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    protected long getRepositoryCount() {
        return transactionDownloadRepository.count();
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

    protected TransactionDownload getPersistedTransactionDownload(TransactionDownload transactionDownload) {
        return transactionDownloadRepository.findById(transactionDownload.getId()).orElseThrow();
    }

    protected void assertPersistedTransactionDownloadToMatchAllProperties(TransactionDownload expectedTransactionDownload) {
        assertTransactionDownloadAllPropertiesEquals(
            expectedTransactionDownload,
            getPersistedTransactionDownload(expectedTransactionDownload)
        );
    }

    protected void assertPersistedTransactionDownloadToMatchUpdatableProperties(TransactionDownload expectedTransactionDownload) {
        assertTransactionDownloadAllUpdatablePropertiesEquals(
            expectedTransactionDownload,
            getPersistedTransactionDownload(expectedTransactionDownload)
        );
    }
}
