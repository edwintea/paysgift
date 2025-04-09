package com.paysgift.productservice.config;

import static org.springframework.security.config.Customizer.withDefaults;

import com.paysgift.productservice.security.*;
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

                    .requestMatchers(mvc.pattern(HttpMethod.GET, "/api/coupons/**")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.POST, "/api/coupons")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.PUT, "/api/coupons")).permitAll()

                    .requestMatchers(mvc.pattern(HttpMethod.GET, "/api/coupon-codes/**")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.POST, "/api/coupon-codes")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.PUT, "/api/coupon-codes")).permitAll()

                    .requestMatchers(mvc.pattern(HttpMethod.GET, "/api/discounts/**")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.POST, "/api/discounts")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.PUT, "/api/discounts")).permitAll()

                    .requestMatchers(mvc.pattern(HttpMethod.GET, "/api/evoucher-deliveries/**")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.POST, "/api/evoucher-deliveries")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.PUT, "/api/evoucher-deliveries")).permitAll()

                    .requestMatchers(mvc.pattern(HttpMethod.GET, "/api/paysgift-promo-infos/**")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.POST, "/api/paysgift-promo-infos")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.PUT, "/api/paysgift-promo-infos")).permitAll()

                    .requestMatchers(mvc.pattern(HttpMethod.GET, "/api/paysgift-promos/**")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.POST, "/api/paysgift-promos")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.PUT, "/api/paysgift-promos")).permitAll()

                    .requestMatchers(mvc.pattern(HttpMethod.GET, "/api/product-categories/**")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.POST, "/api/product-categories")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.PUT, "/api/product-categories")).permitAll()

                    .requestMatchers(mvc.pattern(HttpMethod.GET, "/api/product-favourites/**")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.POST, "/api/product-favourites")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.PUT, "/api/product-favourites")).permitAll()

                    .requestMatchers(mvc.pattern(HttpMethod.GET, "/api/product-images/**")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.POST, "/api/product-images")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.PUT, "/api/product-images")).permitAll()

                    .requestMatchers(mvc.pattern(HttpMethod.GET, "/api/product-occasions/**")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.POST, "/api/product-occasions")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.PUT, "/api/product-occasions")).permitAll()

                    .requestMatchers(mvc.pattern(HttpMethod.GET, "/api/products/**")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.POST, "/api/products")).permitAll()
                    .requestMatchers(mvc.pattern(HttpMethod.PUT, "/api/products")).permitAll()

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
