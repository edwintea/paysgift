package com.paysgift.paymentservice.web.rest;

import static com.paysgift.paymentservice.domain.PaymentListAsserts.*;
import static com.paysgift.paymentservice.web.rest.TestUtil.sameNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paysgift.paymentservice.IntegrationTest;
import com.paysgift.paymentservice.domain.PaymentList;
import com.paysgift.paymentservice.repository.PaymentListRepository;
import com.paysgift.paymentservice.service.mapper.PaymentListMapper;
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
 * Integration tests for the {@link PaymentListResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class PaymentListResourceIT {

    private static final String DEFAULT_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final Long DEFAULT_PAYMENT_PROVIDER_ID = 1L;
    private static final Long UPDATED_PAYMENT_PROVIDER_ID = 2L;

    private static final BigDecimal DEFAULT_PAYMENT_FEE_PERCENTAGE = new BigDecimal(1);
    private static final BigDecimal UPDATED_PAYMENT_FEE_PERCENTAGE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PAYMENT_FEE_NOMINAL = new BigDecimal(1);
    private static final BigDecimal UPDATED_PAYMENT_FEE_NOMINAL = new BigDecimal(2);

    private static final String DEFAULT_PAYMENT_NOTES = "AAAAAAAAAA";
    private static final String UPDATED_PAYMENT_NOTES = "BBBBBBBBBB";

    private static final String DEFAULT_IMAGE_URL = "AAAAAAAAAA";
    private static final String UPDATED_IMAGE_URL = "BBBBBBBBBB";

    private static final String DEFAULT_HOW_TO_PAY = "AAAAAAAAAA";
    private static final String UPDATED_HOW_TO_PAY = "BBBBBBBBBB";

    private static final String DEFAULT_NOTE = "AAAAAAAAAA";
    private static final String UPDATED_NOTE = "BBBBBBBBBB";

    private static final Instant DEFAULT_CREATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_CREATED_BY = 1L;
    private static final Long UPDATED_CREATED_BY = 2L;

    private static final Instant DEFAULT_UPDATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_UPDATED_BY = 1L;
    private static final Long UPDATED_UPDATED_BY = 2L;

    private static final String ENTITY_API_URL = "/api/payment-lists";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    @Autowired
    private ObjectMapper om;

    @Autowired
    private PaymentListRepository paymentListRepository;

    @Autowired
    private PaymentListMapper paymentListMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restPaymentListMockMvc;

    private PaymentList paymentList;

    private PaymentList insertedPaymentList;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PaymentList createEntity() {
        return new PaymentList()
            .status(DEFAULT_STATUS)
            .type(DEFAULT_TYPE)
            .code(DEFAULT_CODE)
            .name(DEFAULT_NAME)
            .paymentProviderId(DEFAULT_PAYMENT_PROVIDER_ID)
            .paymentFeePercentage(DEFAULT_PAYMENT_FEE_PERCENTAGE)
            .paymentFeeNominal(DEFAULT_PAYMENT_FEE_NOMINAL)
            .paymentNotes(DEFAULT_PAYMENT_NOTES)
            .imageUrl(DEFAULT_IMAGE_URL)
            .howToPay(DEFAULT_HOW_TO_PAY)
            .note(DEFAULT_NOTE)
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
    public static PaymentList createUpdatedEntity() {
        return new PaymentList()
            .status(UPDATED_STATUS)
            .type(UPDATED_TYPE)
            .code(UPDATED_CODE)
            .name(UPDATED_NAME)
            .paymentProviderId(UPDATED_PAYMENT_PROVIDER_ID)
            .paymentFeePercentage(UPDATED_PAYMENT_FEE_PERCENTAGE)
            .paymentFeeNominal(UPDATED_PAYMENT_FEE_NOMINAL)
            .paymentNotes(UPDATED_PAYMENT_NOTES)
            .imageUrl(UPDATED_IMAGE_URL)
            .howToPay(UPDATED_HOW_TO_PAY)
            .note(UPDATED_NOTE)
            .createdAt(UPDATED_CREATED_AT)
            .createdBy(UPDATED_CREATED_BY)
            .updatedAt(UPDATED_UPDATED_AT)
            .updatedBy(UPDATED_UPDATED_BY);
    }

    @BeforeEach
    void initTest() {
        paymentList = createEntity();
    }

    @AfterEach
    void cleanup() {
        if (insertedPaymentList != null) {
            paymentListRepository.delete(insertedPaymentList);
            insertedPaymentList = null;
        }
    }

    @Test
    @Transactional
    void getAllPaymentLists() throws Exception {
        // Initialize the database
        insertedPaymentList = paymentListRepository.saveAndFlush(paymentList);

        // Get all the paymentListList
        restPaymentListMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(paymentList.getId().intValue())))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].type").value(hasItem(DEFAULT_TYPE)))
            .andExpect(jsonPath("$.[*].code").value(hasItem(DEFAULT_CODE)))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].paymentProviderId").value(hasItem(DEFAULT_PAYMENT_PROVIDER_ID.intValue())))
            .andExpect(jsonPath("$.[*].paymentFeePercentage").value(hasItem(sameNumber(DEFAULT_PAYMENT_FEE_PERCENTAGE))))
            .andExpect(jsonPath("$.[*].paymentFeeNominal").value(hasItem(sameNumber(DEFAULT_PAYMENT_FEE_NOMINAL))))
            .andExpect(jsonPath("$.[*].paymentNotes").value(hasItem(DEFAULT_PAYMENT_NOTES)))
            .andExpect(jsonPath("$.[*].imageUrl").value(hasItem(DEFAULT_IMAGE_URL)))
            .andExpect(jsonPath("$.[*].howToPay").value(hasItem(DEFAULT_HOW_TO_PAY)))
            .andExpect(jsonPath("$.[*].note").value(hasItem(DEFAULT_NOTE)))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY.intValue())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedBy").value(hasItem(DEFAULT_UPDATED_BY.intValue())));
    }

    @Test
    @Transactional
    void getPaymentList() throws Exception {
        // Initialize the database
        insertedPaymentList = paymentListRepository.saveAndFlush(paymentList);

        // Get the paymentList
        restPaymentListMockMvc
            .perform(get(ENTITY_API_URL_ID, paymentList.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(paymentList.getId().intValue()))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS))
            .andExpect(jsonPath("$.type").value(DEFAULT_TYPE))
            .andExpect(jsonPath("$.code").value(DEFAULT_CODE))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.paymentProviderId").value(DEFAULT_PAYMENT_PROVIDER_ID.intValue()))
            .andExpect(jsonPath("$.paymentFeePercentage").value(sameNumber(DEFAULT_PAYMENT_FEE_PERCENTAGE)))
            .andExpect(jsonPath("$.paymentFeeNominal").value(sameNumber(DEFAULT_PAYMENT_FEE_NOMINAL)))
            .andExpect(jsonPath("$.paymentNotes").value(DEFAULT_PAYMENT_NOTES))
            .andExpect(jsonPath("$.imageUrl").value(DEFAULT_IMAGE_URL))
            .andExpect(jsonPath("$.howToPay").value(DEFAULT_HOW_TO_PAY))
            .andExpect(jsonPath("$.note").value(DEFAULT_NOTE))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY.intValue()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()))
            .andExpect(jsonPath("$.updatedBy").value(DEFAULT_UPDATED_BY.intValue()));
    }

    @Test
    @Transactional
    void getNonExistingPaymentList() throws Exception {
        // Get the paymentList
        restPaymentListMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    protected long getRepositoryCount() {
        return paymentListRepository.count();
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

    protected PaymentList getPersistedPaymentList(PaymentList paymentList) {
        return paymentListRepository.findById(paymentList.getId()).orElseThrow();
    }

    protected void assertPersistedPaymentListToMatchAllProperties(PaymentList expectedPaymentList) {
        assertPaymentListAllPropertiesEquals(expectedPaymentList, getPersistedPaymentList(expectedPaymentList));
    }

    protected void assertPersistedPaymentListToMatchUpdatableProperties(PaymentList expectedPaymentList) {
        assertPaymentListAllUpdatablePropertiesEquals(expectedPaymentList, getPersistedPaymentList(expectedPaymentList));
    }
}
