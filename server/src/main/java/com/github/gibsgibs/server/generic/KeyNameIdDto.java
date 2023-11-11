package com.github.gibsgibs.server.generic;

public class KeyNameIdDto {
    private HrefDto key;
    private String name;
    private int id;
    public HrefDto getKey() {
        return key;
    }
    public void setKey(HrefDto key) {
        this.key = key;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
}
