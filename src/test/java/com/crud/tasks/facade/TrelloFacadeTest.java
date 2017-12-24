package com.crud.tasks.facade;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.mapper.TrelloMapper;
import com.crud.tasks.trello.facade.TrelloFacade;
import com.crud.tasks.trello.validator.TrelloValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TrelloFacadeTest {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    public void mapToBoardDtoTest() {

        TrelloBoard trelloBoard1 = new TrelloBoard("test_id1", "test_board1", new ArrayList<>());
        TrelloBoard trelloBoard2 = new TrelloBoard("test_id2", "test_board2", new ArrayList<>());
        TrelloBoard trelloBoard3 = new TrelloBoard("test_id3", "test_board3", new ArrayList<>());

        List<TrelloBoard> trelloBoardList = new LinkedList<>();
        trelloBoardList.add(trelloBoard1);
        trelloBoardList.add(trelloBoard2);
        trelloBoardList.add(trelloBoard3);

        List<TrelloBoardDto> trelloBoardDtoMappler = trelloMapper.mapToBoardDto(trelloBoardList);

        assertEquals(trelloBoardList, trelloBoardDtoMappler);
    }
}