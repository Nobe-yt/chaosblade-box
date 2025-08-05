package com.alibaba.chaosblade.box.service.auth.ldap;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;


@Configuration
@EnableConfigurationProperties(LdapProperties.class)
@ConditionalOnProperty(name = "ldap.enabled", havingValue = "true")
public class LdapAutoConfiguration {

    private final LdapProperties ldapProperties;

    public LdapAutoConfiguration(LdapProperties ldapProperties) {
        this.ldapProperties = ldapProperties;
    }

    @Bean
    public LdapContextSource ldapContextSource() {
        LdapContextSource source = new LdapContextSource();
        source.setUrl(ldapProperties.getUrl());
        source.setBase(ldapProperties.getBase());
        source.setUserDn(ldapProperties.getUserDn());
        source.setPassword(ldapProperties.getPassword());
        return source;
    }

    @Bean
    public LdapTemplate ldapTemplate() {
        return new LdapTemplate(ldapContextSource());
    }
}