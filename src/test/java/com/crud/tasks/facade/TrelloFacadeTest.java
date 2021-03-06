package com.crud.tasks.facade;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloList;
import com.crud.tasks.domain.TrelloListsDto;
import com.crud.tasks.mapper.TrelloMapper;
import com.crud.tasks.service.TrelloService;
import com.crud.tasks.trello.validator.TrelloValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TrelloFacadeTest {

    @InjectMocks
    private TrelloFacade trelloFacade;

    @Mock
    private TrelloService trelloService;

    @Mock
    private TrelloValidator trelloValidator;

    @Mock
    private TrelloMapper trelloMapper;

    @Test
    public void schoudFetchEmptyList(){
        //Given
        List<TrelloListsDto> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloListsDto("1","test_list",false));

        List<TrelloBoardDto> trelloboard = new ArrayList<>();
        trelloboard.add(new TrelloBoardDto("test","1",trelloLists));

        List<TrelloList> mappedTrelloList = new ArrayList<>();
        mappedTrelloList.add(new TrelloList("1","test_list",false));

        List<TrelloBoard> mappedtrelloboard = new ArrayList<>();
        mappedtrelloboard.add(new TrelloBoard("1","test",mappedTrelloList));

    when(trelloService.fetchTrelloBoards()).thenReturn(trelloboard);
    when(trelloMapper.mapToBoard(trelloboard)).thenReturn(mappedtrelloboard);
    when(trelloMapper.mapToBoardDto(anyList())).thenReturn(new ArrayList<>());
    when(trelloValidator.validateTrelloBoards(mappedtrelloboard)).thenReturn(new ArrayList<>());

    //When
    List<TrelloBoardDto> trelloBoardDtos = trelloFacade.fetchTrelloBoards();
    //Then
    assertNotNull(trelloBoardDtos);
    assertEquals(0,trelloBoardDtos.size());
    }

    @Test
    public void schoudFetchETrelloBoards(){
        //Given
        List<TrelloListsDto> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloListsDto("1","my_list",false));

        List<TrelloBoardDto> trelloboard = new ArrayList<>();
        trelloboard.add(new TrelloBoardDto("my_task","1",trelloLists));

        List<TrelloList> mappedTrelloList = new ArrayList<>();
        mappedTrelloList.add(new TrelloList("1","my_list",false));

        List<TrelloBoard> mappedtrelloboard = new ArrayList<>();
        mappedtrelloboard.add(new TrelloBoard("my_task","1",mappedTrelloList));

        when(trelloService.fetchTrelloBoards()).thenReturn(trelloboard);
        when(trelloMapper.mapToBoard(trelloboard)).thenReturn(mappedtrelloboard);
        when(trelloMapper.mapToBoardDto(anyList())).thenReturn(trelloboard);
        when(trelloValidator.validateTrelloBoards(mappedtrelloboard)).thenReturn(mappedtrelloboard);

        //When
        List<TrelloBoardDto> trelloBoardDtos = trelloFacade.fetchTrelloBoards();
        //Then
        assertNotNull(trelloBoardDtos);
        assertEquals(1,trelloBoardDtos.size());

        trelloBoardDtos.forEach(trelloBoardDto -> {
            assertEquals("1",trelloBoardDto.getId());
            assertEquals("my_task",trelloBoardDto.getName());

            trelloBoardDto.getLists().forEach(trelloListsDto -> {
                assertEquals("1",trelloListsDto.getId());
                assertEquals("my_list",trelloListsDto.getName());
                assertEquals(false,trelloListsDto.isClosed());
            });
        });
    }
}
