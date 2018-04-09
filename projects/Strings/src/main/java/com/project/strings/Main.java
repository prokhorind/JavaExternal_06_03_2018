package com.project.strings;

import com.project.strings.entity.ParseString;
import com.project.strings.entity.Word;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kleba on 03.04.2018.
 */

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller();
        String input=   controller.readFile("src\\main\\resources\\EULA.txt");
        String[] sentences= controller.splitFileToSentences(input);
        List<List<Word>> wordsList = new ArrayList<>();
        for (int i=0;i<sentences.length;i++) {
            ParseString parseString = new ParseString();
            System.out.println(parseString.getWordsAndPunctMarks(sentences[i]));
            wordsList.add(parseString.getWords());
        }
        String word= controller.findWord(wordsList);
        if(word==null){
            System.out.println("Слово отсутствует");
        }else{
            System.out.println("word="+word);
        }
    }
}
