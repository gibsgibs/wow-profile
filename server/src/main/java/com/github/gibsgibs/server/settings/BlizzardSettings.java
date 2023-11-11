package com.github.gibsgibs.server.settings;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("blizzard")
public class BlizzardSettings {
    private String clientId;
    private String clientSecret;
    public String getClientId() {
        return clientId;
    }
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
    public String getClientSecret() {
        return clientSecret;
    }
    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

}
