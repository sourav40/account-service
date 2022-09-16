package edu.miu.cs590.accountservice.constant;

public enum PaymentType {
    PayPal("PayPal"), CreditCard("CreditCard"), BankAccount("BankAccount");

    private String name;

    private PaymentType(String name) {
        this.name = name;
    }

}
