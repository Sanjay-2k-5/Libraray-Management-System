package database;

import java.util.*;
import model.*;

public class Database {
    public static HashMap<String,User> users=new HashMap<>();
    public static HashMap<String,Book> books=new HashMap<>();
    public static ArrayList<Transaction> transactions=new ArrayList<>();
    public static HashMap<String,List<Transaction>> userTransactions=new HashMap<>();

    static{
        Admin admin=new Admin("admin","123");
        users.put(admin.getEmail(),admin);

        Borrower b1=new Borrower("user","123");
        users.put(b1.getEmail(),b1);

        Book book1=new Book("ISBN1","Java Basics",10,500);
        books.put(book1.getIsbn(),book1);
    }
}
