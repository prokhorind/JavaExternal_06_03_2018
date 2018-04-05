package com.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by kleba on 04.04.2018.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String path="http://www.stihi-rus.ru/World/Shekspir/";
        Map<Integer,List<String>> map = new TreeMap();
        Controller controller = new Controller();
        String response= controller.readHTMLPage(path);
        List<String> pathes= controller.getIncludePathes(path,response,20);
        for(String p:pathes){
            String pResponse=  controller.readHTMLPage(p);
            String[] words= controller.getWords(pResponse);
            int number=controller.countWords(words,"Шекспир");
            if(map.containsKey(number)){
                map.get(number).add(p);
            }else{
                List l =new ArrayList();
                l.add(p);
                map.put (number,l);
            }
            String wordWithCounter= controller.theMostCommonWord(words);
            String[] wc=  wordWithCounter.split(":");
            controller.insertDataInHashMap(wc[0], Integer.valueOf(wc[1]),p);
        }
        System.out.println(map.toString());
        System.out.println(controller.getParser().toString());
    }
}
