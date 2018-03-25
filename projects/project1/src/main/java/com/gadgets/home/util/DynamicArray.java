package com.gadgets.home.util;

import com.gadgets.home.entity.Gadget;

import java.util.Arrays;

/**
 * Created by kleba on 15.03.2018.
 */
public class DynamicArray {

    private int length=2;
    private Gadget[] object;

    public DynamicArray(){
        object= new Gadget[length];
    }

    public DynamicArray(Gadget[] object){
        this.object=new Gadget[object.length];
        this.length=object.length;
        insertArray(object);
    }

    private int countValues(){
        int counter=0;
        for(Gadget o: object){
            if(o!=null) {
                ++counter;
            }
        }
        return counter;
    }

    public boolean addValue(Gadget o){
        int pos=countValues();
        if(pos==object.length){
            length*=2;
            Gadget[] newArray=new Gadget[length];
            for (int i=0;i<object.length;i++){
                newArray[i]=object[i];
            }
            if(!isIdPresented(o)) {
                newArray[pos++] = o;
            }else{
                System.out.println("U have gadget with same id");
                return false;
            }
            object=newArray;
        }else{
            object[pos++]=o;
        }
        return true;
    }

    public boolean isIdPresented(Gadget gadget){
        for(Gadget g:object){
            if(g.getId()==gadget.getId()){
                return true;
            }
        }
        return false;
    }

    private boolean insertArray(Gadget[] object){
        try {
            for (int i = 0; i < object.length; i++) {
                this.object[i] = object[i];
            }
            return true;
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
            System.out.println("wrong size");
            return  false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Gadget getGadget(int id){
        return object[id];
    }

    public Gadget[] getObject() {
        Gadget[] objects = new Gadget[countValues()];
        for(int i=0;i<objects.length;i++){
            objects[i]=object[i];
        }
        return objects;
    }

    public int getLength() {
        return countValues();
    }

    @Override
    public String toString() {
        StringBuilder sb =new StringBuilder();
        sb.append("DynamicArray{");
        sb.append("length=");
        sb.append(length);
        sb.append("]");
        sb.append("\n");
        sb.append(Arrays.toString(object));
        return  sb.toString();
    }
}
