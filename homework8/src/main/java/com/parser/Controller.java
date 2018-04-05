package com.parser;

import sun.reflect.generics.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by kleba on 04.04.2018.
 */
public class Controller {

    Map parser = new HashMap <String,TreeMap<Integer,String>>();

    public void insertDataInHashMap(String word,Integer count,String url ){
      TreeMap map=  new TreeMap<>();
        map.put(count,url);
        parser.put(word,map);
    }

    public Map getParser() {
        return new TreeMap<>(parser);
    }

    int countWords(String[] words,String word){
        int counter=0;
        for(String w:words ){
            if(w.equalsIgnoreCase(word)){
                counter++;
            }
        }
        return counter;
    }

    public List<String> getIncludePathes(String path, String response,int urls ){
        int counter=0;
        if(response!=null) {
            List url = new ArrayList();
            Pattern pattern = Pattern.compile(("(?:href|src)=\"/World/Shekspir/([^\"]+).htm"));
            Matcher m = pattern.matcher(response);
            while (m.find()) {
                counter++;
                StringBuilder fullPath = new StringBuilder();
                fullPath.append(path);
                fullPath.append("/");
                fullPath.append(m.group().split("/")[3]);
                url.add(fullPath.toString().replaceAll(String.valueOf((char) 34), ""));
                if (counter == urls) {
                    break;
                }
            }
            return url;
        }else{
            return null;
        }
    }

    public static String readHTMLPage(String path) throws IOException {
        URL website = new URL(path);
        URLConnection connection = website.openConnection();
        BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream(),"Cp1251"));
        String str;
        StringBuilder sb = new StringBuilder();
        while((str=bf.readLine())!=null)
            sb.append(str);
       return sb.toString();
    }

    public String[] getWords(String htmlPage){
        htmlPage= htmlPage.replaceAll("<[^>]*>", "");
        String[] words=  htmlPage.split("['\\w',':','/',',',' -']");
        return words;
    }

    public String theMostCommonWord(String[] words ){
        int max=0;
        String word = null;
        int counter=0;
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words.length;j++){
                if(words[i].equalsIgnoreCase(words[j])&&words[i].length()>3){
                    counter++;
                }
            }
            if(counter>max){
                max=counter;
                word=words[i];
            }
            counter=0;
        }
        return word+":"+max;
    }
}
