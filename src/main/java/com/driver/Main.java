package com.driver;


public class Main {
    public static void main(String[] args) throws Exception {
        /*
        BankAccount b1 = new BankAccount("Druvasena Reddy",1000,100);
        System.out.println(b1.getBalance());
        System.out.println(b1.generateAccountNumber(5,55));
        b1.deposit(120);
        System.out.println(b1.getBalance());
        b1.withdraw(1000);
        System.out.println(b1.getBalance());
        b1.withdraw(21);
        */


//        CurrentAccount c1 = new CurrentAccount("Druvasena Reddy",5999,"AAABB");
//        c1.validateLicenseId();
//        System.out.println(c1.tradeLicenseId);



        SavingsAccount s1 = new SavingsAccount("Druvasena Reddy",300,500,12);
        s1.withdraw(300);
        System.out.println(s1.getBalance());

    }
}