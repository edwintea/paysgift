package com.paysgift.productservice.web.rest;

import static com.paysgift.productservice.domain.ProductAsserts.*;
import static com.paysgift.productservice.web.rest.TestUtil.sameNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paysgift.productservice.IntegrationTest;
import com.paysgift.productservice.domain.Product;
import com.paysgift.productservice.repository.ProductRepository;
import com.paysgift.productservice.service.mapper.ProductMapper;
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
 * Integration tests for the {@link ProductResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class ProductResourceIT {

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

    private static final BigDecimal DEFAULT_DENOM = new BigDecimal(1);
    private static final BigDecimal UPDATED_DENOM = new BigDecimal(2);

    private static final BigDecimal DEFAULT_BUYING_PRICE = new BigDecimal(1);
    private static final BigDecimal UPDATED_BUYING_PRICE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_PRICE = new BigDecimal(1);
    private static final BigDecimal UPDATED_PRICE = new BigDecimal(2);

    private static final Boolean DEFAULT_IS_UNLIMITED = false;
    private static final Boolean UPDATED_IS_UNLIMITED = true;

    private static final Integer DEFAULT_QTY = 1;
    private static final Integer UPDATED_QTY = 2;

    private static final Integer DEFAULT_PURCHASE_QTY = 1;
    private static final Integer UPDATED_PURCHASE_QTY = 2;

    private static final Integer DEFAULT_REMAINING_QTY = 1;
    private static final Integer UPDATED_REMAINING_QTY = 2;

    private static final Integer DEFAULT_VALIDITY_PURCHASE = 1;
    private static final Integer UPDATED_VALIDITY_PURCHASE = 2;

    private static final Instant DEFAULT_VALIDITY_START_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_VALIDITY_START_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_VALIDITY_END_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_VALIDITY_END_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_TAG = "AAAAAAAAAA";
    private static final String UPDATED_TAG = "BBBBBBBBBB";

    private static final Boolean DEFAULT_IS_DELIVERY = false;
    private static final Boolean UPDATED_IS_DELIVERY = true;

    private static final Boolean DEFAULT_IS_ACTIVE = false;
    private static final Boolean UPDATED_IS_ACTIVE = true;

    private static final Boolean DEFAULT_IS_DELETE = false;
    private static final Boolean UPDATED_IS_DELETE = true;

    private static final String DEFAULT_PERMALINK = "AAAAAAAAAA";
    private static final String UPDATED_PERMALINK = "BBBBBBBBBB";

    private static final String DEFAULT_UPDATED_SYNC = "AAAAAAAAAA";
    private static final String UPDATED_UPDATED_SYNC = "BBBBBBBBBB";

    private static final Instant DEFAULT_CREATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_CREATED_BY = 1L;
    private static final Long UPDATED_CREATED_BY = 2L;

    private static final Instant DEFAULT_UPDATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_UPDATED_BY = 1L;
    private static final Long UPDATED_UPDATED_BY = 2L;

    private static final String ENTITY_API_URL = "/api/products";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    @Autowired
    private ObjectMapper om;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restProductMockMvc;

    private Product product;

    private Product insertedProduct;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Product createEntity() {
        return new Product()
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
            .denom(DEFAULT_DENOM)
            .buyingPrice(DEFAULT_BUYING_PRICE)
            .price(DEFAULT_PRICE)
            .isUnlimited(DEFAULT_IS_UNLIMITED)
            .qty(DEFAULT_QTY)
            .purchaseQty(DEFAULT_PURCHASE_QTY)
            .remainingQty(DEFAULT_REMAINING_QTY)
            .validityPurchase(DEFAULT_VALIDITY_PURCHASE)
            .validityStartDate(DEFAULT_VALIDITY_START_DATE)
            .validityEndDate(DEFAULT_VALIDITY_END_DATE)
            .tag(DEFAULT_TAG)
            .isDelivery(DEFAULT_IS_DELIVERY)
            .isActive(DEFAULT_IS_ACTIVE)
            .isDelete(DEFAULT_IS_DELETE)
            .permalink(DEFAULT_PERMALINK)
            .updatedSync(DEFAULT_UPDATED_SYNC)
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
    public static Product createUpdatedEntity() {
        return new Product()
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
            .denom(UPDATED_DENOM)
            .buyingPrice(UPDATED_BUYING_PRICE)
            .price(UPDATED_PRICE)
            .isUnlimited(UPDATED_IS_UNLIMITED)
            .qty(UPDATED_QTY)
            .purchaseQty(UPDATED_PURCHASE_QTY)
            .remainingQty(UPDATED_REMAINING_QTY)
            .validityPurchase(UPDATED_VALIDITY_PURCHASE)
            .validityStartDate(UPDATED_VALIDITY_START_DATE)
            .validityEndDate(UPDATED_VALIDITY_END_DATE)
            .tag(UPDATED_TAG)
            .isDelivery(UPDATED_IS_DELIVERY)
            .isActive(UPDATED_IS_ACTIVE)
            .isDelete(UPDATED_IS_DELETE)
            .permalink(UPDATED_PERMALINK)
            .updatedSync(UPDATED_UPDATED_SYNC)
            .createdAt(UPDATED_CREATED_AT)
            .createdBy(UPDATED_CREATED_BY)
            .updatedAt(UPDATED_UPDATED_AT)
            .updatedBy(UPDATED_UPDATED_BY);
    }

    @BeforeEach
    public void initTest() {
        product = createEntity();
    }

    @AfterEach
    public void cleanup() {
        if (insertedProduct != null) {
            productRepository.delete(insertedProduct);
            insertedProduct = null;
        }
    }

    @Test
    @Transactional
    void getAllProducts() throws Exception {
        // Initialize the database
        insertedProduct = productRepository.saveAndFlush(product);

        // Get all the productList
        restProductMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(product.getId().intValue())))
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
            .andExpect(jsonPath("$.[*].denom").value(hasItem(sameNumber(DEFAULT_DENOM))))
            .andExpect(jsonPath("$.[*].buyingPrice").value(hasItem(sameNumber(DEFAULT_BUYING_PRICE))))
            .andExpect(jsonPath("$.[*].price").value(hasItem(sameNumber(DEFAULT_PRICE))))
            .andExpect(jsonPath("$.[*].isUnlimited").value(hasItem(DEFAULT_IS_UNLIMITED)))
            .andExpect(jsonPath("$.[*].qty").value(hasItem(DEFAULT_QTY)))
            .andExpect(jsonPath("$.[*].purchaseQty").value(hasItem(DEFAULT_PURCHASE_QTY)))
            .andExpect(jsonPath("$.[*].remainingQty").value(hasItem(DEFAULT_REMAINING_QTY)))
            .andExpect(jsonPath("$.[*].validityPurchase").value(hasItem(DEFAULT_VALIDITY_PURCHASE)))
            .andExpect(jsonPath("$.[*].validityStartDate").value(hasItem(DEFAULT_VALIDITY_START_DATE.toString())))
            .andExpect(jsonPath("$.[*].validityEndDate").value(hasItem(DEFAULT_VALIDITY_END_DATE.toString())))
            .andExpect(jsonPath("$.[*].tag").value(hasItem(DEFAULT_TAG)))
            .andExpect(jsonPath("$.[*].isDelivery").value(hasItem(DEFAULT_IS_DELIVERY)))
            .andExpect(jsonPath("$.[*].isActive").value(hasItem(DEFAULT_IS_ACTIVE)))
            .andExpect(jsonPath("$.[*].isDelete").value(hasItem(DEFAULT_IS_DELETE)))
            .andExpect(jsonPath("$.[*].permalink").value(hasItem(DEFAULT_PERMALINK)))
            .andExpect(jsonPath("$.[*].updatedSync").value(hasItem(DEFAULT_UPDATED_SYNC)))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY.intValue())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedBy").value(hasItem(DEFAULT_UPDATED_BY.intValue())));
    }

    @Test
    @Transactional
    void getProduct() throws Exception {
        // Initialize the database
        insertedProduct = productRepository.saveAndFlush(product);

        // Get the product
        restProductMockMvc
            .perform(get(ENTITY_API_URL_ID, product.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(product.getId().intValue()))
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
            .andExpect(jsonPath("$.denom").value(sameNumber(DEFAULT_DENOM)))
            .andExpect(jsonPath("$.buyingPrice").value(sameNumber(DEFAULT_BUYING_PRICE)))
            .andExpect(jsonPath("$.price").value(sameNumber(DEFAULT_PRICE)))
            .andExpect(jsonPath("$.isUnlimited").value(DEFAULT_IS_UNLIMITED))
            .andExpect(jsonPath("$.qty").value(DEFAULT_QTY))
            .andExpect(jsonPath("$.purchaseQty").value(DEFAULT_PURCHASE_QTY))
            .andExpect(jsonPath("$.remainingQty").value(DEFAULT_REMAINING_QTY))
            .andExpect(jsonPath("$.validityPurchase").value(DEFAULT_VALIDITY_PURCHASE))
            .andExpect(jsonPath("$.validityStartDate").value(DEFAULT_VALIDITY_START_DATE.toString()))
            .andExpect(jsonPath("$.validityEndDate").value(DEFAULT_VALIDITY_END_DATE.toString()))
            .andExpect(jsonPath("$.tag").value(DEFAULT_TAG))
            .andExpect(jsonPath("$.isDelivery").value(DEFAULT_IS_DELIVERY))
            .andExpect(jsonPath("$.isActive").value(DEFAULT_IS_ACTIVE))
            .andExpect(jsonPath("$.isDelete").value(DEFAULT_IS_DELETE))
            .andExpect(jsonPath("$.permalink").value(DEFAULT_PERMALINK))
            .andExpect(jsonPath("$.updatedSync").value(DEFAULT_UPDATED_SYNC))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY.intValue()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()))
            .andExpect(jsonPath("$.updatedBy").value(DEFAULT_UPDATED_BY.intValue()));
    }

    @Test
    @Transactional
    void getNonExistingProduct() throws Exception {
        // Get the product
        restProductMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    protected long getRepositoryCount() {
        return productRepository.count();
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

    protected Product getPersistedProduct(Product product) {
        return productRepository.findById(product.getId()).orElseThrow();
    }

    protected void assertPersistedProductToMatchAllProperties(Product expectedProduct) {
        assertProductAllPropertiesEquals(expectedProduct, getPersistedProduct(expectedProduct));
    }

    protected void assertPersistedProductToMatchUpdatableProperties(Product expectedProduct) {
        assertProductAllUpdatablePropertiesEquals(expectedProduct, getPersistedProduct(expectedProduct));
    }
}
