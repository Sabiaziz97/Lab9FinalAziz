package edu.psu.abington.ist.ist242;

import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    // Class Level Variables - Protect the data
    private int orderId;
    private int quantity;
    private Customer cust;
    private Menu menu;
    private ArrayList<Menu> menuItem;

    public Order() {

    }

    // Constructor Method
    public Order(int _orderId) {
        this.orderId = _orderId;
    }

    // Setters and Getters
    public int getorderId() {
        return orderId;
    }

    public void setorderId(int _orderId) {
        this.orderId = _orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public Customer getCust() {
        return cust;
    }

    public void setCust(Customer cust) {
        this.cust = cust;
    }


    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Menu getMenuitem() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Menu Item id :");
        int id = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < menuItem.size(); i++) {
            if (menuItem.get(i).getmenuId() == id) {
                return menuItem.get(i);
            }
        }
        return null;
    }

    public void printOrder() {
        System.out.println("You have Ordered ID ="+ orderId + ", Quantity=" + quantity + ", Item=" + menu.getmenuItem()+ ", Price per Item=" + menu.getPrice());
    }

    public void printBill() {
        System.out.println("Your Bill is "+getQuantity()*menu.getPrice());
    }

    public double getBill() {
        return getQuantity()*menu.getPrice();

    }


}
