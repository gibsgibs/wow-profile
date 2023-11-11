package com.github.gibsgibs.server.charactersummary.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

public class CharacterSummaryResponseDto {
    private int id;
    private String name;
    private String gender;
    private String faction;
    private String race;
    @JsonProperty("character_class")
    private String characterClass;
    @JsonProperty("active_spec")
    private String activeSpec;
    private String realm;
    private String guild;
    private int level;
    private int experience;
    @JsonProperty("achievement_points")
    private int achievementPoints;
    @JsonProperty("last_login_timestamp")
    private String lastLoginTimestamp;
    @JsonProperty("average_item_level")
    private int averageItemLevel;
    @JsonProperty("equipped_item_level")
    private int equippedItemLevel;
    @JsonProperty("active_title")
    private String activeTitle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(GenderDto gender) {
        this.gender = gender.getName();
    }

    public String getFaction() {
        return faction;
    }

    public void setFaction(FactionDto faction) {
        this.faction = faction.getName();
    }

    public String getRace() {
        return race;
    }

    public void setRace(RaceDto race) {
        this.race = race.getName();
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(CharacterClassDto characterClass) {
        this.characterClass = characterClass.getName();
    }

    public String getActiveSpec() {
        return activeSpec;
    }

    public void setActiveSpec(ActiveSpecDto activeSpec) {
        this.activeSpec = activeSpec.getName();
    }

    public String getRealm() {
        return realm;
    }

    public void setRealm(RealmDto realm) {
        this.realm = realm.getName();
    }

    public String getGuild() {
        return guild;
    }

    public void setGuild(GuildDto guild) {
        this.guild = guild.getName();
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getAchievementPoints() {
        return achievementPoints;
    }

    public void setAchievementPoints(int achievementPoints) {
        this.achievementPoints = achievementPoints;
    }

    public String getLastLoginTimestamp() {
        return lastLoginTimestamp;
    }

    public void setLastLoginTimestamp(long lastLoginTimestamp) {
        LocalDateTime date = LocalDateTime.ofInstant(Instant.ofEpochMilli(lastLoginTimestamp),
                ZoneOffset.UTC);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.lastLoginTimestamp = date.format(formatter);
    }

    public int getAverageItemLevel() {
        return averageItemLevel;
    }

    public void setAverageItemLevel(int averageItemLevel) {
        this.averageItemLevel = averageItemLevel;
    }

    public int getEquippedItemLevel() {
        return equippedItemLevel;
    }

    public void setEquippedItemLevel(int equippedItemLevel) {
        this.equippedItemLevel = equippedItemLevel;
    }

    public String getActiveTitle() {
        return activeTitle;
    }

    public void setActiveTitle(ActiveSpecDto activeTitle) {
        this.activeTitle = activeTitle.getName();
    }

}
