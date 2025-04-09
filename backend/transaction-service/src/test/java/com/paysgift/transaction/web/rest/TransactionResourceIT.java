package com.paysgift.transaction.web.rest;

import static com.paysgift.transaction.domain.TransactionAsserts.*;
import static com.paysgift.transaction.web.rest.TestUtil.sameNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paysgift.transaction.IntegrationTest;
import com.paysgift.transaction.domain.Transaction;
import com.paysgift.transaction.repository.TransactionRepository;
import com.paysgift.transaction.service.mapper.TransactionMapper;
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
 * Integration tests for the {@link TransactionResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class TransactionResourceIT {

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

    private static final Long DEFAULT_CURRENCY_ID = 1L;
    private static final Long UPDATED_CURRENCY_ID = 2L;

    private static final String DEFAULT_CURRENCY_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CURRENCY_CODE = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_CURRENCY_RATE = new BigDecimal(1);
    private static final BigDecimal UPDATED_CURRENCY_RATE = new BigDecimal(2);

    private static final Long DEFAULT_PAYMENT_ID = 1L;
    private static final Long UPDATED_PAYMENT_ID = 2L;

    private static final Long DEFAULT_COUPON_CODE_ID = 1L;
    private static final Long UPDATED_COUPON_CODE_ID = 2L;

    private static final String DEFAULT_SHOPBACK_REFERENCE = "AAAAAAAAAA";
    private static final String UPDATED_SHOPBACK_REFERENCE = "BBBBBBBBBB";

    private static final String DEFAULT_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_INVOICE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_INVOICE_CODE = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_PRODUCT_PRICE = new BigDecimal(1);
    private static final BigDecimal UPDATED_PRODUCT_PRICE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PRODUCT_PRICE_USD = new BigDecimal(1);
    private static final BigDecimal UPDATED_PRODUCT_PRICE_USD = new BigDecimal(2);

    private static final BigDecimal DEFAULT_DELIVERY_PRICE = new BigDecimal(1);
    private static final BigDecimal UPDATED_DELIVERY_PRICE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_DELIVERY_PRICE_USD = new BigDecimal(1);
    private static final BigDecimal UPDATED_DELIVERY_PRICE_USD = new BigDecimal(2);

    private static final BigDecimal DEFAULT_DISC_PRODUCT_PRICE = new BigDecimal(1);
    private static final BigDecimal UPDATED_DISC_PRODUCT_PRICE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_DISC_PRODUCT_PRICE_USD = new BigDecimal(1);
    private static final BigDecimal UPDATED_DISC_PRODUCT_PRICE_USD = new BigDecimal(2);

    private static final BigDecimal DEFAULT_DISC_DELIVERY_PRICE = new BigDecimal(1);
    private static final BigDecimal UPDATED_DISC_DELIVERY_PRICE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_DISC_DELIVERY_PRICE_USD = new BigDecimal(1);
    private static final BigDecimal UPDATED_DISC_DELIVERY_PRICE_USD = new BigDecimal(2);

    private static final BigDecimal DEFAULT_DISC_COUPON_PRICE = new BigDecimal(1);
    private static final BigDecimal UPDATED_DISC_COUPON_PRICE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_DISC_COUPON_PRICE_USD = new BigDecimal(1);
    private static final BigDecimal UPDATED_DISC_COUPON_PRICE_USD = new BigDecimal(2);

    private static final BigDecimal DEFAULT_SERVICE_FEE = new BigDecimal(1);
    private static final BigDecimal UPDATED_SERVICE_FEE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_SERVICE_FEE_USD = new BigDecimal(1);
    private static final BigDecimal UPDATED_SERVICE_FEE_USD = new BigDecimal(2);

    private static final BigDecimal DEFAULT_TOTAL_PAYMENT = new BigDecimal(1);
    private static final BigDecimal UPDATED_TOTAL_PAYMENT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_TOTAL_PAYMENT_USD = new BigDecimal(1);
    private static final BigDecimal UPDATED_TOTAL_PAYMENT_USD = new BigDecimal(2);

    private static final String DEFAULT_PAYMENT_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_PAYMENT_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_PAYMENT_QR = "AAAAAAAAAA";
    private static final String UPDATED_PAYMENT_QR = "BBBBBBBBBB";

    private static final String DEFAULT_PAYMENT_LINK = "AAAAAAAAAA";
    private static final String UPDATED_PAYMENT_LINK = "BBBBBBBBBB";

    private static final Boolean DEFAULT_PAYMENT_STATUS = false;
    private static final Boolean UPDATED_PAYMENT_STATUS = true;

    private static final Instant DEFAULT_PAYMENT_EXPIRED = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_PAYMENT_EXPIRED = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_PAYMENT_REFERENCE_ID = "AAAAAAAAAA";
    private static final String UPDATED_PAYMENT_REFERENCE_ID = "BBBBBBBBBB";

    private static final Instant DEFAULT_PAIDED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_PAIDED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_STATUS = "BBBBBBBBBB";

    private static final Instant DEFAULT_CREATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_CREATED_BY = 1L;
    private static final Long UPDATED_CREATED_BY = 2L;

    private static final Instant DEFAULT_UPDATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_UPDATED_BY = 1L;
    private static final Long UPDATED_UPDATED_BY = 2L;

    private static final String ENTITY_API_URL = "/api/transactions";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    @Autowired
    private ObjectMapper om;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionMapper transactionMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restTransactionMockMvc;

    private Transaction transaction;

    private Transaction insertedTransaction;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Transaction createEntity() {
        return new Transaction()
            .customerId(DEFAULT_CUSTOMER_ID)
            .countryId(DEFAULT_COUNTRY_ID)
            .clientId(DEFAULT_CLIENT_ID)
            .channelId(DEFAULT_CHANNEL_ID)
            .brandId(DEFAULT_BRAND_ID)
            .currencyId(DEFAULT_CURRENCY_ID)
            .currencyCode(DEFAULT_CURRENCY_CODE)
            .currencyRate(DEFAULT_CURRENCY_RATE)
            .paymentId(DEFAULT_PAYMENT_ID)
            .couponCodeId(DEFAULT_COUPON_CODE_ID)
            .shopbackReference(DEFAULT_SHOPBACK_REFERENCE)
            .code(DEFAULT_CODE)
            .invoiceCode(DEFAULT_INVOICE_CODE)
            .productPrice(DEFAULT_PRODUCT_PRICE)
            .productPriceUsd(DEFAULT_PRODUCT_PRICE_USD)
            .deliveryPrice(DEFAULT_DELIVERY_PRICE)
            .deliveryPriceUsd(DEFAULT_DELIVERY_PRICE_USD)
            .discProductPrice(DEFAULT_DISC_PRODUCT_PRICE)
            .discProductPriceUsd(DEFAULT_DISC_PRODUCT_PRICE_USD)
            .discDeliveryPrice(DEFAULT_DISC_DELIVERY_PRICE)
            .discDeliveryPriceUsd(DEFAULT_DISC_DELIVERY_PRICE_USD)
            .discCouponPrice(DEFAULT_DISC_COUPON_PRICE)
            .discCouponPriceUsd(DEFAULT_DISC_COUPON_PRICE_USD)
            .serviceFee(DEFAULT_SERVICE_FEE)
            .serviceFeeUsd(DEFAULT_SERVICE_FEE_USD)
            .totalPayment(DEFAULT_TOTAL_PAYMENT)
            .totalPaymentUsd(DEFAULT_TOTAL_PAYMENT_USD)
            .paymentNumber(DEFAULT_PAYMENT_NUMBER)
            .paymentQr(DEFAULT_PAYMENT_QR)
            .paymentLink(DEFAULT_PAYMENT_LINK)
            .paymentStatus(DEFAULT_PAYMENT_STATUS)
            .paymentExpired(DEFAULT_PAYMENT_EXPIRED)
            .paymentReferenceId(DEFAULT_PAYMENT_REFERENCE_ID)
            .paidedAt(DEFAULT_PAIDED_AT)
            .status(DEFAULT_STATUS)
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
    public static Transaction createUpdatedEntity() {
        return new Transaction()
            .customerId(UPDATED_CUSTOMER_ID)
            .countryId(UPDATED_COUNTRY_ID)
            .clientId(UPDATED_CLIENT_ID)
            .channelId(UPDATED_CHANNEL_ID)
            .brandId(UPDATED_BRAND_ID)
            .currencyId(UPDATED_CURRENCY_ID)
            .currencyCode(UPDATED_CURRENCY_CODE)
            .currencyRate(UPDATED_CURRENCY_RATE)
            .paymentId(UPDATED_PAYMENT_ID)
            .couponCodeId(UPDATED_COUPON_CODE_ID)
            .shopbackReference(UPDATED_SHOPBACK_REFERENCE)
            .code(UPDATED_CODE)
            .invoiceCode(UPDATED_INVOICE_CODE)
            .productPrice(UPDATED_PRODUCT_PRICE)
            .productPriceUsd(UPDATED_PRODUCT_PRICE_USD)
            .deliveryPrice(UPDATED_DELIVERY_PRICE)
            .deliveryPriceUsd(UPDATED_DELIVERY_PRICE_USD)
            .discProductPrice(UPDATED_DISC_PRODUCT_PRICE)
            .discProductPriceUsd(UPDATED_DISC_PRODUCT_PRICE_USD)
            .discDeliveryPrice(UPDATED_DISC_DELIVERY_PRICE)
            .discDeliveryPriceUsd(UPDATED_DISC_DELIVERY_PRICE_USD)
            .discCouponPrice(UPDATED_DISC_COUPON_PRICE)
            .discCouponPriceUsd(UPDATED_DISC_COUPON_PRICE_USD)
            .serviceFee(UPDATED_SERVICE_FEE)
            .serviceFeeUsd(UPDATED_SERVICE_FEE_USD)
            .totalPayment(UPDATED_TOTAL_PAYMENT)
            .totalPaymentUsd(UPDATED_TOTAL_PAYMENT_USD)
            .paymentNumber(UPDATED_PAYMENT_NUMBER)
            .paymentQr(UPDATED_PAYMENT_QR)
            .paymentLink(UPDATED_PAYMENT_LINK)
            .paymentStatus(UPDATED_PAYMENT_STATUS)
            .paymentExpired(UPDATED_PAYMENT_EXPIRED)
            .paymentReferenceId(UPDATED_PAYMENT_REFERENCE_ID)
            .paidedAt(UPDATED_PAIDED_AT)
            .status(UPDATED_STATUS)
            .createdAt(UPDATED_CREATED_AT)
            .createdBy(UPDATED_CREATED_BY)
            .updatedAt(UPDATED_UPDATED_AT)
            .updatedBy(UPDATED_UPDATED_BY);
    }

    @BeforeEach
    void initTest() {
        transaction = createEntity();
    }

    @AfterEach
    void cleanup() {
        if (insertedTransaction != null) {
            transactionRepository.delete(insertedTransaction);
            insertedTransaction = null;
        }
    }

    @Test
    @Transactional
    void getAllTransactions() throws Exception {
        // Initialize the database
        insertedTransaction = transactionRepository.saveAndFlush(transaction);

        // Get all the transactionList
        restTransactionMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(transaction.getId().intValue())))
            .andExpect(jsonPath("$.[*].customerId").value(hasItem(DEFAULT_CUSTOMER_ID.intValue())))
            .andExpect(jsonPath("$.[*].countryId").value(hasItem(DEFAULT_COUNTRY_ID.intValue())))
            .andExpect(jsonPath("$.[*].clientId").value(hasItem(DEFAULT_CLIENT_ID.intValue())))
            .andExpect(jsonPath("$.[*].channelId").value(hasItem(DEFAULT_CHANNEL_ID.intValue())))
            .andExpect(jsonPath("$.[*].brandId").value(hasItem(DEFAULT_BRAND_ID.intValue())))
            .andExpect(jsonPath("$.[*].currencyId").value(hasItem(DEFAULT_CURRENCY_ID.intValue())))
            .andExpect(jsonPath("$.[*].currencyCode").value(hasItem(DEFAULT_CURRENCY_CODE)))
            .andExpect(jsonPath("$.[*].currencyRate").value(hasItem(sameNumber(DEFAULT_CURRENCY_RATE))))
            .andExpect(jsonPath("$.[*].paymentId").value(hasItem(DEFAULT_PAYMENT_ID.intValue())))
            .andExpect(jsonPath("$.[*].couponCodeId").value(hasItem(DEFAULT_COUPON_CODE_ID.intValue())))
            .andExpect(jsonPath("$.[*].shopbackReference").value(hasItem(DEFAULT_SHOPBACK_REFERENCE)))
            .andExpect(jsonPath("$.[*].code").value(hasItem(DEFAULT_CODE)))
            .andExpect(jsonPath("$.[*].invoiceCode").value(hasItem(DEFAULT_INVOICE_CODE)))
            .andExpect(jsonPath("$.[*].productPrice").value(hasItem(sameNumber(DEFAULT_PRODUCT_PRICE))))
            .andExpect(jsonPath("$.[*].productPriceUsd").value(hasItem(sameNumber(DEFAULT_PRODUCT_PRICE_USD))))
            .andExpect(jsonPath("$.[*].deliveryPrice").value(hasItem(sameNumber(DEFAULT_DELIVERY_PRICE))))
            .andExpect(jsonPath("$.[*].deliveryPriceUsd").value(hasItem(sameNumber(DEFAULT_DELIVERY_PRICE_USD))))
            .andExpect(jsonPath("$.[*].discProductPrice").value(hasItem(sameNumber(DEFAULT_DISC_PRODUCT_PRICE))))
            .andExpect(jsonPath("$.[*].discProductPriceUsd").value(hasItem(sameNumber(DEFAULT_DISC_PRODUCT_PRICE_USD))))
            .andExpect(jsonPath("$.[*].discDeliveryPrice").value(hasItem(sameNumber(DEFAULT_DISC_DELIVERY_PRICE))))
            .andExpect(jsonPath("$.[*].discDeliveryPriceUsd").value(hasItem(sameNumber(DEFAULT_DISC_DELIVERY_PRICE_USD))))
            .andExpect(jsonPath("$.[*].discCouponPrice").value(hasItem(sameNumber(DEFAULT_DISC_COUPON_PRICE))))
            .andExpect(jsonPath("$.[*].discCouponPriceUsd").value(hasItem(sameNumber(DEFAULT_DISC_COUPON_PRICE_USD))))
            .andExpect(jsonPath("$.[*].serviceFee").value(hasItem(sameNumber(DEFAULT_SERVICE_FEE))))
            .andExpect(jsonPath("$.[*].serviceFeeUsd").value(hasItem(sameNumber(DEFAULT_SERVICE_FEE_USD))))
            .andExpect(jsonPath("$.[*].totalPayment").value(hasItem(sameNumber(DEFAULT_TOTAL_PAYMENT))))
            .andExpect(jsonPath("$.[*].totalPaymentUsd").value(hasItem(sameNumber(DEFAULT_TOTAL_PAYMENT_USD))))
            .andExpect(jsonPath("$.[*].paymentNumber").value(hasItem(DEFAULT_PAYMENT_NUMBER)))
            .andExpect(jsonPath("$.[*].paymentQr").value(hasItem(DEFAULT_PAYMENT_QR)))
            .andExpect(jsonPath("$.[*].paymentLink").value(hasItem(DEFAULT_PAYMENT_LINK)))
            .andExpect(jsonPath("$.[*].paymentStatus").value(hasItem(DEFAULT_PAYMENT_STATUS)))
            .andExpect(jsonPath("$.[*].paymentExpired").value(hasItem(DEFAULT_PAYMENT_EXPIRED.toString())))
            .andExpect(jsonPath("$.[*].paymentReferenceId").value(hasItem(DEFAULT_PAYMENT_REFERENCE_ID)))
            .andExpect(jsonPath("$.[*].paidedAt").value(hasItem(DEFAULT_PAIDED_AT.toString())))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY.intValue())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedBy").value(hasItem(DEFAULT_UPDATED_BY.intValue())));
    }

    @Test
    @Transactional
    void getTransaction() throws Exception {
        // Initialize the database
        insertedTransaction = transactionRepository.saveAndFlush(transaction);

        // Get the transaction
        restTransactionMockMvc
            .perform(get(ENTITY_API_URL_ID, transaction.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(transaction.getId().intValue()))
            .andExpect(jsonPath("$.customerId").value(DEFAULT_CUSTOMER_ID.intValue()))
            .andExpect(jsonPath("$.countryId").value(DEFAULT_COUNTRY_ID.intValue()))
            .andExpect(jsonPath("$.clientId").value(DEFAULT_CLIENT_ID.intValue()))
            .andExpect(jsonPath("$.channelId").value(DEFAULT_CHANNEL_ID.intValue()))
            .andExpect(jsonPath("$.brandId").value(DEFAULT_BRAND_ID.intValue()))
            .andExpect(jsonPath("$.currencyId").value(DEFAULT_CURRENCY_ID.intValue()))
            .andExpect(jsonPath("$.currencyCode").value(DEFAULT_CURRENCY_CODE))
            .andExpect(jsonPath("$.currencyRate").value(sameNumber(DEFAULT_CURRENCY_RATE)))
            .andExpect(jsonPath("$.paymentId").value(DEFAULT_PAYMENT_ID.intValue()))
            .andExpect(jsonPath("$.couponCodeId").value(DEFAULT_COUPON_CODE_ID.intValue()))
            .andExpect(jsonPath("$.shopbackReference").value(DEFAULT_SHOPBACK_REFERENCE))
            .andExpect(jsonPath("$.code").value(DEFAULT_CODE))
            .andExpect(jsonPath("$.invoiceCode").value(DEFAULT_INVOICE_CODE))
            .andExpect(jsonPath("$.productPrice").value(sameNumber(DEFAULT_PRODUCT_PRICE)))
            .andExpect(jsonPath("$.productPriceUsd").value(sameNumber(DEFAULT_PRODUCT_PRICE_USD)))
            .andExpect(jsonPath("$.deliveryPrice").value(sameNumber(DEFAULT_DELIVERY_PRICE)))
            .andExpect(jsonPath("$.deliveryPriceUsd").value(sameNumber(DEFAULT_DELIVERY_PRICE_USD)))
            .andExpect(jsonPath("$.discProductPrice").value(sameNumber(DEFAULT_DISC_PRODUCT_PRICE)))
            .andExpect(jsonPath("$.discProductPriceUsd").value(sameNumber(DEFAULT_DISC_PRODUCT_PRICE_USD)))
            .andExpect(jsonPath("$.discDeliveryPrice").value(sameNumber(DEFAULT_DISC_DELIVERY_PRICE)))
            .andExpect(jsonPath("$.discDeliveryPriceUsd").value(sameNumber(DEFAULT_DISC_DELIVERY_PRICE_USD)))
            .andExpect(jsonPath("$.discCouponPrice").value(sameNumber(DEFAULT_DISC_COUPON_PRICE)))
            .andExpect(jsonPath("$.discCouponPriceUsd").value(sameNumber(DEFAULT_DISC_COUPON_PRICE_USD)))
            .andExpect(jsonPath("$.serviceFee").value(sameNumber(DEFAULT_SERVICE_FEE)))
            .andExpect(jsonPath("$.serviceFeeUsd").value(sameNumber(DEFAULT_SERVICE_FEE_USD)))
            .andExpect(jsonPath("$.totalPayment").value(sameNumber(DEFAULT_TOTAL_PAYMENT)))
            .andExpect(jsonPath("$.totalPaymentUsd").value(sameNumber(DEFAULT_TOTAL_PAYMENT_USD)))
            .andExpect(jsonPath("$.paymentNumber").value(DEFAULT_PAYMENT_NUMBER))
            .andExpect(jsonPath("$.paymentQr").value(DEFAULT_PAYMENT_QR))
            .andExpect(jsonPath("$.paymentLink").value(DEFAULT_PAYMENT_LINK))
            .andExpect(jsonPath("$.paymentStatus").value(DEFAULT_PAYMENT_STATUS))
            .andExpect(jsonPath("$.paymentExpired").value(DEFAULT_PAYMENT_EXPIRED.toString()))
            .andExpect(jsonPath("$.paymentReferenceId").value(DEFAULT_PAYMENT_REFERENCE_ID))
            .andExpect(jsonPath("$.paidedAt").value(DEFAULT_PAIDED_AT.toString()))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY.intValue()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()))
            .andExpect(jsonPath("$.updatedBy").value(DEFAULT_UPDATED_BY.intValue()));
    }

    @Test
    @Transactional
    void getNonExistingTransaction() throws Exception {
        // Get the transaction
        restTransactionMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    protected long getRepositoryCount() {
        return transactionRepository.count();
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

    protected Transaction getPersistedTransaction(Transaction transaction) {
        return transactionRepository.findById(transaction.getId()).orElseThrow();
    }

    protected void assertPersistedTransactionToMatchAllProperties(Transaction expectedTransaction) {
        assertTransactionAllPropertiesEquals(expectedTransaction, getPersistedTransaction(expectedTransaction));
    }

    protected void assertPersistedTransactionToMatchUpdatableProperties(Transaction expectedTransaction) {
        assertTransactionAllUpdatablePropertiesEquals(expectedTransaction, getPersistedTransaction(expectedTransaction));
    }
}
