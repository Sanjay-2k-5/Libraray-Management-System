package service;

import database.Database;
import model.*;
import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class ReportService {

    public static void mostBorrowed(){

        HashMap<String,Integer> map=new HashMap<>();

        for(Transaction t:Database.transactions){
            String isbn=t.getIsbn();
            map.put(isbn,map.getOrDefault(isbn,0)+1);
        }

        for(String k:map.keySet())
            System.out.println(k+" "+map.get(k));
    }

    public static void lowStock(){

        for(Book b:Database.books.values()){
            if(b.getQuantity()<3)
                System.out.println(b.getName());
        }
    }

    public static void overdueUsers(){

        for(Transaction t:Database.transactions){

            long d=ChronoUnit.DAYS.between(
                t.getBorrowDate(),LocalDate.now()
            );

            if(d>15)
                System.out.println(t.getUserEmail());
        }
    }
}