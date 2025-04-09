package com.paysgift.productservice.web.rest;

import static com.paysgift.productservice.domain.CouponCodeAsserts.*;
import static com.paysgift.productservice.web.rest.TestUtil.sameNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paysgift.productservice.IntegrationTest;
import com.paysgift.productservice.domain.CouponCode;
import com.paysgift.productservice.repository.CouponCodeRepository;
import com.paysgift.productservice.service.mapper.CouponCodeMapper;
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
 * Integration tests for the {@link CouponCodeResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class CouponCodeResourceIT {

    private static final Long DEFAULT_COUPON_ID = 1L;
    private static final Long UPDATED_COUPON_ID = 2L;

    private static final Long DEFAULT_PRODUCT_ID = 1L;
    private static final Long UPDATED_PRODUCT_ID = 2L;

    private static final String DEFAULT_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CODE = "BBBBBBBBBB";

    private static final Boolean DEFAULT_USE_VALIDITY = false;
    private static final Boolean UPDATED_USE_VALIDITY = true;

    private static final Instant DEFAULT_VALID_FROM = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_VALID_FROM = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_VALID_TO = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_VALID_TO = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Integer DEFAULT_COUNT = 1;
    private static final Integer UPDATED_COUNT = 2;

    private static final Integer DEFAULT_COUNT_REMAINING = 1;
    private static final Integer UPDATED_COUNT_REMAINING = 2;

    private static final Boolean DEFAULT_UNIQUE_PER_CUSTOMER = false;
    private static final Boolean UPDATED_UNIQUE_PER_CUSTOMER = true;

    private static final BigDecimal DEFAULT_SUBTOTAL = new BigDecimal(1);
    private static final BigDecimal UPDATED_SUBTOTAL = new BigDecimal(2);

    private static final String DEFAULT_DISCOUNT_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_DISCOUNT_TYPE = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_DISCOUNT_AMOUNT = new BigDecimal(1);
    private static final BigDecimal UPDATED_DISCOUNT_AMOUNT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_DISCOUNT_MAX_AMOUNT = new BigDecimal(1);
    private static final BigDecimal UPDATED_DISCOUNT_MAX_AMOUNT = new BigDecimal(2);

    private static final Boolean DEFAULT_IS_ACTIVE = false;
    private static final Boolean UPDATED_IS_ACTIVE = true;

    private static final Boolean DEFAULT_IS_DELETE = false;
    private static final Boolean UPDATED_IS_DELETE = true;

    private static final Instant DEFAULT_CREATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_CREATED_BY = 1L;
    private static final Long UPDATED_CREATED_BY = 2L;

    private static final Instant DEFAULT_UPDATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_UPDATED_BY = 1L;
    private static final Long UPDATED_UPDATED_BY = 2L;

    private static final String ENTITY_API_URL = "/api/coupon-codes";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    @Autowired
    private ObjectMapper om;

    @Autowired
    private CouponCodeRepository couponCodeRepository;

    @Autowired
    private CouponCodeMapper couponCodeMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restCouponCodeMockMvc;

    private CouponCode couponCode;

    private CouponCode insertedCouponCode;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static CouponCode createEntity() {
        return new CouponCode()
            .couponId(DEFAULT_COUPON_ID)
            .productId(DEFAULT_PRODUCT_ID)
            .code(DEFAULT_CODE)
            .useValidity(DEFAULT_USE_VALIDITY)
            .validFrom(DEFAULT_VALID_FROM)
            .validTo(DEFAULT_VALID_TO)
            .count(DEFAULT_COUNT)
            .countRemaining(DEFAULT_COUNT_REMAINING)
            .uniquePerCustomer(DEFAULT_UNIQUE_PER_CUSTOMER)
            .subtotal(DEFAULT_SUBTOTAL)
            .discountType(DEFAULT_DISCOUNT_TYPE)
            .discountAmount(DEFAULT_DISCOUNT_AMOUNT)
            .discountMaxAmount(DEFAULT_DISCOUNT_MAX_AMOUNT)
            .isActive(DEFAULT_IS_ACTIVE)
            .isDelete(DEFAULT_IS_DELETE)
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
    public static CouponCode createUpdatedEntity() {
        return new CouponCode()
            .couponId(UPDATED_COUPON_ID)
            .productId(UPDATED_PRODUCT_ID)
            .code(UPDATED_CODE)
            .useValidity(UPDATED_USE_VALIDITY)
            .validFrom(UPDATED_VALID_FROM)
            .validTo(UPDATED_VALID_TO)
            .count(UPDATED_COUNT)
            .countRemaining(UPDATED_COUNT_REMAINING)
            .uniquePerCustomer(UPDATED_UNIQUE_PER_CUSTOMER)
            .subtotal(UPDATED_SUBTOTAL)
            .discountType(UPDATED_DISCOUNT_TYPE)
            .discountAmount(UPDATED_DISCOUNT_AMOUNT)
            .discountMaxAmount(UPDATED_DISCOUNT_MAX_AMOUNT)
            .isActive(UPDATED_IS_ACTIVE)
            .isDelete(UPDATED_IS_DELETE)
            .createdAt(UPDATED_CREATED_AT)
            .createdBy(UPDATED_CREATED_BY)
            .updatedAt(UPDATED_UPDATED_AT)
            .updatedBy(UPDATED_UPDATED_BY);
    }

    @BeforeEach
    public void initTest() {
        couponCode = createEntity();
    }

    @AfterEach
    public void cleanup() {
        if (insertedCouponCode != null) {
            couponCodeRepository.delete(insertedCouponCode);
            insertedCouponCode = null;
        }
    }

    @Test
    @Transactional
    void getAllCouponCodes() throws Exception {
        // Initialize the database
        insertedCouponCode = couponCodeRepository.saveAndFlush(couponCode);

        // Get all the couponCodeList
        restCouponCodeMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(couponCode.getId().intValue())))
            .andExpect(jsonPath("$.[*].couponId").value(hasItem(DEFAULT_COUPON_ID.intValue())))
            .andExpect(jsonPath("$.[*].productId").value(hasItem(DEFAULT_PRODUCT_ID.intValue())))
            .andExpect(jsonPath("$.[*].code").value(hasItem(DEFAULT_CODE)))
            .andExpect(jsonPath("$.[*].useValidity").value(hasItem(DEFAULT_USE_VALIDITY)))
            .andExpect(jsonPath("$.[*].validFrom").value(hasItem(DEFAULT_VALID_FROM.toString())))
            .andExpect(jsonPath("$.[*].validTo").value(hasItem(DEFAULT_VALID_TO.toString())))
            .andExpect(jsonPath("$.[*].count").value(hasItem(DEFAULT_COUNT)))
            .andExpect(jsonPath("$.[*].countRemaining").value(hasItem(DEFAULT_COUNT_REMAINING)))
            .andExpect(jsonPath("$.[*].uniquePerCustomer").value(hasItem(DEFAULT_UNIQUE_PER_CUSTOMER)))
            .andExpect(jsonPath("$.[*].subtotal").value(hasItem(sameNumber(DEFAULT_SUBTOTAL))))
            .andExpect(jsonPath("$.[*].discountType").value(hasItem(DEFAULT_DISCOUNT_TYPE)))
            .andExpect(jsonPath("$.[*].discountAmount").value(hasItem(sameNumber(DEFAULT_DISCOUNT_AMOUNT))))
            .andExpect(jsonPath("$.[*].discountMaxAmount").value(hasItem(sameNumber(DEFAULT_DISCOUNT_MAX_AMOUNT))))
            .andExpect(jsonPath("$.[*].isActive").value(hasItem(DEFAULT_IS_ACTIVE)))
            .andExpect(jsonPath("$.[*].isDelete").value(hasItem(DEFAULT_IS_DELETE)))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY.intValue())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedBy").value(hasItem(DEFAULT_UPDATED_BY.intValue())));
    }

    @Test
    @Transactional
    void getCouponCode() throws Exception {
        // Initialize the database
        insertedCouponCode = couponCodeRepository.saveAndFlush(couponCode);

        // Get the couponCode
        restCouponCodeMockMvc
            .perform(get(ENTITY_API_URL_ID, couponCode.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(couponCode.getId().intValue()))
            .andExpect(jsonPath("$.couponId").value(DEFAULT_COUPON_ID.intValue()))
            .andExpect(jsonPath("$.productId").value(DEFAULT_PRODUCT_ID.intValue()))
            .andExpect(jsonPath("$.code").value(DEFAULT_CODE))
            .andExpect(jsonPath("$.useValidity").value(DEFAULT_USE_VALIDITY))
            .andExpect(jsonPath("$.validFrom").value(DEFAULT_VALID_FROM.toString()))
            .andExpect(jsonPath("$.validTo").value(DEFAULT_VALID_TO.toString()))
            .andExpect(jsonPath("$.count").value(DEFAULT_COUNT))
            .andExpect(jsonPath("$.countRemaining").value(DEFAULT_COUNT_REMAINING))
            .andExpect(jsonPath("$.uniquePerCustomer").value(DEFAULT_UNIQUE_PER_CUSTOMER))
            .andExpect(jsonPath("$.subtotal").value(sameNumber(DEFAULT_SUBTOTAL)))
            .andExpect(jsonPath("$.discountType").value(DEFAULT_DISCOUNT_TYPE))
            .andExpect(jsonPath("$.discountAmount").value(sameNumber(DEFAULT_DISCOUNT_AMOUNT)))
            .andExpect(jsonPath("$.discountMaxAmount").value(sameNumber(DEFAULT_DISCOUNT_MAX_AMOUNT)))
            .andExpect(jsonPath("$.isActive").value(DEFAULT_IS_ACTIVE))
            .andExpect(jsonPath("$.isDelete").value(DEFAULT_IS_DELETE))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY.intValue()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()))
            .andExpect(jsonPath("$.updatedBy").value(DEFAULT_UPDATED_BY.intValue()));
    }

    @Test
    @Transactional
    void getNonExistingCouponCode() throws Exception {
        // Get the couponCode
        restCouponCodeMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    protected long getRepositoryCount() {
        return couponCodeRepository.count();
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

    protected CouponCode getPersistedCouponCode(CouponCode couponCode) {
        return couponCodeRepository.findById(couponCode.getId()).orElseThrow();
    }

    protected void assertPersistedCouponCodeToMatchAllProperties(CouponCode expectedCouponCode) {
        assertCouponCodeAllPropertiesEquals(expectedCouponCode, getPersistedCouponCode(expectedCouponCode));
    }

    protected void assertPersistedCouponCodeToMatchUpdatableProperties(CouponCode expectedCouponCode) {
        assertCouponCodeAllUpdatablePropertiesEquals(expectedCouponCode, getPersistedCouponCode(expectedCouponCode));
    }
}
