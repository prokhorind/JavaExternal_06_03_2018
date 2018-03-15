package task1.figures;

import java.util.Arrays;

/**
 * Created by kleba on 15.03.2018.
 */
public class DynamicArray {

    private int length=2;
    private Object[] object;


    public DynamicArray(){

        object= new Object[length];
    }

    public DynamicArray(Object[] object){

        this.object=new Object[object.length];
        this.length=object.length;
        insertArray(object);

    }
    public int countValues(){
        int counter=0;
        for(Object o: object){
            if(o!=null) {
                ++counter;
            }
        }


        return counter;
    }

    public boolean addValue(Object o){
        int pos=countValues();

        if(pos==object.length){
            length*=2;
            Object[] newArray=new Object[length];
            for (int i=0;i<object.length;i++){
                newArray[i]=object[i];
            }
            newArray[pos++]=o;
            object=newArray;
        }else{
            object[pos++]=o;
        }


        return true;
    }

    private boolean insertArray(Object[] object){
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

    public Object[] getObject() {
        return object;
    }

    public int getLength() {
        return length;
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
