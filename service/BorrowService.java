package service;

import database.Database;
import model.*;

public class BorrowService {

    public static void borrowBook(Borrower user,String isbn){

        Book b=Database.books.get(isbn);

        if(b==null || b.getQuantity()==0){
            System.out.println("Unavailable");
            return;
        }

        if(user.getBorrowedBooks().size()>=3){
            System.out.println("Limit reached");
            return;
        }

        if(user.getBorrowedBooks().contains(isbn)){
            System.out.println("Already taken");
            return;
        }

        if(user.getDeposit()<500){
            System.out.println("Low deposit");
            return;
        }

        b.setQuantity(b.getQuantity()-1);
        user.getBorrowedBooks().add(isbn);

        Database.transactions.add(new Transaction(user.getEmail(),isbn));
    }

    public static void returnBook(Borrower user,String isbn,int days){

        if(!user.getBorrowedBooks().contains(isbn))
            return;

        Book b=Database.books.get(isbn);

        b.setQuantity(b.getQuantity()+1);
        user.getBorrowedBooks().remove(isbn);

        int fine=FineService.calculateFine(days,b.getCost());

        if(fine>0){
            user.reduceDeposit(fine);
            System.out.println("Fine: "+fine);
        }
    }

    public static void addToCart(Borrower user,String isbn){
        user.getCart().add(isbn);
    }

    public static void checkout(Borrower user){
        for(int i=0;i<user.getCart().size();i++){
            borrowBook(user,user.getCart().get(i));
        }
        user.getCart().clear();
    }

    public static void extendBook(Borrower user,String isbn){

        int c=user.extendCount.getOrDefault(isbn,0);

        if(c>=2){
            System.out.println("Max extend");
            return;
        }

        user.extendCount.put(isbn,c+1);
    }
}