package com.jsnoise.config;

import org.springframework.beans.factory.annotation.Value;

public class BasicAuthCredentials {
    public String getAdminUser() {
        return _adminUser;
    }

    @Value("${admin_user}")
    String _adminUser;

    public String getAdminPassword() {
        return _adminPassword;
    }

    @Value("${admin_password}")
    String _adminPassword;
}
