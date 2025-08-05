package com.alibaba.chaosblade.box.service.auth.ldap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.stereotype.Service;

@Service
public class LdapAuthService {

    @Autowired
    private LdapTemplate ldapTemplate;

    public boolean authenticate(String username, String password) {
        EqualsFilter filter = new EqualsFilter("uid", username);
        return ldapTemplate.authenticate("", filter.encode(), password);
    }
}