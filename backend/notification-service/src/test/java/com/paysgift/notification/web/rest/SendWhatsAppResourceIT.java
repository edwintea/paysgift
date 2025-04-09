package com.paysgift.notification.web.rest;

import static com.paysgift.notification.domain.SendWhatsAppAsserts.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paysgift.notification.IntegrationTest;
import com.paysgift.notification.domain.SendWhatsApp;
import com.paysgift.notification.repository.SendWhatsAppRepository;
import com.paysgift.notification.service.mapper.SendWhatsAppMapper;
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
 * Integration tests for the {@link SendWhatsAppResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class SendWhatsAppResourceIT {

    private static final String DEFAULT_COUNTRY_CODE = "AAAAAAAAAA";
    private static final String UPDATED_COUNTRY_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_PHONE_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_PHONE_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_MESSAGE = "AAAAAAAAAA";
    private static final String UPDATED_MESSAGE = "BBBBBBBBBB";

    private static final String DEFAULT_IMAGE_URL = "AAAAAAAAAA";
    private static final String UPDATED_IMAGE_URL = "BBBBBBBBBB";

    private static final String DEFAULT_DATE_TIME_ENTRY = "AAAAAAAAAA";
    private static final String UPDATED_DATE_TIME_ENTRY = "BBBBBBBBBB";

    private static final Instant DEFAULT_DATE_TIME_SEND = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_DATE_TIME_SEND = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Boolean DEFAULT_STATUS = false;
    private static final Boolean UPDATED_STATUS = true;

    private static final String DEFAULT_RESPONSE_TXT = "AAAAAAAAAA";
    private static final String UPDATED_RESPONSE_TXT = "BBBBBBBBBB";

    private static final String DEFAULT_MESSAGE_ID = "AAAAAAAAAA";
    private static final String UPDATED_MESSAGE_ID = "BBBBBBBBBB";

    private static final String DEFAULT_STATUS_MESSAGE = "AAAAAAAAAA";
    private static final String UPDATED_STATUS_MESSAGE = "BBBBBBBBBB";

    private static final String DEFAULT_TABLE_RELATION = "AAAAAAAAAA";
    private static final String UPDATED_TABLE_RELATION = "BBBBBBBBBB";

    private static final String DEFAULT_TABLE_ID = "AAAAAAAAAA";
    private static final String UPDATED_TABLE_ID = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/send-whats-apps";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    @Autowired
    private ObjectMapper om;

    @Autowired
    private SendWhatsAppRepository sendWhatsAppRepository;

    @Autowired
    private SendWhatsAppMapper sendWhatsAppMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restSendWhatsAppMockMvc;

    private SendWhatsApp sendWhatsApp;

    private SendWhatsApp insertedSendWhatsApp;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SendWhatsApp createEntity() {
        return new SendWhatsApp()
            .countryCode(DEFAULT_COUNTRY_CODE)
            .phoneNumber(DEFAULT_PHONE_NUMBER)
            .message(DEFAULT_MESSAGE)
            .imageUrl(DEFAULT_IMAGE_URL)
            .dateTimeEntry(DEFAULT_DATE_TIME_ENTRY)
            .dateTimeSend(DEFAULT_DATE_TIME_SEND)
            .status(DEFAULT_STATUS)
            .responseTxt(DEFAULT_RESPONSE_TXT)
            .messageId(DEFAULT_MESSAGE_ID)
            .statusMessage(DEFAULT_STATUS_MESSAGE)
            .tableRelation(DEFAULT_TABLE_RELATION)
            .tableId(DEFAULT_TABLE_ID);
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SendWhatsApp createUpdatedEntity() {
        return new SendWhatsApp()
            .countryCode(UPDATED_COUNTRY_CODE)
            .phoneNumber(UPDATED_PHONE_NUMBER)
            .message(UPDATED_MESSAGE)
            .imageUrl(UPDATED_IMAGE_URL)
            .dateTimeEntry(UPDATED_DATE_TIME_ENTRY)
            .dateTimeSend(UPDATED_DATE_TIME_SEND)
            .status(UPDATED_STATUS)
            .responseTxt(UPDATED_RESPONSE_TXT)
            .messageId(UPDATED_MESSAGE_ID)
            .statusMessage(UPDATED_STATUS_MESSAGE)
            .tableRelation(UPDATED_TABLE_RELATION)
            .tableId(UPDATED_TABLE_ID);
    }

    @BeforeEach
    void initTest() {
        sendWhatsApp = createEntity();
    }

    @AfterEach
    void cleanup() {
        if (insertedSendWhatsApp != null) {
            sendWhatsAppRepository.delete(insertedSendWhatsApp);
            insertedSendWhatsApp = null;
        }
    }

    @Test
    @Transactional
    void getAllSendWhatsApps() throws Exception {
        // Initialize the database
        insertedSendWhatsApp = sendWhatsAppRepository.saveAndFlush(sendWhatsApp);

        // Get all the sendWhatsAppList
        restSendWhatsAppMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(sendWhatsApp.getId().intValue())))
            .andExpect(jsonPath("$.[*].countryCode").value(hasItem(DEFAULT_COUNTRY_CODE)))
            .andExpect(jsonPath("$.[*].phoneNumber").value(hasItem(DEFAULT_PHONE_NUMBER)))
            .andExpect(jsonPath("$.[*].message").value(hasItem(DEFAULT_MESSAGE)))
            .andExpect(jsonPath("$.[*].imageUrl").value(hasItem(DEFAULT_IMAGE_URL)))
            .andExpect(jsonPath("$.[*].dateTimeEntry").value(hasItem(DEFAULT_DATE_TIME_ENTRY)))
            .andExpect(jsonPath("$.[*].dateTimeSend").value(hasItem(DEFAULT_DATE_TIME_SEND.toString())))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].responseTxt").value(hasItem(DEFAULT_RESPONSE_TXT)))
            .andExpect(jsonPath("$.[*].messageId").value(hasItem(DEFAULT_MESSAGE_ID)))
            .andExpect(jsonPath("$.[*].statusMessage").value(hasItem(DEFAULT_STATUS_MESSAGE)))
            .andExpect(jsonPath("$.[*].tableRelation").value(hasItem(DEFAULT_TABLE_RELATION)))
            .andExpect(jsonPath("$.[*].tableId").value(hasItem(DEFAULT_TABLE_ID)));
    }

    @Test
    @Transactional
    void getSendWhatsApp() throws Exception {
        // Initialize the database
        insertedSendWhatsApp = sendWhatsAppRepository.saveAndFlush(sendWhatsApp);

        // Get the sendWhatsApp
        restSendWhatsAppMockMvc
            .perform(get(ENTITY_API_URL_ID, sendWhatsApp.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(sendWhatsApp.getId().intValue()))
            .andExpect(jsonPath("$.countryCode").value(DEFAULT_COUNTRY_CODE))
            .andExpect(jsonPath("$.phoneNumber").value(DEFAULT_PHONE_NUMBER))
            .andExpect(jsonPath("$.message").value(DEFAULT_MESSAGE))
            .andExpect(jsonPath("$.imageUrl").value(DEFAULT_IMAGE_URL))
            .andExpect(jsonPath("$.dateTimeEntry").value(DEFAULT_DATE_TIME_ENTRY))
            .andExpect(jsonPath("$.dateTimeSend").value(DEFAULT_DATE_TIME_SEND.toString()))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS))
            .andExpect(jsonPath("$.responseTxt").value(DEFAULT_RESPONSE_TXT))
            .andExpect(jsonPath("$.messageId").value(DEFAULT_MESSAGE_ID))
            .andExpect(jsonPath("$.statusMessage").value(DEFAULT_STATUS_MESSAGE))
            .andExpect(jsonPath("$.tableRelation").value(DEFAULT_TABLE_RELATION))
            .andExpect(jsonPath("$.tableId").value(DEFAULT_TABLE_ID));
    }

    @Test
    @Transactional
    void getNonExistingSendWhatsApp() throws Exception {
        // Get the sendWhatsApp
        restSendWhatsAppMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    protected long getRepositoryCount() {
        return sendWhatsAppRepository.count();
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

    protected SendWhatsApp getPersistedSendWhatsApp(SendWhatsApp sendWhatsApp) {
        return sendWhatsAppRepository.findById(sendWhatsApp.getId()).orElseThrow();
    }

    protected void assertPersistedSendWhatsAppToMatchAllProperties(SendWhatsApp expectedSendWhatsApp) {
        assertSendWhatsAppAllPropertiesEquals(expectedSendWhatsApp, getPersistedSendWhatsApp(expectedSendWhatsApp));
    }

    protected void assertPersistedSendWhatsAppToMatchUpdatableProperties(SendWhatsApp expectedSendWhatsApp) {
        assertSendWhatsAppAllUpdatablePropertiesEquals(expectedSendWhatsApp, getPersistedSendWhatsApp(expectedSendWhatsApp));
    }
}
