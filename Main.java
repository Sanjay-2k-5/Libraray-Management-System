import java.util.*;
import model.*;
import service.*;

public class Main {

    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args){

        while(true){
            System.out.println("\n1.Login\n2.Exit");
            int choice=sc.nextInt();
            sc.nextLine();

            if(choice==1){
                login();
            } else{
                System.out.println("Exiting...");
                break;
            }
        }
    }

    static void login(){
        System.out.println("Enter email:");
        String email=sc.nextLine();

        System.out.println("Enter password:");
        String pass=sc.nextLine();

        User user=AuthService.login(email,pass);

        if(user==null){
            System.out.println("Invalid login");
            return;
        }

        if(user instanceof Admin){
            adminMenu((Admin)user);
        } else{
            borrowerMenu((Borrower)user);
        }
    }

    static void adminMenu(Admin admin){

        while(true){
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1.Add Book");
            System.out.println("2.View Books");
            System.out.println("3.Search Book");
            System.out.println("4.Logout");

            int choice=sc.nextInt();
            sc.nextLine();

            if(choice==1){
                System.out.println("Enter ISBN:");
                String isbn=sc.nextLine();

                System.out.println("Enter name:");
                String name=sc.nextLine();

                System.out.println("Enter quantity:");
                int qty=sc.nextInt();

                System.out.println("Enter cost:");
                int cost=sc.nextInt();
                sc.nextLine();

                BookService.addBook(isbn,name,qty,cost);
                System.out.println("Book added");

            } else if(choice==2){
                BookService.showAllBooks();

            } else if(choice==3){
                System.out.println("Enter ISBN:");
                String isbn=sc.nextLine();

                Book b=BookService.searchByIsbn(isbn);

                if(b==null)
                    System.out.println("Not found");
                else
                    System.out.println(b.getName()+" "+b.getQuantity());

            } else{
                System.out.println("Logout successful");
                break;
            }
        }
    }
    static void borrowerMenu(Borrower user){

        while(true){
            System.out.println("\n--- Borrower Menu ---");
            System.out.println("1.View Books");
            System.out.println("2.Borrow Book");
            System.out.println("3.My Books");
            System.out.println("4.Logout");

            int choice=sc.nextInt();
            sc.nextLine();

            if(choice==1){
                BookService.showAllBooks();

            } else if(choice==2){
                System.out.println("Enter ISBN:");
                String isbn=sc.nextLine();

                BorrowService.borrowBook(user,isbn);

            } else if(choice==3){
                System.out.println("Your Books:");
                for(int i=0;i<user.getBorrowedBooks().size();i++){
                    System.out.println(user.getBorrowedBooks().get(i));
                }

            } else{
                System.out.println("Logout successful");
                break;
            }
        }
    }
}