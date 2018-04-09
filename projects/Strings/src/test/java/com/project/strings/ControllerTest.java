package com.project.strings;

import com.project.strings.entity.ParseString;
import com.project.strings.entity.Word;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by kleba on 09.04.2018.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(Controller.class)
public class ControllerTest {

    private Controller controller;
    @Before
    public void setUp() throws Exception {
        String input = "hello,guys it is Johny.It is.Are    guys     you, hello happy?";
        controller= new Controller();
        PowerMockito.mockStatic(Controller.class);
        PowerMockito.when(controller.readFile("src\\main\\resources\\EULA.txt")).thenReturn(input);
    }

    @After
    public void tearDown() throws Exception {
        controller=null;
    }
    @Test
    public void checkWhitespaces() throws Exception{
        int expectedNumberOfElements=9;
        int numberOfSentenceWithWhitaspacesAndTabs=2;
        String input=  controller.readFile("src\\main\\resources\\EULA.txt");
        String[] sentences=controller.splitFileToSentences(input);
        ParseString parseString = new ParseString();
        int numberOfElements=parseString.getWordsAndPunctMarks(sentences[numberOfSentenceWithWhitaspacesAndTabs]).size();
        assertEquals(expectedNumberOfElements,numberOfElements);
    }

    @Test
    public void splitFileToSentences()throws Exception{
        int numberOfSentences=3;
        String input=  controller.readFile("src\\main\\resources\\EULA.txt");
        String[] sentences=controller.splitFileToSentences(input);
        assertEquals(numberOfSentences,sentences.length);
    }

    @Test
    public void findWord() throws Exception {
        String expectedWord="Johny";
        String input=  controller.readFile("src\\main\\resources\\EULA.txt");
        String[] sentences = input.split("[.!?]");
        List<List<Word>> wordsList = new ArrayList<>();
        for (int i=0;i<sentences.length;i++) {
            ParseString parseString = new ParseString();
            parseString.getWordsAndPunctMarks(sentences[i]);
            wordsList.add(parseString.getWords());
        }
        String word= controller.findWord(wordsList);
        assertEquals(expectedWord,word);
    }
}