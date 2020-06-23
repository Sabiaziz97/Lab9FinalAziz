package edu.psu.abington.ist.ist242;

import java.util.ArrayList;

enum PaymentType {cash, credit}

public class Transaction extends Main{

    // Class Level Variables - Protect the data
    private int transactionId;
    private Order order;
    private PaymentType pType;

    // Constructor Method
    public Transaction(int _transactionId, Order _order, PaymentType _pType) {
        this.transactionId = _transactionId;
        this.order = _order;
        this.pType = _pType;
    }

    // Setters and Getters
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int _transactionId) {
        this.transactionId = _transactionId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order _order) {
        this.order = _order;
    }

    public PaymentType getPaymentType() {
        return pType;
    }

    public void setPaymentType(PaymentType _pType) {
        this.pType = _pType;
    }

    public static void listTransactions(ArrayList<Transaction> tList) {
        for (Transaction trans : tList) {
            System.out.println("Transaction ID: " + trans.getTransactionId());
            System.out.println("Ordered ID ="+ trans.getOrder().getorderId() + ", Quantity=" + trans.getOrder().getQuantity() + ", Item=" + trans.getOrder().getMenu().getmenuItem()+ ", Price per Item=" + trans.getOrder().getMenu().getPrice());
            trans.getOrder().printBill();
            System.out.println("Payment Type: " + trans.getPaymentType());
            System.out.println("Thank you for eating with us!");
            System.out.println("_____________________________");
        }
    }

//	Ordered ID ="+ orderId + ", Quantity=" + quantity + ", Item=" + menu.getmenuItem()+ ", Price per Item=" + menu.getPrice()
}
