package service;

import database.Database;
import model.Book;

public class BookService {
    public static void addBook(String isbn,String name,int qty,int cost){
        Database.books.put(isbn,new Book(isbn,name,qty,cost));
    }

    public static Book searchByIsbn(String isbn){
        return Database.books.get(isbn);
    }

    public static void showAllBooks(){
        for(Book b:Database.books.values()){
            System.out.println(b.getName()+" "+b.getQuantity());
        }
    }
}
