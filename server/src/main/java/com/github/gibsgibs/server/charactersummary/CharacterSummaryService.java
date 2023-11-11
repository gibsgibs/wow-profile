package com.github.gibsgibs.server.charactersummary;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.github.gibsgibs.server.charactersummary.dto.CharacterInfoRequestDto;
import com.github.gibsgibs.server.charactersummary.dto.CharacterSummaryResponseDto;
import com.github.gibsgibs.server.settings.BlizzardSettings;

@RestController
public class CharacterSummaryService {
    private final BlizzardSettings blizzardSettings;

    public CharacterSummaryService(BlizzardSettings blizzardSettings) {
        this.blizzardSettings = blizzardSettings;
    }

    @PostMapping("/GetCharacterSummary")
    public CharacterSummaryResponseDto getCharacterSummary(@RequestBody CharacterInfoRequestDto infoRequest) {
        try {
            TokenDto token = getToken();
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Bearer " + token.getAccessToken());
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> request = new HttpEntity<>(headers);
            RestTemplate template = new RestTemplate();
            String url = new StringBuilder()
                    .append("https://us.api.blizzard.com/profile/wow/character/")
                    .append(infoRequest.getRealm())
                    .append("/")
                    .append(infoRequest.getName())
                    .append("?namespace=profile-us&locale=en_US")
                    .toString();
            ResponseEntity<CharacterSummaryResponseDto> response = template.exchange(
                url, 
                HttpMethod.GET, 
                request, 
                CharacterSummaryResponseDto.class);
            return response.getBody();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    private TokenDto getToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(this.blizzardSettings.getClientId(), this.blizzardSettings.getClientSecret());
        HttpEntity<String> request = new HttpEntity<>(headers);
        RestTemplate template = new RestTemplate();
        String url = "https://oauth.battle.net/token?grant_type=client_credentials";
        ResponseEntity<TokenDto> response = template.exchange(url, HttpMethod.POST, request, TokenDto.class);
        return response.getBody();
    }
}