package com.project.strings.entity;

/**
 * Created by kleba on 03.04.2018.
 */
public class Symbol {

    private String ch;

    public Symbol(String ch){
        this.ch=ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    public String getCh() {
        return ch;
    }

    @Override
    public String toString() {
        return ch ;
    }
}
