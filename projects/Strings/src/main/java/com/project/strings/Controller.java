package com.project.strings;

import com.project.strings.entity.Word;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


/**
 * Created by kleba on 03.04.2018.
 */
public class Controller {

    public String findWord(List<List<Word>> list ) {
         for(int i=0;i<list.get(0).size();i++) {
             int counter = 0;
             for (int m = 1; m < list.size(); m++) {
                 for (int n = 0; n < list.get(m).size(); n++) {
                      if(list.get(0).get(i).getWord().equalsIgnoreCase(list.get(m).get(n).getWord())){
                          counter++;
                      }
                 }
             }
            if(counter==0){
                return list.get(0).get(i).getWord();
            }
         }
        return null;
    }

    public static String readFile(String path){
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                stringBuilder.append(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  stringBuilder.toString();
    }

    public String[]splitFileToSentences(String input){
        String[] sentences=input.split("[.!?:]");
        return sentences;
    }
}
