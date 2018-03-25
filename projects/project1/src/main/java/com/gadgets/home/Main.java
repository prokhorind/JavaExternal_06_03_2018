package com.gadgets.home;
import com.gadgets.home.controller.Controller;
import com.gadgets.home.entity.*;

import java.io.*;
import java.util.Arrays;

/**
 * Created by kleba on 23.03.2018.
 */
public class Main {

    public static void main(String[] args)  {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Gadget[] gadgets= Controller.readGadgetsFromFile("gadgets.txt").getObject();
        Controller controller= new Controller(gadgets);
        int choice=0;
        do {
            System.out.println("Меню");
            System.out.println("1.Посчитать потребляемую мощность");
            System.out.println("2.Cортировка приборов в квартире на основе мощности");
            System.out.println("3.Найти прибор по мощности");
            System.out.println("4.Найти прибор по id");
            System.out.println("5.Включить все приборы");
            System.out.println("6.Вылючить все приборы");
            System.out.println("7.Включить /Выключить  по id");
            System.out.println("8.Лист устройств");
            System.out.println("9.Выход");
            try {
                choice=Integer.parseInt(br.readLine());
            } catch (NumberFormatException e) {
                choice=0;
            } catch (IOException e) {
                e.printStackTrace();
            }
            switch (choice){
                case 1:
                    System.out.println(controller.countPowerInPluggedDevices());
                    break;
                case 2:
                    System.out.println(Arrays.toString(controller.sortGadgetsByPower()));
                    break;
                case 3:
                    System.out.println("Введите минимальное и максимально значение мощности");
                    try {
                        double min=Double.parseDouble(br.readLine());
                        double max=Double.parseDouble(br.readLine());
                        System.out.println(Arrays.toString(controller.searchGadgetsByPower(min,max)));
                    } catch (NumberFormatException e) {
                        System.out.println("Неправильно введены данные");
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (NullPointerException e){
                        System.out.println("Устройство не найдено");
                    }
                    break;
                case 4:
                    System.out.println("Введите id прибора");
                    try {
                      int id=Integer.parseInt(br.readLine());
                        System.out.println(controller.searchGadgetsById(id).toString());
                    } catch (NumberFormatException e) {
                        System.out.println("Неправильно введены данные");
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (NullPointerException e){
                        System.out.println("Устройство не найдено");
                    }
                    break;
                case 5:
                    controller.turnOnAllGadgets();
                    break;
                case 6:
                    controller.turnOffAllGadgets();
                    break;
                case 7:
                    System.out.println("Ведите id");
                    try {
                        int id=Integer.parseInt(br.readLine());
                        controller.turnOnOffGadgetById(id);
                        System.out.println(controller.searchGadgetsById(id).toString());
                    } catch (NumberFormatException e) {
                        System.out.println("Неправильно введены данные");
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (NullPointerException e){
                        System.out.println("Устройство не найдено");
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 8:
                    System.out.println(Arrays.toString(gadgets));
                    break;
                case 9:
                    System.out.println("Выход выполнен");
                    break;
                default:
                    System.out.println("Неправильный номер команды");
                    break;
            }
        }while (choice!=9);
    }
}
