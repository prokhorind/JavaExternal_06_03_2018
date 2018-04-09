package com.project.strings.entity;

/**
 * Created by kleba on 03.04.2018.
 */
public class PunctMarks implements TextPart{

    private String punctMarc;

    public PunctMarks(String punctMarc){
        this.punctMarc=punctMarc;
    }

    public void setPunctMarc(String punctMarc) {
        this.punctMarc = punctMarc;
    }

    public String getPunctMarc() {
        return punctMarc;
    }

    @Override
    public String toString() {
        return "PunctMarks{" +
                "punctMarc=" + punctMarc +
                '}';
    }
}
