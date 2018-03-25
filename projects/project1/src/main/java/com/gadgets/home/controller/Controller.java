package com.gadgets.home.controller;

import com.gadgets.home.entity.Gadget;
import com.gadgets.home.service.GadgetService;
import com.gadgets.home.util.DynamicArray;

/**
 * Created by kleba on 23.03.2018.
 */
public class Controller {

    private  Gadget[] gadgets;
    private GadgetService gadgetService ;

    public Controller(Gadget[] gadgets){
        this.gadgetService= new GadgetService();
        this.gadgets=gadgets;
    }

    public static DynamicArray readGadgetsFromFile(String name){
        return GadgetService.readGadgetsFromFile(name);
    }

    public Gadget[] sortGadgetsByPower(){
        return gadgetService.sortGadgetsByPower(gadgets);
    }

    public double countPowerInPluggedDevices(){
        return gadgetService.countPowerInPluggedDevices(gadgets);
    }

    public Gadget[] searchGadgetsByPower( double min,double max){
        return gadgetService.searchGadgetsByPower(gadgets,min,max);
    }

    public Gadget searchGadgetsById(int id){
        return gadgetService.searchGadgetsById(id,gadgets);
    }

    public void turnOnAllGadgets(){
        gadgetService.turnOnAllGadgets(gadgets);
    }

    public void turnOffAllGadgets(){
        gadgetService.turnOffAllGadgets(gadgets);
    }
    public boolean turnOnOffGadgetById(int id) throws ClassNotFoundException {
        return gadgetService.turnOnOffGadgetById(gadgets,id);
    }
}
