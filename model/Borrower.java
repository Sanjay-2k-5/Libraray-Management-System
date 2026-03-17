package model;

import java.util.*;

public class Borrower extends User{
    private int deposit=1500;
    private List<String> borrowedBooks=new ArrayList<>();

    public Borrower(String email,String password){
        super(email,password);
    }

    public List<String> getBorrowedBooks(){
        return borrowedBooks;
    }

    public int getDeposit(){
        return deposit;
    }

    public void reduceDeposit(int amount){
        deposit-=amount;
    }
}
