package model;

import java.time.LocalDate;

public class Transaction {
    private String userEmail;
    private String isbn;
    private LocalDate borrowDate;

    public Transaction(String userEmail,String isbn){
        this.userEmail=userEmail;
        this.isbn=isbn;
        this.borrowDate=LocalDate.now();
    }

    public String getUserEmail(){
        return userEmail;
    }

    public String getIsbn(){
        return isbn;
    }

    public LocalDate getBorrowDate(){
        return borrowDate;
    }
}
