package com.paysgift.paymentservice.web.rest;

import static com.paysgift.paymentservice.domain.PaymentTransactionRecurringAsserts.*;
import static com.paysgift.paymentservice.web.rest.TestUtil.sameNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paysgift.paymentservice.IntegrationTest;
import com.paysgift.paymentservice.domain.PaymentTransactionRecurring;
import com.paysgift.paymentservice.repository.PaymentTransactionRecurringRepository;
import com.paysgift.paymentservice.service.mapper.PaymentTransactionRecurringMapper;
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
 * Integration tests for the {@link PaymentTransactionRecurringResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class PaymentTransactionRecurringResourceIT {

    private static final Long DEFAULT_PAYMENT_PROVIDER_ID = 1L;
    private static final Long UPDATED_PAYMENT_PROVIDER_ID = 2L;

    private static final Long DEFAULT_PAYMENT_LIST_ID = 1L;
    private static final Long UPDATED_PAYMENT_LIST_ID = 2L;

    private static final Long DEFAULT_PAYMENT_TRANSACTION_ID = 1L;
    private static final Long UPDATED_PAYMENT_TRANSACTION_ID = 2L;

    private static final Long DEFAULT_CUSTOMER_ID = 1L;
    private static final Long UPDATED_CUSTOMER_ID = 2L;

    private static final Long DEFAULT_PAYMENT_METHOD_ID = 1L;
    private static final Long UPDATED_PAYMENT_METHOD_ID = 2L;

    private static final Long DEFAULT_RECURRING_PLAN_ID = 1L;
    private static final Long UPDATED_RECURRING_PLAN_ID = 2L;

    private static final Long DEFAULT_CYCLE_ID = 1L;
    private static final Long UPDATED_CYCLE_ID = 2L;

    private static final Long DEFAULT_SCHEDULE_ID = 1L;
    private static final Long UPDATED_SCHEDULE_ID = 2L;

    private static final Long DEFAULT_ACTION_ID = 1L;
    private static final Long UPDATED_ACTION_ID = 2L;

    private static final Boolean DEFAULT_STATUS = false;
    private static final Boolean UPDATED_STATUS = true;

    private static final Integer DEFAULT_CYCLE = 1;
    private static final Integer UPDATED_CYCLE = 2;

    private static final BigDecimal DEFAULT_AMOUNT = new BigDecimal(1);
    private static final BigDecimal UPDATED_AMOUNT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_TAX = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PAYMENT_CHARGE = new BigDecimal(1);
    private static final BigDecimal UPDATED_PAYMENT_CHARGE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_TOTAL = new BigDecimal(1);
    private static final BigDecimal UPDATED_TOTAL = new BigDecimal(2);

    private static final Instant DEFAULT_DATETIME_PAID = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_DATETIME_PAID = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Integer DEFAULT_TOTAL_RETRY = 1;
    private static final Integer UPDATED_TOTAL_RETRY = 2;

    private static final Integer DEFAULT_ATTEMPT_RETRY = 1;
    private static final Integer UPDATED_ATTEMPT_RETRY = 2;

    private static final Instant DEFAULT_DATETIME_LAST_RETRY = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_DATETIME_LAST_RETRY = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Boolean DEFAULT_SEND_CALLBACK = false;
    private static final Boolean UPDATED_SEND_CALLBACK = true;

    private static final Integer DEFAULT_SEND_CALLBACK_ATTEMPT = 1;
    private static final Integer UPDATED_SEND_CALLBACK_ATTEMPT = 2;

    private static final Instant DEFAULT_PAYMENT_SCHEDULE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_PAYMENT_SCHEDULE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_PAYMENT_LINK = "AAAAAAAAAA";
    private static final String UPDATED_PAYMENT_LINK = "BBBBBBBBBB";

    private static final String DEFAULT_REFERENCE_ID = "AAAAAAAAAA";
    private static final String UPDATED_REFERENCE_ID = "BBBBBBBBBB";

    private static final String DEFAULT_DATA_OBJ = "AAAAAAAAAA";
    private static final String UPDATED_DATA_OBJ = "BBBBBBBBBB";

    private static final Instant DEFAULT_CREATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_CREATED_BY = 1L;
    private static final Long UPDATED_CREATED_BY = 2L;

    private static final Instant DEFAULT_UPDATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_UPDATED_BY = 1L;
    private static final Long UPDATED_UPDATED_BY = 2L;

    private static final String ENTITY_API_URL = "/api/payment-transaction-recurrings";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    @Autowired
    private ObjectMapper om;

    @Autowired
    private PaymentTransactionRecurringRepository paymentTransactionRecurringRepository;

    @Autowired
    private PaymentTransactionRecurringMapper paymentTransactionRecurringMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restPaymentTransactionRecurringMockMvc;

    private PaymentTransactionRecurring paymentTransactionRecurring;

    private PaymentTransactionRecurring insertedPaymentTransactionRecurring;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PaymentTransactionRecurring createEntity() {
        return new PaymentTransactionRecurring()
            .paymentProviderId(DEFAULT_PAYMENT_PROVIDER_ID)
            .paymentListId(DEFAULT_PAYMENT_LIST_ID)
            .paymentTransactionId(DEFAULT_PAYMENT_TRANSACTION_ID)
            .customerId(DEFAULT_CUSTOMER_ID)
            .paymentMethodId(DEFAULT_PAYMENT_METHOD_ID)
            .recurringPlanId(DEFAULT_RECURRING_PLAN_ID)
            .cycleId(DEFAULT_CYCLE_ID)
            .scheduleId(DEFAULT_SCHEDULE_ID)
            .actionId(DEFAULT_ACTION_ID)
            .status(DEFAULT_STATUS)
            .cycle(DEFAULT_CYCLE)
            .amount(DEFAULT_AMOUNT)
            .tax(DEFAULT_TAX)
            .paymentCharge(DEFAULT_PAYMENT_CHARGE)
            .total(DEFAULT_TOTAL)
            .datetimePaid(DEFAULT_DATETIME_PAID)
            .totalRetry(DEFAULT_TOTAL_RETRY)
            .attemptRetry(DEFAULT_ATTEMPT_RETRY)
            .datetimeLastRetry(DEFAULT_DATETIME_LAST_RETRY)
            .sendCallback(DEFAULT_SEND_CALLBACK)
            .sendCallbackAttempt(DEFAULT_SEND_CALLBACK_ATTEMPT)
            .paymentSchedule(DEFAULT_PAYMENT_SCHEDULE)
            .paymentLink(DEFAULT_PAYMENT_LINK)
            .referenceId(DEFAULT_REFERENCE_ID)
            .dataObj(DEFAULT_DATA_OBJ)
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
    public static PaymentTransactionRecurring createUpdatedEntity() {
        return new PaymentTransactionRecurring()
            .paymentProviderId(UPDATED_PAYMENT_PROVIDER_ID)
            .paymentListId(UPDATED_PAYMENT_LIST_ID)
            .paymentTransactionId(UPDATED_PAYMENT_TRANSACTION_ID)
            .customerId(UPDATED_CUSTOMER_ID)
            .paymentMethodId(UPDATED_PAYMENT_METHOD_ID)
            .recurringPlanId(UPDATED_RECURRING_PLAN_ID)
            .cycleId(UPDATED_CYCLE_ID)
            .scheduleId(UPDATED_SCHEDULE_ID)
            .actionId(UPDATED_ACTION_ID)
            .status(UPDATED_STATUS)
            .cycle(UPDATED_CYCLE)
            .amount(UPDATED_AMOUNT)
            .tax(UPDATED_TAX)
            .paymentCharge(UPDATED_PAYMENT_CHARGE)
            .total(UPDATED_TOTAL)
            .datetimePaid(UPDATED_DATETIME_PAID)
            .totalRetry(UPDATED_TOTAL_RETRY)
            .attemptRetry(UPDATED_ATTEMPT_RETRY)
            .datetimeLastRetry(UPDATED_DATETIME_LAST_RETRY)
            .sendCallback(UPDATED_SEND_CALLBACK)
            .sendCallbackAttempt(UPDATED_SEND_CALLBACK_ATTEMPT)
            .paymentSchedule(UPDATED_PAYMENT_SCHEDULE)
            .paymentLink(UPDATED_PAYMENT_LINK)
            .referenceId(UPDATED_REFERENCE_ID)
            .dataObj(UPDATED_DATA_OBJ)
            .createdAt(UPDATED_CREATED_AT)
            .createdBy(UPDATED_CREATED_BY)
            .updatedAt(UPDATED_UPDATED_AT)
            .updatedBy(UPDATED_UPDATED_BY);
    }

    @BeforeEach
    void initTest() {
        paymentTransactionRecurring = createEntity();
    }

    @AfterEach
    void cleanup() {
        if (insertedPaymentTransactionRecurring != null) {
            paymentTransactionRecurringRepository.delete(insertedPaymentTransactionRecurring);
            insertedPaymentTransactionRecurring = null;
        }
    }

    @Test
    @Transactional
    void getAllPaymentTransactionRecurrings() throws Exception {
        // Initialize the database
        insertedPaymentTransactionRecurring = paymentTransactionRecurringRepository.saveAndFlush(paymentTransactionRecurring);

        // Get all the paymentTransactionRecurringList
        restPaymentTransactionRecurringMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(paymentTransactionRecurring.getId().intValue())))
            .andExpect(jsonPath("$.[*].paymentProviderId").value(hasItem(DEFAULT_PAYMENT_PROVIDER_ID.intValue())))
            .andExpect(jsonPath("$.[*].paymentListId").value(hasItem(DEFAULT_PAYMENT_LIST_ID.intValue())))
            .andExpect(jsonPath("$.[*].paymentTransactionId").value(hasItem(DEFAULT_PAYMENT_TRANSACTION_ID.intValue())))
            .andExpect(jsonPath("$.[*].customerId").value(hasItem(DEFAULT_CUSTOMER_ID.intValue())))
            .andExpect(jsonPath("$.[*].paymentMethodId").value(hasItem(DEFAULT_PAYMENT_METHOD_ID.intValue())))
            .andExpect(jsonPath("$.[*].recurringPlanId").value(hasItem(DEFAULT_RECURRING_PLAN_ID.intValue())))
            .andExpect(jsonPath("$.[*].cycleId").value(hasItem(DEFAULT_CYCLE_ID.intValue())))
            .andExpect(jsonPath("$.[*].scheduleId").value(hasItem(DEFAULT_SCHEDULE_ID.intValue())))
            .andExpect(jsonPath("$.[*].actionId").value(hasItem(DEFAULT_ACTION_ID.intValue())))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].cycle").value(hasItem(DEFAULT_CYCLE)))
            .andExpect(jsonPath("$.[*].amount").value(hasItem(sameNumber(DEFAULT_AMOUNT))))
            .andExpect(jsonPath("$.[*].tax").value(hasItem(sameNumber(DEFAULT_TAX))))
            .andExpect(jsonPath("$.[*].paymentCharge").value(hasItem(sameNumber(DEFAULT_PAYMENT_CHARGE))))
            .andExpect(jsonPath("$.[*].total").value(hasItem(sameNumber(DEFAULT_TOTAL))))
            .andExpect(jsonPath("$.[*].datetimePaid").value(hasItem(DEFAULT_DATETIME_PAID.toString())))
            .andExpect(jsonPath("$.[*].totalRetry").value(hasItem(DEFAULT_TOTAL_RETRY)))
            .andExpect(jsonPath("$.[*].attemptRetry").value(hasItem(DEFAULT_ATTEMPT_RETRY)))
            .andExpect(jsonPath("$.[*].datetimeLastRetry").value(hasItem(DEFAULT_DATETIME_LAST_RETRY.toString())))
            .andExpect(jsonPath("$.[*].sendCallback").value(hasItem(DEFAULT_SEND_CALLBACK)))
            .andExpect(jsonPath("$.[*].sendCallbackAttempt").value(hasItem(DEFAULT_SEND_CALLBACK_ATTEMPT)))
            .andExpect(jsonPath("$.[*].paymentSchedule").value(hasItem(DEFAULT_PAYMENT_SCHEDULE.toString())))
            .andExpect(jsonPath("$.[*].paymentLink").value(hasItem(DEFAULT_PAYMENT_LINK)))
            .andExpect(jsonPath("$.[*].referenceId").value(hasItem(DEFAULT_REFERENCE_ID)))
            .andExpect(jsonPath("$.[*].dataObj").value(hasItem(DEFAULT_DATA_OBJ)))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY.intValue())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedBy").value(hasItem(DEFAULT_UPDATED_BY.intValue())));
    }

    @Test
    @Transactional
    void getPaymentTransactionRecurring() throws Exception {
        // Initialize the database
        insertedPaymentTransactionRecurring = paymentTransactionRecurringRepository.saveAndFlush(paymentTransactionRecurring);

        // Get the paymentTransactionRecurring
        restPaymentTransactionRecurringMockMvc
            .perform(get(ENTITY_API_URL_ID, paymentTransactionRecurring.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(paymentTransactionRecurring.getId().intValue()))
            .andExpect(jsonPath("$.paymentProviderId").value(DEFAULT_PAYMENT_PROVIDER_ID.intValue()))
            .andExpect(jsonPath("$.paymentListId").value(DEFAULT_PAYMENT_LIST_ID.intValue()))
            .andExpect(jsonPath("$.paymentTransactionId").value(DEFAULT_PAYMENT_TRANSACTION_ID.intValue()))
            .andExpect(jsonPath("$.customerId").value(DEFAULT_CUSTOMER_ID.intValue()))
            .andExpect(jsonPath("$.paymentMethodId").value(DEFAULT_PAYMENT_METHOD_ID.intValue()))
            .andExpect(jsonPath("$.recurringPlanId").value(DEFAULT_RECURRING_PLAN_ID.intValue()))
            .andExpect(jsonPath("$.cycleId").value(DEFAULT_CYCLE_ID.intValue()))
            .andExpect(jsonPath("$.scheduleId").value(DEFAULT_SCHEDULE_ID.intValue()))
            .andExpect(jsonPath("$.actionId").value(DEFAULT_ACTION_ID.intValue()))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS))
            .andExpect(jsonPath("$.cycle").value(DEFAULT_CYCLE))
            .andExpect(jsonPath("$.amount").value(sameNumber(DEFAULT_AMOUNT)))
            .andExpect(jsonPath("$.tax").value(sameNumber(DEFAULT_TAX)))
            .andExpect(jsonPath("$.paymentCharge").value(sameNumber(DEFAULT_PAYMENT_CHARGE)))
            .andExpect(jsonPath("$.total").value(sameNumber(DEFAULT_TOTAL)))
            .andExpect(jsonPath("$.datetimePaid").value(DEFAULT_DATETIME_PAID.toString()))
            .andExpect(jsonPath("$.totalRetry").value(DEFAULT_TOTAL_RETRY))
            .andExpect(jsonPath("$.attemptRetry").value(DEFAULT_ATTEMPT_RETRY))
            .andExpect(jsonPath("$.datetimeLastRetry").value(DEFAULT_DATETIME_LAST_RETRY.toString()))
            .andExpect(jsonPath("$.sendCallback").value(DEFAULT_SEND_CALLBACK))
            .andExpect(jsonPath("$.sendCallbackAttempt").value(DEFAULT_SEND_CALLBACK_ATTEMPT))
            .andExpect(jsonPath("$.paymentSchedule").value(DEFAULT_PAYMENT_SCHEDULE.toString()))
            .andExpect(jsonPath("$.paymentLink").value(DEFAULT_PAYMENT_LINK))
            .andExpect(jsonPath("$.referenceId").value(DEFAULT_REFERENCE_ID))
            .andExpect(jsonPath("$.dataObj").value(DEFAULT_DATA_OBJ))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY.intValue()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()))
            .andExpect(jsonPath("$.updatedBy").value(DEFAULT_UPDATED_BY.intValue()));
    }

    @Test
    @Transactional
    void getNonExistingPaymentTransactionRecurring() throws Exception {
        // Get the paymentTransactionRecurring
        restPaymentTransactionRecurringMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    protected long getRepositoryCount() {
        return paymentTransactionRecurringRepository.count();
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

    protected PaymentTransactionRecurring getPersistedPaymentTransactionRecurring(PaymentTransactionRecurring paymentTransactionRecurring) {
        return paymentTransactionRecurringRepository.findById(paymentTransactionRecurring.getId()).orElseThrow();
    }

    protected void assertPersistedPaymentTransactionRecurringToMatchAllProperties(
        PaymentTransactionRecurring expectedPaymentTransactionRecurring
    ) {
        assertPaymentTransactionRecurringAllPropertiesEquals(
            expectedPaymentTransactionRecurring,
            getPersistedPaymentTransactionRecurring(expectedPaymentTransactionRecurring)
        );
    }

    protected void assertPersistedPaymentTransactionRecurringToMatchUpdatableProperties(
        PaymentTransactionRecurring expectedPaymentTransactionRecurring
    ) {
        assertPaymentTransactionRecurringAllUpdatablePropertiesEquals(
            expectedPaymentTransactionRecurring,
            getPersistedPaymentTransactionRecurring(expectedPaymentTransactionRecurring)
        );
    }
}
