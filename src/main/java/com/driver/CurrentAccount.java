package com.driver;

import java.util.Arrays;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        if(balance < 5000) throw new Exception("Insufficient Balance");
        this.tradeLicenseId = tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

        int[] freq = new int[26];


        // If any character frequency is grater than ceil(length of LicenseId)/2 times throws Exception
        for(int i=0;i<tradeLicenseId.length();i++){
            freq[tradeLicenseId.charAt(i)-'A']++;
            if(freq[tradeLicenseId.charAt(i)-'A'] > Math.ceil((double)tradeLicenseId.length()/ (double) 2)){
                throw new Exception("Valid License can not be generated");
            }
        }

        boolean isConsecutive = false;

        // Checking whether same characters are Consecutive
        for(int i=0;i<tradeLicenseId.length() - 1;i++){
            char currChar = tradeLicenseId.charAt(i);
            char nextChar = tradeLicenseId.charAt(i+1);
            if(currChar==nextChar){
                isConsecutive = true;
                break;
            }
        }

        // Re-arranging the characters of the LicenseId
        if(isConsecutive){
            char []arr = tradeLicenseId.toCharArray();
            Arrays.sort(arr);
            tradeLicenseId = "";
            for(int i=0;i<arr.length/2;i++){
                tradeLicenseId+=arr[i];
                tradeLicenseId+= arr[(int)Math.ceil((double)arr.length/2) + i];
            }
            if(arr.length%2!=0) tradeLicenseId+=arr[arr.length/2];
        }
    }

}
