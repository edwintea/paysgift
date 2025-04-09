package com.paysgift.paymentservice.web.rest;

import static com.paysgift.paymentservice.domain.DanaOrderAsserts.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paysgift.paymentservice.IntegrationTest;
import com.paysgift.paymentservice.domain.DanaOrder;
import com.paysgift.paymentservice.repository.DanaOrderRepository;
import com.paysgift.paymentservice.service.mapper.DanaOrderMapper;
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
 * Integration tests for the {@link DanaOrderResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class DanaOrderResourceIT {

    private static final String DEFAULT_VERSION = "AAAAAAAAAA";
    private static final String UPDATED_VERSION = "BBBBBBBBBB";

    private static final String DEFAULT_FUNCTION_NAME = "AAAAAAAAAA";
    private static final String UPDATED_FUNCTION_NAME = "BBBBBBBBBB";

    private static final Instant DEFAULT_REQ_TIME = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_REQ_TIME = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_RESP_TIME = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_RESP_TIME = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Boolean DEFAULT_IS_ACTIVE = false;
    private static final Boolean UPDATED_IS_ACTIVE = true;

    private static final String DEFAULT_REQ_MSG_ID = "AAAAAAAAAA";
    private static final String UPDATED_REQ_MSG_ID = "BBBBBBBBBB";

    private static final String DEFAULT_REQUEST_ID = "AAAAAAAAAA";
    private static final String UPDATED_REQUEST_ID = "BBBBBBBBBB";

    private static final String DEFAULT_ORDER_ID = "AAAAAAAAAA";
    private static final String UPDATED_ORDER_ID = "BBBBBBBBBB";

    private static final String DEFAULT_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_MESSAGE = "AAAAAAAAAA";
    private static final String UPDATED_MESSAGE = "BBBBBBBBBB";

    private static final String DEFAULT_PRODUCT_ID = "AAAAAAAAAA";
    private static final String UPDATED_PRODUCT_ID = "BBBBBBBBBB";

    private static final String DEFAULT_ISSUANCE_ID = "AAAAAAAAAA";
    private static final String UPDATED_ISSUANCE_ID = "BBBBBBBBBB";

    private static final String DEFAULT_VOUCHER_CODE = "AAAAAAAAAA";
    private static final String UPDATED_VOUCHER_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_VOUCHER_PIN = "AAAAAAAAAA";
    private static final String UPDATED_VOUCHER_PIN = "BBBBBBBBBB";

    private static final Instant DEFAULT_ISSUANCE_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_ISSUANCE_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_EXPIRED_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_EXPIRED_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_EXTEND_INFO = "AAAAAAAAAA";
    private static final String UPDATED_EXTEND_INFO = "BBBBBBBBBB";

    private static final Instant DEFAULT_SEND_EMAIL_NOTIF = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_SEND_EMAIL_NOTIF = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_CREATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_CREATED_BY = 1L;
    private static final Long UPDATED_CREATED_BY = 2L;

    private static final Instant DEFAULT_UPDATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_UPDATED_BY = 1L;
    private static final Long UPDATED_UPDATED_BY = 2L;

    private static final String ENTITY_API_URL = "/api/dana-orders";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    @Autowired
    private ObjectMapper om;

    @Autowired
    private DanaOrderRepository danaOrderRepository;

    @Autowired
    private DanaOrderMapper danaOrderMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restDanaOrderMockMvc;

    private DanaOrder danaOrder;

    private DanaOrder insertedDanaOrder;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static DanaOrder createEntity() {
        return new DanaOrder()
            .version(DEFAULT_VERSION)
            .functionName(DEFAULT_FUNCTION_NAME)
            .reqTime(DEFAULT_REQ_TIME)
            .respTime(DEFAULT_RESP_TIME)
            .isActive(DEFAULT_IS_ACTIVE)
            .reqMsgId(DEFAULT_REQ_MSG_ID)
            .requestId(DEFAULT_REQUEST_ID)
            .orderId(DEFAULT_ORDER_ID)
            .code(DEFAULT_CODE)
            .status(DEFAULT_STATUS)
            .message(DEFAULT_MESSAGE)
            .productId(DEFAULT_PRODUCT_ID)
            .issuanceId(DEFAULT_ISSUANCE_ID)
            .voucherCode(DEFAULT_VOUCHER_CODE)
            .voucherPin(DEFAULT_VOUCHER_PIN)
            .issuanceDate(DEFAULT_ISSUANCE_DATE)
            .expiredDate(DEFAULT_EXPIRED_DATE)
            .extendInfo(DEFAULT_EXTEND_INFO)
            .sendEmailNotif(DEFAULT_SEND_EMAIL_NOTIF)
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
    public static DanaOrder createUpdatedEntity() {
        return new DanaOrder()
            .version(UPDATED_VERSION)
            .functionName(UPDATED_FUNCTION_NAME)
            .reqTime(UPDATED_REQ_TIME)
            .respTime(UPDATED_RESP_TIME)
            .isActive(UPDATED_IS_ACTIVE)
            .reqMsgId(UPDATED_REQ_MSG_ID)
            .requestId(UPDATED_REQUEST_ID)
            .orderId(UPDATED_ORDER_ID)
            .code(UPDATED_CODE)
            .status(UPDATED_STATUS)
            .message(UPDATED_MESSAGE)
            .productId(UPDATED_PRODUCT_ID)
            .issuanceId(UPDATED_ISSUANCE_ID)
            .voucherCode(UPDATED_VOUCHER_CODE)
            .voucherPin(UPDATED_VOUCHER_PIN)
            .issuanceDate(UPDATED_ISSUANCE_DATE)
            .expiredDate(UPDATED_EXPIRED_DATE)
            .extendInfo(UPDATED_EXTEND_INFO)
            .sendEmailNotif(UPDATED_SEND_EMAIL_NOTIF)
            .createdAt(UPDATED_CREATED_AT)
            .createdBy(UPDATED_CREATED_BY)
            .updatedAt(UPDATED_UPDATED_AT)
            .updatedBy(UPDATED_UPDATED_BY);
    }

    @BeforeEach
    void initTest() {
        danaOrder = createEntity();
    }

    @AfterEach
    void cleanup() {
        if (insertedDanaOrder != null) {
            danaOrderRepository.delete(insertedDanaOrder);
            insertedDanaOrder = null;
        }
    }

    @Test
    @Transactional
    void getAllDanaOrders() throws Exception {
        // Initialize the database
        insertedDanaOrder = danaOrderRepository.saveAndFlush(danaOrder);

        // Get all the danaOrderList
        restDanaOrderMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(danaOrder.getId().intValue())))
            .andExpect(jsonPath("$.[*].version").value(hasItem(DEFAULT_VERSION)))
            .andExpect(jsonPath("$.[*].functionName").value(hasItem(DEFAULT_FUNCTION_NAME)))
            .andExpect(jsonPath("$.[*].reqTime").value(hasItem(DEFAULT_REQ_TIME.toString())))
            .andExpect(jsonPath("$.[*].respTime").value(hasItem(DEFAULT_RESP_TIME.toString())))
            .andExpect(jsonPath("$.[*].isActive").value(hasItem(DEFAULT_IS_ACTIVE)))
            .andExpect(jsonPath("$.[*].reqMsgId").value(hasItem(DEFAULT_REQ_MSG_ID)))
            .andExpect(jsonPath("$.[*].requestId").value(hasItem(DEFAULT_REQUEST_ID)))
            .andExpect(jsonPath("$.[*].orderId").value(hasItem(DEFAULT_ORDER_ID)))
            .andExpect(jsonPath("$.[*].code").value(hasItem(DEFAULT_CODE)))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].message").value(hasItem(DEFAULT_MESSAGE)))
            .andExpect(jsonPath("$.[*].productId").value(hasItem(DEFAULT_PRODUCT_ID)))
            .andExpect(jsonPath("$.[*].issuanceId").value(hasItem(DEFAULT_ISSUANCE_ID)))
            .andExpect(jsonPath("$.[*].voucherCode").value(hasItem(DEFAULT_VOUCHER_CODE)))
            .andExpect(jsonPath("$.[*].voucherPin").value(hasItem(DEFAULT_VOUCHER_PIN)))
            .andExpect(jsonPath("$.[*].issuanceDate").value(hasItem(DEFAULT_ISSUANCE_DATE.toString())))
            .andExpect(jsonPath("$.[*].expiredDate").value(hasItem(DEFAULT_EXPIRED_DATE.toString())))
            .andExpect(jsonPath("$.[*].extendInfo").value(hasItem(DEFAULT_EXTEND_INFO)))
            .andExpect(jsonPath("$.[*].sendEmailNotif").value(hasItem(DEFAULT_SEND_EMAIL_NOTIF.toString())))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY.intValue())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedBy").value(hasItem(DEFAULT_UPDATED_BY.intValue())));
    }

    @Test
    @Transactional
    void getDanaOrder() throws Exception {
        // Initialize the database
        insertedDanaOrder = danaOrderRepository.saveAndFlush(danaOrder);

        // Get the danaOrder
        restDanaOrderMockMvc
            .perform(get(ENTITY_API_URL_ID, danaOrder.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(danaOrder.getId().intValue()))
            .andExpect(jsonPath("$.version").value(DEFAULT_VERSION))
            .andExpect(jsonPath("$.functionName").value(DEFAULT_FUNCTION_NAME))
            .andExpect(jsonPath("$.reqTime").value(DEFAULT_REQ_TIME.toString()))
            .andExpect(jsonPath("$.respTime").value(DEFAULT_RESP_TIME.toString()))
            .andExpect(jsonPath("$.isActive").value(DEFAULT_IS_ACTIVE))
            .andExpect(jsonPath("$.reqMsgId").value(DEFAULT_REQ_MSG_ID))
            .andExpect(jsonPath("$.requestId").value(DEFAULT_REQUEST_ID))
            .andExpect(jsonPath("$.orderId").value(DEFAULT_ORDER_ID))
            .andExpect(jsonPath("$.code").value(DEFAULT_CODE))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS))
            .andExpect(jsonPath("$.message").value(DEFAULT_MESSAGE))
            .andExpect(jsonPath("$.productId").value(DEFAULT_PRODUCT_ID))
            .andExpect(jsonPath("$.issuanceId").value(DEFAULT_ISSUANCE_ID))
            .andExpect(jsonPath("$.voucherCode").value(DEFAULT_VOUCHER_CODE))
            .andExpect(jsonPath("$.voucherPin").value(DEFAULT_VOUCHER_PIN))
            .andExpect(jsonPath("$.issuanceDate").value(DEFAULT_ISSUANCE_DATE.toString()))
            .andExpect(jsonPath("$.expiredDate").value(DEFAULT_EXPIRED_DATE.toString()))
            .andExpect(jsonPath("$.extendInfo").value(DEFAULT_EXTEND_INFO))
            .andExpect(jsonPath("$.sendEmailNotif").value(DEFAULT_SEND_EMAIL_NOTIF.toString()))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY.intValue()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()))
            .andExpect(jsonPath("$.updatedBy").value(DEFAULT_UPDATED_BY.intValue()));
    }

    @Test
    @Transactional
    void getNonExistingDanaOrder() throws Exception {
        // Get the danaOrder
        restDanaOrderMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    protected long getRepositoryCount() {
        return danaOrderRepository.count();
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

    protected DanaOrder getPersistedDanaOrder(DanaOrder danaOrder) {
        return danaOrderRepository.findById(danaOrder.getId()).orElseThrow();
    }

    protected void assertPersistedDanaOrderToMatchAllProperties(DanaOrder expectedDanaOrder) {
        assertDanaOrderAllPropertiesEquals(expectedDanaOrder, getPersistedDanaOrder(expectedDanaOrder));
    }

    protected void assertPersistedDanaOrderToMatchUpdatableProperties(DanaOrder expectedDanaOrder) {
        assertDanaOrderAllUpdatablePropertiesEquals(expectedDanaOrder, getPersistedDanaOrder(expectedDanaOrder));
    }
}
