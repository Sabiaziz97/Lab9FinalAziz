/*
Project: Lab 8 Pizza Shop Ordering System
Purpose Details: A text based pizza shop order handling system: show a menu, handle an order with menu items, and accept the transaction payment
Course: IST 242
Author: Sabi Aziz
Date Developed: 6/13/2020
Last Date Changed:
Revision: 1
*/
package edu.psu.abington.ist.ist242;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    int cCount = 1;
    int oCount = 1;
    int tCount = 1;
    static int firstPrompt = 1;

    public static void main(String[] args) {
        Main main = new Main();

        final char EXIT_CODE = 'E';
        final char CUST_CODE = 'C';
        final char MENU_CODE = 'M';
        final char ORDER_CODE = 'O';
        final char TRAN_CODE = 'T';
        final char CUST_PRNT = 'P';
        final char SPECIFIC_MENU = 'S';
        //final char Add_MENU = 'A';
        //final char Remove_MENU = 'R';
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to my pizza shop! Let's get started on your order: ");
        System.out.println("___________________________________________________________");


        char userAction;
        final String PROMPT_ACTION = "Press 'C' for Customer to add your information."
                + "\nPress 'P' to print your information"
                + "\nPress 'M' to view the Menu and pricing"
                + "\nPress 'S' for a specific pizza"
          //      + "\nPress 'A' for adding Menu Item"
          //      + "\nPress 'R'for removing Menu Item"
                + "\nPress O to order"
                + "\nPress T for method of Transaction "
                + "\nPress E for Exit: ";

        ArrayList<Customer> cList = new ArrayList<>();
        ArrayList<Menu> mList = new ArrayList<>();
        Menu menu1 = new Menu(1, "Plain", 7.00);
        mList.add(menu1);

        Menu menu2 = new Menu(2, "Meat Filled", 12.00);
        mList.add(menu2);

        Menu menu3 = new Menu(3, "Extra Cheese", 10.00);
        mList.add(menu3);

        Menu menu4 = new Menu(4, "Veggie", 9.00);
        mList.add(menu4);


        ArrayList<Order> oList = new ArrayList<>();
        ArrayList<Transaction> tList = new ArrayList<>();

//            Order order1 = new Order(1);

//            Transaction trans1 = new Transaction(1, order1, PaymentType.cash);
//            tList.add(trans1);
//            oList.add(order1);

        userAction = getAction(PROMPT_ACTION);
        while(userAction != EXIT_CODE) {
            switch(userAction) {
                case CUST_CODE :
                    cList.add(main.addCustomer());
                    break;
                case CUST_PRNT :
                    Customer.printCustomer(cList);
                    break;
                case MENU_CODE :
                    Menu.listMenu(mList);
                    break;
                case ORDER_CODE :
                    Menu.listMenu(mList);
                    System.out.println("Please Select your Menu Item");
                    System.out.println("Choose Id");
                    Order order = new Order(main.oCount);
                    oList.add(order);
                    int menuId = input.nextInt();
                    switch(menuId) {
                        case 1:
                            order.setMenu(mList.get(0));
                            System.out.println("Enter the Quantity");
                            int quantity = input.nextInt();
                            order.setQuantity(quantity);
//                    		double TotalBill = order.getQuantity() * order.getMenu().getPrice();
                            order.printOrder();
                            order.printBill();

                            break;
                        case 2:
                            order.setMenu(mList.get(1));
                            System.out.println("Enter the Quantity");
                            quantity = input.nextInt();
                            order.setQuantity(quantity);
//                    		double TotalBill = order.getQuantity() * order.getMenu().getPrice();
                            order.printOrder();
                            order.printBill();
                            break;
                        case 3:
                            order.setMenu(mList.get(2));
                            System.out.println("Enter the Quantity");
                            quantity = input.nextInt();
                            order.setQuantity(quantity);
//                    		double TotalBill = order.getQuantity() * order.getMenu().getPrice();
                            order.printOrder();
                            order.printBill();
                            break;
                        case 4:
                            order.setMenu(mList.get(3));
                            System.out.println("Enter the Quantity");
                            quantity = input.nextInt();
                            order.setQuantity(quantity);
//                    		double TotalBill = order.getQuantity() * order.getMenu().getPrice();
                            order.printOrder();
                            order.printBill();
                            break;
                        default:
                            System.out.println("Invalid choice");
                            break;
                    }
                    break;
                case TRAN_CODE :
//                    	Transaction t = new Transaction(tcou, _order, _pType)
                    if(!oList.isEmpty()) {
                        for (Order o : oList) {
                            System.out.println("Select the Payment Type");
                            System.out.println("1.Credit");
                            System.out.println("2.Cash");
                            int choice =input.nextInt();
                            Transaction t =null;
                            if(choice==1){
                                t = new Transaction(main.tCount++, o, PaymentType.credit);
                            }else{
                                t = new Transaction(main.tCount++, o, PaymentType.cash);

                            }
                            tList.add(t);
                        }
                        Transaction.listTransactions(tList);
                    }else {
                        System.out.println("You haven't Ordered Yet");
                        System.out.println("Please Place the Order");
                        userAction = getAction(PROMPT_ACTION);
                    }
                    break;
                case SPECIFIC_MENU :Menu m=getMenu(mList);
                    if(m!=null) {
                        System.out.println(m.getmenuItem());
                    }
                    break;
              //  case Add_MENU:
              //      Menu m1=inputMenu();
              //      mList.add(m1);
              //      break;
              //  case Remove_MENU:
              //      removeMenu(mList);
                default:
                    System.out.println("Please Select a Valid Choice");

                    break;
            }
            userAction = getAction(PROMPT_ACTION);
        }
        System.out.println("System Exited");
        System.exit(0);
    }

    public static Menu getMenu(ArrayList<Menu> list) {
        Scanner sc=new Scanner(System.in);
        System.out.println("MenuId: Press 1 for Plain, 2 for Meat, 3 for Extra Cheese, and 4 for Veggie");
        int menuid=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<list.size();++i) {
            if(list.get(i).getmenuId()==menuid) {
                return list.get(i);
            }
        }
        return null;
    }
    public static char getAction(String prompt) {
        Scanner sc=new Scanner(System.in);
        String answer = "";
        System.out.println(prompt);
        answer = sc.nextLine().toUpperCase() + " ";
        char firstChar = answer.charAt(0);


        return firstChar;
    }

    public Customer addCustomer(){
        Customer cust = new Customer(cCount++);
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter your Name: ");
        cust.setCustomerName(sc.nextLine());
        System.out.println("Please Enter your Phone Number: ");
        cust.setCustomerPhoneNumber(sc.nextLine());
        return cust;
    }
    public static Menu inputMenu() {
        Scanner sc=new Scanner(System.in);
        System.out.print("Menu id :");
        int menuid = sc.nextInt();
        sc.nextLine();
        System.out.print("Menu Item :");
        String menuitem = sc.nextLine();
        System.out.print("Price :");
        double price = sc.nextInt();
        //double price = sc.nextDouble();
        Menu m = new Menu(menuid, menuitem, price);
        return m;
    }
    public static void removeMenu(ArrayList<Menu> mList1) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Menu id :");
        int menuid=sc.nextInt();
        for(int i=0;i<mList1.size();++i) {
            if(mList1.get(i).getmenuId()== menuid) {
                mList1.remove(i);
            }
        }

    }
}