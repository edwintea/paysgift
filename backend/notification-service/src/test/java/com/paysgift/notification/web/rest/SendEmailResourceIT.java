package com.paysgift.notification.web.rest;

import static com.paysgift.notification.domain.SendEmailAsserts.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paysgift.notification.IntegrationTest;
import com.paysgift.notification.domain.SendEmail;
import com.paysgift.notification.repository.SendEmailRepository;
import com.paysgift.notification.service.mapper.SendEmailMapper;
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
 * Integration tests for the {@link SendEmailResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class SendEmailResourceIT {

    private static final String DEFAULT_MAIL_TO = "AAAAAAAAAA";
    private static final String UPDATED_MAIL_TO = "BBBBBBBBBB";

    private static final String DEFAULT_MAIL_TO_NAME = "AAAAAAAAAA";
    private static final String UPDATED_MAIL_TO_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_SUBJECT = "AAAAAAAAAA";
    private static final String UPDATED_SUBJECT = "BBBBBBBBBB";

    private static final String DEFAULT_BODY = "AAAAAAAAAA";
    private static final String UPDATED_BODY = "BBBBBBBBBB";

    private static final String DEFAULT_ATTACHED_1 = "AAAAAAAAAA";
    private static final String UPDATED_ATTACHED_1 = "BBBBBBBBBB";

    private static final String DEFAULT_ATTACHED_UNLINK_1 = "AAAAAAAAAA";
    private static final String UPDATED_ATTACHED_UNLINK_1 = "BBBBBBBBBB";

    private static final String DEFAULT_ATTACHED_2 = "AAAAAAAAAA";
    private static final String UPDATED_ATTACHED_2 = "BBBBBBBBBB";

    private static final String DEFAULT_ATTACHED_UNLINK_2 = "AAAAAAAAAA";
    private static final String UPDATED_ATTACHED_UNLINK_2 = "BBBBBBBBBB";

    private static final String DEFAULT_ATTACHED_3 = "AAAAAAAAAA";
    private static final String UPDATED_ATTACHED_3 = "BBBBBBBBBB";

    private static final String DEFAULT_ATTACHED_UNLINK_3 = "AAAAAAAAAA";
    private static final String UPDATED_ATTACHED_UNLINK_3 = "BBBBBBBBBB";

    private static final Instant DEFAULT_DATE_TIME_ENTRY = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_DATE_TIME_ENTRY = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_DATE_TIME_SEND = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_DATE_TIME_SEND = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_MAIL_FROM = "AAAAAAAAAA";
    private static final String UPDATED_MAIL_FROM = "BBBBBBBBBB";

    private static final String DEFAULT_MAIL_FROM_NAME = "AAAAAAAAAA";
    private static final String UPDATED_MAIL_FROM_NAME = "BBBBBBBBBB";

    private static final Boolean DEFAULT_STATUS = false;
    private static final Boolean UPDATED_STATUS = true;

    private static final String DEFAULT_INFO = "AAAAAAAAAA";
    private static final String UPDATED_INFO = "BBBBBBBBBB";

    private static final String DEFAULT_MAIL_CC = "AAAAAAAAAA";
    private static final String UPDATED_MAIL_CC = "BBBBBBBBBB";

    private static final String DEFAULT_MAIL_CC_NAME = "AAAAAAAAAA";
    private static final String UPDATED_MAIL_CC_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_TABLE_RELATION = "AAAAAAAAAA";
    private static final String UPDATED_TABLE_RELATION = "BBBBBBBBBB";

    private static final String DEFAULT_TABLE_ID = "AAAAAAAAAA";
    private static final String UPDATED_TABLE_ID = "BBBBBBBBBB";

    private static final Instant DEFAULT_CREATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_CREATED_BY = 1L;
    private static final Long UPDATED_CREATED_BY = 2L;

    private static final Instant DEFAULT_UPDATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_UPDATED_BY = 1L;
    private static final Long UPDATED_UPDATED_BY = 2L;

    private static final String ENTITY_API_URL = "/api/send-emails";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    @Autowired
    private ObjectMapper om;

    @Autowired
    private SendEmailRepository sendEmailRepository;

    @Autowired
    private SendEmailMapper sendEmailMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restSendEmailMockMvc;

    private SendEmail sendEmail;

    private SendEmail insertedSendEmail;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SendEmail createEntity() {
        return new SendEmail()
            .mailTo(DEFAULT_MAIL_TO)
            .mailToName(DEFAULT_MAIL_TO_NAME)
            .subject(DEFAULT_SUBJECT)
            .body(DEFAULT_BODY)
            .attached1(DEFAULT_ATTACHED_1)
            .attachedUnlink1(DEFAULT_ATTACHED_UNLINK_1)
            .attached2(DEFAULT_ATTACHED_2)
            .attachedUnlink2(DEFAULT_ATTACHED_UNLINK_2)
            .attached3(DEFAULT_ATTACHED_3)
            .attachedUnlink3(DEFAULT_ATTACHED_UNLINK_3)
            .dateTimeEntry(DEFAULT_DATE_TIME_ENTRY)
            .dateTimeSend(DEFAULT_DATE_TIME_SEND)
            .mailFrom(DEFAULT_MAIL_FROM)
            .mailFromName(DEFAULT_MAIL_FROM_NAME)
            .status(DEFAULT_STATUS)
            .info(DEFAULT_INFO)
            .mailCc(DEFAULT_MAIL_CC)
            .mailCcName(DEFAULT_MAIL_CC_NAME)
            .tableRelation(DEFAULT_TABLE_RELATION)
            .tableId(DEFAULT_TABLE_ID)
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
    public static SendEmail createUpdatedEntity() {
        return new SendEmail()
            .mailTo(UPDATED_MAIL_TO)
            .mailToName(UPDATED_MAIL_TO_NAME)
            .subject(UPDATED_SUBJECT)
            .body(UPDATED_BODY)
            .attached1(UPDATED_ATTACHED_1)
            .attachedUnlink1(UPDATED_ATTACHED_UNLINK_1)
            .attached2(UPDATED_ATTACHED_2)
            .attachedUnlink2(UPDATED_ATTACHED_UNLINK_2)
            .attached3(UPDATED_ATTACHED_3)
            .attachedUnlink3(UPDATED_ATTACHED_UNLINK_3)
            .dateTimeEntry(UPDATED_DATE_TIME_ENTRY)
            .dateTimeSend(UPDATED_DATE_TIME_SEND)
            .mailFrom(UPDATED_MAIL_FROM)
            .mailFromName(UPDATED_MAIL_FROM_NAME)
            .status(UPDATED_STATUS)
            .info(UPDATED_INFO)
            .mailCc(UPDATED_MAIL_CC)
            .mailCcName(UPDATED_MAIL_CC_NAME)
            .tableRelation(UPDATED_TABLE_RELATION)
            .tableId(UPDATED_TABLE_ID)
            .createdAt(UPDATED_CREATED_AT)
            .createdBy(UPDATED_CREATED_BY)
            .updatedAt(UPDATED_UPDATED_AT)
            .updatedBy(UPDATED_UPDATED_BY);
    }

    @BeforeEach
    void initTest() {
        sendEmail = createEntity();
    }

    @AfterEach
    void cleanup() {
        if (insertedSendEmail != null) {
            sendEmailRepository.delete(insertedSendEmail);
            insertedSendEmail = null;
        }
    }

    @Test
    @Transactional
    void getAllSendEmails() throws Exception {
        // Initialize the database
        insertedSendEmail = sendEmailRepository.saveAndFlush(sendEmail);

        // Get all the sendEmailList
        restSendEmailMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(sendEmail.getId().intValue())))
            .andExpect(jsonPath("$.[*].mailTo").value(hasItem(DEFAULT_MAIL_TO)))
            .andExpect(jsonPath("$.[*].mailToName").value(hasItem(DEFAULT_MAIL_TO_NAME)))
            .andExpect(jsonPath("$.[*].subject").value(hasItem(DEFAULT_SUBJECT)))
            .andExpect(jsonPath("$.[*].body").value(hasItem(DEFAULT_BODY)))
            .andExpect(jsonPath("$.[*].attached1").value(hasItem(DEFAULT_ATTACHED_1)))
            .andExpect(jsonPath("$.[*].attachedUnlink1").value(hasItem(DEFAULT_ATTACHED_UNLINK_1)))
            .andExpect(jsonPath("$.[*].attached2").value(hasItem(DEFAULT_ATTACHED_2)))
            .andExpect(jsonPath("$.[*].attachedUnlink2").value(hasItem(DEFAULT_ATTACHED_UNLINK_2)))
            .andExpect(jsonPath("$.[*].attached3").value(hasItem(DEFAULT_ATTACHED_3)))
            .andExpect(jsonPath("$.[*].attachedUnlink3").value(hasItem(DEFAULT_ATTACHED_UNLINK_3)))
            .andExpect(jsonPath("$.[*].dateTimeEntry").value(hasItem(DEFAULT_DATE_TIME_ENTRY.toString())))
            .andExpect(jsonPath("$.[*].dateTimeSend").value(hasItem(DEFAULT_DATE_TIME_SEND.toString())))
            .andExpect(jsonPath("$.[*].mailFrom").value(hasItem(DEFAULT_MAIL_FROM)))
            .andExpect(jsonPath("$.[*].mailFromName").value(hasItem(DEFAULT_MAIL_FROM_NAME)))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].info").value(hasItem(DEFAULT_INFO)))
            .andExpect(jsonPath("$.[*].mailCc").value(hasItem(DEFAULT_MAIL_CC)))
            .andExpect(jsonPath("$.[*].mailCcName").value(hasItem(DEFAULT_MAIL_CC_NAME)))
            .andExpect(jsonPath("$.[*].tableRelation").value(hasItem(DEFAULT_TABLE_RELATION)))
            .andExpect(jsonPath("$.[*].tableId").value(hasItem(DEFAULT_TABLE_ID)))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].createdBy").value(hasItem(DEFAULT_CREATED_BY.intValue())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedBy").value(hasItem(DEFAULT_UPDATED_BY.intValue())));
    }

    @Test
    @Transactional
    void getSendEmail() throws Exception {
        // Initialize the database
        insertedSendEmail = sendEmailRepository.saveAndFlush(sendEmail);

        // Get the sendEmail
        restSendEmailMockMvc
            .perform(get(ENTITY_API_URL_ID, sendEmail.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(sendEmail.getId().intValue()))
            .andExpect(jsonPath("$.mailTo").value(DEFAULT_MAIL_TO))
            .andExpect(jsonPath("$.mailToName").value(DEFAULT_MAIL_TO_NAME))
            .andExpect(jsonPath("$.subject").value(DEFAULT_SUBJECT))
            .andExpect(jsonPath("$.body").value(DEFAULT_BODY))
            .andExpect(jsonPath("$.attached1").value(DEFAULT_ATTACHED_1))
            .andExpect(jsonPath("$.attachedUnlink1").value(DEFAULT_ATTACHED_UNLINK_1))
            .andExpect(jsonPath("$.attached2").value(DEFAULT_ATTACHED_2))
            .andExpect(jsonPath("$.attachedUnlink2").value(DEFAULT_ATTACHED_UNLINK_2))
            .andExpect(jsonPath("$.attached3").value(DEFAULT_ATTACHED_3))
            .andExpect(jsonPath("$.attachedUnlink3").value(DEFAULT_ATTACHED_UNLINK_3))
            .andExpect(jsonPath("$.dateTimeEntry").value(DEFAULT_DATE_TIME_ENTRY.toString()))
            .andExpect(jsonPath("$.dateTimeSend").value(DEFAULT_DATE_TIME_SEND.toString()))
            .andExpect(jsonPath("$.mailFrom").value(DEFAULT_MAIL_FROM))
            .andExpect(jsonPath("$.mailFromName").value(DEFAULT_MAIL_FROM_NAME))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS))
            .andExpect(jsonPath("$.info").value(DEFAULT_INFO))
            .andExpect(jsonPath("$.mailCc").value(DEFAULT_MAIL_CC))
            .andExpect(jsonPath("$.mailCcName").value(DEFAULT_MAIL_CC_NAME))
            .andExpect(jsonPath("$.tableRelation").value(DEFAULT_TABLE_RELATION))
            .andExpect(jsonPath("$.tableId").value(DEFAULT_TABLE_ID))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.createdBy").value(DEFAULT_CREATED_BY.intValue()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()))
            .andExpect(jsonPath("$.updatedBy").value(DEFAULT_UPDATED_BY.intValue()));
    }

    @Test
    @Transactional
    void getNonExistingSendEmail() throws Exception {
        // Get the sendEmail
        restSendEmailMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    protected long getRepositoryCount() {
        return sendEmailRepository.count();
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

    protected SendEmail getPersistedSendEmail(SendEmail sendEmail) {
        return sendEmailRepository.findById(sendEmail.getId()).orElseThrow();
    }

    protected void assertPersistedSendEmailToMatchAllProperties(SendEmail expectedSendEmail) {
        assertSendEmailAllPropertiesEquals(expectedSendEmail, getPersistedSendEmail(expectedSendEmail));
    }

    protected void assertPersistedSendEmailToMatchUpdatableProperties(SendEmail expectedSendEmail) {
        assertSendEmailAllUpdatablePropertiesEquals(expectedSendEmail, getPersistedSendEmail(expectedSendEmail));
    }
}
