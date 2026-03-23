package model;

import java.util.*;

public class Borrower extends User{

    private int deposit=1500;
    private List<String> borrowedBooks=new ArrayList<>();
    private List<String> cart=new ArrayList<>();
    public HashMap<String,Integer> extendCount=new HashMap<>();

    public Borrower(String email,String password){
        super(email,password);
    }

    public List<String> getBorrowedBooks(){
        return borrowedBooks;
    }

    public List<String> getCart(){
        return cart;
    }

    public int getDeposit(){
        return deposit;
    }

    public void reduceDeposit(int amt){
        deposit-=amt;
    }
}