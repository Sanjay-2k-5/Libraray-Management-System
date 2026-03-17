package model;

public class Book {
    private String isbn;
    private String name;
    private int quantity;
    private int cost;

    public Book(String isbn,String name,int quantity,int cost){
        this.isbn=isbn;
        this.name=name;
        this.quantity=quantity;
        this.cost=cost;
    }

    public String getIsbn(){
        return isbn;
    }

    public String getName(){
        return name;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int q){
        quantity=q;
    }

    public int getCost(){
        return cost;
    }
}
