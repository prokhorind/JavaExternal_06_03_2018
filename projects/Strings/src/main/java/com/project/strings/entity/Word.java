package com.project.strings.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kleba on 03.04.2018.
 */
public class Word implements TextPart{

    private List<Symbol> symbols;

    public Word(List<Symbol>symbols){
        this.symbols=symbols;
    }

    public void setSymbols(List<Symbol> symbols) {
        this.symbols = symbols;
    }

    public List<Symbol> getSymbols() {
        return symbols;
    }

    public String getWord(){
        StringBuilder sb = new StringBuilder();
        for( int i=0;i<symbols.size();i++){
            sb.append(symbols.get(i));
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Word[");
        StringBuilder characterSb= new StringBuilder();
        for(Symbol symbol:symbols){
            characterSb.append(symbol);
        }
        sb.append(characterSb.toString());
        sb.append("]");
        return sb.toString();
    }
}
