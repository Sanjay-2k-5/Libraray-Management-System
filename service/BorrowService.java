package service;

import database.Database;
import model.*;

public class BorrowService {
    public static void borrowBook(Borrower user,String isbn){
        Book book=Database.books.get(isbn);

        if(book==null){
            System.out.println("Book not found");
            return;
        }
        if(book.getQuantity()==0){
            System.out.println("Out of stock");
            return;
        }
        if(user.getBorrowedBooks().size()>=3){
            System.out.println("Limit reached");
            return;
        }
        if(user.getBorrowedBooks().contains(isbn)){
            System.out.println("Already borrowed");
            return;
        }
        if(user.getDeposit()<500){
            System.out.println("Insufficient deposit");
            return;
        }
        book.setQuantity(book.getQuantity()-1);
        user.getBorrowedBooks().add(isbn);

        Transaction t=new Transaction(user.getEmail(),isbn);
        Database.transactions.add(t);

        System.out.println("Borrowed successfully");
    }
}
