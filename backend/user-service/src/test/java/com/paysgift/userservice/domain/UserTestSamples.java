package com.paysgift.userservice.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class UserTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static User getUserSample1() {
        return new User()
            .id(1L)
            .groupId(1L)
            .countryId(1L)
            .image("image1")
            .username("username1")
            .password("password1")
            .fullname("fullname1")
            .email("email1")
            .mobileNumber("mobileNumber1")
            .location("location1")
            .google2faSecret("google2faSecret1")
            .otpNumber("otpNumber1");
    }

    public static User getUserSample2() {
        return new User()
            .id(2L)
            .groupId(2L)
            .countryId(2L)
            .image("image2")
            .username("username2")
            .password("password2")
            .fullname("fullname2")
            .email("email2")
            .mobileNumber("mobileNumber2")
            .location("location2")
            .google2faSecret("google2faSecret2")
            .otpNumber("otpNumber2");
    }

    public static User getUserRandomSampleGenerator() {
        return new User()
            .id(longCount.incrementAndGet())
            .groupId(longCount.incrementAndGet())
            .countryId(longCount.incrementAndGet())
            .image(UUID.randomUUID().toString())
            .username(UUID.randomUUID().toString())
            .password(UUID.randomUUID().toString())
            .fullname(UUID.randomUUID().toString())
            .email(UUID.randomUUID().toString())
            .mobileNumber(UUID.randomUUID().toString())
            .location(UUID.randomUUID().toString())
            .google2faSecret(UUID.randomUUID().toString())
            .otpNumber(UUID.randomUUID().toString());
    }
}
