package nl.miwgroningen.cohort4.mark.demo.model;

import javax.persistence.*;
import java.util.List;

/**
 * Author: Mark Amerkamp (markamerkamp@gmail.com)
 *Info over de auteur
 */
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer authorId;

    private String name;

    @OneToMany(mappedBy = "author")
    private List<Book> myBooks;


    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfBooks(){
        return myBooks.size();
    }
}
