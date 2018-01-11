//package com.crud.tasks.facade;
//
//import com.crud.tasks.domain.*;
//import com.crud.tasks.mapper.TrelloMapper;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.LinkedList;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class TrelloMapperTest {
//
//    @Autowired
//    private TrelloMapper trelloMapper;
//
//    @Test
//    public void mapToBoardDtoTest() {
//
//        TrelloList trelloList1 = new TrelloList("1","test1",false);
//        TrelloList trelloList2 = new TrelloList("2","test2",true);
//
//        List<TrelloList> trelloList = new LinkedList<>();
//        trelloList.add(trelloList1);
//        trelloList.add(trelloList2);
//
//        TrelloBoard trelloBoard1 = new TrelloBoard("test_id1", "test_board1", trelloList);
//        TrelloBoard trelloBoard2 = new TrelloBoard("test_id2", "test_board2", trelloList);
//        TrelloBoard trelloBoard3 = new TrelloBoard("test_id3", "test_board3", trelloList);
//
//        List<TrelloBoard> trelloBoardList = new LinkedList<>();
//        trelloBoardList.add(trelloBoard1);
//        trelloBoardList.add(trelloBoard2);
//        trelloBoardList.add(trelloBoard3);
//
//        assertEquals("test_id1", trelloMapper.mapToBoardDto(trelloBoardList).get(0).getName());
//        assertEquals("test_board1", trelloMapper.mapToBoardDto(trelloBoardList).get(0).getId());
//        assertEquals("test1", trelloMapper.mapToBoardDto(trelloBoardList).get(0).getLists().get(0).getName());
//    }
//    @Test
//    public void mapToBoardTest() {
//
//        TrelloListsDto trelloDtoList1 = new TrelloListsDto("1","test1",false);
//        TrelloListsDto trelloDtoList2 = new TrelloListsDto("2","test2",true);
//
//        List<TrelloListsDto> trelloListDto = new LinkedList<>();
//        trelloListDto.add(trelloDtoList1);
//        trelloListDto.add(trelloDtoList2);
//
//        TrelloBoardDto trelloDtoBoard1 = new TrelloBoardDto("test_id1", "test_board1", trelloListDto);
//        TrelloBoardDto trelloDtoBoard2 = new TrelloBoardDto("test_id2", "test_board2", trelloListDto);
//        TrelloBoardDto trelloDtoBoard3 = new TrelloBoardDto("test_id3", "test_board3", trelloListDto);
//
//        List<TrelloBoardDto> trelloBoardListDto = new LinkedList<>();
//        trelloBoardListDto.add(trelloDtoBoard1);
//        trelloBoardListDto.add(trelloDtoBoard2);
//        trelloBoardListDto.add(trelloDtoBoard3);
//
//        assertEquals("test_id1", trelloMapper.mapToBoard(trelloBoardListDto).get(0).getName());
//        assertEquals("test_board1", trelloMapper.mapToBoard(trelloBoardListDto).get(0).getId());
//        assertEquals("test1", trelloMapper.mapToBoard(trelloBoardListDto).get(0).getLists().get(0).getName());
//    }
//    @Test
//    public void mapToListDtoTest() {
//
//        TrelloList trelloList1 = new TrelloList("1","test1",false);
//        TrelloList trelloList2 = new TrelloList("2","test2",true);
//
//        List<TrelloList> trelloList = new LinkedList<>();
//        trelloList.add(trelloList1);
//        trelloList.add(trelloList2);
//
//        assertEquals("1", trelloMapper.mapToListDto(trelloList).get(0).getId());
//        assertEquals("test1", trelloMapper.mapToListDto(trelloList).get(0).getName());
//        assertEquals(false, trelloMapper.mapToListDto(trelloList).get(0).isClosed());
//    }
//    @Test
//    public void mapToListTest() {
//
//        TrelloListsDto trelloListDto1 = new TrelloListsDto("1","test1",false);
//        TrelloListsDto trelloListDto2 = new TrelloListsDto("2","test2",true);
//
//        List<TrelloListsDto> trelloListDto = new LinkedList<>();
//        trelloListDto.add(trelloListDto1);
//        trelloListDto.add(trelloListDto2);
//
//        assertEquals("1", trelloMapper.mapToList(trelloListDto).get(0).getId());
//        assertEquals("test1", trelloMapper.mapToList(trelloListDto).get(0).getName());
//        assertEquals(false, trelloMapper.mapToList(trelloListDto).get(0).isClosed());
//    }
//    @Test
//    public void mapToCardDtoTest() {
//
//        TrelloCard trelloCard1 = new TrelloCard("Card1","Description1","1","Do Zrobienia");
//
//        assertEquals("Card1", trelloMapper.mapToCardDto(trelloCard1).getName());
//        assertEquals("Description1", trelloMapper.mapToCardDto(trelloCard1).getDescription());
//        assertEquals("1", trelloMapper.mapToCardDto(trelloCard1).getPos());
//        assertEquals("Do Zrobienia", trelloMapper.mapToCardDto(trelloCard1).getListId());
//
//    }
//    @Test
//    public void mapToCardTest() {
//
//        TrelloCardDto trelloCardDto1 = new TrelloCardDto("Card1","Description1","1","Do Zrobienia");
//
//        assertEquals("Card1", trelloMapper.mapToCard(trelloCardDto1).getName());
//        assertEquals("Description1", trelloMapper.mapToCard(trelloCardDto1).getDescription());
//        assertEquals("1", trelloMapper.mapToCard(trelloCardDto1).getPos());
//        assertEquals("Do Zrobienia", trelloMapper.mapToCard(trelloCardDto1).getListId());
//    }
//}