package com.project.strings.entity;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kleba on 07.04.2018.
 */
public class ParseString {

    private Map<Integer,TextPart> map;

    public Map<Integer, TextPart> getMap() {
        return map;
    }

    public void setMap(Map<Integer, TextPart> map) {
        this.map = map;
    }
    public ParseString(){
        map= new HashMap<>();
    }

    public  Map<Integer,TextPart> getWordsAndPunctMarks(String input){
        int counter=0;
        input=input.replaceAll("[\\s]{2,}", " ");
        String patternString = ".";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(input);
        List<Symbol> symbolsList = new ArrayList<>();
        while(matcher.find()){
            String symbol=matcher.group();
            if(symbol.matches("\\w")) {
                symbolsList.add(new Symbol(symbol));
            } else{
                Word word = new Word(symbolsList);
                symbolsList=new ArrayList<>();
                if(word.getWord().length()>0) {
                    map.put(++counter, word);
                    PunctMarks punctMark = new PunctMarks(symbol);
                    map.put(++counter,punctMark);
                }
            }
            if(matcher.end()==input.length()){
                Word word = new Word(symbolsList);
                map.put(++counter, word);
            }
        }
        return map;
    }

    public List<Word> getWords(){
        List<Word> wordList= new ArrayList<>();
        List<TextPart> textParts= new ArrayList<>(map.values());
        for(TextPart t:textParts){
            if(t.getClass().getSimpleName().equals("Word")){
                wordList.add((Word) t);
            }
        }
        return wordList;
    }
}
