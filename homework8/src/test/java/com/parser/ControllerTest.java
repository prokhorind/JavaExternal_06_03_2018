package com.parser;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kleba on 05.04.2018.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(Controller.class)
public class ControllerTest {

    private Controller controller;
    private String path;
    @Before
    public void setUp() throws Exception {
        String data="Мы урожая ждем от лучших лоз,\n" +
                "Чтоб красота жила, не увядая.\n" +
                "Пусть вянут лепестки созревших роз,\n" +
                "Хранит их память роза молодая.\n" +
                "\n" +
                "А ты, в свою влюбленный красоту,\n" +
                "Все лучшие ей отдавая соки,\n" +
                "Обилье превращаешь в нищету, -\n" +
                "Свой злейший враг, бездушный и жестокий.\n" +
                "\n" +
                "Ты - украшенье нынешнего дня,\n" +
                "Недолговременной весны глашатай, -\n" +
                "Грядущее в зачатке хороня,\n" +
                "Соединяешь скаредность с растратой.\n" +
                "\n" +
                "Жалея мир, земле не предавай\n" +
                "Грядущих лет прекрасный урожай!";
        PowerMockito.mockStatic(Controller.class);
        path="http://www.stihi-rus.ru/World/Shekspir/";
        PowerMockito.when(Controller.readHTMLPage(path)).thenReturn(data);
        controller= new Controller();
        path=null;
    }

    @After
    public void tearDown() throws Exception {
        controller=null;
    }

    @Test
    public void getParser() throws Exception {
        int sizeOfHashMap=1;
        String pResponse=  controller.readHTMLPage(path);
        String[] words= controller.getWords(pResponse);
        String wordWithCounter= controller.theMostCommonWord(words);
        String[] wc=  wordWithCounter.split(":");
        controller.insertDataInHashMap(wc[0], Integer.valueOf(wc[1]),path);
        assertEquals(sizeOfHashMap,controller.getParser().size());
    }

    @Test
    public void getIncludePathes() throws Exception {
        int expectedListSize=0;
        int numberOfIncludedPathes=20;
        String response= controller.readHTMLPage(path);
        List<String>paths= controller.getIncludePathes(path,response,numberOfIncludedPathes);
        assertEquals(expectedListSize,paths.size());
    }

    @Test
    public void getWords() throws Exception {
        int numberOfWords=68;
        String pResponse=  Controller.readHTMLPage(path);
        String[] words= controller.getWords(pResponse);
        int wordNumber= words.length;
        assertEquals(numberOfWords,wordNumber);
    }
    @Test
    public void countWords(){
        int expectedNumber=2;
        String[] values={"first", "second", "third", "first"};
        int countWords=controller.countWords(values,"first");
        assertEquals(expectedNumber,countWords);
    }

    @Test
    public void theMostCommonWord() throws Exception {
        String expectedWord="урожая";
        int number=1;
        String pResponse=  Controller.readHTMLPage(path);
        String[] words= controller.getWords(pResponse);
        String wordWithCounter= controller.theMostCommonWord(words);
        String word=wordWithCounter.split(":")[0];
        Integer counter= Integer.valueOf(wordWithCounter.split(":")[1]);
        assertEquals(java.util.Optional.ofNullable(number), java.util.Optional.ofNullable(counter));
        assertEquals(expectedWord,word);
    }

}