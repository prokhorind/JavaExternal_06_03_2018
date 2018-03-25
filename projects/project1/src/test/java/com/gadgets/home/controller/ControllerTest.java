package com.gadgets.home.controller;

import com.gadgets.home.entity.*;
import com.gadgets.home.util.DynamicArray;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.InputStreamReader;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by kleba on 24.03.2018.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(Controller.class)
public class ControllerTest {

   private Controller controller;
   private Gadget[] gadgets;

    @Before
    public void setUp() throws Exception {
        Gadget gadget1 = new Heater("Heater", 1, 200, false, 50, false);
        Gadget gadget = new FlatIron("FlatIron", 2, 100, false, 20);
        Gadget gadget2 = new Humidifier("Humidifier", 3, 300, true, 50, 100);
        Gadget gadget3 = new WashingMachine("Washing Machine", 4, 200, false, 50);
        Gadget[] gadgetss = {gadget, gadget2, gadget1, gadget3};
        PowerMockito.mockStatic(Controller.class);
        DynamicArray dm = new DynamicArray(gadgetss);
        PowerMockito.when(Controller.readGadgetsFromFile("gadgets.txt")).thenReturn(dm);
        gadgets= Controller.readGadgetsFromFile("gadgets.txt").getObject();
        controller = new Controller(gadgets);
    }

    @After
    public void tearDown() throws Exception {
        gadgets=null;
        controller=null;
    }

    @Test
    public void searchGadgetsByPower() throws Exception {
        int min=100;
        int max=200;
        int numberOfGadgets=3;
        Gadget[] gadgets=controller.searchGadgetsByPower(min,max);
        assertEquals(numberOfGadgets,gadgets.length);
    }

    @Test
    public void searchGadgetsByUknownId() throws Exception {
        int uknownGadgetId=11;
        Gadget gadget= controller.searchGadgetsById(uknownGadgetId);
        assertNull(gadget);
    }

    @Test
    public void searchGadgetsById() throws Exception {
        int gadgetId=1;
        Gadget gadget= controller.searchGadgetsById(gadgetId);
        assertNotNull(gadget);
    }

   @Test
    public void turnOnOffGadgetWithUnknownId() throws Exception {
        int unknownId=19;
        assertFalse(controller.turnOnOffGadgetById(unknownId));
    }
    @Test
    public void turnOnOffGadgetById() throws Exception {
        int gadgetId=1;
        boolean result= controller.turnOnOffGadgetById(gadgetId);
        assertTrue(result);
    }
    @Test
    public void countPowerWithAllPluggedDevices() throws Exception{
        double totalPower=800;
        controller.turnOnAllGadgets();
        double result=  controller.countPowerInPluggedDevices();
        assertEquals(totalPower,result,0);
    }

    @Test
    public void countPowerWithNoPluggedDevices() throws Exception{
        double totalPower=0;
        controller.turnOffAllGadgets();
        double result=  controller.countPowerInPluggedDevices();
        assertEquals(totalPower,result,0);
    }

}