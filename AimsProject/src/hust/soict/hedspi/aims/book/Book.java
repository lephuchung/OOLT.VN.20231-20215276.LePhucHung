package AimsProject.src.hust.soict.hedspi.aims.book;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private int id;
    private String title;
    private String category;
    private float cost;
    private List<String> authors = new ArrayList<String>();

    public Book() {
    }

    public Book(String title) {
        this.title = title;
    }

    public Book(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public Book(int id,String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public void addAuthor(String authorName) {
        for(String author: authors) {
            if(author.equals(authorName)) {
                System.out.println("Author is already added!");
                return ;
            }
        }
        authors.add(authorName);
        System.out.println("Author is added!");
    }
    public void removeAuthor(String authorName) {
        for(String author: authors) {
            if(author.equals(authorName)) {
                authors.remove(authorName);
                System.out.println("Author is removed!");
                return ;
            }
        }
        System.out.println("Author is not added yet!");
    }
}
