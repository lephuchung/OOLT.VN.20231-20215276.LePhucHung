package AimsProject.src.hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

    private List<String> authors = new ArrayList<String>();

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