package com.paysgift.paymentservice.web.rest;

import static com.paysgift.paymentservice.domain.PaymentTransactionAsserts.*;
import static com.paysgift.paymentservice.web.rest.TestUtil.sameInstant;
import static com.paysgift.paymentservice.web.rest.TestUtil.sameNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paysgift.paymentservice.IntegrationTest;
import com.paysgift.paymentservice.domain.PaymentTransaction;
import com.paysgift.paymentservice.repository.PaymentTransactionRepository;
import com.paysgift.paymentservice.service.mapper.PaymentTransactionMapper;
import jakarta.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
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
 * Integration tests for the {@link PaymentTransactionResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class PaymentTransactionResourceIT {

    private static final String DEFAULT_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_STATUS = "BBBBBBBBBB";

    private static final Long DEFAULT_PAYMENT_PROVIDER_ID = 1L;
    private static final Long UPDATED_PAYMENT_PROVIDER_ID = 2L;

    private static final Long DEFAULT_PAYMENT_LIST_ID = 1L;
    private static final Long UPDATED_PAYMENT_LIST_ID = 2L;

    private static final Long DEFAULT_ORDER_ID = 1L;
    private static final Long UPDATED_ORDER_ID = 2L;

    private static final String DEFAULT_ORDER_NO = "AAAAAAAAAA";
    private static final String UPDATED_ORDER_NO = "BBBBBBBBBB";

    private static final String DEFAULT_INVOICE_ID = "AAAAAAAAAA";
    private static final String UPDATED_INVOICE_ID = "BBBBBBBBBB";

    private static final String DEFAULT_REFERENCE_ID = "AAAAAAAAAA";
    private static final String UPDATED_REFERENCE_ID = "BBBBBBBBBB";

    private static final Long DEFAULT_CLIENT_ID = 1L;
    private static final Long UPDATED_CLIENT_ID = 2L;

    private static final BigDecimal DEFAULT_AMOUNT = new BigDecimal(1);
    private static final BigDecimal UPDATED_AMOUNT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_TAX = new BigDecimal(1);
    private static final BigDecimal UPDATED_TAX = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PAYMENT_CHARGE = new BigDecimal(1);
    private static final BigDecimal UPDATED_PAYMENT_CHARGE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_TOTAL = new BigDecimal(1);
    private static final BigDecimal UPDATED_TOTAL = new BigDecimal(2);

    private static final Boolean DEFAULT_EXPIRY_REQUEST = false;
    private static final Boolean UPDATED_EXPIRY_REQUEST = true;

    private static final Instant DEFAULT_EXPIRY_TIME = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_EXPIRY_TIME = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final ZonedDateTime DEFAULT_EXPIRY_LINK = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_EXPIRY_LINK = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final Boolean DEFAULT_PROCESS_EXPIRED = false;
    private static final Boolean UPDATED_PROCESS_EXPIRED = true;

    private static final String DEFAULT_PAYMENT_CODE = "AAAAAAAAAA";
    private static final String UPDATED_PAYMENT_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_PAYMENT_DEEPLINK = "AAAAAAAAAA";
    private static final String UPDATED_PAYMENT_DEEPLINK = "BBBBBBBBBB";

    private static final String DEFAULT_PAYMENT_OBJ = "AAAAAAAAAA";
    private static final String UPDATED_PAYMENT_OBJ = "BBBBBBBBBB";

    private static final String DEFAULT_NOTES = "AAAAAAAAAA";
    private static final String UPDATED_NOTES = "BBBBBBBBBB";

    private static final String DEFAULT_SGI_UID = "AAAAAAAAAA";
    private static final String UPDATED_SGI_UID = "BBBBBBBBBB";

    private static final String DEFAULT_CUSTOMER_NAME = "AAAAAAAAAA";
    private static final String UPDATED_CUSTOMER_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_CUSTOMER_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_CUSTOMER_EMAIL = "BBBBBBBBBB";

    private static final String DEFAULT_CUSTOMER_MOBILE_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_CUSTOMER_MOBILE_NUMBER = "BBBBBBBBBB";

    private static final Boolean DEFAULT_IS_SUBSCRIPTION = false;
    private static final Boolean UPDATED_IS_SUBSCRIPTION = true;

    private static final Integer DEFAULT_TOTAL_RECURRING = 1;
    private static final Integer UPDATED_TOTAL_RECURRING = 2;

    private static final Integer DEFAULT_RETRY_TOTAL = 1;
    private static final Integer UPDATED_RETRY_TOTAL = 2;

    private static final Integer DEFAULT_RETRY_INTERVAL = 1;
    private static final Integer UPDATED_RETRY_INTERVAL = 2;

    private static final Integer DEFAULT_CYCLE_ACTIVE = 1;
    private static final Integer UPDATED_CYCLE_ACTIVE = 2;

    private static final String DEFAULT_MODE = "AAAAAAAAAA";
    private static final String UPDATED_MODE = "BBBBBBBBBB";

    private static final String DEFAULT_MODE_INTERVAL = "AAAAAAAAAA";
    private static final String UPDATED_MODE_INTERVAL = "BBBBBBBBBB";

    private static final Instant DEFAULT_NEXT_PAYMENT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_NEXT_PAYMENT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Boolean DEFAULT_SEND_CALLBACK = false;
    private static final Boolean UPDATED_SEND_CALLBACK = true;

    private static final Integer DEFAULT_SEND_CALLBACK_ATTEMPT = 1;
    private static final Integer UPDATED_SEND_CALLBACK_ATTEMPT = 2;

    private static final Boolean DEFAULT_SEND_EMAIL = false;
    private static final Boolean UPDATED_SEND_EMAIL = true;

    private static final Integer DEFAULT_SEND_EMAIL_ATTEMPT = 1;
    private static final Integer UPDATED_SEND_EMAIL_ATTEMPT = 2;

    private static final Instant DEFAULT_CREATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_CREATED_BY = 1L;
    private static final Long UPDATED_CREATED_BY = 2L;

    private static final Instant DEFAULT_UPDATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_UPDATED_BY = 1L;
    private static final Long UPDATED_UPDATED_BY = 2L;

    private static final String ENTITY_API_URL = "/api/payment-transactions";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    @Autowired
    private ObjectMapper om;

    @Autowired
    private PaymentTransactionRepository paymentTransactionRepository;

    @Autowired
    private PaymentTransactionMapper paymentTransactionMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restPaymentTransactionMockMvc;

    private PaymentTransaction paymentTransaction;

    private PaymentTransaction insertedPaymentTransaction;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PaymentTransaction createEntity() {
        return new PaymentTransaction()
            .status(DEFAULT_STATUS)
            .paymentProviderId(DEFAULT_PAYMENT_PROVIDER_ID)
            .paymentListId(DEFAULT_PAYMENT_LIST_ID)
            .orderId(DEFAULT_ORDER_ID)
            .orderNo(DEFAULT_ORDER_NO)
            .invoiceId(DEFAULT_INVOICE_ID)
            .referenceId(DEFAULT_REFERENCE_ID)
            .clientId(DEFAULT_CLIENT_ID)
            .amount(DEFAULT_AMOUNT)
            .tax(DEFAULT_TAX)
            .paymentCharge(DEFAULT_PAYMENT_CHARGE)
            .total(DEFAULT_TOTAL)
            .expiryRequest(DEFAULT_EXPIRY_REQUEST)
            .expiryTime(DEFAULT_EXPIRY_TIME)
            .expiryLink(DEFAULT_EXPIRY_LINK)
            .processExpired(DEFAULT_PROCESS_EXPIRED)
            .paymentCode(DEFAULT_PAYMENT_CODE)
            .paymentDeeplink(DEFAULT_PAYMENT_DEEPLINK)
            .paymentObj(DEFAULT_PAYMENT_OBJ)
            .notes(DEFAULT_NOTES)
            .sgiUid(DEFAULT_SGI_UID)
            .customerName(DEFAULT_CUSTOMER_NAME)
            .customerEmail(DEFAULT_CUSTOMER_EMAIL)
            .customerMobileNumber(DEFAULT_CUSTOMER_MOBILE_NUMBER)
            .isSubscription(DEFAULT_IS_SUBSCRIPTION)
            .totalRecurring(DEFAULT_TOTAL_RECURRING)
            .retryTotal(DEFAULT_RETRY_TOTAL)
            .retryInterval(DEFAULT_RETRY_INTERVAL)
            .cycleActive(DEFAULT_CYCLE_ACTIVE)
            .mode(DEFAULT_MODE)
            .modeInterval(DEFAULT_MODE_INTERVAL)
            .nextPayment(DEFAULT_NEXT_PAYMENT)
            .sendCallback(DEFAULT_SEND_CALLBACK)
            .sendCallbackAttempt(DEFAULT_SEND_CALLBACK_ATTEMPT)
            .sendEmail(DEFAULT_SEND_EMAIL)
            .sendEmailAttempt(DEFAULT_SEND_EMAIL_ATTEMPT)
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
    public static PaymentTransaction createUpdatedEntity() {
        return new PaymentTransaction()
            .status(UPDATED_STATUS)
            .paymentProviderId(UPDATED_PAYMENT_PROVIDER_ID)
            .paymentListId(UPDATED_PAYMENT_LIST_ID)
            .orderId(UPDATED_ORDER_ID)
            .orderNo(UPDATED_ORDER_NO)
            .invoiceId(UPDATED_INVOICE_ID)
            .referenceId(UPDATED_REFERENCE_ID)
            .clientId(UPDATED_CLIENT_ID)
            .amount(UPDATED_AMOUNT)
            .tax(UPDATED_TAX)
            .paymentCharge(UPDATED_PAYMENT_CHARGE)
            .total(UPDATED_TOTAL)
            .expiryRequest(UPDATED_EXPIRY_REQUEST)
            .expiryTime(UPDATED_EXPIRY_TIME)
            .expiryLink(UPDATED_EXPIRY_LINK)
            .processExpired(UPDATED_PROCESS_EXPIRED)
            .paymentCode(UPDATED_PAYMENT_CODE)
            .paymentDeeplink(UPDATED_PAYMENT_DEEPLINK)
            .paymentObj(UPDATED_PAYMENT_OBJ)
            .notes(UPDATED_NOTES)
            .sgiUid(UPDATED_SGI_UID)
            .customerName(UPDATED_CUSTOMER_NAME)
            .customerEmail(UPDATED_CUSTOMER_EMAIL)
            .customerMobileNumber(UPDATED_CUSTOMER_MOBILE_NUMBER)
            .isSubscription(UPDATED_IS_SUBSCRIPTION)
            .totalRecurring(UPDATED_TOTAL_RECURRING)
            .retryTotal(UPDATED_RETRY_TOTAL)
            .retryInterval(UPDATED_RETRY_INTERVAL)
            .cycleActive(UPDATED_CYCLE_ACTIVE)
            .mode(UPDATED_MODE)
            .modeInterval(UPDATED_MODE_INTERVAL)
            .nextPayment(UPDATED_NEXT_PAYMENT)
            .sendCallback(UPDATED_SEND_CALLBACK)
            .sendCallbackAttempt(UPDATED_SEND_CALLBACK_ATTEMPT)
            .sendEmail(UPDATED_SEND_EMAIL)
            .sendEmailAttempt(UPDATED_SEND_EMAIL_ATTEMPT)
            .createdAt(UPDATED_CREATED_AT)
            .createdBy(UPDATED_CREATED_BY)
            .updatedAt(UPDATED_UPDATED_AT)
            .updatedBy(UPDATED_UPDATED_BY);
    }

    @BeforeEach
    void initTest() {
        paymentTransaction = createEntity();
    }

    @AfterEach
    void cleanup() {
        if (insertedPaymentTransaction != null) {
            paymentTransactionRepository.delete(insertedPaymentTransaction);
            insertedPaymentTransaction = null;
        }
    }

    @Test
    @Transactional
    void getAllPaymentTransactions() throws Exception {
        // Initialize the database
        insertedPaymentTransaction = paymentTransactionRepository.saveAndFlush(paymentTransaction);

        // Get all the paymentTransactionList
        restPaymentTransactionMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(paymentTransaction.getId().intValue())))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].paymentProviderId").value(hasItem(DEFAULT_PAYMENT_PROVIDER_ID.intValue())))
            .andExpect(jsonPath("$.[*].paymentListId").value(hasItem(DEFAULT_PAYMENT_LIST_ID.intValue())))
            .andExpect(jsonPath("$.[*].orderId").value(hasItem(DEFAULT_ORDER_ID.intValue())))
            .andExpect(jsonPath("$.[*].orderNo").value(hasItem(DEFAULT_ORDER_NO)))
            .andExpect(jsonPath("$.[*].invoiceId").value(hasItem(DEFAULT_INVOICE_ID)))
            .andExpect(jsonPath("$.[*].referenceId").value(hasItem(DEFAULT_REFERENCE_ID)))
            .andExpect(jsonPath("$.[*].clientId").value(hasItem(DEFAULT_CLIENT_ID.intValue())))
            .andExpect(jsonPath("$.[*].amount").value(hasItem(sameNumber(DEFAULT_AMOUNT))))
            .andExpect(jsonPath("$.[*].tax").value(hasItem(sameNumber(DEFAULT_TAX))))
            .andExpect(jsonPath("$.[*].paymentCharge").value(hasItem(sameNumber(DEFAULT_PAYMENT_CHARGE))))
            .andExpect(jsonPath("$.[*].total").value(hasItem(sameNumber(DEFAULT_TOTAL))))
            .andExpect(jsonPath("$.[*].expiryRequest").value(hasItem(DEFAULT_EXPIRY_REQUEST)))
            .andExpect(jsonPath("$.[*].expiryTime").value(hasItem(DEFAULT_EXPIRY_TIME.toString())))
            .andExpect(jsonPath("$.[*].expiryLink").value(hasItem(sameInstant(DEFAULT_EXPIRY_LINK))))
            .andExpect(jsonPath("$.[*].processExpired").value(hasItem(DEFAULT_PROCESS_EXPIRED)))
            .andExpect(jsonPath("$.[*].paymentCode").value(hasItem(DEFAULT_PAYMENT_CODE)))
            .andExpect(jsonPath("$.[*].paymentDeeplink").value(hasItem(DEFAULT_PAYMENT_DEEPLINK)))
            .andExpect(jsonPath("$.[*].paymentObj").value(hasItem(DEFAULT_PAYMENT_OBJ)))
            .andExpect(jsonPath("$.[*].notes").value(hasItem(DEFAULT_NOTES)))
            .andExpect(jsonPath("$.[*].sgiUid").value(hasItem(DEFAULT_SGI_UID)))
            .andExpect(jsonPath("$.[*].customerName").value(hasItem(DEFAULT_CUSTOMER_NAME)))
            .andExpect(jsonPath("$.[*].customerEmail").value(hasItem(DEFAULT_CUSTOMER_EMAIL)))
            .andExpect(jsonPath("$.[*].customerMobileNumber").value(hasItem(DEFAULT_CUSTOMER_MOBILE_NUMBER)))
            .andExpect(jsonPath("$.[*].isSubscription").value(hasItem(DEFAULT_IS_SUBSCRIPTION)))
            .andExpect(jsonPath("$.[*].totalRecurring").value(hasItem(DEFAULT_TOTAL_RECURRING)))
            .andExpect(jsonPath("$.[*].retryTotal").value(hasItem(DEFAULT_RETRY_TOTAL)))
            .andExpect(jsonPath("$.[*].retryInterval").value(hasItem(DEFAULT_RETRY_INTERVAL)))
            .andExpect(jsonPath("$.[*].cycleActive").value(hasItem(DEFAULT_CYCLE_ACTIVE)))
            .andExpect(jsonPath("$.[*].mode").value(hasItem(DEFAULT_MODE)))
            .andExpect(jsonPath("$.[*].modeInterval").value(hasItem(DEFAULT_MODE_INTERVAL)))
            .andExpect(jsonPath("$.[*].nextPayment").value(hasItem(DEFAULT_NEXT_PAYMENT.toString())))
            .andExpect(jsonPath("$.[*].sendCallback").value(hasItem(DEFAULT_SEND_CALLBACK)))
            .andExpect(jsonPath("$.[*].sendCallbackAttempt").value(hasItem(DEFAULT_SEND_CALLBACK_ATTEMPT)))
            .andExpect(jsonPath("$.[*].sendEmail").value(hasItem(DEFAULT_SEND_EMAIL)))
            .andExpect(jsonPath("$.[*].sendEmailAttempt").value(hasItem(DEFAULT_SEND_EMAIL_ATTEMPT)))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY.intValue())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedBy").value(hasItem(DEFAULT_UPDATED_BY.intValue())));
    }

    @Test
    @Transactional
    void getPaymentTransaction() throws Exception {
        // Initialize the database
        insertedPaymentTransaction = paymentTransactionRepository.saveAndFlush(paymentTransaction);

        // Get the paymentTransaction
        restPaymentTransactionMockMvc
            .perform(get(ENTITY_API_URL_ID, paymentTransaction.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(paymentTransaction.getId().intValue()))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS))
            .andExpect(jsonPath("$.paymentProviderId").value(DEFAULT_PAYMENT_PROVIDER_ID.intValue()))
            .andExpect(jsonPath("$.paymentListId").value(DEFAULT_PAYMENT_LIST_ID.intValue()))
            .andExpect(jsonPath("$.orderId").value(DEFAULT_ORDER_ID.intValue()))
            .andExpect(jsonPath("$.orderNo").value(DEFAULT_ORDER_NO))
            .andExpect(jsonPath("$.invoiceId").value(DEFAULT_INVOICE_ID))
            .andExpect(jsonPath("$.referenceId").value(DEFAULT_REFERENCE_ID))
            .andExpect(jsonPath("$.clientId").value(DEFAULT_CLIENT_ID.intValue()))
            .andExpect(jsonPath("$.amount").value(sameNumber(DEFAULT_AMOUNT)))
            .andExpect(jsonPath("$.tax").value(sameNumber(DEFAULT_TAX)))
            .andExpect(jsonPath("$.paymentCharge").value(sameNumber(DEFAULT_PAYMENT_CHARGE)))
            .andExpect(jsonPath("$.total").value(sameNumber(DEFAULT_TOTAL)))
            .andExpect(jsonPath("$.expiryRequest").value(DEFAULT_EXPIRY_REQUEST))
            .andExpect(jsonPath("$.expiryTime").value(DEFAULT_EXPIRY_TIME.toString()))
            .andExpect(jsonPath("$.expiryLink").value(sameInstant(DEFAULT_EXPIRY_LINK)))
            .andExpect(jsonPath("$.processExpired").value(DEFAULT_PROCESS_EXPIRED))
            .andExpect(jsonPath("$.paymentCode").value(DEFAULT_PAYMENT_CODE))
            .andExpect(jsonPath("$.paymentDeeplink").value(DEFAULT_PAYMENT_DEEPLINK))
            .andExpect(jsonPath("$.paymentObj").value(DEFAULT_PAYMENT_OBJ))
            .andExpect(jsonPath("$.notes").value(DEFAULT_NOTES))
            .andExpect(jsonPath("$.sgiUid").value(DEFAULT_SGI_UID))
            .andExpect(jsonPath("$.customerName").value(DEFAULT_CUSTOMER_NAME))
            .andExpect(jsonPath("$.customerEmail").value(DEFAULT_CUSTOMER_EMAIL))
            .andExpect(jsonPath("$.customerMobileNumber").value(DEFAULT_CUSTOMER_MOBILE_NUMBER))
            .andExpect(jsonPath("$.isSubscription").value(DEFAULT_IS_SUBSCRIPTION))
            .andExpect(jsonPath("$.totalRecurring").value(DEFAULT_TOTAL_RECURRING))
            .andExpect(jsonPath("$.retryTotal").value(DEFAULT_RETRY_TOTAL))
            .andExpect(jsonPath("$.retryInterval").value(DEFAULT_RETRY_INTERVAL))
            .andExpect(jsonPath("$.cycleActive").value(DEFAULT_CYCLE_ACTIVE))
            .andExpect(jsonPath("$.mode").value(DEFAULT_MODE))
            .andExpect(jsonPath("$.modeInterval").value(DEFAULT_MODE_INTERVAL))
            .andExpect(jsonPath("$.nextPayment").value(DEFAULT_NEXT_PAYMENT.toString()))
            .andExpect(jsonPath("$.sendCallback").value(DEFAULT_SEND_CALLBACK))
            .andExpect(jsonPath("$.sendCallbackAttempt").value(DEFAULT_SEND_CALLBACK_ATTEMPT))
            .andExpect(jsonPath("$.sendEmail").value(DEFAULT_SEND_EMAIL))
            .andExpect(jsonPath("$.sendEmailAttempt").value(DEFAULT_SEND_EMAIL_ATTEMPT))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY.intValue()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()))
            .andExpect(jsonPath("$.updatedBy").value(DEFAULT_UPDATED_BY.intValue()));
    }

    @Test
    @Transactional
    void getNonExistingPaymentTransaction() throws Exception {
        // Get the paymentTransaction
        restPaymentTransactionMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    protected long getRepositoryCount() {
        return paymentTransactionRepository.count();
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

    protected PaymentTransaction getPersistedPaymentTransaction(PaymentTransaction paymentTransaction) {
        return paymentTransactionRepository.findById(paymentTransaction.getId()).orElseThrow();
    }

    protected void assertPersistedPaymentTransactionToMatchAllProperties(PaymentTransaction expectedPaymentTransaction) {
        assertPaymentTransactionAllPropertiesEquals(expectedPaymentTransaction, getPersistedPaymentTransaction(expectedPaymentTransaction));
    }

    protected void assertPersistedPaymentTransactionToMatchUpdatableProperties(PaymentTransaction expectedPaymentTransaction) {
        assertPaymentTransactionAllUpdatablePropertiesEquals(
            expectedPaymentTransaction,
            getPersistedPaymentTransaction(expectedPaymentTransaction)
        );
    }
}
