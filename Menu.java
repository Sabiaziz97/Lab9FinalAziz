package edu.psu.abington.ist.ist242;

import java.util.ArrayList;

public class Menu {

    // Class Level Variables - Protect the data
    private int menuId;
    private String menuItem;
    private double price;

    // Constructor Method
    public Menu(int _menuId, String _menuItem, double _price) {
        this.menuId = _menuId;
        this.menuItem = _menuItem;
        this.price = _price;
    }

    // Setters and Getters
    public int getmenuId() {
        return menuId;
    }

    public void setmenuId(int _menuId) {
        this.menuId = _menuId;
    }

    public String getmenuItem() {
        return menuItem;
    }

    public void setmenuItem(String _menuItem) {
        this.menuItem = _menuItem;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double _price) {
        this.price = _price;
    }

    public static void listMenu(ArrayList<Menu> mList) {
        for (Menu menu : mList) {
            System.out.println(menu.printMenu());
        }
    }

    public String printMenu() {
        return "Menu [ID =" + menuId + ", Item =" + menuItem + ", Price =" + price + "]";
    }



}