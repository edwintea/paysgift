package com.paysgift.paymentservice.config;

import static org.springframework.security.config.Customizer.withDefaults;

import com.paysgift.paymentservice.security.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationEntryPoint;
import org.springframework.security.oauth2.server.resource.web.access.BearerTokenAccessDeniedHandler;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;
import tech.jhipster.config.JHipsterProperties;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfiguration {

    private final JHipsterProperties jHipsterProperties;

    public SecurityConfiguration(JHipsterProperties jHipsterProperties) {
        this.jHipsterProperties = jHipsterProperties;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, MvcRequestMatcher.Builder mvc) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authz ->
                // prettier-ignore
                authz
                    .requestMatchers(mvc.pattern(HttpMethod.POST, "/api/authenticate")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.GET, "/api/authenticate")).permitAll()
                    .requestMatchers(mvc.pattern("/api/admin/**")).hasAuthority(AuthoritiesConstants.ADMIN)

                    .requestMatchers(mvc.pattern(HttpMethod.GET, "/api/dana-orders/**")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.POST, "/api/dana-orders")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.PUT, "/api/dana-orders")).permitAll()

                    .requestMatchers(mvc.pattern(HttpMethod.GET, "/api/payment-campaigns/**")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.POST, "/api/payment-campaigns")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.PUT, "/api/payment-campaigns")).permitAll()


                    .requestMatchers(mvc.pattern(HttpMethod.GET, "/api/payment-customer-samsungs/**")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.POST, "/api/payment-customer-samsungs")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.PUT, "/api/payment-customer-samsungs")).permitAll()

                    .requestMatchers(mvc.pattern(HttpMethod.GET, "/api/payment-lists/**")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.POST, "/api/payment-lists")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.PUT, "/api/payment-lists")).permitAll()

                    .requestMatchers(mvc.pattern(HttpMethod.GET, "/api/payment-providers/**")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.POST, "/api/payment-providers")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.PUT, "/api/payment-providers")).permitAll()

                    .requestMatchers(mvc.pattern(HttpMethod.GET, "/api/payments/**")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.POST, "/api/payments")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.PUT, "/api/payments")).permitAll()

                    .requestMatchers(mvc.pattern(HttpMethod.GET, "/api/payment-transaction-campaigns/**")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.POST, "/api/payment-transaction-campaigns")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.PUT, "/api/payment-transaction-campaigns")).permitAll()


                    .requestMatchers(mvc.pattern(HttpMethod.GET, "/api/payment-transaction-recurrings/**")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.POST, "/api/payment-transaction-recurrings")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.PUT, "/api/payment-transaction-recurrings")).permitAll()


                    .requestMatchers(mvc.pattern(HttpMethod.GET, "/api/payment-transactions/**")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.POST, "/api/payment-transactions")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.PUT, "/api/payment-transactions")).permitAll()

                    .requestMatchers(mvc.pattern(HttpMethod.GET, "/api/payment-transaction-retryings/**")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.POST, "/api/payment-transaction-retryings")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.PUT, "/api/payment-transaction-retryings")).permitAll()

                    .requestMatchers(mvc.pattern(HttpMethod.GET, "/api/payment-types/**")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.POST, "/api/payment-types")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.PUT, "/api/payment-types")).permitAll()

                    .requestMatchers(mvc.pattern("/api/**")).authenticated()
                    .requestMatchers(mvc.pattern("/v3/api-docs/**")).hasAuthority(AuthoritiesConstants.ADMIN)
                    .requestMatchers(mvc.pattern("/management/health")).permitAll()
                    .requestMatchers(mvc.pattern("/management/health/**")).permitAll()
                    .requestMatchers(mvc.pattern("/management/info")).permitAll()
                    .requestMatchers(mvc.pattern("/management/prometheus")).permitAll()
                    .requestMatchers(mvc.pattern("/management/**")).hasAuthority(AuthoritiesConstants.ADMIN)
            )
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .exceptionHandling(exceptions ->
                exceptions
                    .authenticationEntryPoint(new BearerTokenAuthenticationEntryPoint())
                    .accessDeniedHandler(new BearerTokenAccessDeniedHandler())
            )
            .oauth2ResourceServer(oauth2 -> oauth2.jwt(withDefaults()));
        return http.build();
    }

    @Bean
    MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
        return new MvcRequestMatcher.Builder(introspector);
    }
}
