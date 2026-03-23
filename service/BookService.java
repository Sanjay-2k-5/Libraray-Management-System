package service;

import database.Database;
import java.util.*;
import model.Book;

public class BookService {

    public static void addBook(String isbn,String name,int q,int cost){
        Database.books.put(isbn,new Book(isbn,name,q,cost));
    }

    public static Book searchByIsbn(String isbn){
        return Database.books.get(isbn);
    }

    public static void showAllBooks(){
        for(Book b:Database.books.values())
            System.out.println(b.getName()+" "+b.getQuantity());
    }

    public static void sortByName(){

        List<Book> list=new ArrayList<>(Database.books.values());

        list.sort((a,b)->a.getName().compareTo(b.getName()));

        for(Book b:list)
            System.out.println(b.getName());
    }

    public static void sortByQuantity(){

        List<Book> list=new ArrayList<>(Database.books.values());

        list.sort((a,b)->b.getQuantity()-a.getQuantity());

        for(Book b:list)
            System.out.println(b.getName()+" "+b.getQuantity());
    }
}