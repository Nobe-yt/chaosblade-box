package com.alibaba.chaosblade.box.service.auth.ldap;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "ldap")
public class LdapProperties {
    private boolean enabled;
    @Getter
    private String url;
    @Getter
    private String base;
    @Getter
    private String userDn;
    @Getter
    private String password;

    public boolean getEnabled() {
        return enabled;
    }

}
