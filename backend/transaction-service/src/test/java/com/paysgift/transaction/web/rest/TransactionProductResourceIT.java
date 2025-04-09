package com.paysgift.transaction.web.rest;

import static com.paysgift.transaction.domain.TransactionProductAsserts.*;
import static com.paysgift.transaction.web.rest.TestUtil.sameNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paysgift.transaction.IntegrationTest;
import com.paysgift.transaction.domain.TransactionProduct;
import com.paysgift.transaction.repository.TransactionProductRepository;
import com.paysgift.transaction.service.mapper.TransactionProductMapper;
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
 * Integration tests for the {@link TransactionProductResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class TransactionProductResourceIT {

    private static final Long DEFAULT_TRANSACTION_ID = 1L;
    private static final Long UPDATED_TRANSACTION_ID = 2L;

    private static final Long DEFAULT_TRANSACTION_SEND_ID = 1L;
    private static final Long UPDATED_TRANSACTION_SEND_ID = 2L;

    private static final Long DEFAULT_PRODUCT_ID = 1L;
    private static final Long UPDATED_PRODUCT_ID = 2L;

    private static final Long DEFAULT_COUNTRY_ID = 1L;
    private static final Long UPDATED_COUNTRY_ID = 2L;

    private static final Long DEFAULT_BRAND_ID = 1L;
    private static final Long UPDATED_BRAND_ID = 2L;

    private static final String DEFAULT_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_PARENT_CODE = "AAAAAAAAAA";
    private static final String UPDATED_PARENT_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_SKU_CODE = "AAAAAAAAAA";
    private static final String UPDATED_SKU_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_NAME_EN = "AAAAAAAAAA";
    private static final String UPDATED_NAME_EN = "BBBBBBBBBB";

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final String DEFAULT_DESCRIPTION_EN = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION_EN = "BBBBBBBBBB";

    private static final String DEFAULT_TNC = "AAAAAAAAAA";
    private static final String UPDATED_TNC = "BBBBBBBBBB";

    private static final String DEFAULT_TNC_EN = "AAAAAAAAAA";
    private static final String UPDATED_TNC_EN = "BBBBBBBBBB";

    private static final String DEFAULT_HOW_TO_CLAIM = "AAAAAAAAAA";
    private static final String UPDATED_HOW_TO_CLAIM = "BBBBBBBBBB";

    private static final String DEFAULT_HOW_TO_CLAIM_EN = "AAAAAAAAAA";
    private static final String UPDATED_HOW_TO_CLAIM_EN = "BBBBBBBBBB";

    private static final String DEFAULT_IMAGE = "AAAAAAAAAA";
    private static final String UPDATED_IMAGE = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_DENOM = new BigDecimal(1);
    private static final BigDecimal UPDATED_DENOM = new BigDecimal(2);

    private static final BigDecimal DEFAULT_BUYING_PRICE = new BigDecimal(1);
    private static final BigDecimal UPDATED_BUYING_PRICE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_BUYING_PRICE_USD = new BigDecimal(1);
    private static final BigDecimal UPDATED_BUYING_PRICE_USD = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PRICE = new BigDecimal(1);
    private static final BigDecimal UPDATED_PRICE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PRICE_USD = new BigDecimal(1);
    private static final BigDecimal UPDATED_PRICE_USD = new BigDecimal(2);

    private static final BigDecimal DEFAULT_DISC_PRICE = new BigDecimal(1);
    private static final BigDecimal UPDATED_DISC_PRICE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_DISC_PRICE_USD = new BigDecimal(1);
    private static final BigDecimal UPDATED_DISC_PRICE_USD = new BigDecimal(2);

    private static final BigDecimal DEFAULT_TOTAL_PRICE = new BigDecimal(1);
    private static final BigDecimal UPDATED_TOTAL_PRICE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_TOTAL_PRICE_USD = new BigDecimal(1);
    private static final BigDecimal UPDATED_TOTAL_PRICE_USD = new BigDecimal(2);

    private static final Boolean DEFAULT_IS_DELIVERY = false;
    private static final Boolean UPDATED_IS_DELIVERY = true;

    private static final Boolean DEFAULT_PAYMENT_STATUS = false;
    private static final Boolean UPDATED_PAYMENT_STATUS = true;

    private static final Boolean DEFAULT_STATUS = false;
    private static final Boolean UPDATED_STATUS = true;

    private static final Boolean DEFAULT_IS_CODE = false;
    private static final Boolean UPDATED_IS_CODE = true;

    private static final String DEFAULT_VOUCHER_LINK = "AAAAAAAAAA";
    private static final String UPDATED_VOUCHER_LINK = "BBBBBBBBBB";

    private static final String DEFAULT_VOUCHER_CODE = "AAAAAAAAAA";
    private static final String UPDATED_VOUCHER_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_VOUCHER_PIN = "AAAAAAAAAA";
    private static final String UPDATED_VOUCHER_PIN = "BBBBBBBBBB";

    private static final String DEFAULT_VOUCHER_ISSUANCE = "AAAAAAAAAA";
    private static final String UPDATED_VOUCHER_ISSUANCE = "BBBBBBBBBB";

    private static final Instant DEFAULT_VOUCHER_EXPIRED = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_VOUCHER_EXPIRED = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_VOUCHER_REFERENCE = "AAAAAAAAAA";
    private static final String UPDATED_VOUCHER_REFERENCE = "BBBBBBBBBB";

    private static final String DEFAULT_REFERENCE_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_REFERENCE_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_ERROR_CODE = "AAAAAAAAAA";
    private static final String UPDATED_ERROR_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_ERROR_REASON = "AAAAAAAAAA";
    private static final String UPDATED_ERROR_REASON = "BBBBBBBBBB";

    private static final Boolean DEFAULT_RETRY = false;
    private static final Boolean UPDATED_RETRY = true;

    private static final Boolean DEFAULT_BLIBLI_ITEM_ID = false;
    private static final Boolean UPDATED_BLIBLI_ITEM_ID = true;

    private static final Instant DEFAULT_CREATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_CREATED_BY = 1L;
    private static final Long UPDATED_CREATED_BY = 2L;

    private static final Instant DEFAULT_UPDATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_UPDATED_BY = 1L;
    private static final Long UPDATED_UPDATED_BY = 2L;

    private static final String ENTITY_API_URL = "/api/transaction-products";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    @Autowired
    private ObjectMapper om;

    @Autowired
    private TransactionProductRepository transactionProductRepository;

    @Autowired
    private TransactionProductMapper transactionProductMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restTransactionProductMockMvc;

    private TransactionProduct transactionProduct;

    private TransactionProduct insertedTransactionProduct;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static TransactionProduct createEntity() {
        return new TransactionProduct()
            .transactionId(DEFAULT_TRANSACTION_ID)
            .transactionSendId(DEFAULT_TRANSACTION_SEND_ID)
            .productId(DEFAULT_PRODUCT_ID)
            .countryId(DEFAULT_COUNTRY_ID)
            .brandId(DEFAULT_BRAND_ID)
            .code(DEFAULT_CODE)
            .parentCode(DEFAULT_PARENT_CODE)
            .skuCode(DEFAULT_SKU_CODE)
            .name(DEFAULT_NAME)
            .nameEn(DEFAULT_NAME_EN)
            .description(DEFAULT_DESCRIPTION)
            .descriptionEn(DEFAULT_DESCRIPTION_EN)
            .tnc(DEFAULT_TNC)
            .tncEn(DEFAULT_TNC_EN)
            .howToClaim(DEFAULT_HOW_TO_CLAIM)
            .howToClaimEn(DEFAULT_HOW_TO_CLAIM_EN)
            .image(DEFAULT_IMAGE)
            .denom(DEFAULT_DENOM)
            .buyingPrice(DEFAULT_BUYING_PRICE)
            .buyingPriceUsd(DEFAULT_BUYING_PRICE_USD)
            .price(DEFAULT_PRICE)
            .priceUsd(DEFAULT_PRICE_USD)
            .discPrice(DEFAULT_DISC_PRICE)
            .discPriceUsd(DEFAULT_DISC_PRICE_USD)
            .totalPrice(DEFAULT_TOTAL_PRICE)
            .totalPriceUsd(DEFAULT_TOTAL_PRICE_USD)
            .isDelivery(DEFAULT_IS_DELIVERY)
            .paymentStatus(DEFAULT_PAYMENT_STATUS)
            .status(DEFAULT_STATUS)
            .isCode(DEFAULT_IS_CODE)
            .voucherLink(DEFAULT_VOUCHER_LINK)
            .voucherCode(DEFAULT_VOUCHER_CODE)
            .voucherPin(DEFAULT_VOUCHER_PIN)
            .voucherIssuance(DEFAULT_VOUCHER_ISSUANCE)
            .voucherExpired(DEFAULT_VOUCHER_EXPIRED)
            .voucherReference(DEFAULT_VOUCHER_REFERENCE)
            .referenceNumber(DEFAULT_REFERENCE_NUMBER)
            .errorCode(DEFAULT_ERROR_CODE)
            .errorReason(DEFAULT_ERROR_REASON)
            .retry(DEFAULT_RETRY)
            .blibliItemId(DEFAULT_BLIBLI_ITEM_ID)
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
    public static TransactionProduct createUpdatedEntity() {
        return new TransactionProduct()
            .transactionId(UPDATED_TRANSACTION_ID)
            .transactionSendId(UPDATED_TRANSACTION_SEND_ID)
            .productId(UPDATED_PRODUCT_ID)
            .countryId(UPDATED_COUNTRY_ID)
            .brandId(UPDATED_BRAND_ID)
            .code(UPDATED_CODE)
            .parentCode(UPDATED_PARENT_CODE)
            .skuCode(UPDATED_SKU_CODE)
            .name(UPDATED_NAME)
            .nameEn(UPDATED_NAME_EN)
            .description(UPDATED_DESCRIPTION)
            .descriptionEn(UPDATED_DESCRIPTION_EN)
            .tnc(UPDATED_TNC)
            .tncEn(UPDATED_TNC_EN)
            .howToClaim(UPDATED_HOW_TO_CLAIM)
            .howToClaimEn(UPDATED_HOW_TO_CLAIM_EN)
            .image(UPDATED_IMAGE)
            .denom(UPDATED_DENOM)
            .buyingPrice(UPDATED_BUYING_PRICE)
            .buyingPriceUsd(UPDATED_BUYING_PRICE_USD)
            .price(UPDATED_PRICE)
            .priceUsd(UPDATED_PRICE_USD)
            .discPrice(UPDATED_DISC_PRICE)
            .discPriceUsd(UPDATED_DISC_PRICE_USD)
            .totalPrice(UPDATED_TOTAL_PRICE)
            .totalPriceUsd(UPDATED_TOTAL_PRICE_USD)
            .isDelivery(UPDATED_IS_DELIVERY)
            .paymentStatus(UPDATED_PAYMENT_STATUS)
            .status(UPDATED_STATUS)
            .isCode(UPDATED_IS_CODE)
            .voucherLink(UPDATED_VOUCHER_LINK)
            .voucherCode(UPDATED_VOUCHER_CODE)
            .voucherPin(UPDATED_VOUCHER_PIN)
            .voucherIssuance(UPDATED_VOUCHER_ISSUANCE)
            .voucherExpired(UPDATED_VOUCHER_EXPIRED)
            .voucherReference(UPDATED_VOUCHER_REFERENCE)
            .referenceNumber(UPDATED_REFERENCE_NUMBER)
            .errorCode(UPDATED_ERROR_CODE)
            .errorReason(UPDATED_ERROR_REASON)
            .retry(UPDATED_RETRY)
            .blibliItemId(UPDATED_BLIBLI_ITEM_ID)
            .createdAt(UPDATED_CREATED_AT)
            .createdBy(UPDATED_CREATED_BY)
            .updatedAt(UPDATED_UPDATED_AT)
            .updatedBy(UPDATED_UPDATED_BY);
    }

    @BeforeEach
    void initTest() {
        transactionProduct = createEntity();
    }

    @AfterEach
    void cleanup() {
        if (insertedTransactionProduct != null) {
            transactionProductRepository.delete(insertedTransactionProduct);
            insertedTransactionProduct = null;
        }
    }

    @Test
    @Transactional
    void getAllTransactionProducts() throws Exception {
        // Initialize the database
        insertedTransactionProduct = transactionProductRepository.saveAndFlush(transactionProduct);

        // Get all the transactionProductList
        restTransactionProductMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(transactionProduct.getId().intValue())))
            .andExpect(jsonPath("$.[*].transactionId").value(hasItem(DEFAULT_TRANSACTION_ID.intValue())))
            .andExpect(jsonPath("$.[*].transactionSendId").value(hasItem(DEFAULT_TRANSACTION_SEND_ID.intValue())))
            .andExpect(jsonPath("$.[*].productId").value(hasItem(DEFAULT_PRODUCT_ID.intValue())))
            .andExpect(jsonPath("$.[*].countryId").value(hasItem(DEFAULT_COUNTRY_ID.intValue())))
            .andExpect(jsonPath("$.[*].brandId").value(hasItem(DEFAULT_BRAND_ID.intValue())))
            .andExpect(jsonPath("$.[*].code").value(hasItem(DEFAULT_CODE)))
            .andExpect(jsonPath("$.[*].parentCode").value(hasItem(DEFAULT_PARENT_CODE)))
            .andExpect(jsonPath("$.[*].skuCode").value(hasItem(DEFAULT_SKU_CODE)))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME)))
            .andExpect(jsonPath("$.[*].nameEn").value(hasItem(DEFAULT_NAME_EN)))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION)))
            .andExpect(jsonPath("$.[*].descriptionEn").value(hasItem(DEFAULT_DESCRIPTION_EN)))
            .andExpect(jsonPath("$.[*].tnc").value(hasItem(DEFAULT_TNC)))
            .andExpect(jsonPath("$.[*].tncEn").value(hasItem(DEFAULT_TNC_EN)))
            .andExpect(jsonPath("$.[*].howToClaim").value(hasItem(DEFAULT_HOW_TO_CLAIM)))
            .andExpect(jsonPath("$.[*].howToClaimEn").value(hasItem(DEFAULT_HOW_TO_CLAIM_EN)))
            .andExpect(jsonPath("$.[*].image").value(hasItem(DEFAULT_IMAGE)))
            .andExpect(jsonPath("$.[*].denom").value(hasItem(sameNumber(DEFAULT_DENOM))))
            .andExpect(jsonPath("$.[*].buyingPrice").value(hasItem(sameNumber(DEFAULT_BUYING_PRICE))))
            .andExpect(jsonPath("$.[*].buyingPriceUsd").value(hasItem(sameNumber(DEFAULT_BUYING_PRICE_USD))))
            .andExpect(jsonPath("$.[*].price").value(hasItem(sameNumber(DEFAULT_PRICE))))
            .andExpect(jsonPath("$.[*].priceUsd").value(hasItem(sameNumber(DEFAULT_PRICE_USD))))
            .andExpect(jsonPath("$.[*].discPrice").value(hasItem(sameNumber(DEFAULT_DISC_PRICE))))
            .andExpect(jsonPath("$.[*].discPriceUsd").value(hasItem(sameNumber(DEFAULT_DISC_PRICE_USD))))
            .andExpect(jsonPath("$.[*].totalPrice").value(hasItem(sameNumber(DEFAULT_TOTAL_PRICE))))
            .andExpect(jsonPath("$.[*].totalPriceUsd").value(hasItem(sameNumber(DEFAULT_TOTAL_PRICE_USD))))
            .andExpect(jsonPath("$.[*].isDelivery").value(hasItem(DEFAULT_IS_DELIVERY)))
            .andExpect(jsonPath("$.[*].paymentStatus").value(hasItem(DEFAULT_PAYMENT_STATUS)))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].isCode").value(hasItem(DEFAULT_IS_CODE)))
            .andExpect(jsonPath("$.[*].voucherLink").value(hasItem(DEFAULT_VOUCHER_LINK)))
            .andExpect(jsonPath("$.[*].voucherCode").value(hasItem(DEFAULT_VOUCHER_CODE)))
            .andExpect(jsonPath("$.[*].voucherPin").value(hasItem(DEFAULT_VOUCHER_PIN)))
            .andExpect(jsonPath("$.[*].voucherIssuance").value(hasItem(DEFAULT_VOUCHER_ISSUANCE)))
            .andExpect(jsonPath("$.[*].voucherExpired").value(hasItem(DEFAULT_VOUCHER_EXPIRED.toString())))
            .andExpect(jsonPath("$.[*].voucherReference").value(hasItem(DEFAULT_VOUCHER_REFERENCE)))
            .andExpect(jsonPath("$.[*].referenceNumber").value(hasItem(DEFAULT_REFERENCE_NUMBER)))
            .andExpect(jsonPath("$.[*].errorCode").value(hasItem(DEFAULT_ERROR_CODE)))
            .andExpect(jsonPath("$.[*].errorReason").value(hasItem(DEFAULT_ERROR_REASON)))
            .andExpect(jsonPath("$.[*].retry").value(hasItem(DEFAULT_RETRY)))
            .andExpect(jsonPath("$.[*].blibliItemId").value(hasItem(DEFAULT_BLIBLI_ITEM_ID)))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY.intValue())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedBy").value(hasItem(DEFAULT_UPDATED_BY.intValue())));
    }

    @Test
    @Transactional
    void getTransactionProduct() throws Exception {
        // Initialize the database
        insertedTransactionProduct = transactionProductRepository.saveAndFlush(transactionProduct);

        // Get the transactionProduct
        restTransactionProductMockMvc
            .perform(get(ENTITY_API_URL_ID, transactionProduct.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(transactionProduct.getId().intValue()))
            .andExpect(jsonPath("$.transactionId").value(DEFAULT_TRANSACTION_ID.intValue()))
            .andExpect(jsonPath("$.transactionSendId").value(DEFAULT_TRANSACTION_SEND_ID.intValue()))
            .andExpect(jsonPath("$.productId").value(DEFAULT_PRODUCT_ID.intValue()))
            .andExpect(jsonPath("$.countryId").value(DEFAULT_COUNTRY_ID.intValue()))
            .andExpect(jsonPath("$.brandId").value(DEFAULT_BRAND_ID.intValue()))
            .andExpect(jsonPath("$.code").value(DEFAULT_CODE))
            .andExpect(jsonPath("$.parentCode").value(DEFAULT_PARENT_CODE))
            .andExpect(jsonPath("$.skuCode").value(DEFAULT_SKU_CODE))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.nameEn").value(DEFAULT_NAME_EN))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION))
            .andExpect(jsonPath("$.descriptionEn").value(DEFAULT_DESCRIPTION_EN))
            .andExpect(jsonPath("$.tnc").value(DEFAULT_TNC))
            .andExpect(jsonPath("$.tncEn").value(DEFAULT_TNC_EN))
            .andExpect(jsonPath("$.howToClaim").value(DEFAULT_HOW_TO_CLAIM))
            .andExpect(jsonPath("$.howToClaimEn").value(DEFAULT_HOW_TO_CLAIM_EN))
            .andExpect(jsonPath("$.image").value(DEFAULT_IMAGE))
            .andExpect(jsonPath("$.denom").value(sameNumber(DEFAULT_DENOM)))
            .andExpect(jsonPath("$.buyingPrice").value(sameNumber(DEFAULT_BUYING_PRICE)))
            .andExpect(jsonPath("$.buyingPriceUsd").value(sameNumber(DEFAULT_BUYING_PRICE_USD)))
            .andExpect(jsonPath("$.price").value(sameNumber(DEFAULT_PRICE)))
            .andExpect(jsonPath("$.priceUsd").value(sameNumber(DEFAULT_PRICE_USD)))
            .andExpect(jsonPath("$.discPrice").value(sameNumber(DEFAULT_DISC_PRICE)))
            .andExpect(jsonPath("$.discPriceUsd").value(sameNumber(DEFAULT_DISC_PRICE_USD)))
            .andExpect(jsonPath("$.totalPrice").value(sameNumber(DEFAULT_TOTAL_PRICE)))
            .andExpect(jsonPath("$.totalPriceUsd").value(sameNumber(DEFAULT_TOTAL_PRICE_USD)))
            .andExpect(jsonPath("$.isDelivery").value(DEFAULT_IS_DELIVERY))
            .andExpect(jsonPath("$.paymentStatus").value(DEFAULT_PAYMENT_STATUS))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS))
            .andExpect(jsonPath("$.isCode").value(DEFAULT_IS_CODE))
            .andExpect(jsonPath("$.voucherLink").value(DEFAULT_VOUCHER_LINK))
            .andExpect(jsonPath("$.voucherCode").value(DEFAULT_VOUCHER_CODE))
            .andExpect(jsonPath("$.voucherPin").value(DEFAULT_VOUCHER_PIN))
            .andExpect(jsonPath("$.voucherIssuance").value(DEFAULT_VOUCHER_ISSUANCE))
            .andExpect(jsonPath("$.voucherExpired").value(DEFAULT_VOUCHER_EXPIRED.toString()))
            .andExpect(jsonPath("$.voucherReference").value(DEFAULT_VOUCHER_REFERENCE))
            .andExpect(jsonPath("$.referenceNumber").value(DEFAULT_REFERENCE_NUMBER))
            .andExpect(jsonPath("$.errorCode").value(DEFAULT_ERROR_CODE))
            .andExpect(jsonPath("$.errorReason").value(DEFAULT_ERROR_REASON))
            .andExpect(jsonPath("$.retry").value(DEFAULT_RETRY))
            .andExpect(jsonPath("$.blibliItemId").value(DEFAULT_BLIBLI_ITEM_ID))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY.intValue()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()))
            .andExpect(jsonPath("$.updatedBy").value(DEFAULT_UPDATED_BY.intValue()));
    }

    @Test
    @Transactional
    void getNonExistingTransactionProduct() throws Exception {
        // Get the transactionProduct
        restTransactionProductMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    protected long getRepositoryCount() {
        return transactionProductRepository.count();
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

    protected TransactionProduct getPersistedTransactionProduct(TransactionProduct transactionProduct) {
        return transactionProductRepository.findById(transactionProduct.getId()).orElseThrow();
    }

    protected void assertPersistedTransactionProductToMatchAllProperties(TransactionProduct expectedTransactionProduct) {
        assertTransactionProductAllPropertiesEquals(expectedTransactionProduct, getPersistedTransactionProduct(expectedTransactionProduct));
    }

    protected void assertPersistedTransactionProductToMatchUpdatableProperties(TransactionProduct expectedTransactionProduct) {
        assertTransactionProductAllUpdatablePropertiesEquals(
            expectedTransactionProduct,
            getPersistedTransactionProduct(expectedTransactionProduct)
        );
    }
}
