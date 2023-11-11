package com.github.gibsgibs.server.charactersummary.dto;

public class CharacterInfoRequestDto {
    private String name;
    private String realm;
    public String getName() {
        return name;
    }
    public String getRealm() {
        return realm;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setRealm(String realm) {
        this.realm = realm;
    }
}
