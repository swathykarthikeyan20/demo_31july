package com.firstname;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TransactionParty {
    String seller;
    String buyer;

    public TransactionParty(String seller, String buyer) {
        this.seller = seller;
        this.buyer = buyer;
    }
}

class Receipt {
    TransactionParty transactionParty;
    String productsQR;

    public Receipt(TransactionParty transactionParty, String productsQR) {
        this.transactionParty = transactionParty;
        this.productsQR = productsQR;
    }
}

class GenerateReceipt {
    public int verifyParty(Receipt r) {
        Pattern pattern = Pattern.compile("^[a-zA-Z' -]+$");
        Matcher sellerMatcher = pattern.matcher(r.transactionParty.seller);
        Matcher buyerMatcher = pattern.matcher(r.transactionParty.buyer);

        boolean validSeller = sellerMatcher.matches();
        boolean validBuyer = buyerMatcher.matches();

        if (validSeller && validBuyer) {
            return 2;
        } else if (validSeller || validBuyer) {
            return 1;
        } else {
            return 0;
        }
    }

    public String calcGST(Receipt r) {
        String[] products = r.productsQR.split("@");
        int GST_Rate = 12;
        int totalGST = 0;

        for (String product : products) {
            String[] rateAndQuantity = product.split(",");
            int rate = Integer.parseInt(rateAndQuantity[0]);
            int quantity = Integer.parseInt(rateAndQuantity[1]);
            totalGST += rate * quantity;
        }

        totalGST *= GST_Rate;
        return Integer.toString(totalGST);
    }
}

public class Validation {
    public static void main(String[] args) {
        TransactionParty tp = new TransactionParty("Daniel D'Cruz", "Giselle Dawn-Wright");
        Receipt receipt = new Receipt(tp, "250,10@100,3@50,7");

        GenerateReceipt gr = new GenerateReceipt();
        int partyValidation = gr.verifyParty(receipt);
        System.out.println("Party Validation Result: " + partyValidation);

        String gstValue = gr.calcGST(receipt);
        System.out.println("GST Value: " + gstValue);
    }
}