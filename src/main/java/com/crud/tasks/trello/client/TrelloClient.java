package com.crud.tasks.trello.client;

import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.trello.config.TrelloConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Component
public class TrelloClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(TrelloClient.class);

    @Autowired
    private TrelloConfig trelloConfig;

    @Autowired
    private RestTemplate restTemplate;

    public List<TrelloBoardDto> getTrelloBoards() {

        URI url = getUri();
    try {

        TrelloBoardDto[] boardsResponse = restTemplate.getForObject(url, TrelloBoardDto[].class);
        return Arrays.asList(Optional.ofNullable(boardsResponse).orElse(new TrelloBoardDto[0]));}

    catch (RestClientException e) {
        LOGGER.error(e.getMessage(), e);
        return new ArrayList<>();
        }
    }

     public CreatedTrelloCardDto createNewCard(TrelloCardDto trelloCardDto){

        URI url = UriComponentsBuilder.fromHttpUrl(trelloConfig.getTrelloApiEndPoint() + "/cards")
                .queryParam("key", trelloConfig.getTrelloApiKey())
                .queryParam("token", trelloConfig.getTrelloApiToken())
                .queryParam("name", trelloCardDto.getName())
                .queryParam("desc",trelloCardDto.getDescription())
                .queryParam("pos", trelloCardDto.getPos())
                .queryParam( "idList",trelloCardDto.getListId())
                .build().encode().toUri();
        return restTemplate.postForObject(url,null,CreatedTrelloCardDto.class);
    }

    private URI getUri() {
        return UriComponentsBuilder.fromHttpUrl(trelloConfig.getTrelloApiEndPoint()+ "/members/grzegorz459/boards")
                    .queryParam("key", trelloConfig.getTrelloApiKey())
                    .queryParam("token", trelloConfig.getTrelloApiToken())
                    .queryParam("fields", "name,id")
                    .queryParam("lists", "all").build().encode().toUri();
    }
}
