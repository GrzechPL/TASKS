package com.crud.tasks.trello.client;

import com.crud.tasks.domain.TrelloBoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class TrelloClient {

    @Value("${trello.username}")
    private String trelloUsername;

    @Value("${trello.api.endpoint.prod}")
    private String trelloApiEndPoint;

    @Value("${trello.app.key}")
    private String trelloApiKey;

    @Value("${trello.app.token}")
    private String trelloApiToken;

    @Autowired
    private RestTemplate restTemplate;

    public List<TrelloBoardDto> getTrelloBoards() {

        URI url = getUri();

        TrelloBoardDto[] boardsResponse =restTemplate.getForObject(url,TrelloBoardDto[].class);
        return Arrays.asList(Optional.ofNullable(boardsResponse).orElse(new TrelloBoardDto[0]));
    }

    private URI getUri() {
        return UriComponentsBuilder.fromHttpUrl(trelloApiEndPoint + "/members/" + trelloUsername + "/boards")
                    .queryParam("key", trelloApiKey)
                    .queryParam("token", trelloApiToken)
                    .queryParam("fields", "name,id").build().encode().toUri();
    }
}
