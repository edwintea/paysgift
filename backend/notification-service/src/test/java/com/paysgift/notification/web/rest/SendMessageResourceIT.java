package com.paysgift.notification.web.rest;

import static com.paysgift.notification.domain.SendMessageAsserts.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paysgift.notification.IntegrationTest;
import com.paysgift.notification.domain.SendMessage;
import com.paysgift.notification.repository.SendMessageRepository;
import com.paysgift.notification.service.mapper.SendMessageMapper;
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
 * Integration tests for the {@link SendMessageResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class SendMessageResourceIT {

    private static final String DEFAULT_PHONE_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_PHONE_NUMBER = "BBBBBBBBBB";

    private static final String DEFAULT_MESSAGE = "AAAAAAAAAA";
    private static final String UPDATED_MESSAGE = "BBBBBBBBBB";

    private static final Instant DEFAULT_DATE_TIME_ENTRY = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_DATE_TIME_ENTRY = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_DATE_TIME_SEND = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_DATE_TIME_SEND = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Boolean DEFAULT_STATUS = false;
    private static final Boolean UPDATED_STATUS = true;

    private static final String DEFAULT_RESPONSE_TEXT = "AAAAAAAAAA";
    private static final String UPDATED_RESPONSE_TEXT = "BBBBBBBBBB";

    private static final String DEFAULT_MESSAGE_ID = "AAAAAAAAAA";
    private static final String UPDATED_MESSAGE_ID = "BBBBBBBBBB";

    private static final String DEFAULT_STATUS_MESSAGE = "AAAAAAAAAA";
    private static final String UPDATED_STATUS_MESSAGE = "BBBBBBBBBB";

    private static final String DEFAULT_TABLE_RELATION = "AAAAAAAAAA";
    private static final String UPDATED_TABLE_RELATION = "BBBBBBBBBB";

    private static final String DEFAULT_TABLE_ID = "AAAAAAAAAA";
    private static final String UPDATED_TABLE_ID = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/send-messages";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    @Autowired
    private ObjectMapper om;

    @Autowired
    private SendMessageRepository sendMessageRepository;

    @Autowired
    private SendMessageMapper sendMessageMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restSendMessageMockMvc;

    private SendMessage sendMessage;

    private SendMessage insertedSendMessage;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SendMessage createEntity() {
        return new SendMessage()
            .phoneNumber(DEFAULT_PHONE_NUMBER)
            .message(DEFAULT_MESSAGE)
            .dateTimeEntry(DEFAULT_DATE_TIME_ENTRY)
            .dateTimeSend(DEFAULT_DATE_TIME_SEND)
            .status(DEFAULT_STATUS)
            .responseText(DEFAULT_RESPONSE_TEXT)
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
    public static SendMessage createUpdatedEntity() {
        return new SendMessage()
            .phoneNumber(UPDATED_PHONE_NUMBER)
            .message(UPDATED_MESSAGE)
            .dateTimeEntry(UPDATED_DATE_TIME_ENTRY)
            .dateTimeSend(UPDATED_DATE_TIME_SEND)
            .status(UPDATED_STATUS)
            .responseText(UPDATED_RESPONSE_TEXT)
            .messageId(UPDATED_MESSAGE_ID)
            .statusMessage(UPDATED_STATUS_MESSAGE)
            .tableRelation(UPDATED_TABLE_RELATION)
            .tableId(UPDATED_TABLE_ID);
    }

    @BeforeEach
    void initTest() {
        sendMessage = createEntity();
    }

    @AfterEach
    void cleanup() {
        if (insertedSendMessage != null) {
            sendMessageRepository.delete(insertedSendMessage);
            insertedSendMessage = null;
        }
    }

    @Test
    @Transactional
    void getAllSendMessages() throws Exception {
        // Initialize the database
        insertedSendMessage = sendMessageRepository.saveAndFlush(sendMessage);

        // Get all the sendMessageList
        restSendMessageMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(sendMessage.getId().intValue())))
            .andExpect(jsonPath("$.[*].phoneNumber").value(hasItem(DEFAULT_PHONE_NUMBER)))
            .andExpect(jsonPath("$.[*].message").value(hasItem(DEFAULT_MESSAGE)))
            .andExpect(jsonPath("$.[*].dateTimeEntry").value(hasItem(DEFAULT_DATE_TIME_ENTRY.toString())))
            .andExpect(jsonPath("$.[*].dateTimeSend").value(hasItem(DEFAULT_DATE_TIME_SEND.toString())))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].responseText").value(hasItem(DEFAULT_RESPONSE_TEXT)))
            .andExpect(jsonPath("$.[*].messageId").value(hasItem(DEFAULT_MESSAGE_ID)))
            .andExpect(jsonPath("$.[*].statusMessage").value(hasItem(DEFAULT_STATUS_MESSAGE)))
            .andExpect(jsonPath("$.[*].tableRelation").value(hasItem(DEFAULT_TABLE_RELATION)))
            .andExpect(jsonPath("$.[*].tableId").value(hasItem(DEFAULT_TABLE_ID)));
    }

    @Test
    @Transactional
    void getSendMessage() throws Exception {
        // Initialize the database
        insertedSendMessage = sendMessageRepository.saveAndFlush(sendMessage);

        // Get the sendMessage
        restSendMessageMockMvc
            .perform(get(ENTITY_API_URL_ID, sendMessage.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(sendMessage.getId().intValue()))
            .andExpect(jsonPath("$.phoneNumber").value(DEFAULT_PHONE_NUMBER))
            .andExpect(jsonPath("$.message").value(DEFAULT_MESSAGE))
            .andExpect(jsonPath("$.dateTimeEntry").value(DEFAULT_DATE_TIME_ENTRY.toString()))
            .andExpect(jsonPath("$.dateTimeSend").value(DEFAULT_DATE_TIME_SEND.toString()))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS))
            .andExpect(jsonPath("$.responseText").value(DEFAULT_RESPONSE_TEXT))
            .andExpect(jsonPath("$.messageId").value(DEFAULT_MESSAGE_ID))
            .andExpect(jsonPath("$.statusMessage").value(DEFAULT_STATUS_MESSAGE))
            .andExpect(jsonPath("$.tableRelation").value(DEFAULT_TABLE_RELATION))
            .andExpect(jsonPath("$.tableId").value(DEFAULT_TABLE_ID));
    }

    @Test
    @Transactional
    void getNonExistingSendMessage() throws Exception {
        // Get the sendMessage
        restSendMessageMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    protected long getRepositoryCount() {
        return sendMessageRepository.count();
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

    protected SendMessage getPersistedSendMessage(SendMessage sendMessage) {
        return sendMessageRepository.findById(sendMessage.getId()).orElseThrow();
    }

    protected void assertPersistedSendMessageToMatchAllProperties(SendMessage expectedSendMessage) {
        assertSendMessageAllPropertiesEquals(expectedSendMessage, getPersistedSendMessage(expectedSendMessage));
    }

    protected void assertPersistedSendMessageToMatchUpdatableProperties(SendMessage expectedSendMessage) {
        assertSendMessageAllUpdatablePropertiesEquals(expectedSendMessage, getPersistedSendMessage(expectedSendMessage));
    }
}
