package com.paysgift.orderservice.domain;

import static org.assertj.core.api.Assertions.assertThat;

public class CartDeleteAsserts {

    /**
     * Asserts that the entity has all properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertCartDeleteAllPropertiesEquals(CartDelete expected, CartDelete actual) {
        assertCartDeleteAutoGeneratedPropertiesEquals(expected, actual);
        assertCartDeleteAllUpdatablePropertiesEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all updatable properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertCartDeleteAllUpdatablePropertiesEquals(CartDelete expected, CartDelete actual) {
        assertCartDeleteUpdatableFieldsEquals(expected, actual);
        assertCartDeleteUpdatableRelationshipsEquals(expected, actual);
    }

    /**
     * Asserts that the entity has all the auto generated properties (fields/relationships) set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertCartDeleteAutoGeneratedPropertiesEquals(CartDelete expected, CartDelete actual) {
        assertThat(actual)
            .as("Verify CartDelete auto generated properties")
            .satisfies(a -> assertThat(a.getId()).as("check id").isEqualTo(expected.getId()));
    }

    /**
     * Asserts that the entity has all the updatable fields set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertCartDeleteUpdatableFieldsEquals(CartDelete expected, CartDelete actual) {
        assertThat(actual)
            .as("Verify CartDelete relevant properties")
            .satisfies(a ->
                assertThat(a.getTransactionDetailId()).as("check transactionDetailId").isEqualTo(expected.getTransactionDetailId())
            )
            .satisfies(a -> assertThat(a.getCustomerId()).as("check customerId").isEqualTo(expected.getCustomerId()))
            .satisfies(a -> assertThat(a.getCountryId()).as("check countryId").isEqualTo(expected.getCountryId()))
            .satisfies(a -> assertThat(a.getClientId()).as("check clientId").isEqualTo(expected.getClientId()))
            .satisfies(a -> assertThat(a.getChannelId()).as("check channelId").isEqualTo(expected.getChannelId()))
            .satisfies(a -> assertThat(a.getBrandId()).as("check brandId").isEqualTo(expected.getBrandId()))
            .satisfies(a -> assertThat(a.getProductId()).as("check productId").isEqualTo(expected.getProductId()))
            .satisfies(a -> assertThat(a.getQty()).as("check qty").isEqualTo(expected.getQty()))
            .satisfies(a -> assertThat(a.getCreatedAt()).as("check createdAt").isEqualTo(expected.getCreatedAt()))
            .satisfies(a -> assertThat(a.getCreatedBy()).as("check createdBy").isEqualTo(expected.getCreatedBy()))
            .satisfies(a -> assertThat(a.getUpdatedAt()).as("check updatedAt").isEqualTo(expected.getUpdatedAt()))
            .satisfies(a -> assertThat(a.getUpdatedBy()).as("check updatedBy").isEqualTo(expected.getUpdatedBy()));
    }

    /**
     * Asserts that the entity has all the updatable relationships set.
     *
     * @param expected the expected entity
     * @param actual the actual entity
     */
    public static void assertCartDeleteUpdatableRelationshipsEquals(CartDelete expected, CartDelete actual) {
        // empty method
    }
}
