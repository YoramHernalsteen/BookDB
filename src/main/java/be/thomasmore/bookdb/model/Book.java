package be.thomasmore.bookdb.model;

import javax.persistence.*;

@Entity
public class Book {
    @GeneratedValue
    @Id
    private Integer id;
    private String title;
    private String isbn;
    @ManyToOne(fetch = FetchType.LAZY)
    private Author author;
    @ManyToOne(fetch = FetchType.LAZY)
    private Genre genre;
    private int pages;
    private boolean read;

    public Book() {
    }

    public Book(Integer id, String title, String isbn, Author author, Genre genre, int pages, boolean read) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.genre = genre;
        this.pages = pages;
        this.read = read;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public Author getAuthor() {
        return author;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getPages() {
        return pages;
    }

    public boolean isRead() {
        return read;
    }

    public String readAsString(){
        return String.valueOf(read);
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public void setReadFromString (String read){
        this.read = Boolean.parseBoolean(read);
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
