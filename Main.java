import service.*;
import model.*;
import java.util.*;

public class Main {

    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args){

        while(true){
            System.out.println("\n1.Login\n2.Exit");
            int choice=sc.nextInt();
            sc.nextLine();

            if(choice==1)
                login();
            else
                break;
        }
    }

    static void login(){
        System.out.println("Email:");
        String email=sc.nextLine();

        System.out.println("Password:");
        String pass=sc.nextLine();

        User user=AuthService.login(email,pass);

        if(user==null){
            System.out.println("Invalid");
            return;
        }

        if(user instanceof Admin)
            adminMenu((Admin)user);
        else
            borrowerMenu((Borrower)user);
    }

    static void adminMenu(Admin admin){

        while(true){
            System.out.println("\n1.Add Book\n2.View Books\n3.Search\n4.Low Stock\n5.Most Borrowed\n6.Overdue\n7.Sort Name\n8.Sort Qty\n9.Logout");

            int c=sc.nextInt();
            sc.nextLine();

            if(c==1){
                String isbn=sc.nextLine();
                String name=sc.nextLine();
                int q=sc.nextInt();
                int cost=sc.nextInt();
                sc.nextLine();

                BookService.addBook(isbn,name,q,cost);
            }
            else if(c==2)
                BookService.showAllBooks();

            else if(c==3){
                String isbn=sc.nextLine();
                Book b=BookService.searchByIsbn(isbn);
                if(b!=null)
                    System.out.println(b.getName());
            }
            else if(c==4)
                ReportService.lowStock();

            else if(c==5)
                ReportService.mostBorrowed();

            else if(c==6)
                ReportService.overdueUsers();

            else if(c==7)
                BookService.sortByName();

            else if(c==8)
                BookService.sortByQuantity();

            else
                break;
        }
    }

    static void borrowerMenu(Borrower user){

        while(true){
            System.out.println("\n1.View\n2.Borrow\n3.Return\n4.My Books\n5.Cart Add\n6.Cart View\n7.Checkout\n8.Extend\n9.Logout");

            int c=sc.nextInt();
            sc.nextLine();

            if(c==1)
                BookService.showAllBooks();

            else if(c==2){
                String isbn=sc.nextLine();
                BorrowService.borrowBook(user,isbn);
            }

            else if(c==3){
                String isbn=sc.nextLine();
                int days=sc.nextInt();
                sc.nextLine();
                BorrowService.returnBook(user,isbn,days);
            }

            else if(c==4){
                for(int i=0;i<user.getBorrowedBooks().size();i++)
                    System.out.println(user.getBorrowedBooks().get(i));
            }

            else if(c==5){
                String isbn=sc.nextLine();
                BorrowService.addToCart(user,isbn);
            }

            else if(c==6){
                for(int i=0;i<user.getCart().size();i++)
                    System.out.println(user.getCart().get(i));
            }

            else if(c==7)
                BorrowService.checkout(user);

            else if(c==8){
                String isbn=sc.nextLine();
                BorrowService.extendBook(user,isbn);
            }

            else
                break;
        }
    }
}