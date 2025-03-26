package com.paysgift.paymentservice;

import com.paysgift.paymentservice.config.AsyncSyncConfiguration;
import com.paysgift.paymentservice.config.EmbeddedElasticsearch;
import com.paysgift.paymentservice.config.EmbeddedSQL;
import com.paysgift.paymentservice.config.JacksonConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { PaymentServiceApp.class, JacksonConfiguration.class, AsyncSyncConfiguration.class })
@EmbeddedElasticsearch
@EmbeddedSQL
public @interface IntegrationTest {
}
