package com.paysgift.orderservice;

import com.paysgift.orderservice.config.AsyncSyncConfiguration;
import com.paysgift.orderservice.config.EmbeddedElasticsearch;
import com.paysgift.orderservice.config.EmbeddedSQL;
import com.paysgift.orderservice.config.JacksonConfiguration;
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
@SpringBootTest(classes = { OrderServiceApp.class, JacksonConfiguration.class, AsyncSyncConfiguration.class })
@EmbeddedElasticsearch
@EmbeddedSQL
public @interface IntegrationTest {
}
