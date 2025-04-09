package com.paysgift.transaction.web.rest;

import static com.paysgift.transaction.domain.TransactionSendAsserts.*;
import static com.paysgift.transaction.web.rest.TestUtil.sameNumber;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paysgift.transaction.IntegrationTest;
import com.paysgift.transaction.domain.TransactionSend;
import com.paysgift.transaction.repository.TransactionSendRepository;
import com.paysgift.transaction.service.mapper.TransactionSendMapper;
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
 * Integration tests for the {@link TransactionSendResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class TransactionSendResourceIT {

    private static final Long DEFAULT_TRANSACTION_ID = 1L;
    private static final Long UPDATED_TRANSACTION_ID = 2L;

    private static final String DEFAULT_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_PIN = "AAAAAAAAAA";
    private static final String UPDATED_PIN = "BBBBBBBBBB";

    private static final Long DEFAULT_STICKER_ID = 1L;
    private static final Long UPDATED_STICKER_ID = 2L;

    private static final String DEFAULT_SENDER_NAME = "AAAAAAAAAA";
    private static final String UPDATED_SENDER_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_MESSAGE = "AAAAAAAAAA";
    private static final String UPDATED_MESSAGE = "BBBBBBBBBB";

    private static final String DEFAULT_SEND_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_SEND_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_CONTACT_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_CONTACT_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_RECEPIENT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_RECEPIENT_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_RECEPIENT_CONTACT = "AAAAAAAAAA";
    private static final String UPDATED_RECEPIENT_CONTACT = "BBBBBBBBBB";

    private static final String DEFAULT_RECEPIENT_CONTACT_HASH = "AAAAAAAAAA";
    private static final String UPDATED_RECEPIENT_CONTACT_HASH = "BBBBBBBBBB";

    private static final Boolean DEFAULT_IS_IMMEDIATELY = false;
    private static final Boolean UPDATED_IS_IMMEDIATELY = true;

    private static final Instant DEFAULT_SEND_SCHEDULE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_SEND_SCHEDULE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_ADDRESS_LABEL = "AAAAAAAAAA";
    private static final String UPDATED_ADDRESS_LABEL = "BBBBBBBBBB";

    private static final Long DEFAULT_COUNTRY_ID = 1L;
    private static final Long UPDATED_COUNTRY_ID = 2L;

    private static final Long DEFAULT_PROVINCE_ID = 1L;
    private static final Long UPDATED_PROVINCE_ID = 2L;

    private static final Long DEFAULT_CITY_ID = 1L;
    private static final Long UPDATED_CITY_ID = 2L;

    private static final Long DEFAULT_DISTRICT_ID = 1L;
    private static final Long UPDATED_DISTRICT_ID = 2L;

    private static final Long DEFAULT_VILLAGE_ID = 1L;
    private static final Long UPDATED_VILLAGE_ID = 2L;

    private static final String DEFAULT_ZIPCODE = "AAAAAAAAAA";
    private static final String UPDATED_ZIPCODE = "BBBBBBBBBB";

    private static final String DEFAULT_ADDRESS = "AAAAAAAAAA";
    private static final String UPDATED_ADDRESS = "BBBBBBBBBB";

    private static final String DEFAULT_COURIER_NOTE = "AAAAAAAAAA";
    private static final String UPDATED_COURIER_NOTE = "BBBBBBBBBB";

    private static final String DEFAULT_LONGITUDE = "AAAAAAAAAA";
    private static final String UPDATED_LONGITUDE = "BBBBBBBBBB";

    private static final String DEFAULT_LATITUDE = "AAAAAAAAAA";
    private static final String UPDATED_LATITUDE = "BBBBBBBBBB";

    private static final String DEFAULT_REFERENCE_ID = "AAAAAAAAAA";
    private static final String UPDATED_REFERENCE_ID = "BBBBBBBBBB";

    private static final String DEFAULT_SEND_BY = "AAAAAAAAAA";
    private static final String UPDATED_SEND_BY = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_DELIVERY_PRICE = new BigDecimal(1);
    private static final BigDecimal UPDATED_DELIVERY_PRICE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_DELIVERY_PRICE_USD = new BigDecimal(1);
    private static final BigDecimal UPDATED_DELIVERY_PRICE_USD = new BigDecimal(2);

    private static final BigDecimal DEFAULT_DISC_DELIVERY_PRICE = new BigDecimal(1);
    private static final BigDecimal UPDATED_DISC_DELIVERY_PRICE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_DISC_DELIVERY_PRICE_USD = new BigDecimal(1);
    private static final BigDecimal UPDATED_DISC_DELIVERY_PRICE_USD = new BigDecimal(2);

    private static final BigDecimal DEFAULT_TOTAL_DELIVERY_PRICE = new BigDecimal(1);
    private static final BigDecimal UPDATED_TOTAL_DELIVERY_PRICE = new BigDecimal(2);

    private static final BigDecimal DEFAULT_TOTAL_DELIVERY_PRICE_USD = new BigDecimal(1);
    private static final BigDecimal UPDATED_TOTAL_DELIVERY_PRICE_USD = new BigDecimal(2);

    private static final String DEFAULT_STATUS_DELIVERY = "AAAAAAAAAA";
    private static final String UPDATED_STATUS_DELIVERY = "BBBBBBBBBB";

    private static final String DEFAULT_STATUS_REASON = "AAAAAAAAAA";
    private static final String UPDATED_STATUS_REASON = "BBBBBBBBBB";

    private static final String DEFAULT_BLIBLI_PACKAGE_ID = "AAAAAAAAAA";
    private static final String UPDATED_BLIBLI_PACKAGE_ID = "BBBBBBBBBB";

    private static final Boolean DEFAULT_TRY_OPEN = false;
    private static final Boolean UPDATED_TRY_OPEN = true;

    private static final Instant DEFAULT_CREATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_CREATED_BY = 1L;
    private static final Long UPDATED_CREATED_BY = 2L;

    private static final Instant DEFAULT_UPDATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_UPDATED_BY = 1L;
    private static final Long UPDATED_UPDATED_BY = 2L;

    private static final String ENTITY_API_URL = "/api/transaction-sends";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    @Autowired
    private ObjectMapper om;

    @Autowired
    private TransactionSendRepository transactionSendRepository;

    @Autowired
    private TransactionSendMapper transactionSendMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restTransactionSendMockMvc;

    private TransactionSend transactionSend;

    private TransactionSend insertedTransactionSend;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static TransactionSend createEntity() {
        return new TransactionSend()
            .transactionId(DEFAULT_TRANSACTION_ID)
            .code(DEFAULT_CODE)
            .pin(DEFAULT_PIN)
            .stickerId(DEFAULT_STICKER_ID)
            .senderName(DEFAULT_SENDER_NAME)
            .message(DEFAULT_MESSAGE)
            .sendType(DEFAULT_SEND_TYPE)
            .contactType(DEFAULT_CONTACT_TYPE)
            .recepientName(DEFAULT_RECEPIENT_NAME)
            .recepientContact(DEFAULT_RECEPIENT_CONTACT)
            .recepientContactHash(DEFAULT_RECEPIENT_CONTACT_HASH)
            .isImmediately(DEFAULT_IS_IMMEDIATELY)
            .sendSchedule(DEFAULT_SEND_SCHEDULE)
            .addressLabel(DEFAULT_ADDRESS_LABEL)
            .countryId(DEFAULT_COUNTRY_ID)
            .provinceId(DEFAULT_PROVINCE_ID)
            .cityId(DEFAULT_CITY_ID)
            .districtId(DEFAULT_DISTRICT_ID)
            .villageId(DEFAULT_VILLAGE_ID)
            .zipcode(DEFAULT_ZIPCODE)
            .address(DEFAULT_ADDRESS)
            .courierNote(DEFAULT_COURIER_NOTE)
            .longitude(DEFAULT_LONGITUDE)
            .latitude(DEFAULT_LATITUDE)
            .referenceId(DEFAULT_REFERENCE_ID)
            .sendBy(DEFAULT_SEND_BY)
            .deliveryPrice(DEFAULT_DELIVERY_PRICE)
            .deliveryPriceUsd(DEFAULT_DELIVERY_PRICE_USD)
            .discDeliveryPrice(DEFAULT_DISC_DELIVERY_PRICE)
            .discDeliveryPriceUsd(DEFAULT_DISC_DELIVERY_PRICE_USD)
            .totalDeliveryPrice(DEFAULT_TOTAL_DELIVERY_PRICE)
            .totalDeliveryPriceUsd(DEFAULT_TOTAL_DELIVERY_PRICE_USD)
            .statusDelivery(DEFAULT_STATUS_DELIVERY)
            .statusReason(DEFAULT_STATUS_REASON)
            .blibliPackageId(DEFAULT_BLIBLI_PACKAGE_ID)
            .tryOpen(DEFAULT_TRY_OPEN)
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
    public static TransactionSend createUpdatedEntity() {
        return new TransactionSend()
            .transactionId(UPDATED_TRANSACTION_ID)
            .code(UPDATED_CODE)
            .pin(UPDATED_PIN)
            .stickerId(UPDATED_STICKER_ID)
            .senderName(UPDATED_SENDER_NAME)
            .message(UPDATED_MESSAGE)
            .sendType(UPDATED_SEND_TYPE)
            .contactType(UPDATED_CONTACT_TYPE)
            .recepientName(UPDATED_RECEPIENT_NAME)
            .recepientContact(UPDATED_RECEPIENT_CONTACT)
            .recepientContactHash(UPDATED_RECEPIENT_CONTACT_HASH)
            .isImmediately(UPDATED_IS_IMMEDIATELY)
            .sendSchedule(UPDATED_SEND_SCHEDULE)
            .addressLabel(UPDATED_ADDRESS_LABEL)
            .countryId(UPDATED_COUNTRY_ID)
            .provinceId(UPDATED_PROVINCE_ID)
            .cityId(UPDATED_CITY_ID)
            .districtId(UPDATED_DISTRICT_ID)
            .villageId(UPDATED_VILLAGE_ID)
            .zipcode(UPDATED_ZIPCODE)
            .address(UPDATED_ADDRESS)
            .courierNote(UPDATED_COURIER_NOTE)
            .longitude(UPDATED_LONGITUDE)
            .latitude(UPDATED_LATITUDE)
            .referenceId(UPDATED_REFERENCE_ID)
            .sendBy(UPDATED_SEND_BY)
            .deliveryPrice(UPDATED_DELIVERY_PRICE)
            .deliveryPriceUsd(UPDATED_DELIVERY_PRICE_USD)
            .discDeliveryPrice(UPDATED_DISC_DELIVERY_PRICE)
            .discDeliveryPriceUsd(UPDATED_DISC_DELIVERY_PRICE_USD)
            .totalDeliveryPrice(UPDATED_TOTAL_DELIVERY_PRICE)
            .totalDeliveryPriceUsd(UPDATED_TOTAL_DELIVERY_PRICE_USD)
            .statusDelivery(UPDATED_STATUS_DELIVERY)
            .statusReason(UPDATED_STATUS_REASON)
            .blibliPackageId(UPDATED_BLIBLI_PACKAGE_ID)
            .tryOpen(UPDATED_TRY_OPEN)
            .createdAt(UPDATED_CREATED_AT)
            .createdBy(UPDATED_CREATED_BY)
            .updatedAt(UPDATED_UPDATED_AT)
            .updatedBy(UPDATED_UPDATED_BY);
    }

    @BeforeEach
    void initTest() {
        transactionSend = createEntity();
    }

    @AfterEach
    void cleanup() {
        if (insertedTransactionSend != null) {
            transactionSendRepository.delete(insertedTransactionSend);
            insertedTransactionSend = null;
        }
    }

    @Test
    @Transactional
    void getAllTransactionSends() throws Exception {
        // Initialize the database
        insertedTransactionSend = transactionSendRepository.saveAndFlush(transactionSend);

        // Get all the transactionSendList
        restTransactionSendMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(transactionSend.getId().intValue())))
            .andExpect(jsonPath("$.[*].transactionId").value(hasItem(DEFAULT_TRANSACTION_ID.intValue())))
            .andExpect(jsonPath("$.[*].code").value(hasItem(DEFAULT_CODE)))
            .andExpect(jsonPath("$.[*].pin").value(hasItem(DEFAULT_PIN)))
            .andExpect(jsonPath("$.[*].stickerId").value(hasItem(DEFAULT_STICKER_ID.intValue())))
            .andExpect(jsonPath("$.[*].senderName").value(hasItem(DEFAULT_SENDER_NAME)))
            .andExpect(jsonPath("$.[*].message").value(hasItem(DEFAULT_MESSAGE)))
            .andExpect(jsonPath("$.[*].sendType").value(hasItem(DEFAULT_SEND_TYPE)))
            .andExpect(jsonPath("$.[*].contactType").value(hasItem(DEFAULT_CONTACT_TYPE)))
            .andExpect(jsonPath("$.[*].recepientName").value(hasItem(DEFAULT_RECEPIENT_NAME)))
            .andExpect(jsonPath("$.[*].recepientContact").value(hasItem(DEFAULT_RECEPIENT_CONTACT)))
            .andExpect(jsonPath("$.[*].recepientContactHash").value(hasItem(DEFAULT_RECEPIENT_CONTACT_HASH)))
            .andExpect(jsonPath("$.[*].isImmediately").value(hasItem(DEFAULT_IS_IMMEDIATELY)))
            .andExpect(jsonPath("$.[*].sendSchedule").value(hasItem(DEFAULT_SEND_SCHEDULE.toString())))
            .andExpect(jsonPath("$.[*].addressLabel").value(hasItem(DEFAULT_ADDRESS_LABEL)))
            .andExpect(jsonPath("$.[*].countryId").value(hasItem(DEFAULT_COUNTRY_ID.intValue())))
            .andExpect(jsonPath("$.[*].provinceId").value(hasItem(DEFAULT_PROVINCE_ID.intValue())))
            .andExpect(jsonPath("$.[*].cityId").value(hasItem(DEFAULT_CITY_ID.intValue())))
            .andExpect(jsonPath("$.[*].districtId").value(hasItem(DEFAULT_DISTRICT_ID.intValue())))
            .andExpect(jsonPath("$.[*].villageId").value(hasItem(DEFAULT_VILLAGE_ID.intValue())))
            .andExpect(jsonPath("$.[*].zipcode").value(hasItem(DEFAULT_ZIPCODE)))
            .andExpect(jsonPath("$.[*].address").value(hasItem(DEFAULT_ADDRESS)))
            .andExpect(jsonPath("$.[*].courierNote").value(hasItem(DEFAULT_COURIER_NOTE)))
            .andExpect(jsonPath("$.[*].longitude").value(hasItem(DEFAULT_LONGITUDE)))
            .andExpect(jsonPath("$.[*].latitude").value(hasItem(DEFAULT_LATITUDE)))
            .andExpect(jsonPath("$.[*].referenceId").value(hasItem(DEFAULT_REFERENCE_ID)))
            .andExpect(jsonPath("$.[*].sendBy").value(hasItem(DEFAULT_SEND_BY)))
            .andExpect(jsonPath("$.[*].deliveryPrice").value(hasItem(sameNumber(DEFAULT_DELIVERY_PRICE))))
            .andExpect(jsonPath("$.[*].deliveryPriceUsd").value(hasItem(sameNumber(DEFAULT_DELIVERY_PRICE_USD))))
            .andExpect(jsonPath("$.[*].discDeliveryPrice").value(hasItem(sameNumber(DEFAULT_DISC_DELIVERY_PRICE))))
            .andExpect(jsonPath("$.[*].discDeliveryPriceUsd").value(hasItem(sameNumber(DEFAULT_DISC_DELIVERY_PRICE_USD))))
            .andExpect(jsonPath("$.[*].totalDeliveryPrice").value(hasItem(sameNumber(DEFAULT_TOTAL_DELIVERY_PRICE))))
            .andExpect(jsonPath("$.[*].totalDeliveryPriceUsd").value(hasItem(sameNumber(DEFAULT_TOTAL_DELIVERY_PRICE_USD))))
            .andExpect(jsonPath("$.[*].statusDelivery").value(hasItem(DEFAULT_STATUS_DELIVERY)))
            .andExpect(jsonPath("$.[*].statusReason").value(hasItem(DEFAULT_STATUS_REASON)))
            .andExpect(jsonPath("$.[*].blibliPackageId").value(hasItem(DEFAULT_BLIBLI_PACKAGE_ID)))
            .andExpect(jsonPath("$.[*].tryOpen").value(hasItem(DEFAULT_TRY_OPEN)))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY.intValue())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedBy").value(hasItem(DEFAULT_UPDATED_BY.intValue())));
    }

    @Test
    @Transactional
    void getTransactionSend() throws Exception {
        // Initialize the database
        insertedTransactionSend = transactionSendRepository.saveAndFlush(transactionSend);

        // Get the transactionSend
        restTransactionSendMockMvc
            .perform(get(ENTITY_API_URL_ID, transactionSend.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(transactionSend.getId().intValue()))
            .andExpect(jsonPath("$.transactionId").value(DEFAULT_TRANSACTION_ID.intValue()))
            .andExpect(jsonPath("$.code").value(DEFAULT_CODE))
            .andExpect(jsonPath("$.pin").value(DEFAULT_PIN))
            .andExpect(jsonPath("$.stickerId").value(DEFAULT_STICKER_ID.intValue()))
            .andExpect(jsonPath("$.senderName").value(DEFAULT_SENDER_NAME))
            .andExpect(jsonPath("$.message").value(DEFAULT_MESSAGE))
            .andExpect(jsonPath("$.sendType").value(DEFAULT_SEND_TYPE))
            .andExpect(jsonPath("$.contactType").value(DEFAULT_CONTACT_TYPE))
            .andExpect(jsonPath("$.recepientName").value(DEFAULT_RECEPIENT_NAME))
            .andExpect(jsonPath("$.recepientContact").value(DEFAULT_RECEPIENT_CONTACT))
            .andExpect(jsonPath("$.recepientContactHash").value(DEFAULT_RECEPIENT_CONTACT_HASH))
            .andExpect(jsonPath("$.isImmediately").value(DEFAULT_IS_IMMEDIATELY))
            .andExpect(jsonPath("$.sendSchedule").value(DEFAULT_SEND_SCHEDULE.toString()))
            .andExpect(jsonPath("$.addressLabel").value(DEFAULT_ADDRESS_LABEL))
            .andExpect(jsonPath("$.countryId").value(DEFAULT_COUNTRY_ID.intValue()))
            .andExpect(jsonPath("$.provinceId").value(DEFAULT_PROVINCE_ID.intValue()))
            .andExpect(jsonPath("$.cityId").value(DEFAULT_CITY_ID.intValue()))
            .andExpect(jsonPath("$.districtId").value(DEFAULT_DISTRICT_ID.intValue()))
            .andExpect(jsonPath("$.villageId").value(DEFAULT_VILLAGE_ID.intValue()))
            .andExpect(jsonPath("$.zipcode").value(DEFAULT_ZIPCODE))
            .andExpect(jsonPath("$.address").value(DEFAULT_ADDRESS))
            .andExpect(jsonPath("$.courierNote").value(DEFAULT_COURIER_NOTE))
            .andExpect(jsonPath("$.longitude").value(DEFAULT_LONGITUDE))
            .andExpect(jsonPath("$.latitude").value(DEFAULT_LATITUDE))
            .andExpect(jsonPath("$.referenceId").value(DEFAULT_REFERENCE_ID))
            .andExpect(jsonPath("$.sendBy").value(DEFAULT_SEND_BY))
            .andExpect(jsonPath("$.deliveryPrice").value(sameNumber(DEFAULT_DELIVERY_PRICE)))
            .andExpect(jsonPath("$.deliveryPriceUsd").value(sameNumber(DEFAULT_DELIVERY_PRICE_USD)))
            .andExpect(jsonPath("$.discDeliveryPrice").value(sameNumber(DEFAULT_DISC_DELIVERY_PRICE)))
            .andExpect(jsonPath("$.discDeliveryPriceUsd").value(sameNumber(DEFAULT_DISC_DELIVERY_PRICE_USD)))
            .andExpect(jsonPath("$.totalDeliveryPrice").value(sameNumber(DEFAULT_TOTAL_DELIVERY_PRICE)))
            .andExpect(jsonPath("$.totalDeliveryPriceUsd").value(sameNumber(DEFAULT_TOTAL_DELIVERY_PRICE_USD)))
            .andExpect(jsonPath("$.statusDelivery").value(DEFAULT_STATUS_DELIVERY))
            .andExpect(jsonPath("$.statusReason").value(DEFAULT_STATUS_REASON))
            .andExpect(jsonPath("$.blibliPackageId").value(DEFAULT_BLIBLI_PACKAGE_ID))
            .andExpect(jsonPath("$.tryOpen").value(DEFAULT_TRY_OPEN))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY.intValue()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()))
            .andExpect(jsonPath("$.updatedBy").value(DEFAULT_UPDATED_BY.intValue()));
    }

    @Test
    @Transactional
    void getNonExistingTransactionSend() throws Exception {
        // Get the transactionSend
        restTransactionSendMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    protected long getRepositoryCount() {
        return transactionSendRepository.count();
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

    protected TransactionSend getPersistedTransactionSend(TransactionSend transactionSend) {
        return transactionSendRepository.findById(transactionSend.getId()).orElseThrow();
    }

    protected void assertPersistedTransactionSendToMatchAllProperties(TransactionSend expectedTransactionSend) {
        assertTransactionSendAllPropertiesEquals(expectedTransactionSend, getPersistedTransactionSend(expectedTransactionSend));
    }

    protected void assertPersistedTransactionSendToMatchUpdatableProperties(TransactionSend expectedTransactionSend) {
        assertTransactionSendAllUpdatablePropertiesEquals(expectedTransactionSend, getPersistedTransactionSend(expectedTransactionSend));
    }
}
