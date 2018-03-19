import vehicles.interf.interfimpl.transport.Vehicle;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by kleba on 15.03.2018.
 */
public class DynamicArray {

    private int length=2;
    private Vehicle[] object;


    public DynamicArray(){

        object= new Vehicle[length];
    }

    public DynamicArray(Vehicle[] object){

        this.object=new Vehicle[object.length];
        this.length=object.length;
        insertArray(object);

    }
    public int countValues(){
        int counter=0;
        for(Vehicle o: object){
            if(o!=null) {
                ++counter;
            }
        }


        return counter;
    }

    public boolean addValue(Vehicle o){
        int pos=countValues();

        if(pos==object.length){
            length*=2;
            Vehicle[] newArray=new Vehicle[length];
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

    private boolean insertArray(Vehicle[] object){
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

    public Vehicle[] getObject() {
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
