package com.gadgets.home.dao;

import com.gadgets.home.entity.Gadget;
import com.gadgets.home.util.DynamicArray;

import java.io.*;
import java.util.Arrays;

/**
 * Created by kleba on 23.03.2018.
 */
public class GadgetDAO {

    public static boolean isFileExsists(String name){
        return new File(name).exists();
    }

    public static DynamicArray readGadgetsFromFile(String name){
        DynamicArray dm =new DynamicArray();
        if(isFileExsists(name)){
            try(FileInputStream fin = new FileInputStream(name);
                ObjectInputStream ois = new ObjectInputStream(fin);) {
                while (ois.available() != -1) {
                    Gadget gadget = (Gadget) ois.readObject();
                    dm.addValue(gadget);
                }

            } catch (EOFException e){
                return dm;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return dm;
    }

    public Gadget[] sortGadgetsByPower(Gadget[] gadgets){
        return  Arrays.stream(gadgets).sorted((o1, o2) ->Double.compare(o1.getPower(),o2.getPower()))
                .toArray(Gadget[]::new);
    }

    public double countPowerInPluggedDevices(Gadget[] gadgets){
        double sumPower=0;
        for(Gadget g: gadgets){
            if(g.isPlugged()){
                sumPower+=g.getPower();
            }
        }
        return sumPower;
    }

    public Gadget[] searchGadgetsByPower(Gadget[] gadgets, double min,double max){
        DynamicArray dm =new DynamicArray();
        for(Gadget g: gadgets){
            if(g.getPower()>=min&&g.getPower()<=max){
                dm.addValue(g);
            }
        }
        return dm.getObject();
    }

    public Gadget searchGadgetsById(int id, Gadget[] gadgets){
            for (Gadget g: gadgets){
                if(g.getId()==id){
                    return g;
                }
            }
            return null;
    }

    public void turnOnAllGadgets(Gadget[]gadgets){
        for (Gadget g: gadgets){
            if(!g.isPlugged()){
                g.setPlugged(true);
            }
        }
    }

    public void turnOffAllGadgets(Gadget[]gadgets){
        for (Gadget g: gadgets){
            if(g.isPlugged()){
                g.setPlugged(false);
            }
        }
    }

    public boolean turnOnOffGadgetById(Gadget[] gadgets, long id) throws ClassNotFoundException {
        boolean flag=false;
            for(Gadget g: gadgets){
                if(g.getId()==id){
                    flag=true;
                    if(g.isPlugged()){
                        g.setPlugged(false);
                    }else if(!g.isPlugged()){
                        g.setPlugged(true);
                    }
                    break;
                }
            }
        return flag;
    }
}
