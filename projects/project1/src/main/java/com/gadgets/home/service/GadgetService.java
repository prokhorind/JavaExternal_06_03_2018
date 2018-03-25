package com.gadgets.home.service;

import com.gadgets.home.dao.GadgetDAO;
import com.gadgets.home.entity.Gadget;
import com.gadgets.home.util.DynamicArray;

/**
 * Created by kleba on 23.03.2018.
 */
public class GadgetService {

    GadgetDAO gadgetDAO = new GadgetDAO();

    public static DynamicArray readGadgetsFromFile(String name){
        return GadgetDAO.readGadgetsFromFile(name);
    }
    public Gadget[] sortGadgetsByPower(Gadget[] gadgets) {
        return gadgetDAO.sortGadgetsByPower(gadgets);
    }
    public double countPowerInPluggedDevices(Gadget[] gadgets){
        return gadgetDAO.countPowerInPluggedDevices(gadgets);
    }

    public Gadget[] searchGadgetsByPower(Gadget[] gadgets, double min,double max){
        return gadgetDAO.searchGadgetsByPower(gadgets,min,max);
    }

    public Gadget searchGadgetsById(int id, Gadget[] gadgets){
        return gadgetDAO.searchGadgetsById(id,gadgets);
    }

    public void turnOnAllGadgets(Gadget[]gadgets){
        gadgetDAO.turnOnAllGadgets(gadgets);
    }

    public void turnOffAllGadgets(Gadget[]gadgets){
        gadgetDAO.turnOffAllGadgets(gadgets);
    }

    public boolean turnOnOffGadgetById(Gadget[] gadgets, long id) throws ClassNotFoundException {
        return gadgetDAO.turnOnOffGadgetById(gadgets,id);
    }

}
