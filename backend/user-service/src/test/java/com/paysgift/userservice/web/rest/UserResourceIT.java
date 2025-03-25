package com.paysgift.userservice.web.rest;

import static com.paysgift.userservice.domain.UserAsserts.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paysgift.userservice.IntegrationTest;
import com.paysgift.userservice.domain.User;
import com.paysgift.userservice.repository.UserRepository;
import com.paysgift.userservice.service.mapper.UserMapper;
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
 * Integration tests for the {@link UserResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class UserResourceIT {

    private static final Long DEFAULT_GROUP_ID = 1L;
    private static final Long UPDATED_GROUP_ID = 2L;

    private static final Long DEFAULT_COUNTRY_ID = 1L;
    private static final Long UPDATED_COUNTRY_ID = 2L;

    private static final Boolean DEFAULT_IS_ACTIVE = false;
    private static final Boolean UPDATED_IS_ACTIVE = true;

    private static final String DEFAULT_IMAGE = "AAAAAAAAAA";
    private static final String UPDATED_IMAGE = "BBBBBBBBBB";

    private static final String DEFAULT_USERNAME = "AAAAAAAAAA";
    private static final String UPDATED_USERNAME = "BBBBBBBBBB";

    private static final String DEFAULT_PASSWORD = "AAAAAAAAAA";
    private static final String UPDATED_PASSWORD = "BBBBBBBBBB";

    private static final String DEFAULT_FULLNAME = "AAAAAAAAAA";
    private static final String UPDATED_FULLNAME = "BBBBBBBBBB";

    private static final String DEFAULT_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL = "BBBBBBBBBB";

    private static final String DEFAULT_MOBILE_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_MOBILE_NUMBER = "BBBBBBBBBB";

    private static final Boolean DEFAULT_IS_ADMIN = false;
    private static final Boolean UPDATED_IS_ADMIN = true;

    private static final Boolean DEFAULT_IS_INTERNAL = false;
    private static final Boolean UPDATED_IS_INTERNAL = true;

    private static final Boolean DEFAULT_BY_LOCATION = false;
    private static final Boolean UPDATED_BY_LOCATION = true;

    private static final String DEFAULT_LOCATION = "AAAAAAAAAA";
    private static final String UPDATED_LOCATION = "BBBBBBBBBB";

    private static final String DEFAULT_GOOGLE_2_FA_SECRET = "AAAAAAAAAA";
    private static final String UPDATED_GOOGLE_2_FA_SECRET = "BBBBBBBBBB";

    private static final String DEFAULT_OTP_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_OTP_NUMBER = "BBBBBBBBBB";

    private static final Boolean DEFAULT_OTP_STATUS = false;
    private static final Boolean UPDATED_OTP_STATUS = true;

    private static final Instant DEFAULT_OTP_EXPIRED_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_OTP_EXPIRED_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_LAST_LOGIN_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_LAST_LOGIN_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_CREATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Instant DEFAULT_UPDATED_AT = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_UPDATED_AT = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Boolean DEFAULT_IS_2_FA = false;
    private static final Boolean UPDATED_IS_2_FA = true;

    private static final String ENTITY_API_URL = "/api/users";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    @Autowired
    private ObjectMapper om;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restUserMockMvc;

    private User user;

    private User insertedUser;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static User createEntity() {
        return new User()
            .groupId(DEFAULT_GROUP_ID)
            .countryId(DEFAULT_COUNTRY_ID)
            .isActive(DEFAULT_IS_ACTIVE)
            .image(DEFAULT_IMAGE)
            .username(DEFAULT_USERNAME)
            .password(DEFAULT_PASSWORD)
            .fullname(DEFAULT_FULLNAME)
            .email(DEFAULT_EMAIL)
            .mobileNumber(DEFAULT_MOBILE_NUMBER)
            .isAdmin(DEFAULT_IS_ADMIN)
            .isInternal(DEFAULT_IS_INTERNAL)
            .byLocation(DEFAULT_BY_LOCATION)
            .location(DEFAULT_LOCATION)
            .google2faSecret(DEFAULT_GOOGLE_2_FA_SECRET)
            .otpNumber(DEFAULT_OTP_NUMBER)
            .otpStatus(DEFAULT_OTP_STATUS)
            .otpExpiredDate(DEFAULT_OTP_EXPIRED_DATE)
            .lastLoginAt(DEFAULT_LAST_LOGIN_AT)
            .createdAt(DEFAULT_CREATED_AT)
            .updatedAt(DEFAULT_UPDATED_AT)
            .is2fa(DEFAULT_IS_2_FA);
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static User createUpdatedEntity() {
        return new User()
            .groupId(UPDATED_GROUP_ID)
            .countryId(UPDATED_COUNTRY_ID)
            .isActive(UPDATED_IS_ACTIVE)
            .image(UPDATED_IMAGE)
            .username(UPDATED_USERNAME)
            .password(UPDATED_PASSWORD)
            .fullname(UPDATED_FULLNAME)
            .email(UPDATED_EMAIL)
            .mobileNumber(UPDATED_MOBILE_NUMBER)
            .isAdmin(UPDATED_IS_ADMIN)
            .isInternal(UPDATED_IS_INTERNAL)
            .byLocation(UPDATED_BY_LOCATION)
            .location(UPDATED_LOCATION)
            .google2faSecret(UPDATED_GOOGLE_2_FA_SECRET)
            .otpNumber(UPDATED_OTP_NUMBER)
            .otpStatus(UPDATED_OTP_STATUS)
            .otpExpiredDate(UPDATED_OTP_EXPIRED_DATE)
            .lastLoginAt(UPDATED_LAST_LOGIN_AT)
            .createdAt(UPDATED_CREATED_AT)
            .updatedAt(UPDATED_UPDATED_AT)
            .is2fa(UPDATED_IS_2_FA);
    }

    @BeforeEach
    public void initTest() {
        user = createEntity();
    }

    @AfterEach
    public void cleanup() {
        if (insertedUser != null) {
            userRepository.delete(insertedUser);
            insertedUser = null;
        }
    }

    @Test
    @Transactional
    void getAllUsers() throws Exception {
        // Initialize the database
        insertedUser = userRepository.saveAndFlush(user);

        // Get all the userList
        restUserMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(user.getId().intValue())))
            .andExpect(jsonPath("$.[*].groupId").value(hasItem(DEFAULT_GROUP_ID.intValue())))
            .andExpect(jsonPath("$.[*].countryId").value(hasItem(DEFAULT_COUNTRY_ID.intValue())))
            .andExpect(jsonPath("$.[*].isActive").value(hasItem(DEFAULT_IS_ACTIVE)))
            .andExpect(jsonPath("$.[*].image").value(hasItem(DEFAULT_IMAGE)))
            .andExpect(jsonPath("$.[*].username").value(hasItem(DEFAULT_USERNAME)))
            .andExpect(jsonPath("$.[*].password").value(hasItem(DEFAULT_PASSWORD)))
            .andExpect(jsonPath("$.[*].fullname").value(hasItem(DEFAULT_FULLNAME)))
            .andExpect(jsonPath("$.[*].email").value(hasItem(DEFAULT_EMAIL)))
            .andExpect(jsonPath("$.[*].mobileNumber").value(hasItem(DEFAULT_MOBILE_NUMBER)))
            .andExpect(jsonPath("$.[*].isAdmin").value(hasItem(DEFAULT_IS_ADMIN)))
            .andExpect(jsonPath("$.[*].isInternal").value(hasItem(DEFAULT_IS_INTERNAL)))
            .andExpect(jsonPath("$.[*].byLocation").value(hasItem(DEFAULT_BY_LOCATION)))
            .andExpect(jsonPath("$.[*].location").value(hasItem(DEFAULT_LOCATION)))
            .andExpect(jsonPath("$.[*].google2faSecret").value(hasItem(DEFAULT_GOOGLE_2_FA_SECRET)))
            .andExpect(jsonPath("$.[*].otpNumber").value(hasItem(DEFAULT_OTP_NUMBER)))
            .andExpect(jsonPath("$.[*].otpStatus").value(hasItem(DEFAULT_OTP_STATUS)))
            .andExpect(jsonPath("$.[*].otpExpiredDate").value(hasItem(DEFAULT_OTP_EXPIRED_DATE.toString())))
            .andExpect(jsonPath("$.[*].lastLoginAt").value(hasItem(DEFAULT_LAST_LOGIN_AT.toString())))
            .andExpect(jsonPath("$.[*].createdAt").value(hasItem(DEFAULT_CREATED_AT.toString())))
            .andExpect(jsonPath("$.[*].updatedAt").value(hasItem(DEFAULT_UPDATED_AT.toString())))
            .andExpect(jsonPath("$.[*].is2fa").value(hasItem(DEFAULT_IS_2_FA)));
    }

    @Test
    @Transactional
    void getUser() throws Exception {
        // Initialize the database
        insertedUser = userRepository.saveAndFlush(user);

        // Get the user
        restUserMockMvc
            .perform(get(ENTITY_API_URL_ID, user.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(user.getId().intValue()))
            .andExpect(jsonPath("$.groupId").value(DEFAULT_GROUP_ID.intValue()))
            .andExpect(jsonPath("$.countryId").value(DEFAULT_COUNTRY_ID.intValue()))
            .andExpect(jsonPath("$.isActive").value(DEFAULT_IS_ACTIVE))
            .andExpect(jsonPath("$.image").value(DEFAULT_IMAGE))
            .andExpect(jsonPath("$.username").value(DEFAULT_USERNAME))
            .andExpect(jsonPath("$.password").value(DEFAULT_PASSWORD))
            .andExpect(jsonPath("$.fullname").value(DEFAULT_FULLNAME))
            .andExpect(jsonPath("$.email").value(DEFAULT_EMAIL))
            .andExpect(jsonPath("$.mobileNumber").value(DEFAULT_MOBILE_NUMBER))
            .andExpect(jsonPath("$.isAdmin").value(DEFAULT_IS_ADMIN))
            .andExpect(jsonPath("$.isInternal").value(DEFAULT_IS_INTERNAL))
            .andExpect(jsonPath("$.byLocation").value(DEFAULT_BY_LOCATION))
            .andExpect(jsonPath("$.location").value(DEFAULT_LOCATION))
            .andExpect(jsonPath("$.google2faSecret").value(DEFAULT_GOOGLE_2_FA_SECRET))
            .andExpect(jsonPath("$.otpNumber").value(DEFAULT_OTP_NUMBER))
            .andExpect(jsonPath("$.otpStatus").value(DEFAULT_OTP_STATUS))
            .andExpect(jsonPath("$.otpExpiredDate").value(DEFAULT_OTP_EXPIRED_DATE.toString()))
            .andExpect(jsonPath("$.lastLoginAt").value(DEFAULT_LAST_LOGIN_AT.toString()))
            .andExpect(jsonPath("$.createdAt").value(DEFAULT_CREATED_AT.toString()))
            .andExpect(jsonPath("$.updatedAt").value(DEFAULT_UPDATED_AT.toString()))
            .andExpect(jsonPath("$.is2fa").value(DEFAULT_IS_2_FA));
    }

    @Test
    @Transactional
    void getNonExistingUser() throws Exception {
        // Get the user
        restUserMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    protected long getRepositoryCount() {
        return userRepository.count();
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

    protected User getPersistedUser(User user) {
        return userRepository.findById(user.getId()).orElseThrow();
    }

    protected void assertPersistedUserToMatchAllProperties(User expectedUser) {
        assertUserAllPropertiesEquals(expectedUser, getPersistedUser(expectedUser));
    }

    protected void assertPersistedUserToMatchUpdatableProperties(User expectedUser) {
        assertUserAllUpdatablePropertiesEquals(expectedUser, getPersistedUser(expectedUser));
    }
}
